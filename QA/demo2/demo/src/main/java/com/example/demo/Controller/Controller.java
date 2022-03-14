package com.example.demo.Controller;

import com.example.demo.Entity.Answer;
import com.example.demo.Form.AnswerForm;
import com.example.demo.Form.QuestionForm;
import com.example.demo.Service.AnswerService;
import com.example.demo.Service.QuestionService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(path="/demo")
public class Controller {

    private final QuestionService questionService;
    private final AnswerService answerService;

    public Controller(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PostMapping("/ask")
    public String askQuestion(@RequestBody QuestionForm questionForm) {
        return questionService.askQuestion(questionForm);
    }

    @PostMapping("/answer")
    public String ansQuestion(@RequestBody AnswerForm answerForm) {
        return answerService.addAnswer(answerForm);
    }

    @GetMapping("/getAll/{userId}")
    public List<Answer> getAllByUserId(@PathVariable Long userId) {
        return answerService.getAll(userId);
    }

}
