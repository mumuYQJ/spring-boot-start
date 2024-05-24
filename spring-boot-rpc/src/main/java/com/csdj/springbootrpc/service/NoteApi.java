package com.csdj.springbootrpc.service;

import com.csdj.pojo.Note;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface NoteApi {

    @PostExchange(url = "https://dfsns.market.alicloudapi.com/data/send_sms",accept = MediaType.APPLICATION_JSON_VALUE, contentType = "application/x-www-form-urlencoded; charset=UTF-8")
    Mono<String> note(@RequestBody MultiValueMap<String, String> formData);
}
