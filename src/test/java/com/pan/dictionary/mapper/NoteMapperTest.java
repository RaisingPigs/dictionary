package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:52
 **/
@SpringBootTest
public class NoteMapperTest {
    @Autowired
    private NoteMapper noteMapper;
    
    @Test
    void testSelect() {
        List<Note> notes = noteMapper.selectList(null);
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
