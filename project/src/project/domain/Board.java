package project.domain;

import java.sql.Date;

public class Board {
  String boardNo; //PK
  String taskNo;//FK
  Date createDate;
  int veiws;
  String content;
  String title;
  String writer;
  int employeeNo; //FK
  String projectCode; //FK
  String role; //FK
  
  
  
  public String getBoardNo() {
    return boardNo;
  }
  public void setBoardNo(String boardNo) {
    this.boardNo = boardNo;
  }
  public String getTaskNo() {
    return taskNo;
  }
  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public int getVeiws() {
    return veiws;
  }
  public void setVeiws(int veiws) {
    this.veiws = veiws;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public int getEmployeeNo() {
    return employeeNo;
  }
  public void setEmployeeNo(int employeeNo) {
    this.employeeNo = employeeNo;
  }
  public String getProjectCode() {
    return projectCode;
  }
  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }


}
