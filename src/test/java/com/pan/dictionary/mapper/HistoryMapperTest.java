package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.History;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:45
 **/
@SpringBootTest
public class HistoryMapperTest {
    @Autowired
    private HistoryMapper historyMapper;
    
    @Test
    void testSelect() {
        List<History> histories = historyMapper.selectList(null);
        for (History history : histories) {
            System.out.println(history);
        }
    }
}
