package com.arslan.quizapp.data.remote;

import com.arslan.quizapp.data.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionResponse {
    @SerializedName("response_code")
    private int responseCode;

    private List<Question> results;

    public QuestionResponse(int responseCode, List<Question> results) {
        this.responseCode = responseCode;
        this.results = results;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
