package com.br.quizze.repositories;

import com.br.quizze.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageReposiory extends JpaRepository<Image, Long> {
}
