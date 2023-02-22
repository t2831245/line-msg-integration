package com.demo.entity;

import com.linecorp.bot.model.event.message.MessageContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgRecordResponse {

    private String userId;
    private MessageContent content;
    private String webhookEventId;
    private Instant timestamp;
}
