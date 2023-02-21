package com.demo.entity.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushMsgRequest {
    private String userId;
    private String text;
}
