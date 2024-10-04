package com.example.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public static final String KEY_WORKER = "Sent";
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
      //Getting Data from InputData

        Data data =getInputData();
        int limit=data.getInt("maxLimit",0);

        // count to 1000

        for(int i=0; i<limit;i++){

            Log.i("TAGY","COUNT IS : "+i);
        }
        // Sending Data and Done info
        Data dataToSend = new Data.Builder().putString(KEY_WORKER,"Task Done Successfully").build();

        return Result.success(dataToSend);
    }
}
