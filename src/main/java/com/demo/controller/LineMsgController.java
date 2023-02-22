package com.demo.controller;

import com.demo.service.MsgService;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LineMessageHandler
public class LineMsgController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final LineMessagingClient lineMessagingClient;

    private final MsgService msgService;

    public LineMsgController(LineMessagingClient lineMessagingClient, MsgService msgService) {
        this.lineMessagingClient = lineMessagingClient;
        this.msgService = msgService;
    }

    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        logger.info("event: " + event);
        msgService.insertRecord(event);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        logger.info("event: " + event);
        msgService.insertRecord((MessageEvent) event);
    }

}