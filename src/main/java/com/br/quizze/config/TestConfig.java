package com.br.quizze.config;

import com.br.quizze.builders.QuestionBuilder;
import com.br.quizze.builders.QuizBuilder;
import com.br.quizze.entities.Question;
import com.br.quizze.entities.User;
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
    public void run(String... args) throws Exception {
        User u1 = new User("User", "Teste");

        Question firstQuestion = new QuestionBuilder("Quem descobriu o Brasil?")
                .answer("Pedro Alvares Cabral")
                .answer("Jorge Carlos")
                .answer("Fernandinho Beira-Mar")
                .build();

        new QuizBuilder("Você é inteligente?")
                .addQuestion(firstQuestion)
                .creator(u1)
                .build();

        userRepository.save(u1);
    }
}
