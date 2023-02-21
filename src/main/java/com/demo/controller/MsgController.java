package com.demo.controller;

import com.demo.entity.MsgRecord;
import com.demo.entity.input.PushMsgRequest;
import com.demo.service.MsgService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/msg")
public class MsgController {

    private final MsgService msgService;

    public MsgController(MsgService msgService) {
        this.msgService = msgService;
    }

    @PostMapping
    public ResponseEntity pushMessage(@RequestBody PushMsgRequest request) {
        msgService.pushMessage(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MsgRecord>> findByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(msgService.findByUserId(userId));
    }
}
