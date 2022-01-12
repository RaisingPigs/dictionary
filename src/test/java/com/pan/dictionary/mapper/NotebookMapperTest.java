package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.Notebook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:56
 **/
@SpringBootTest
public class NotebookMapperTest {
    @Autowired
    private NotebookMapper notebookMapper;
    
    @Test
    void testSelect() {
        List<Notebook> notebooks = notebookMapper.selectList(null);

        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }
}
