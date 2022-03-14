package com.example.demo.Service.Impl;

import com.example.demo.Entity.Question;
import com.example.demo.Entity.User;
import com.example.demo.Form.QuestionForm;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String askQuestion(QuestionForm questionForm) {
        Question question = new Question();
        question.setQuestion(questionForm.getQuestion());
        if(Objects.nonNull(questionForm.getUserId())){
            User user = userRepository.findById(questionForm.getUserId()).get();
            question.setUser(user);
        }
        questionRepository.save(question);
        return "Data Added Successfully";
    }
}
