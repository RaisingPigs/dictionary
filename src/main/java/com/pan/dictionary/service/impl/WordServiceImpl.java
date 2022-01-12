package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.LanguageType;
import com.pan.dictionary.bean.Word;
import com.pan.dictionary.mapper.LanguageTypeMapper;
import com.pan.dictionary.mapper.WordMapper;
import com.pan.dictionary.service.WordService;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:02
 **/
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements WordService {
    @Autowired
    private LanguageTypeMapper languageTypeMapper;
    
    @Autowired
    private WordMapper wordMapper; 
    
    @Override
    public Word getOneByWordAndLanguage(String word, String code) {
        QueryWrapper<LanguageType> languageTypeQueryWrapper = new QueryWrapper<>();
        languageTypeQueryWrapper.lambda().eq(LanguageType::getCode, code);
        LanguageType languageType = languageTypeMapper.selectOne(languageTypeQueryWrapper);

        QueryWrapper<Word> wordQueryWrapper = new QueryWrapper<>();
        wordQueryWrapper.lambda().eq(Word::getWord, word).eq(Word::getLanguage,languageType.getId());
        return wordMapper.selectOne(wordQueryWrapper);
    }
}
