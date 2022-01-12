package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.LanguageType;
import com.pan.dictionary.mapper.LanguageTypeMapper;
import com.pan.dictionary.service.LanguageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 17:37
 **/
@Service
public class LanguageTypeServiceImpl extends ServiceImpl<LanguageTypeMapper, LanguageType> implements LanguageTypeService {
    @Autowired
    private LanguageTypeMapper languageTypeMapper;

    @Override
    public LanguageType getLanguageTypeByCode(String code) {
        QueryWrapper<LanguageType> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(LanguageType::getCode, code);
        
        return languageTypeMapper.selectOne(wrapper);
    }
}
