package ex03;

import java.util.List;
import java.util.Map;

public class Customer {
	
	//list or map 의 의존성 주입
	private List<String> lists;
	private List<Person> persons;
	private Map<String, Object> maps;
	
	
	//get
	public List<String> getLists() {
		return lists;
	}
	//set
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	
	//get
	public Map<String, Object> getMaps() {
		return maps;
	}
	//set
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	
	//get
	public List<Person> getPersons() {
		return persons;
	}
	//set
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	

	
}
