package com.br.quizze.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity {

    @Length(min = 5, max = 32)
    private String username;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "creator")
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private List<Quiz> quizzes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private List<QuizAnswer> quizAnswers;

    public User(@Length(min = 5, max = 32) String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
