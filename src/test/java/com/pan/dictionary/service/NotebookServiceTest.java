package com.pan.dictionary.service;

import com.pan.dictionary.bean.Notebook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:09
 **/
@SpringBootTest
public class NotebookServiceTest {
    @Autowired
    private NotebookService notebookService;
    
    @Test
    void testSelect() {
        List<Notebook> notebooks = notebookService.list();

        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
    }
}
