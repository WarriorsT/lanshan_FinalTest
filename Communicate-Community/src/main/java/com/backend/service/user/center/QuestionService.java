package com.backend.service.user.center;

import java.util.Map;

public interface QuestionService {
    Map<String, String> saveQuestion(Integer userid, String question);
}
