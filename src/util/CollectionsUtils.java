package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class CollectionsUtils {
	
	
	public static <T>List<T> convertBeanList(List<Map<String, Object>> maplist,Class<T> beanclass){
		List<T> list = new ArrayList<T>();
		for(Map<String,Object> map:maplist){
			T b = MapUtils.convertObject(map, beanclass);
			list.add(b);
		}
		return list;
	}

	public static <T,V>List<V> getValueList(List<T> objlist,String name){
		T[] objarr = (T[]) objlist.toArray(new Object[objlist.size()]);
		return getValueList(objarr, name);
	}
	
	public static <T,V>List<V> getValueList(T[] objs,String name){
		List<V> list = new ArrayList<V>();
		try {
			Field field = objs[0].getClass().getDeclaredField(name);
			field.setAccessible(true);
			for(Object obj:objs){
				list.add((V) field.get(obj));
			}
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
