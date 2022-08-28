package com.backend.service.impl.user.center;

import com.backend.mapper.UserQuestionMapper;
import com.backend.pojo.UserQuestion;
import com.backend.service.user.center.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存用户提出的话题
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private UserQuestionMapper userQuestionMapper;

    private UserQuestion userQuestion = new UserQuestion();

    @Override
    public Map<String, String> saveQuestion(Integer userid, String question) {
        userQuestion.setUserid(userid);
        userQuestion.setQuestion(question);
        userQuestionMapper.insert(userQuestion);

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");
        return map;
    }
}
