package com.pan.dictionary.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.dictionary.bean.User;
import com.pan.dictionary.service.HistoryService;
import com.pan.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 15:30
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(User user,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, user.getUsername());
        wrapper.lambda().eq(User::getPassword, user.getPassword());

        User loginUser = userService.getOne(wrapper);

        if (loginUser != null) {
            session.setAttribute("loginUser", loginUser);

            return "redirect:/index";
        } else {
            redirectAttributes.addFlashAttribute("msg", "用户名或密码错误");
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            
            return "redirect:/user/login";
        } 
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.removeAttribute("noteTransMsg");
        session.removeAttribute("transMsg");
        session.removeAttribute("histories");

        return "redirect:/user/login";
    }
}
