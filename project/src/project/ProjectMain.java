package project;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import project.context.ApplicationContext;
import project.context.request.RequestHandlerMapping;
import project.controller.AdminController;
import project.util.CommandUtil;
import project.util.Session;

public class ProjectMain {
  String id;
  String pw;
  String choice;
  ApplicationContext appContext;
  RequestHandlerMapping requestHandlerMapping;
  Scanner keyScan = new Scanner(System.in);
  Session session = new Session();
  
  public static void main(String[] args) {
    ProjectMain project = new ProjectMain();
    project.run();
  }
  
  public ProjectMain() {
    appContext = new ApplicationContext("project");
    requestHandlerMapping = new RequestHandlerMapping(appContext);
    appContext.addBean("stdinScan", keyScan);
    appContext.addBean("session", session);
    
    try {
      InputStream inputStream = Resources.getResourceAsStream(
          "conf/mybatis-config.xml");
      appContext.addBean("sqlSessionFactory", 
          new SqlSessionFactoryBuilder().build(inputStream));

    } catch (Exception e) {
      System.out.println("mybatis 준비 중 오류 발생!\n시스템을 종료하겠습니다.");
      e.printStackTrace();
      return;
    }
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
    
    while (!choice.equals("3")) {
    	System.out.println("1. 개인정보수정\n2. 프로젝트 참가 현황\n3. 메인");
    	System.out.print("선택> ");
    	choice = keyScan.nextLine();
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
  	//진행중인 프로젝트가 있는지 받아오기.
  	if (CommandUtil.confirm(keyScan, "프로젝트 작업을 진행하시겠습니까?")) {
  		doProjectTask();
  	}
  }

  private void doProjectTask() {
  	String input;
  	do{
  	System.out.print("프로젝트 코드> ");
  	input = keyScan.nextLine();
  	if(input.equals("123")) {
  		break;
  	}
  	}while(true); 
	}

	private void employeeInfoUpdate() {
  	 // 로그인된 사원의 기본 정보 수정하여 저장하게끔..
     System.out.printf("이메일? ");
     String input = keyScan.nextLine();  	
     System.out.printf("암호? ");
     input = keyScan.nextLine();  	 
     System.out.printf("전화? " );
     input = keyScan.nextLine();  	
     
     if (CommandUtil.confirm(keyScan, "변경하시겠습니까?")) {
    	 System.out.println("저장됨");
     }
     doEmployee();
    //
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
    AdminController adminController = new AdminController();
    switch (choice) {
    case "1":
      empoloyeeSupervise();
      break;
    case "2":
      certificationSupervise();
      break;
    case "3":
      adminController.teamSupervise();
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
