package com.pan.dictionary.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-13 17:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_language_type")
public class LanguageType {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String type;
    private String code;
}
