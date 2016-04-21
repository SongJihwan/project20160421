package project.domain;

import java.sql.Date;

public class Certification {
  String certificationNo; //PK
  String certificationName;
  Date acquisitionDate;
  int employeeNo; //FK
  
  
  public String getCertificationNo() {
    return certificationNo;
  }
  public void setCertificationNo(String certificationNo) {
    this.certificationNo = certificationNo;
  }
  public String getCertificationName() {
    return certificationName;
  }
  public void setCertificationName(String certificationName) {
    this.certificationName = certificationName;
  }
  public Date getAcquisitionDate() {
    return acquisitionDate;
  }
  public void setAcquisitionDate(Date acquisitionDate) {
    this.acquisitionDate = acquisitionDate;
  }
  public int getEmployeeNo() {
    return employeeNo;
  }
  public void setEmployeeNo(int employeeNo) {
    this.employeeNo = employeeNo;
  }
  
  
  
  
  
  
}
