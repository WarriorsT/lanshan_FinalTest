package com.backend.utils.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentMessage {
    String error_message;
    String comment;
    String commentTowho;
}
