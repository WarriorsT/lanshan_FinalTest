package com.backend.mapper;

import com.backend.pojo.UserComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCommentMapper extends BaseMapper<UserComment> {

    @Delete("delete from user_comment where userid = #{userid} and comment_towho = #{who} and " +
            "which_question = #{whichQuestion}")
    void delete(Integer userid, String who, String whichQuestion);
}
