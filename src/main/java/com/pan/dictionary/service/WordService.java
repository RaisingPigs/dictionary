package com.pan.dictionary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.dictionary.bean.Word;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:01
 **/
public interface WordService extends IService<Word> {
    Word getOneByWordAndLanguage(String word, String code);
}
