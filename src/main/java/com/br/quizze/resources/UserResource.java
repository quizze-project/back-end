package com.br.quizze.resources;

import com.br.quizze.entities.User;
import com.br.quizze.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByName(@PathVariable long id) {
        return ResponseEntity.ok().body(userRepository.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

/*    public ResponseEntity<User> findByName(@RequestParam(name = "id") long id) {
        System.out.println(id);
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.of(user)
    }*/

}
