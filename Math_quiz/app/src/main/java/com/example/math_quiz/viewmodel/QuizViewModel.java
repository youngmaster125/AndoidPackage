package com.example.math_quiz.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.math_quiz.model.QuestionList;
import com.example.math_quiz.repository.QuizRepository;


public class QuizViewModel extends ViewModel {

    QuizRepository repository = new QuizRepository();

    LiveData<QuestionList> questionListLiveData;

    public QuizViewModel() {
        questionListLiveData = repository.getQuestionsFromAPI();
    }

    public LiveData<QuestionList> getQuestionListLiveData() {
        return questionListLiveData;
    }
}
