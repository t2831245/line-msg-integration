package com.demo.service;

import com.demo.entity.MsgRecord;
import com.demo.entity.PushMsgRequest;
import com.demo.exception.UnauthorizedException;
import com.demo.repository.MsgRecordRepository;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MsgService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MsgRecordRepository msgRecordRepository;

    @Value("${line.bot.channel-token}")
    private String channelToken;

    public MsgService(MsgRecordRepository msgRecordRepository) {
        this.msgRecordRepository = msgRecordRepository;
    }

    public void pushMessage(PushMsgRequest request) {

        final LineMessagingClient client = LineMessagingClient
                .builder(channelToken)
                .build();

        final TextMessage textMessage = new TextMessage(request.getText());
        final PushMessage pushMessage = new PushMessage(
                request.getUserId(),
                textMessage);

        final BotApiResponse botApiResponse;
        try {
            botApiResponse = client.pushMessage(pushMessage).get();
        } catch (InterruptedException | ExecutionException e) {
            logger.warn(e.toString());
            throw new UnauthorizedException("token invalidate.");
        }
        logger.debug("push success! ", botApiResponse.toString());
    }

    public void insertRecord(MessageEvent messageEvent) {

        msgRecordRepository.insert(
                MsgRecord.builder()
                        .userId(messageEvent.getSource().getUserId())
                        .content(messageEvent.getMessage())
                        .timestamp(messageEvent.getTimestamp())
                        .eventMode(messageEvent.getMode())
                        .webhookEventId(messageEvent.getWebhookEventId())
                        .deliveryContext(messageEvent.getDeliveryContext())
                        .build()
        );
    }

    public List<MsgRecord> findByUserId(String userId) {
        return msgRecordRepository.findByUserId(userId);
    }
}
