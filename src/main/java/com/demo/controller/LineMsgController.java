package com.demo.controller;

import com.demo.service.MsgService;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@LineMessageHandler
public class LineMsgController {

    private final LineMessagingClient lineMessagingClient;

    private final MsgService msgService;

    public LineMsgController(LineMessagingClient lineMessagingClient, MsgService msgService) {
        this.lineMessagingClient = lineMessagingClient;
        this.msgService = msgService;
    }

//    @EventMapping
//    public void handleTextEvent(MessageEvent<TextMessageContent> messageEvent) {
//        try{
//            Source source = messageEvent.getSource();
//            String lineId = source.getUserId();
//            String replyToken = messageEvent.getReplyToken();
//            String message = messageEvent.getMessage().getText();
//
//            String displayName = lineMessagingClient
//                    .getProfile(lineId)
//                    .get()
//                    .getDisplayName();
//
//            System.out.println("xxx" + displayName + "," + lineId);
//
//            String answer = String.format("Hello, %s! Your message is %s", displayName, message);
//            TextMessage responseMessage = new TextMessage(answer);
//
//            lineMessagingClient
//                    .replyMessage(new ReplyMessage(replyToken, responseMessage));
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @EventMapping
    public void handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        msgService.insertRecord(event);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
        msgService.insertRecord((MessageEvent) event);
    }

}