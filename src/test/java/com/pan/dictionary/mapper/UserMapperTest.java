package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:55
 **/
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    void testSelect() {
        List<User> users = userMapper.selectList(null);

        for (User user : users) {
            System.out.println(user);
        }
    }
}
