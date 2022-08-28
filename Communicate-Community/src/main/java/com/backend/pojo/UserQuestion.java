package com.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 *  question表示用户发表过的问题
 */
public class UserQuestion {
    private Integer userid;
    private String question;
}
