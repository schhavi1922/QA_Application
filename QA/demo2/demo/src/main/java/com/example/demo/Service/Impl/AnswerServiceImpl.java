package com.example.demo.Service.Impl;

import com.example.demo.Entity.Answer;
import com.example.demo.Entity.Question;
import com.example.demo.Entity.User;
import com.example.demo.Form.AnswerForm;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public AnswerServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String addAnswer(AnswerForm answerForm) {

        Answer answer = new Answer();
        answer.setAnswer(answerForm.getAnswer());
        if(Objects.nonNull(answerForm.getUserId())){
            User user = userRepository.findById(answerForm.getUserId()).get();
            answer.setUser(user);
        }
        if(Objects.nonNull(answerForm.getUserId())){
            Question question = questionRepository.findById(answerForm.getUserId()).get();
           answer.setQuestion(question);
        }
        answerRepository.save(answer);
        return "Data Saved Successfully";
    }

    @Override
    public List<Answer> getAll(Long userId) {

        List<Answer> answerList = new ArrayList<>();
        answerList = answerRepository.findByUserId(userId);
        return answerList;
    }
}
