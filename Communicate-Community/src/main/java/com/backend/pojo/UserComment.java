package com.backend.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  comment:用户的评论
 */
public class UserComment {
    private Integer userid;
    private String comment;
    private String commentTowho;
    private String whichQuestion;
}
