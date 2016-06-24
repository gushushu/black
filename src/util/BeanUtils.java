package util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class BeanUtils {

	public static <T, V> HashMap<String, Object> toMap(T t) {
		HashMap<String, Object> result = new HashMap<>();

		Field[] fieldArr = t.getClass().getDeclaredFields();
		try {
			for (Field field : fieldArr) {
				field.setAccessible(true);
				String key = field.getName();
				Object value = field.get(t);
				result.put(key, value);
			}

		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;

	}

}
