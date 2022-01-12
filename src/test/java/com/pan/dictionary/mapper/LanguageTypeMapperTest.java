package com.pan.dictionary.mapper;

import com.pan.dictionary.bean.LanguageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 17:38
 **/
@SpringBootTest
public class LanguageTypeMapperTest {
    @Autowired
    private LanguageTypeMapper languageTypeMapper;
    
    @Test
    void testSelect() {
        List<LanguageType> types = languageTypeMapper.selectList(null);
        for (LanguageType type : types) {
            System.out.println(type);
        }

    }
}
