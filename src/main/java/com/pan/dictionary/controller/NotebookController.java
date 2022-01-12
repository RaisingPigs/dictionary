package com.pan.dictionary.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pan.dictionary.bean.*;
import com.pan.dictionary.service.LanguageTypeService;
import com.pan.dictionary.service.NoteService;
import com.pan.dictionary.service.NotebookService;
import com.pan.dictionary.service.UserService;
import com.pan.dictionary.utils.mine.TransResultFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-14 01:25
 **/
@Controller
@RequestMapping("/note")
public class NotebookController {
    @Autowired
    private UserService userService;
    @Autowired
    private NotebookService notebookService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private LanguageTypeService languageTypeService;

    @GetMapping("/notebook")
    public String notebookPage(HttpSession session,
                               Model model) throws JsonProcessingException {
        session.setAttribute("sign", "2");

        List<LanguageType> languageTypes = languageTypeService.list();
        model.addAttribute("languageTypes", languageTypes);

        TransMsg noteTransMsg = (TransMsg) session.getAttribute("noteTransMsg");
        if (noteTransMsg == null) {
            noteTransMsg = new TransMsg();
            session.setAttribute("noteTransMsg", noteTransMsg);
        }

        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser != null) {
            List<Notebook> notebooks = notebookService.list(new QueryWrapper<Notebook>().lambda().eq(Notebook::getUserId, loginUser.getId()));

            for (Notebook notebook : notebooks) {
                List<Note> notes = noteService.list(new QueryWrapper<Note>().lambda().eq(Note::getNoteId, notebook.getId()));

                notebook.setNotes(notes);
            }

            List<Note> noteList = notebooks.get(0).getNotes();
            LinkedHashSet<String> notes = new LinkedHashSet<>();
            for (Note note : noteList) {
                notes.add(note.getWord());
            }

            session.setAttribute("notes", notes);
        }

        session.removeAttribute("transMsg");
        return "user/notebook";
    }

    @GetMapping("note-search")
    public String noteSearch(@RequestParam("from") String from,
                             @RequestParam("to") String to,
                             @RequestParam("word") String word,
                             HttpSession session) throws JsonProcessingException {

        LanguageType toLanguage = languageTypeService.getLanguageTypeByCode(to);
        LinkedHashSet<String> notes = (LinkedHashSet<String>) session.getAttribute("notes");

        TransMsg noteTransMsg;

        if (notes.contains(word)) {
            Note note = noteService.getNoteByWordAndLanguageId(word, toLanguage.getId());
            if (note == null) {
                TransResult transRes = TransResultFormat.getTransRes(from, to, word);
                TransMsg transMsg = new TransMsg(word, (String) transRes.getTransResult().get(0).get("dst"), from, to);
                noteService.saveNoteByTransMsg(1, transMsg, toLanguage.getId());

                note = noteService.getNoteByWordAndLanguageId(word, toLanguage.getId());
            }

            noteTransMsg = new TransMsg(note, from, to);
        } else {
            noteTransMsg = new TransMsg(word, null, from, to);
        }

        session.setAttribute("noteTransMsg", noteTransMsg);

        return "forward:/note/notebook";
    }
    
    @GetMapping("add-note")
    public String addNote(HttpSession session) {
        TransMsg transMsg = (TransMsg) session.getAttribute("transMsg");
        LanguageType toLanguage = languageTypeService.getLanguageTypeByCode(transMsg.getToCode());
        Note note = new Note(1, transMsg, toLanguage.getId());
        noteService.save(note);

        session.setAttribute("isAdd", true);

        return "redirect:/index";
    }
}
