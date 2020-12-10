package com.arslan.quizapp.core;

public interface ICoreCallback<T> {
    void onSuccess(T result);
    void onFailure( Exception e);

}
