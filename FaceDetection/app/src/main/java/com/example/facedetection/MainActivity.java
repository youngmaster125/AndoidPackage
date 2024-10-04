package com.example.facedetection;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    ImageView imageView;

    private  final  static int REQUEST_IMAGE_CAPTURE=124;

    InputImage firebaseVision;
    FaceDetection visionFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button =findViewById(R.id.camera_btn);
        textView=findViewById(R.id.text1);
        imageView=findViewById(R.id.imageview);

        FirebaseApp.initializeApp(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFile();
            }
        });
        Toast.makeText(this,"App is started",Toast.LENGTH_SHORT);
        
    }

    private void openFile() {

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager())!=null){

            startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

        }else{
            Toast.makeText(this,"Failled",Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle=data.getExtras();
        Bitmap bitmap=(Bitmap) bundle.get("data");

        FaceDetectionProcess(bitmap);
        Toast.makeText(this,"Success!!!",Toast.LENGTH_SHORT);
    }

    public void FaceDetectionProcess(Bitmap bitmap) {
        textView.setText("Processing Image.......");
        final StringBuilder builder=new StringBuilder();
        BitmapDrawable drawable=(BitmapDrawable) imageView.getDrawable();

        InputImage image=InputImage.fromBitmap(bitmap,0);
        FaceDetectorOptions highAccuracyOpt= new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                .enableTracking().build();

        FaceDetector detector=FaceDetection.getClient(highAccuracyOpt);
        Task<List<Face>> result=detector.process(image).addOnSuccessListener(new OnSuccessListener<List<Face>>() {
            @Override
            public void onSuccess(List<Face> faces) {
                 if(faces.size()!=0){
                     if(faces.size()==1){
                         builder.append(faces.size()+ "Face detected\n\n");
                     }
                   else  if(faces.size()==1){
                         builder.append(faces.size()+ "Faces detected\n\n");
                     }
                 }
                 for (Face face: faces){
                     int id=face.getTrackingId();
                     float rotY=face.getHeadEulerAngleY();
                     float rotZ=face.getHeadEulerAngleZ();
                   //  float rotX=face.getHeadEulerAngleX();

                     // rotated probability
                     builder.append("1. Face tracking Id ["+id+"]\n");
                     builder.append("2. Head rotation to Right" +
                             " ["+String.format("%.2f",rotY)
                             +" deg ]\n");
                     builder.append("2. Head Tilted to sideways" +
                             " ["+String.format("%.2f",rotZ)
                             +" deg ]\n");
                     //Smilling probability
                     if (face.getSmilingProbability()>0){
                         float smilingProbability=face.getSmilingProbability();
                         builder.append("4. Smiling probability ["+
                                 String.format("%.2f",smilingProbability)+"]\n");
                     }

                     //left Eye Open
                     if (face.getLeftEyeOpenProbability()>0){
                         float leftEye=face.getLeftEyeOpenProbability();
                         builder.append("4. Left eye open ["+
                                 String.format("%.2f",leftEye)+"]\n");
                     }

                     //right Eye Open
                     if (face.getRightEyeOpenProbability()>0){
                         float rightEye=face.getRightEyeOpenProbability();
                         builder.append("4. Right eye open ["+
                                 String.format("%.2f",rightEye)+"]\n");
                     }
                     builder.append("\n");

                 }
                 showDetector("Face Detection",builder,true);
            }
        });
        result.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                StringBuilder builder1=new StringBuilder();
                builder1.append("Sorry!! there is an error");
                showDetector("Face Detection",builder,true);
            }
        });
    }
    public  void showDetector(final String title,final StringBuilder builder,Boolean success){
        textView.setText("Face detector in process");
        if(success==true){
            textView.setText(null);
            textView.setMovementMethod(new ScrollingMovementMethod());

            if(builder.length()!=0){
                textView.append(builder);
                if(title.substring(0,title.indexOf(' ')).equalsIgnoreCase("OCR")){
                    textView.append("\n Hold the text to copy it ");
                }else{
                    textView.append("(Hold the text to copy it )");
                }
                textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                        ClipData clip =ClipData.newPlainText(title,builder);

                        clipboardManager.setPrimaryClip(clip);

                        return true;
                    }
                });
            }else{
                textView.append(title.substring(0,title.indexOf(' '))+"Failed to detect anything");
            }
        }else if(success==false){
            textView.setText(null);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textView.append(builder);
        }

    }
}