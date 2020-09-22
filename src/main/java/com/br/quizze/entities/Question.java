package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity()
@NoArgsConstructor
public class Question {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "question")
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private List<QuestionAnswer> questionAnswerList;

    private long correctAnswerId = -1;

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
            correctAnswerId = answer.getId();
        }
    }
}
