package project.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import project.annotation.Controller;
import project.annotation.RequestMapping;
import project.dao.CertificationDao;
import project.domain.Certification;
import project.util.CommandUtil;

@Controller
//@RequestMapping("certification/")
public class CertificationController {
  private CertificationDao certificationDao;
  
  public void setCertificationDao(CertificationDao certificationDao) {
    this.certificationDao = certificationDao;
  }

 // @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    try {
      Certification certification = new Certification();

      System.out.print("자격증번호?: ");
      certification.setCertificationNo(keyScan.nextLine());
      System.out.print("자격증명?: ");
      certification.setCertificationName(keyScan.nextLine());
      System.out.print("취득일?: ");
      certification.setAcquisitionDate(Date.valueOf(keyScan.nextLine()));
      System.out.print("사번?: ");
      certification.setEmployeeNo(Integer.parseInt(keyScan.nextLine()));

      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        certificationDao.insert(certification);
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  //@RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 자격증 번호?: ");
      String no = keyScan.nextLine();

      
      if (CommandUtil.confirm(keyScan, "정말 삭제하시겠습니까?")) {
      	
       int count = certificationDao.delete(no);
       if (count > 0) {
         System.out.println("삭제하였습니다.");
       
       } else {
         System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
       }
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
      
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  //@RequestMapping("list.do")
  public void list() {
    try {
      List<Certification> certifications = certificationDao.selectList();
      for (Certification certification : certifications) {
        System.out.printf("%d, %s, %s, %s, %,d\n",
            certification.getCertificationNo(),certification.getCertificationName(),
            certification.getAcquisitionDate(),certification.getEmployeeNo());
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 자격증 번호?");
      String no = keyScan.nextLine();

      Certification certification = certificationDao.selectOne(no);
      if (certification == null) {
        System.out.println("유효하지 않은 번호입니다.");
        return;
      }
      
      System.out.printf("자격증번호(%s)? ", certification.getCertificationNo());
      certification.setCertificationNo(keyScan.nextLine());
      System.out.printf("자격증명(%s)? ", certification.getCertificationName());
      certification.setCertificationName(keyScan.nextLine());
      System.out.printf("취득일(%s)? ", certification.getAcquisitionDate());
      certification.setAcquisitionDate(Date.valueOf(keyScan.nextLine()));
      System.out.printf("사번(%s)? ", certification.getEmployeeNo());
      certification.setEmployeeNo(Integer.parseInt(keyScan.nextLine()));

      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = certificationDao.update(certification);
        if (count > 0) {
          System.out.println("변경하였습니다.");
          
        } else {
          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        }
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
}
