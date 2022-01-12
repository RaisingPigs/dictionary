package com.pan.dictionary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.dictionary.bean.LanguageType;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 17:37
 **/
public interface LanguageTypeService extends IService<LanguageType> {
    LanguageType getLanguageTypeByCode(String code);
}
