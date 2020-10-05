package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity()
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz extends BaseEntity {

    @Length(min = 4, max = 32)
    private String name;

    @Nullable
    @Length(max = 50)
    private String description;

    private long createdAt = System.currentTimeMillis();
    private boolean isPrivate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "quiz")
    @Setter(AccessLevel.NONE)
    private List<Question> questions = new ArrayList<>();

    public Quiz(@Length(min = 4, max = 32) String name) {
        this.name = name;
    }

    public Quiz(String name, boolean isPrivate) {
        this.name = name;
        this.isPrivate = isPrivate;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
