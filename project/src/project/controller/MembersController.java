package project.controller;

import java.util.List;
import java.util.Scanner;

import project.annotation.Controller;
import project.annotation.RequestMapping;
import project.dao.MembersDao;
import project.domain.Certification;
import project.domain.Members;
import project.domain.Team;
import project.util.CommandUtil;

@Controller
@RequestMapping("members/")
public class MembersController {
  private MembersDao membersDao;

  public void setMembersDao(MembersDao membersDao) {
    this.membersDao = membersDao;
  }

  @RequestMapping("add.do")
  public void add(Scanner keyScan) {
    Members members = new Members();
    
    System.out.print("사원번호? ");
    members.setEmployeeNo(Integer.parseInt(keyScan.nextLine()));
    System.out.print("이름? ");
    members.setName(keyScan.nextLine());
    System.out.print("이메일? ");
    members.setEmail(keyScan.nextLine());
    System.out.print("연차? ");
    members.setYears(Integer.parseInt(keyScan.nextLine()));
    System.out.print("전화번호? ");
    members.setName(keyScan.nextLine());
    System.out.print("직급? ");
    members.setPosition(keyScan.nextLine());
    System.out.print("비밀번호? ");
    members.setPassword(keyScan.nextLine());

    if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
      try {
        membersDao.insert(members);
        System.out.println("저장하였습니다.");
      } catch (Exception e) {
        System.out.println("데이터를 저장하는데 실패했습니다.");
      }
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }
  
  @RequestMapping("delete.do")
  public void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 사원 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      if (CommandUtil.confirm(keyScan, "정말 삭제하시겠습니까?")) {
        int count = membersDao.delete(no);
        if (count > 0) {
          System.out.println("삭제하였습니다.");
        } else {
          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        }
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
      
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
  
  @RequestMapping("list.do")
  public void list() {
    try {
      List<Members> membersList = membersDao.selectList();
      
      for (Members members : membersList) {
        System.out.printf("%d, %s, %s, %s\n", members.getNo(),
            members.getName(), members.getEmail(), members.getTel());
      }
    } catch (Exception e) {
      throw new RuntimeException("사원 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("listone.do")
  public void listOne(Scanner keyScan) {
    try {
      System.out.print("검색할 사원 번호는? ");
      String name = keyScan.nextLine();
      Members membersList = membersDao.selectOne(name);

      System.out.printf("%d, %s, %s, %s\n", 
          membersList.getEmployeeNo(), membersList.getTeamCode(), 
          membersList.getName(), membersList.getEmail(), membersList.getYears(),
          membersList.getMemberTel(), membersList.getPosition(), 
          membersList.getPassword(), membersList.getRole());
      
    } catch (Exception e) {
      throw new RuntimeException("사원 데이터 로딩 실패!", e);
    }
  }
  
  @RequestMapping("update.do")
  public void update(Scanner keyScan) {
    try {
      System.out.print("변경할 사원 번호는? ");
      int no = Integer.parseInt(keyScan.nextLine());
  
      Members members = membersDao.selectOneUpdate(no);
      if (members == null) {
        System.out.println("유효하지 않은 번호입니다.");
        return;
      }
      
      System.out.printf("사원번호(%d)? ", members.getEmployeeNo());
      members.setEmployeeNo(Integer.parseInt(keyScan.nextLine()));
      System.out.printf("이름(%s)? ", members.getName());
      members.setName(keyScan.nextLine());
      System.out.printf("이메일(%s)? ", members.getEmail());
      members.setEmail(keyScan.nextLine());
      System.out.printf("연차(%d)? ", members.getYears());
      members.setYears(Integer.parseInt(keyScan.nextLine()));
      System.out.printf("전화번호(%s)? ", members.getMemberTel());
      members.setName(keyScan.nextLine());
      System.out.printf("직급(%s)? ", members.getPosition());
      members.setPosition(keyScan.nextLine());
      System.out.printf("비밀번호(%s)? ", members.getPassword());
      members.setPassword(keyScan.nextLine());
  
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = membersDao.update(members);
        if (count > 0) {
          System.out.println("변경하였습니다.");
        } else {
          System.out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
        }
      } else {
        System.out.println("변경을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 처리에 실패했습니다.");
    }
  }
}










