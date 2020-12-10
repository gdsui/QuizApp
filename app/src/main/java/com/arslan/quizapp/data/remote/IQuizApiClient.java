package com.arslan.quizapp.data.remote;

import com.arslan.quizapp.core.ICoreCallback;
import com.arslan.quizapp.data.model.GlobalResponse;
import com.arslan.quizapp.data.model.Question;
import com.arslan.quizapp.data.model.QuizQuestionCount;
import com.arslan.quizapp.data.model.TriviaCategories;

import java.util.List;

public interface IQuizApiClient {
    void getQuestion(int amount, Integer category, String difficulty, QuestionCallback callback);

    void getGlobal(GlobalCallback globalCallback);

    void getQuestionResponse(Integer category,QuestionResponseCallback questionResponseCallback);

    void getTriviaCategoryCallback(TriviaCategoryCallback triviaCategoryCallback);

    interface QuestionCallback extends ICoreCallback<List<Question>> {
        void onFailure(Throwable t);
    }

    interface GlobalCallback extends ICoreCallback<GlobalResponse> {
    }

    interface QuestionResponseCallback extends ICoreCallback<QuizQuestionCount> {
    }

    interface TriviaCategoryCallback extends ICoreCallback<TriviaCategories> {
    }
}
