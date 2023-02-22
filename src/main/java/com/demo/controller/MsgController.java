package com.demo.controller;

import com.demo.entity.MsgConverter;
import com.demo.entity.MsgRecordResponse;
import com.demo.entity.PushMsgRequest;
import com.demo.service.MsgService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/msg")
public class MsgController {

    private final MsgService msgService;

    public MsgController(MsgService msgService) {
        this.msgService = msgService;
    }

    @PostMapping
    public ResponseEntity pushMessage(@Valid @RequestBody PushMsgRequest request) {
        msgService.pushMessage(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MsgRecordResponse>> findByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(
                msgService.findByUserId(userId).stream().map(MsgConverter::entityToModel).collect(Collectors.toList())
        );
    }
}
