package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TEmp {

  private long empId;
  private String empNo;
  private String empName;
  private long empDeptId;
  private String empSex;
  private String empEducation;
  private String empEmail;
  private String empPhone;
  private java.sql.Timestamp empEntryTime;
  private java.sql.Timestamp empCreateTime;

}
