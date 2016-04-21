package project;

import java.util.Scanner;

import project.util.CommandUtil;

public class ProjectMain {
  Scanner keyScan = new Scanner(System.in);
  String id;
  String pw;
  String choice;
  
  public ProjectMain() {}
  
  public static void main(String[] args) {
    ProjectMain project = new ProjectMain();
    project.run();
  }
  
  public void run() {
    while (true) {
      System.out.println("1. 로그인\n0. 종료");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      mainMenuChoice(choice);
    }
  }
  
  private void mainMenuChoice(String choice) {
    switch (choice) {
    case "1":
      login();
      break;
    case "0":
      System.out.println("시스템을 종료하겠습니다.");
      System.exit(0);
    default:
      System.out.println("잘못 입력하셨습니다.");
    }
  }

  private void login() {
    System.out.print("Email : ");
    id = keyScan.nextLine();
    System.out.print("비밀번호 : ");
    pw = keyScan.nextLine();
    if (id.equalsIgnoreCase("admin")) {
      doAdmin();
    } else {
      doEmployee();
    }
  }

  private void doEmployee() {
    System.out.println("1. 개인정보수정\n2. 프로젝트 참가 현황\n3. 메인");
    System.out.print("선택> ");
    choice = keyScan.nextLine();
    
    while (!choice.equals("3")) {
      employeeMenuChoice(choice);
    }
  }

  private void employeeMenuChoice(String choice) {
    switch (choice) {
    case "1":
      employeeInfoUpdate();
      break;
    case "2":
      projectParticipate();
      break;
    case "3":
      System.out.println();
      break;
    default:
      System.out.println("잘못 입력하셨습니다.");
    }
  }

  private void projectParticipate() {
    // TODO Auto-generated method stub
    
  }

  private void employeeInfoUpdate() {
    // TODO Auto-generated method stub
    
  }

  private void doAdmin() {
    while (true) {
      System.out.println("1. 사원 관리\n2. 자격증 관리\n3. 부서 관리\n4. PM 지정\n5. ADMIN 정보변경\n6. 메인");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("6")) 
        break;
      adminMenuChoice(choice);
    }
  }

  private void adminMenuChoice(String choice) {
    switch (choice) {
    case "1":
      empoloyeeSupervise();
      break;
    case "2":
      certificationSupervise();
      break;
    case "3":
      teamSupervise();
      break;
    case "4":
      pmSelect();
      break;
    case "5":
      adminInfoUpdate();
      break;
    case "6":
      System.out.println();
      break;
    default:
      System.out.println("잘못 입력하셨습니다.");
    }
  }

  private void adminInfoUpdate() {
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

  private void pmSelect() {
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

  private void teamSupervise() {
    while (true) {
      System.out.println("1. 부서 등록\n2. 부서 수정\n3. 부서 삭제\n4. 부서 조회\n5. 전체 부서 조회\n6. 이전메뉴");
      System.out.print("선택> ");
      choice = keyScan.nextLine();
      if (choice.equals("6")) 
        break;
      teamCRUD(choice);
    }
  }

  private void teamCRUD(String choice) {
    switch (choice) {
    case "1":
      add();
      break;
    case "2":
      update();
      break;
    case "3":
      delete();
      break;
    case "4":
      oneList();
      break;
    case "5":
      allList();
      break;
    case "6":
      System.out.println();
      break;
    default:
      System.out.println("잘못 입력하셨습니다.");
    }
  }

  private void allList() {
    // TODO Auto-generated method stub
    
  }

  private void oneList() {
    // TODO Auto-generated method stub
    
  }

  private void delete() {
    // TODO Auto-generated method stub
    
  }

  private void update() {
    // TODO Auto-generated method stub
    
  }

  private void add() {
    // TODO Auto-generated method stub
    
  }

  private void certificationSupervise() {
    // TODO Auto-generated method stub
    
  }

  private void empoloyeeSupervise() {
    // TODO Auto-generated method stub
    
  }

}
