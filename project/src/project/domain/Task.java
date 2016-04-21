package project.domain;
public class Task {
  String taskNo; //PK
  String projectCode; //FK
  String detailWork;
  String filePath;
  String developmentType;
  String manager; //FK 담당자 MNM
  String role; //FK
  
  
  public String getTaskNo() {
    return taskNo;
  }
  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }
  public String getProjectCode() {
    return projectCode;
  }
  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
  }
  public String getDetailWork() {
    return detailWork;
  }
  public void setDetailWork(String detailWork) {
    this.detailWork = detailWork;
  }
  public String getFilePath() {
    return filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
  public String getDevelopmentType() {
    return developmentType;
  }
  public void setDevelopmentType(String developmentType) {
    this.developmentType = developmentType;
  }
  public String getManager() {
    return manager;
  }
  public void setManager(String manager) {
    this.manager = manager;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  
  
  
  
  
  
}
