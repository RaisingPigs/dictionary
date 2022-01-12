package com.pan.dictionary.bean;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 10:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransResult {
    private String from;
    private String to;
    @JsonAlias("trans_result")
    private List<Map<String, Object>> transResult;
}
