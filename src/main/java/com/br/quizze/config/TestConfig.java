package com.br.quizze.config;

import com.br.quizze.builders.QuestionBuilder;
import com.br.quizze.builders.QuizBuilder;
import com.br.quizze.entities.*;
import com.br.quizze.repositories.QuizAnswerRepository;
import com.br.quizze.repositories.QuizRepository;
import com.br.quizze.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public void run(String... args) {
        User u1 = new User("Carlinhos Tereu", "User", "Teste");
/*
        Question question1 = new QuestionBuilder("Quem descobriu o Brasil?")
                .answer("Pedro Alvares Cabral")
                .answer("Jorge Carlos", true)
                .answer("Fernandinho Beira-Mar")
                .build();

        Quiz q1 = new QuizBuilder("Você é inteligente?")
                .addQuestion(question1)
                .creator(u1)
                .build();*/

        /*quizRepository.save(q1);*/
        userRepository.save(u1);
    }
}
