package com.arslan.quizapp.data.db.Converter;

import androidx.room.TypeConverter;

import com.arslan.quizapp.data.model.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class QuestionConverter {
    @TypeConverter
    public static List<Question> fromRaw(String questionJson) {
        if (questionJson==null) return null;

        Gson gson = new Gson();
        Type type = new TypeToken<List<Question>>(){}.getType();
        return gson.fromJson(questionJson,type);
    }
    @TypeConverter
    public static String toRaw(List<Question> questions) {
        if (questions == null) return null;

        Gson gson = new Gson();
        Type type = new TypeToken<List<Question>>() {}.getType();
        return gson.toJson(questions, type);
    }
}
