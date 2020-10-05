package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@Entity()
@NoArgsConstructor
public class Question extends BaseEntity {

    @Length(max = 250)
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "question")
    @Setter(AccessLevel.NONE)
    private List<QuestionAnswer> questionAnswerList = new ArrayList<>();

    @OneToOne()
    @JoinColumn(name = "correct_answer_id")
    private QuestionAnswer correctAnswer;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Question(String question, Quiz quiz) {
        this.question = question;
        this.quiz = quiz;
    }

    public Question(String question) {
        this.question = question;
    }

    public void addAnswer(QuestionAnswer answer) {
        questionAnswerList.add(answer);
    }

    public void addAnswer(QuestionAnswer answer, boolean correct) {
        addAnswer(answer);
        if (correct) {
            setCorrectAnswer(answer);
        }
    }
}
