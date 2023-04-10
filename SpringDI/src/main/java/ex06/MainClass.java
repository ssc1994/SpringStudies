package ex06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("autowired-context.xml");
		
		ServiceImpl service = ctx.getBean("service", ServiceImpl.class);
//		System.out.println(service.hello());

		Controller controller = ctx.getBean("controller", Controller.class);
		controller.hello();
		
		
		
		
	}

}
