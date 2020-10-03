package com.br.quizze.controllers;

import com.br.quizze.entities.Quiz;
import com.br.quizze.entities.User;
import com.br.quizze.repositories.QuizRepository;
import com.br.quizze.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/quizzes")
public class QuizController {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Quiz>> findAll() {
        return ResponseEntity.ok().body(quizRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quiz> getById(@PathVariable long id) {
        return ResponseEntity.of(quizRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Quiz> insert(@RequestParam(name = "creator_id") long creator_id, @RequestBody Quiz quiz) {
        Optional<User> user = userRepository.findById(creator_id);
        if (user.isPresent()) {
            quiz.setCreator(user.get());
            return ResponseEntity.ok(quiz);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "{/id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Quiz requestQuiz) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if (!quiz.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (requestQuiz.getId() != id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id's aren't the same!");
        }

        quizRepository.save(requestQuiz);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(requestQuiz);
    }


}
