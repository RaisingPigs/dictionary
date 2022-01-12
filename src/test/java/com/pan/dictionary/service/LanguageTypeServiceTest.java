package com.pan.dictionary.service;

import com.pan.dictionary.bean.LanguageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 17:41
 **/
@SpringBootTest
public class LanguageTypeServiceTest {
    @Autowired
    private LanguageTypeService languageTypeService;
    
    @Test
    void testSelect() {
        List<LanguageType> list = languageTypeService.list();
        for (LanguageType type : list) {
            System.out.println(type);
        }
    }
}
