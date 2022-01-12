package com.pan.dictionary.utils.mine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pan.dictionary.bean.TransResult;
import com.pan.dictionary.utils.baidu.translateAPI.TransApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 11:18
 **/
public class TransResultFormat {
    private static final String APP_ID = "20211013000971525";
    private static final String SECURITY_KEY = "v0kgjoUlfKewPgoxW91K";

    public static TransResult getTransRes(String from, String to, String word) throws JsonProcessingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String result = api.getTransResult(word, from, to);
        
        /*创建Jackson的mapper*/
        ObjectMapper mapper = new ObjectMapper();

        /*mapper.readValue("被转义字符", 转义结果类)*/
        return mapper.readValue(result, TransResult.class);
    }
}
