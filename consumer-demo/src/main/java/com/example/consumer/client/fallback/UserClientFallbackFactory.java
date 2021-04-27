package com.example.consumer.client.fallback;

import com.example.consumer.client.UserClient;
import com.example.consumer.pojo.User;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallbackFactory implements FallbackFactory {
    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public User queryById(Long id) {
                return new User().setId(id).setName("not fund");
            }
        };
    }
}
