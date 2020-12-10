package com.arslan.quizapp.data.db.Converter;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataConverter {
    @TypeConverter
    public static Date fromRaw(Long timestamp) {
        if (timestamp == null) return null;

        return new Date(timestamp);
    }

    @TypeConverter
    public static Long toRaw(Date date) {
        if (date == null) return null;
        return date.getTime();
    }
}
