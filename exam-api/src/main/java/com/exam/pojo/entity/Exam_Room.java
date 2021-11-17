package com.exam.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("exam_room")
public class Exam_Room {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String method;
    private String score;
    private Integer time;

    private Date statime;

    private Date endtime;
    @TableField(fill = FieldFill.DEFAULT )
    private Integer should;
    @TableField(fill = FieldFill.DEFAULT )
    private String real;
    @TableField(fill = FieldFill.DEFAULT )
    private Integer already;
    @TableField(fill = FieldFill.DEFAULT )
    private String none;
    @TableField(fill = FieldFill.DEFAULT )
    private String monitor;
    @TableField(fill = FieldFill.DEFAULT )
    private Integer examInfold;
}
