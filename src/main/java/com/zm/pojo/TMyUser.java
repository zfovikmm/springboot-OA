package com.zm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TMyUser {

  private long myId;
  private String myAccount;
  private String myPwd;
  private String myEmpNo;
  private long myRoleId;
  private java.sql.Timestamp myCreateTime;

}
