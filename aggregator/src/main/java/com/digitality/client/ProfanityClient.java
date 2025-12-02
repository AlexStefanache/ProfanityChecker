package com.digitality.client;

import com.digitality.dto.CheckProfanityDTO;
import com.digitality.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "profanity-service")
@RequestMapping("/profanity")
public interface ProfanityClient {
    @PostMapping("/check")
    public CheckProfanityDTO check(@RequestBody MessageDTO message);
}
