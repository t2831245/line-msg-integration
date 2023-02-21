package com.demo.controller;

import com.demo.entity.Member;
import com.demo.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberRepository memberRepository;


    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Member member) {
        Member entity = memberRepository.insert(member);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public List<Member> getList(){
        return memberRepository.findAll();
    }
}
