package project.domain;
public class Members {
  int employeeNo; //PK
  String teamCode; //FK
  String name;
  String email;
  int years;
  String memberTel;
  String position;
  String password;
  String role; //FK
  
  public int getEmployeeNo() {
    return employeeNo;
  }
  public void setEmployeeNo(int employeeNo) {
    this.employeeNo = employeeNo;
  }
  public String getTeamCode() {
    return teamCode;
  }
  public void setTeamCode(String teamCode) {
    this.teamCode = teamCode;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getYears() {
    return years;
  }
  public void setYears(int years) {
    this.years = years;
  }
  public String getMemberTel() {
    return memberTel;
  }
  public void setMemberTel(String memberTel) {
    this.memberTel = memberTel;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  
  
  
}
