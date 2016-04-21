package project.controller;

import java.util.List;
import java.util.Scanner;

import project.annotation.Controller;
import project.annotation.RequestMapping;
import project.dao.TeamDao;
import project.domain.Team;
import project.util.CommandUtil;


@Controller
@RequestMapping("team")
public class TeamController {
  private TeamDao teamDao;
  private Scanner keyScan;
  
  public void setTeamDao(TeamDao teamDao) {
    this.teamDao = teamDao;
  }
  
  public void setScanner(Scanner keyScan) {
    this.keyScan = keyScan;
  }
  
  public void teamCRUD(String choice) {
    switch (choice) {
    case "1":
      add(keyScan);
      break;
    case "2":
      update(keyScan);
      break;
    case "3":
      delete(keyScan);
      break;
    case "4":
      oneList(keyScan);
      break;
    case "5":
      list();
      break;
    case "6":
      System.out.println();
      break;
    default:
      System.out.println("잘못 입력하셨습니다.");
    }
  }

  private void oneList(Scanner keyScan) {
    System.out.print("검색할 부서명? ");
    String code = keyScan.nextLine();

    try {
      Team team = teamDao.selectOne(code);
      if (team == null) {
        System.out.println("유효하지 않은 코드입니다.");
        return;
      }
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  //  @RequestMapping("add.do")
  private void add(Scanner keyScan) {
    try {
      Team team = new Team();

      System.out.print("부서코드? ");
      team.setTeamCode(keyScan.nextLine());
      System.out.print("부서이름? ");
      team.setTeamName(keyScan.nextLine());
      
      if (CommandUtil.confirm(keyScan, "저장하시겠습니까?")) {
        teamDao.insert(team);
        System.out.println("저장하였습니다.");
      } else {
        System.out.println("저장을 취소하였습니다.");
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
//  @RequestMapping("delete.do")
  private void delete(Scanner keyScan) {
    try {
      System.out.print("삭제할 부서 코드?");
      String code = keyScan.nextLine();

      if (CommandUtil.confirm(keyScan, "정말 삭제하시겠습니까?")) {
       int count = teamDao.delete(code);
       if (count > 0) {
         System.out.println("삭제하였습니다.");
       
       } else {
         System.out.println("유효하지 않은 코드이거나, 이미 삭제된 항목입니다.");
       }
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
      
    } catch (Exception e) {
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
//  @RequestMapping("list.do")
  private void list() {
    try {
      List<Team> teams = teamDao.selectList();
      for (Team team : teams) {
        System.out.printf("%s, %s", team.getTeamCode(), team.getTeamName());
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("데이터 로딩에 실패했습니다.");
    }
  }
  
//  @RequestMapping("update.do")
  private void update(Scanner keyScan) {
    try {
      System.out.print("변경할 부서 코드? ");
      String code = keyScan.nextLine();

      Team team = teamDao.selectOne(code);
      if (team == null) {
        System.out.println("유효하지 않은 코드입니다.");
        return;
      }
      
      System.out.print("부서코드? ");
      team.setTeamCode(keyScan.nextLine());
      System.out.print("부서이름? ");
      team.setTeamName(keyScan.nextLine());
      
      if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
        int count = teamDao.update(team);
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
