package com.br.quizze.controllers;

import com.br.quizze.entities.Image;
import com.br.quizze.repositories.ImageReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    private ImageReposiory imageReposiory;

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImage(@PathVariable long id) {
        return ResponseEntity.of(imageReposiory.findById(id));
    }

    @PostMapping
    public ResponseEntity<Image> uploadImage(@RequestParam("file") MultipartFile file) {

        file.getSize()

    }

}
