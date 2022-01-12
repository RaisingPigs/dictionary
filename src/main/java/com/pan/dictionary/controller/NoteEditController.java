package com.pan.dictionary.controller;

import com.pan.dictionary.bean.LanguageType;
import com.pan.dictionary.bean.Note;
import com.pan.dictionary.bean.TransMsg;
import com.pan.dictionary.service.LanguageTypeService;
import com.pan.dictionary.service.NoteService;
import com.sun.media.sound.SoftTuning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-14 18:44
 **/
@Controller
@RequestMapping("/noteEdit")
public class NoteEditController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private LanguageTypeService languageTypeService;

    @GetMapping("/editPage")
    public String noteEditPage(@RequestParam("language") Integer language,
                               @RequestParam("word") String word,
                               Model model) {
        Note note = noteService.getNoteByWordAndLanguageId(word, language);
        model.addAttribute("note", note);

        return "/user/edit";
    }

    @PostMapping("/saveNote")
    public String saveNote(Note note) {
        System.out.println("1"+note);
        noteService.updateById(note);
        LanguageType toLanguage = languageTypeService.getById(note.getLanguage());

        return "redirect:/note/note-search?from=auto&to=" + toLanguage.getCode() + "&word=" + note.getWord();
    }

    @GetMapping("/deleteNote")
    public String deleteNote(@RequestParam("word") String word,
                             HttpSession session) {
        noteService.removeNoteByWord(word);
        TransMsg oldNoteTransMsg = (TransMsg) session.getAttribute("noteTransMsg");

        TransMsg noteTransMsg = new TransMsg(oldNoteTransMsg.getWord(), null, oldNoteTransMsg.getFromCode(), oldNoteTransMsg.getToCode());
        
        session.setAttribute("noteTransMsg", noteTransMsg);
        
        return "redirect:/note/notebook";
    }
}
