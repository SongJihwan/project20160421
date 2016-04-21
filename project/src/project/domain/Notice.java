package project.domain;
import java.sql.Date;

public class Notice {
  int noticeNo; //PK
  Date createDate;
  String writer;
  int views; //FK
  int employeeNo; //FK
  String role; //FK
  
  public int getNoticeNo() {
    return noticeNo;
  }
  public void setNoticeNo(int noticeNo) {
    this.noticeNo = noticeNo;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public int getViews() {
    return views;
  }
  public void setViews(int views) {
    this.views = views;
  }
  public int getEmployeeNo() {
    return employeeNo;
  }
  public void setEmployeeNo(int employeeNo) {
    this.employeeNo = employeeNo;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  
  
  
  
  
  
}
