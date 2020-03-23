package com.yezd.xpcrt;


import com.yezd.xpcrt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class XpcrtApplicationTests {


    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(jedisPool);
    }

    @Test
    void testJedisString(){
        String value = userService.getString("root");
        System.out.println(value);
    }


}
