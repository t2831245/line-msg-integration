package com.demo.entity;

public class MsgConverter {

    public static MsgRecordResponse entityToModel(MsgRecord ent){
        return MsgRecordResponse.builder()
                .userId(ent.getUserId())
                .timestamp(ent.getTimestamp())
                .content(ent.getContent())
                .build();
    }
}
