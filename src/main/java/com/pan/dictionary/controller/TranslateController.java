package com.pan.dictionary.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pan.dictionary.bean.*;
import com.pan.dictionary.service.HistoryService;
import com.pan.dictionary.service.NoteService;
import com.pan.dictionary.service.WordService;
import com.pan.dictionary.utils.mine.TransResultFormat;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-14 13:35
 **/
@Controller
@RequestMapping("/translate")
public class TranslateController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private WordService wordService;

    @GetMapping("/search")
    public String translate(@RequestParam("from") String from,
                            @RequestParam("to") String to,
                            @RequestParam("word") String word,
                            HttpSession session) throws JsonProcessingException {

        Word transWord = wordService.getOneByWordAndLanguage(word, to);
        TransMsg transMsg;
        if (transWord != null) {
            transMsg = new TransMsg(transWord, from, to);
        } else {
            TransResult transRes = TransResultFormat.getTransRes(from, to, word);
            transMsg = new TransMsg(word, (String) transRes.getTransResult().get(0).get("dst"), from, to);
        }

        session.setAttribute("transMsg", transMsg);

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            List<History> histories = (List<History>) session.getAttribute("histories");

            if (histories == null) {
                histories = new LinkedList<>();
            }

            histories.add(0, new History(null, null, null, word));
            histories = new LinkedList<>(new LinkedHashSet<>(histories));

            session.setAttribute("histories", histories);
        } else {
            if (!historyService.isExist(loginUser.getId(), word)) {
                historyService.save(new History(null, null, loginUser.getId(), word));
            }
        }

        List<Note> notes = noteService.list(new QueryWrapper<Note>().lambda().eq(Note::getWord, word));

        if (notes.isEmpty()) {
            session.setAttribute("isAdd", false);
        } else {
            session.setAttribute("isAdd", true);
        }

        return "redirect:/index";
    }

    @GetMapping("delHistory")
    public String delHistory(@RequestParam("id") String id,
                             @RequestParam("index") String index,
                             HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser == null) {
            List<History> histories = (List<History>) session.getAttribute("histories");
            histories.remove(Integer.parseInt(index));
        } else {
            historyService.removeById(id);
        }

        return "redirect:/index";
    }
}
