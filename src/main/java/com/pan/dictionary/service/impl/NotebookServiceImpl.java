package com.pan.dictionary.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.dictionary.bean.Notebook;
import com.pan.dictionary.mapper.NotebookMapper;
import com.pan.dictionary.service.NotebookService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-12 00:06
 **/
@Service
public class NotebookServiceImpl extends ServiceImpl<NotebookMapper, Notebook> implements NotebookService {
}
