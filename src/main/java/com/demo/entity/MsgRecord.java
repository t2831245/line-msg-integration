package com.demo.entity;

import com.linecorp.bot.model.event.DeliveryContext;
import com.linecorp.bot.model.event.EventMode;
import com.linecorp.bot.model.event.message.MessageContent;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "msgRecord")
public class MsgRecord {

    private String userId;
    private MessageContent content;
    private EventMode eventMode;
    private String webhookEventId;
    private DeliveryContext deliveryContext;
    private Instant timestamp;
}
