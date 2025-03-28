package com.example.Project_Cuoi_Ky.dto;

public class ResponseData {
private int errCode;
private String errMssage;
private Object data;

 public ResponseData(int errCode, String errMssage, Object data) {
    this.errCode = errCode;
    this.errMssage = errMssage;
    this.data = data;
 }

public int getErrCode() {
    return errCode;

 }
 public void setErrCode(int errCode) {
    this.errCode = errCode;
 }

 public String getErrMssage() {
    return errMssage;

 }
 public void setErrMssage(String errMssage) {
    this.errMssage = errMssage;
 }
 public Object getData() {
    return data;

 }
 public void setData(Object data) {
    this.data = data;
 }
}
