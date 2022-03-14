package com.example.demo.Service;

import com.example.demo.Entity.Answer;
import com.example.demo.Form.AnswerForm;

import java.util.List;

public interface AnswerService {
    
    String addAnswer(AnswerForm answerForm);

    List<Answer> getAll(Long userId);
}
