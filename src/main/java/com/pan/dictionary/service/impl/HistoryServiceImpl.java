package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.History;
import com.pan.dictionary.mapper.HistoryMapper;
import com.pan.dictionary.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:04
 **/
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public boolean isExist(Integer userId, String word) {
        QueryWrapper<History> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(History::getUserId, userId);
        wrapper.lambda().eq(History::getWord, word);

        return historyMapper.selectOne(wrapper) != null;
    }

    @Override
    public List<History> getHistoriesDesc(Integer userId) {
        QueryWrapper<History> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(History::getUserId, userId);
        wrapper.lambda().orderByDesc(History::getId);
        
        return historyMapper.selectList(wrapper);
    }
}
