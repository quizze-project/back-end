package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity()
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz extends BaseEntity {

    private String name;
    private long createdAt;
    private boolean isPrivate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    @JsonIgnore
    private User creator;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "quiz")
    @Setter(AccessLevel.NONE)
    private List<Question> questions = new ArrayList<>();

    public Quiz(String name) {
        this.name = name;
        this.createdAt = System.currentTimeMillis();
    }

    public Quiz(String name, boolean isPrivate, User creator) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.creator = creator;
        this.createdAt = System.currentTimeMillis();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
