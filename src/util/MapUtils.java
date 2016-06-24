package util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import entity.User;

@SuppressWarnings({ "serial" })
public class MapUtils<T, V> extends HashMap<T, V> {

	public static void main(String[] args) {
		MapUtils<String, Object> map = new MapUtils<>();
		map.put("NAME", "tosssm");
		map.put("AGe", "tomsss");
		User user = map.convertObject(map, User.class);
		System.out.println(user);

	}

	public static <C> C convertObject(Map<String, Object> map, Class<C> c) {
		C cobj = null;
		try {
			cobj = c.newInstance();
			Field[] fieldArr = c.getDeclaredFields();
			for (Field field : fieldArr) {
				field.setAccessible(true);

				String key = field.getName();

				Object value = map.get(key);
				if (value != null) {
					field.set(cobj, value);
					continue;
				}

				value = map.get(key.toUpperCase());
				if (value != null) {
					field.set(cobj, value);
					continue;
				}

				value = map.get(key.toLowerCase());
				if (value != null) {
					field.set(cobj, value);
					continue;
				}

			}

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return cobj;
	}

}
