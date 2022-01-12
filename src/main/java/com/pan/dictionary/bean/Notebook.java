package com.pan.dictionary.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: Mr.Pan
 * @create: 2021-10-11 23:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_notebooks")
public class Notebook {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;

    @TableField(exist = false)
    private List<Note> notes;
}
