package com.br.quizze.resources;

import com.br.quizze.entities.Quiz;
import com.br.quizze.entities.User;
import com.br.quizze.repositories.QuizRepository;
import com.br.quizze.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/quizzes")
public class QuizResource {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Quiz>> findAll() {
/*        List<QuizDTO> quizzes = quizRepository
                .findAll()
                .stream()
                .map(m -> new QuizDTO(m.getId(), m.getName(), m.getCreatedAt(), m.getCreator().getId()))
                .collect(Collectors.toList());*/

        return ResponseEntity.ok().body(quizRepository.findAll());
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<User> insert(@PathVariable long id, @RequestBody Quiz quiz) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            quiz.setCreator(user);
            quizRepository.save(quiz);

            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

}
