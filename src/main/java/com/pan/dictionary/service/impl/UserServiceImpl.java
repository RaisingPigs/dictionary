package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.User;
import com.pan.dictionary.mapper.HistoryMapper;
import com.pan.dictionary.mapper.UserMapper;
import com.pan.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:58
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
   
}
