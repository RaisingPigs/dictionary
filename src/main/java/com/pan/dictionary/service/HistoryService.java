package com.pan.dictionary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.dictionary.bean.History;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:03
 **/
public interface HistoryService extends IService<History> {
    boolean isExist(Integer userId, String word);

    List<History> getHistoriesDesc(Integer userId);
}
