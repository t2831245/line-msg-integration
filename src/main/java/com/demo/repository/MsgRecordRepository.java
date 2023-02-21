package com.demo.repository;

import com.demo.entity.MsgRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MsgRecordRepository extends MongoRepository<MsgRecord, String> {
    List<MsgRecord> findByUserId(String userId);
}
