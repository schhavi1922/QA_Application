package com.example.demo.Repository;

import com.example.demo.Entity.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    @Query(value = "SELECT * FROM answer WHERE user_id =:userId")
    List<Answer> findByUserId(Long userId);
}
