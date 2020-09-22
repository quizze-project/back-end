package com.br.quizze.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class QuizDTO implements Serializable {

    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private long createdAt;
    private long creator_id;

}
