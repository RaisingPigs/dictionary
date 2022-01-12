package com.pan.dictionary.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_words")
public class Word {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String word;
    private String pronunciation;
    private String mean;
    private String sentence;
    @TableField("sentence_translate")
    private String sentenceTranslate;
    private Integer language;
}
