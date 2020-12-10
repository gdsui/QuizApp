package com.arslan.quizapp;

import android.app.Application;

import androidx.room.Room;

import com.arslan.quizapp.data.local.HistoryStorage;
import com.arslan.quizapp.data.local.QuizDataBase;
import com.arslan.quizapp.data.remote.QuizApiClient;
import com.arslan.quizapp.data.remote.QuizRepository;

public class App extends Application {
    public static QuizRepository quizRepository;
    public static QuizDataBase dataBase;



    @Override
    public void onCreate() {
        super.onCreate();

        dataBase = Room.databaseBuilder(this, QuizDataBase.class, "quiz"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();

        dataBase.historyDao();
        quizRepository = new QuizRepository(new HistoryStorage(dataBase.historyDao()), new QuizApiClient());

    }
}
