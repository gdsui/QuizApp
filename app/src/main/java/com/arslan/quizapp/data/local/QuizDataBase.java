package com.arslan.quizapp.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.arslan.quizapp.data.model.QuizResult;

@Database(entities = {QuizResult.class},version = 1,exportSchema = false)
public abstract class QuizDataBase extends RoomDatabase {
    public abstract HistoryDao historyDao();
}
