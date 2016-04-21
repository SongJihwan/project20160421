package project.controller;

import java.util.Scanner;

import project.annotation.Controller;
import project.annotation.RequestMapping;


@Controller
@RequestMapping("admin")
public class AdminController {
  private String choice;
  private Scanner keyScan = new Scanner(System.in);
  private TeamController teamcontrol;
  
  public void setKeyScan(Scanner keyScan) {
    this.keyScan = keyScan;
  }
  
  public void setTeamControl(TeamController teamcontrol) {
    this.teamcontrol = teamcontrol;
  }

  public void teamSupervise() {
    while (true) {
      System.out.println("1. 부서 등록\n2. 부서 수정\n3. 부서 삭제\n4. 부서 조회\n5. 전체 부서 조회\n6. 이전메뉴");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("6")) 
        break;
      teamcontrol.teamCRUD(choice);
    }
  }
}
