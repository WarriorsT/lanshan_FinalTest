package com.backend.mapper;

import com.backend.pojo.UserQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserQuestionMapper extends BaseMapper<UserQuestion> {
    @Delete("delete from user_question where question = #{question}")
    void deleteByQuestion(String question);

    @Update("update user_question set question = #{current} where question = #{origin}")
    void updateByQuestion(String origin, String current);
}
