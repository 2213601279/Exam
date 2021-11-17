package com.exam.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("role")
public class Role implements Serializable {
    private Integer id;

    private String roleName;
}
