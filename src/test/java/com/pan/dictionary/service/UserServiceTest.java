package com.pan.dictionary.service;

import com.pan.dictionary.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:11
 **/
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @Test
    void testSelect() {
        List<User> users = userService.list();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
