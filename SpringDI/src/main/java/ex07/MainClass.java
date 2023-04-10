package ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex02.MemberDAO;

public class MainClass {
	
	public static void main(String[] args) {
		
		//java설정으로 만들어진 bean파일은
		//AnnotationConfigApplicationContext 로 사용한다
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
//		System.out.println(ctx.getBeanDefinitionCount());
		
		MemberDAO dao = ctx.getBean("dao", MemberDAO.class);
		System.out.println(dao.getDatabaseDev().getUrl());
		System.out.println(dao.getDatabaseDev().getUid());
		System.out.println(dao.getDatabaseDev().getUpw());
		
	}

}
