package com.wood.woodapi_interface.client;

import com.wood.woodapiclientsdk.client.WoodapiClient;
import com.wood.woodapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WoodapiClientTest {

    @Resource
    private WoodapiClient client;

    @Test
    void testGetNameByGet() {
        client.getNameByPost("马飞飞");
    }

    @Test
    void testGetNameByPost() {
        client.getNameByPost("牛牛大");
    }

    @Test
    void testGetUsernameByPost() {
        User user = new User();
        user.setUsername("zhuzhupi");
        client.getUsernameByPost(user);
    }
}