package com.csdj.springbootrpc.service;

import com.csdj.pojo.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Service
public class NoteService {

    @Autowired
    private NoteApi noteApi;

    public Mono<String> note(String content, String templateId, String phone) {
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("content",content);
        multiValueMap.add("template_id",templateId);
        multiValueMap.add("phone_number",phone);
//        Note note = new Note(content, templateId, phone);
        return noteApi.note(multiValueMap);
    }

}
