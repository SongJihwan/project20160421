package project;

import java.util.Scanner;

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
    System.out.println("1. 사원 관리\n2. 자격증 관리\n3. 부서 관리\n4. PM 지정\n5. ADMIN 정보변경\n6. 메인");
    System.out.print("선택> ");
    choice = keyScan.nextLine();
    
    while (!choice.equals("6")) {
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
    // TODO Auto-generated method stub
    
  }

  private void pmSelect() {
    // TODO Auto-generated method stub
    
  }

  private void teamSupervise() {
    // TODO Auto-generated method stub
    
  }

  private void certificationSupervise() {
    // TODO Auto-generated method stub
    
  }

  private void empoloyeeSupervise() {
    // TODO Auto-generated method stub
    
  }

}
