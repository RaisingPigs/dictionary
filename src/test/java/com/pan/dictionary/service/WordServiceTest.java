package com.pan.dictionary.service;

import com.pan.dictionary.bean.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:13
 **/
@SpringBootTest
public class WordServiceTest {
    @Autowired
    private WordService wordService;
    
    @Test
    void testSelect() {
        List<Word> words = wordService.list();
        
        for (Word word : words) {
            System.out.println(word);
        }
    }
}
