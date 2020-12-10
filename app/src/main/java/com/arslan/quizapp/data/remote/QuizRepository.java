package com.arslan.quizapp.data.remote;

import androidx.lifecycle.LiveData;

import com.arslan.quizapp.data.local.HistoryStorage;
import com.arslan.quizapp.data.model.History;
import com.arslan.quizapp.data.model.Question;
import com.arslan.quizapp.data.model.QuizResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizRepository {
    private HistoryStorage historyStorage;
    private QuizApiClient quizApiClient;

    public QuizRepository(HistoryStorage localDataSource, QuizApiClient quizApiClient) {
        this.historyStorage = localDataSource;
        this.quizApiClient = quizApiClient;
    }

    public int saveQuizResult(QuizResult quizResult) {
        return historyStorage.saveQuizResult(quizResult);
    }

    public void delete(int id) {
        historyStorage.delete(id);
    }


    public void deleteAll() {
        historyStorage.deleteAll();
    }

    public LiveData<List<QuizResult>> getAll() {
        return historyStorage.getAll();
    }

    public LiveData<List<History>> getAllHistory() {
        return historyStorage.getAllHistory();
    }

    public QuizResult get(int id) {
        return historyStorage.get(id);
    }


    public void getQuestion(int amount, Integer category, String difficulty, final IQuizApiClient.QuestionCallback callback) {
        quizApiClient.getQuestion(amount, category, difficulty, new IQuizApiClient.QuestionCallback() {
            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onSuccess(List<Question> result) {
                for (int i = 0; i < result.size(); i++) {
                    result.set(i, shuffleAnswers(result.get(i)));
                }
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(new Exception(e));
            }

           /* @Override
            public void onFailure(Throwable t) {
                callback.onFailure(new Exception(t));
            }*/
        });
    }

    private Question shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.addAll(question.getIncorrectAnswers());
        Collections.shuffle(answers);
        question.setAnswers(answers);
        return question;
    }
}
