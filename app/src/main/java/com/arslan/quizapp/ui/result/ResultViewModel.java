package com.arslan.quizapp.ui.result;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.arslan.quizapp.App;
import com.arslan.quizapp.data.model.QuizResult;

public class ResultViewModel extends ViewModel {
    MutableLiveData<QuizResult> quizResult = new MutableLiveData<>();

    public void getResult(Integer id) {
        quizResult.setValue(App.dataBase.historyDao().get(id));
    }
}
