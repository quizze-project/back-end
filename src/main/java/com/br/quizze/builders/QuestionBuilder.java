package com.br.quizze.builders;

import com.br.quizze.entities.Question;
import com.br.quizze.entities.QuestionAnswer;

public class QuestionBuilder {

    private Question question;

    public QuestionBuilder(String name) {
        question = new Question(name);
    }

    public QuestionBuilder answer(String answer) {
        question.addAnswer(getNewQuestionAnswer(answer));
        return this;
    }

    public QuestionBuilder answer(String answer, boolean correct) {
        question.addAnswer(getNewQuestionAnswer(answer), correct);
        return this;
    }

    private QuestionAnswer getNewQuestionAnswer(String answer) {
        return new QuestionAnswer(answer, question);
    }

    public Question build() {
        return question;
    }

}
