package com.br.quizze.builders;

import com.br.quizze.entities.Question;
import com.br.quizze.entities.Quiz;
import com.br.quizze.entities.User;

public class QuizBuilder {

    private final Quiz quiz;

    public QuizBuilder(String quizName) {
        quiz = new Quiz(quizName);
    }

    public QuizBuilder unlisted() {
        quiz.setPrivate(true);
        return this;
    }

    public QuizBuilder addQuestion(Question question) {
        quiz.addQuestion(question);
        return this;
    }

    public QuizBuilder creator(User user) {
        quiz.setCreator(user);
        return this;
    }

    public Quiz build() {
        return quiz;
    }

}
