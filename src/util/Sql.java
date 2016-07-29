package common;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class Sql {
	
	
	public static void main(String[] args) {
		String bsql = " #{ asdf } #{ cc } ";
		
		System.out.println(new Object[]{1}[0]!=null);
		
	//	String re = "#\\{ *.+? *\\}";
		
/*		System.out.println(Pattern.matches(re, bsql));
		
		Matcher m = Pattern.compile(re).matcher(bsql);

		System.out.println(m.groupCount());
		
		System.out.println(m.find());
		System.out.println(m.group());
		
		System.out.println(m.find());
		System.out.println(m.group());*/
		
		
		
		Object[] param = {null,"cc"};
		System.out.println(compile(bsql, param));
	}
	
	
	//#{and 1=1} #{and 1=1} #{and 1=1}
	public static final String compile(String bsql,Object[] param){
		
		StringBuilder sql = new StringBuilder(bsql);
		
	/*	if(param == null) return null;
		for(int i = 0;i<param.length;i++){
			if(param[i] != null)
				break;
			if(i == param.length - 1)
				return null;
		}*/
		
		String re = "#\\{ *.+? *\\}";
		Pattern pattern = Pattern.compile(re);
		Matcher matcher = pattern.matcher(bsql);
		
		for(int i=0;i<param.length;i++){
			
			if(!matcher.find())
				try {
					throw new Exception("bsql placeholder-sql not equal param length.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			String placesql = matcher.group();
			String newsql = placesql.replace("#{", " ").replace("}", " ");
			
			int start = sql.indexOf(placesql);
			int end = start + placesql.length(); 
			if(param[i] != null)
				sql.replace(start, end, newsql);
			else
				sql.replace(start, end, "");
			
		}
		
		return " "+sql.toString()+" ";
	}
	
	

	public static final String complie(String bsql, Map<String, Object[]> param) {

		StringBuilder sql = new StringBuilder(" " + bsql + " ");

		Iterator<String> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Object[] value = param.get(key);
			if (value[0] != null) {
				int start = sql.indexOf("#" + key);
				sql.replace(start, start + key.length(), " " + value[1].toString() + " ");
				System.err.println(sql);
			}

		}

		return sql.toString().replaceAll("#.+? ", " ");
	}

}
