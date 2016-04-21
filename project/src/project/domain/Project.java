package project.domain;
import java.sql.Date;

public class Project {
  String projectCode; //PK
  String clientNo; //FK
  String projectName;
  String goal;
  String content;
  Date createDate;
  Date endDate;
  int progress;
  String manager; //FK MNM 책이마
  
  
  public String getProjectCode() {
    return projectCode;
  }
  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }
  public String getClientNo() {
    return clientNo;
  }
  public void setClientNo(String clientNo) {
    this.clientNo = clientNo;
  }
  public String getProjectName() {
    return projectName;
  }
  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }
  public String getGoal() {
    return goal;
  }
  public void setGoal(String goal) {
    this.goal = goal;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getProgress() {
    return progress;
  }
  public void setProgress(int progress) {
    this.progress = progress;
  }
  public String getManager() {
    return manager;
  }
  public void setManager(String manager) {
    this.manager = manager;
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
