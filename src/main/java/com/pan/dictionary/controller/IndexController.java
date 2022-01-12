package com.pan.dictionary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pan.dictionary.bean.*;
import com.pan.dictionary.service.HistoryService;
import com.pan.dictionary.service.LanguageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 15:02
 **/
@Controller
public class IndexController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private LanguageTypeService languageTypeService;

    @GetMapping(value = {"/", "/index"})
    public String indexPage(HttpSession session,
                            Model model) {
        session.setAttribute("sign", "1");

        User loginUser = (User) session.getAttribute("loginUser");

        List<LanguageType> languageTypes = languageTypeService.list();
        model.addAttribute("languageTypes", languageTypes);
        
        TransMsg transMsg = (TransMsg) session.getAttribute("transMsg");
        session.removeAttribute("noteTransMsg");

        if (transMsg == null) {
            transMsg = new TransMsg();
            session.setAttribute("transMsg", transMsg);
            return "main";
        } else if (loginUser == null) {

            return "main";
        } else {
            List<History> histories = historyService.getHistoriesDesc(loginUser.getId());
            session.setAttribute("histories", histories);

            return "main";
        }
        
        
    }
}
