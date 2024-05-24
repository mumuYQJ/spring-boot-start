package com.csdj.springbootrpc.controller;

import com.csdj.springbootrpc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/note")
    public Mono<String> note() {
        String phone = "15107690623";
        String templateId = "CST_ptdie100";
        String content = "code:6379";
        return noteService.note(content,templateId,phone);
    }
}
