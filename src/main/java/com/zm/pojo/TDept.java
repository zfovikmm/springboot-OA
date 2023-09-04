package com.zm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDept {

  private long deptId;
  private String deptNo;
  private String deptName;
  private String deptLocation;
  private long deptPid;

}
