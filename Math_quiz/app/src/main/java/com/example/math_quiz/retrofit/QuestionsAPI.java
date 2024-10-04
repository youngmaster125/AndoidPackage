package com.example.math_quiz.retrofit;



import com.example.math_quiz.model.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsAPI {
    // Used to define the structure and behavior of
    // network requests to a RESTful API.
    // Acts as a bridge between android app and the web service

    @GET("questions")  // end point
    Call<QuestionList> getQuestions();


}
