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
 * @create: 2021-10-11 23:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_history")
public class History {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("word_id")
    private Integer wordId;
    @TableField("user_id")
    private Integer userId;
    private String word;
}
