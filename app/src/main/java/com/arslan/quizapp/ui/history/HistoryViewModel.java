package com.arslan.quizapp.ui.history;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.arslan.quizapp.App;
import com.arslan.quizapp.data.model.History;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    LiveData<List<History>> historyLiveData = App.quizRepository.getAllHistory();
}