package ex06;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceImpl {
	
	@Autowired
	private DAO dao;

	public ServiceImpl() {
	}

	public String hello() {
		return dao.hello();
	}
}
