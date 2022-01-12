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
 * @create: 2021-10-11 23:07
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_users")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String username;
    private String password;

    @TableField(exist = false)
    private List<Notebook> notebooks;
    @TableField(exist = false)
    private List<History> histories;
}
