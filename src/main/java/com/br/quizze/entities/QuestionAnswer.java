package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Entity
@Getter
@EqualsAndHashCode(callSuper = true)
public class QuestionAnswer extends BaseEntity {

    @Length(max = 150)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    public QuestionAnswer(String answer, Question question) {
        this.answer = answer;
        this.question = question;
    }
}
