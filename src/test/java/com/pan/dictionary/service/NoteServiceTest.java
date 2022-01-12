package com.pan.dictionary.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.dictionary.bean.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:12
 **/
@SpringBootTest
public class NoteServiceTest {
    @Autowired
    private NoteService noteService;
    
    @Test
    void testSelect() {
        List<Note> notes = noteService.list();
        
        for (Note note : notes) {
            System.out.println(note);
        }
    }
    
    @Test
    void test() {
        List<Note> list = noteService.list(new QueryWrapper<Note>().lambda().eq(Note::getWord, "ann"));
        System.out.println(list.isEmpty());
    }
}
