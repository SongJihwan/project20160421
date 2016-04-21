package project.controller;

import java.util.Scanner;

import project.annotation.Controller;
import project.annotation.RequestMapping;
import project.util.CommandUtil;


@Controller
@RequestMapping("admin")
public class AdminController {
  private String choice;
  private Scanner keyScan;
  private TeamController teamControl;
  private CertificationController certiControl;
  private MembersController membersControl;
  
  public void setKeyScan(Scanner keyScan) {
    this.keyScan = keyScan;
  }
  
  public void setTeamControl(TeamController teamControl) {
    this.teamControl = teamControl;
  }
  
  public void setCertiControl(CertificationController certiControl) {
    this.certiControl = certiControl;
  }

  
  public void setMembersControl(MembersController membersControl) {
    this.membersControl = membersControl;
  }

  public void teamSupervise() {
    while (true) {
      System.out.println("1. 부서 등록\n2. 부서 수정\n3. 부서 삭제\n4. 부서 조회\n5. 전체 부서 조회\n6. 이전메뉴");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("6")) 
        break;
      teamControl.teamCRUD(choice);
    }
  }
  
  public void certificationSupervise() {
    while (true) {
      System.out.println("1. 자격증 등록\n2. 자격증 수정\n3. 자격증 삭제\n4. 자격증 조회\n5. 이전메뉴");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("5")) 
        break;
      certiControl.certiCRUD(choice);
    }
  }
  
  public void empoloyeeSupervise() {
    while (true) {
      System.out.println("1. 사원 등록\n2. 사원 수정\n3. 사원 삭제\n4. 사원 조회\n5. 전체 사원 조회\n6. 이전메뉴");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("6")) 
        break;
      membersControl.memberCRUD(choice);
    }
    
  }
  
  public void adminInfoUpdate() {
    System.out.println("Admin 계정은 암호만 변경이 가능합니다.");
    System.out.print("변경하실 암호? ");
    String pwd = keyScan.nextLine();
    if (CommandUtil.confirm(keyScan, "변경")) {
      //db 저장
      System.out.println("암호를 변경하였습니다.");
    } else {
      System.out.println("암호 변경을 취소하였습니다.");
    }
  }
  
  public void pmSelect() {
    //select문 사용해서 리턴하여 리스트 받아온 후
    System.out.print("PM으로 지정할 사원을 선택해주세요. ");
    int pmMno = Integer.parseInt(keyScan.nextLine());
    //select문 사용 pmMno 넘겨서 이름 받아오기
    if (CommandUtil.confirm(keyScan, /*이름*/"을 PM으로 지정")) {
      System.out.println(/*이름*/"이 PM으로 지정되었습니다.");
      
    } else {
      System.out.println(/*이름*/"을 PM으로 지정하지 않았습니다.");
    }
      
  }
}
