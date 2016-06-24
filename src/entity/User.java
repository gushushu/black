package entity;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.CollectionsUtils;

public class User {

	public static void main(String[] args) throws NoSuchAlgorithmException {
	/*	MessageDigest md = MessageDigest.getInstance("sha");
		byte[] bt = md.digest("admin".getBytes());
		System.out.println(Arrays.toString(bt));*/
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		Map<String, Object> map5 = new HashMap<String, Object>();
		map1.put("name", "name1");
		map1.put("age", "age1");
		
		map2.put("name", "name2");
		map2.put("age", "age2");
		
		map3.put("name", "age3");
		map3.put("age", "age3");
		
		map4.put("name", "age4");
		map4.put("age", "age4");
		
		map5.put("name", "name5");
		map5.put("age", "age5");
		
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		maplist.add(map1);
		maplist.add(map2);
		maplist.add(map3);
		maplist.add(map4);
		maplist.add(map5);
		
		List<User> list = CollectionsUtils.convertBeanList(maplist, User.class);
		
		for(User user:list){
			System.out.println(user.name+"\t"+user.age);
		}
		
		
	}
	
	
	private String name;
	private String age;
	@Override
	public String toString() {
		return "user [name=" + name + ", age=" + age + "]";
	}
	
}
