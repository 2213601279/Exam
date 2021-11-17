package com.exam.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Test {
  private Integer id;
  private String name;
  private String method;
  private Integer count;
  private Date statime;
  private Date endtime;
  private Integer time;
}
