package ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
	
	GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("application-context.xml");
	//생성자를 통한 주입 확인
//	Hotel hotel = ctx.getBean(Hotel.class);
//		hotel.getChef().cooking();
		
	MemberDAO dao = ctx.getBean("dao", MemberDAO.class);
		
	DatabaseDev dev =  dao.getDatabaseDev();
	
	System.out.println(dev.getUrl());
	System.out.println(dev.getUid());
	System.out.println(dev.getUpw());
		
		
	}
	
	

}
