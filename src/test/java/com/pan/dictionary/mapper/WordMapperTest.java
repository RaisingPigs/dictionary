package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.Word;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:54
 **/
@SpringBootTest
public class WordMapperTest {
    @Autowired
    private WordMapper wordMapper;
    
    @Test
    void testSelect() {
        List<Word> words = wordMapper.selectList(null);
        for (Word word : words) {
            System.out.println(word);
        }
    }
}
