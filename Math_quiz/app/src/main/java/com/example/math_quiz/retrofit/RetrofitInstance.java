package com.example.math_quiz.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    // Always use 10.0.2.2 to connect emulator to the host's server
    String baseUrl1 = "http://127.0.0.1:8080/";
    String baseUrl= "http://10.0.2.2:8080/";

    // Create and Return a configured Retrofit Instance
    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
