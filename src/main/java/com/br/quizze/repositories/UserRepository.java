package com.br.quizze.repositories;

import com.br.quizze.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select c from users c where c.email = :email")
    User findByEmail(@Param("email") String email);

}
