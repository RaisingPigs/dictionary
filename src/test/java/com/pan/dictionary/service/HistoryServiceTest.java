package com.pan.dictionary.service;

import com.pan.dictionary.bean.History;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:07
 **/
@SpringBootTest
public class HistoryServiceTest {
    @Autowired
    private HistoryService historyService;
    
    @Test
    void testSelect() {
        List<History> histories = historyService.list();

        for (History history : histories) {
            System.out.println(history);
        }
    }
}
