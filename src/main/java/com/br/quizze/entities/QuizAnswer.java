package com.br.quizze.entities;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)
public class QuizAnswer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Type(type = "list-array")
    @Column(
            name = "answers",
            columnDefinition = "bigint[]"
    )
    private List<Long> questionAnswers = new ArrayList<>();

    private long responseAt;

    public QuizAnswer(User user, Quiz quiz, List<Long> questionAnswers) {
        this.user = user;
        this.quiz = quiz;
        this.questionAnswers = questionAnswers;
        this.responseAt = System.currentTimeMillis();
    }
}
