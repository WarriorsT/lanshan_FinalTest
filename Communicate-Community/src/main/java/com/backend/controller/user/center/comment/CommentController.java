package com.backend.controller.user.center.comment;


import com.backend.mapper.UserCommentMapper;
import com.backend.pojo.User;
import com.backend.pojo.UserComment;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user/center/comment")
public class CommentController {

    @Autowired
    private UserCommentMapper userCommentMapper;


    /**
     * 保存一条评论
     * @param map
     * @return
     */
    @PostMapping("/save")
    public Map<String, String> comment(@RequestParam Map<String, String> map){
        Map<String, String> hash = new HashMap<>();
        String userid = map.get("userid");
        String comment = map.get("comment");
        String commentTowho = map.get("commentTowho");
        String whichQuestion = map.get("whichQuestion");

        UserComment userComment = new UserComment();
        userComment.setUserid(Integer.parseInt(userid));
        userComment.setCommentTowho(commentTowho);
        userComment.setComment(comment);
        userComment.setWhichQuestion(whichQuestion);

        userCommentMapper.insert(userComment);
        hash.put("error_message", "success");
        return hash;
    }

    /**
     * 获取自己做过的评论
     * @param userid
     * @return
     */
    @GetMapping("/{userid}")
    public Map<String, List<UserComment>> lookComment(@PathVariable Integer userid){
        Map<String, List<UserComment>> map = new HashMap<>();
        QueryWrapper<UserComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userid);
        List<UserComment> list = new ArrayList<>();
        list = userCommentMapper.selectList(queryWrapper);
        map.put("UserComment", list);
        return map;
    }

    /**
     * 删除评论
     * @param map
     * @return
     */
    @DeleteMapping("/delete")
    public Map<String, String> deleteComment(@RequestParam Map<String, String> map){
        Map<String, String> hash = new HashMap<>();
        Integer userid = Integer.parseInt(map.get("userid"));
        String who = map.get("commentTowho");
        String whichQuestion = map.get("whichQuestion");
        System.out.println(userid);
        System.out.println(who);
        System.out.println(whichQuestion);

        userCommentMapper.delete(userid, who, whichQuestion);
        hash.put("error_message", "success");
        return hash;
    }


    /**
     * 查看别人的回答
     * @param userid
     * @return
     */
    @GetMapping("/answer/{userid}")
    public Map<String, List<UserComment>> getAnswer(@PathVariable Integer userid){
        Map<String, List<UserComment>> map = new HashMap<>();
        QueryWrapper<UserComment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("comment_towho", userid);
        List<UserComment> list = new ArrayList<>();
        list = userCommentMapper.selectList(queryWrapper);
        map.put("UserComment", list);
        return map;
    }
}
