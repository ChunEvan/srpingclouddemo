package com.example.consumer.client;

import com.example.consumer.client.fallback.UserClientFallback;
import com.example.consumer.client.fallback.UserClientFallbackFactory;
import com.example.consumer.config.FeignConfig;
import com.example.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", fallback = UserClientFallback.class)
//@FeignClient(value = "user-service", fallbackFactory = UserClientFallbackFactory.class, configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
