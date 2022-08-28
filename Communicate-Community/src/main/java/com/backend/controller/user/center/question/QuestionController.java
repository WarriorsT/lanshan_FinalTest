package com.backend.controller.user.center.question;

import com.backend.mapper.UserQuestionMapper;
import com.backend.pojo.UserQuestion;
import com.backend.service.user.center.QuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserQuestionMapper userQuestionMapper;


    /**
     * 保存问题
     * @param map
     * @return
     */
    @PostMapping("/user/center/saveQuestion")
    public Map<String, String> saveQuestion(@RequestParam Map<String, String> map){
        int id = Integer.parseInt(map.get("userid"));
        String question = map.get("question");
        return questionService.saveQuestion(id, question);
    }


    /**
     * 查看问题
     * @param userid
     * @return
     */
    @GetMapping("/user/center/{userid}")
    public List<String> getQuestion(@PathVariable Integer userid){
        List<String> list = new ArrayList<>();
        QueryWrapper<UserQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userid);
        List<UserQuestion> questions = userQuestionMapper.selectList(queryWrapper);

        if(questions.size() == 0){
            list.add("你还没有提过问题！");
            return list;
        }

        for(UserQuestion question : questions){
            list.add(question.getQuestion());
        }
        return list;
    }


    /**
     * 删除问题
     * @param
     * @return
     */
    @DeleteMapping("/user/center/delete")
    public Map<String, String> delete(@RequestParam Map<String, String> temp){
        Map<String, String> map = new HashMap<>();
        String question = temp.get("question");
        userQuestionMapper.deleteByQuestion(question);
        map.put("error_message", "success");
        return map;
    }


    /**
     * 修改问题
     * @param
     * @return
     */
   @PutMapping("/user/center/update")
    public Map<String, String> update(@RequestParam String origin, @RequestParam String current){
       Map<String, String> map = new HashMap<>();
       try {
           userQuestionMapper.updateByQuestion(origin, current);
       } catch (Exception e) {
           map.put("error_message", "fail");
           throw new RuntimeException(e);
       }
       map.put("error_message", "success");
       return map;
    }

}
