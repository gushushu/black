package util;
import java.util.HashMap;
import java.util.Map;

public class JsonResponseUtils {
	
	
	public final static String KEY_STATUS = "status";
	public final static String KEY_MSG = "msg";
	public final static String KEY_DATA = "data";
	
	public final static String STATUS_VALUE_OK = "ok";
	public final static String STATUS_VALUE_ERR = "err";
	
	public final static String MSG_NO_PARAM = "缺少参数";
	
	/**
	 * 成功响应
	 * @param data 响应的数据
	 * @param msg 响应的消息
	 * @return
	 */
	public Map<String,Object> ok(Object data,String msg) {
		Map<String, Object> responseData = put(data, msg);
		responseData.put(KEY_STATUS, STATUS_VALUE_OK);
		return responseData;
	}
	
	/**
	 * 错误响应
	 * @param data 响应的数据
	 * @param msg 响应的消息
	 * @return
	 */
	public Map<String,Object> err(Object data,String msg) {
		Map<String, Object> responseData = put(data, msg);
		responseData.put(KEY_STATUS, STATUS_VALUE_ERR);
		return responseData;
		
	}
	
	
	/**
	 * 自定义响应
	 * @param data 响应的数据
	 * @param msg 响应的消息
	 * @return
	 */
	private Map<String,Object> put(Object data,String msg){
		HashMap<String,Object> responseData = new HashMap<String,Object>();
		responseData.put(KEY_DATA, data);
		responseData.put(KEY_MSG, msg);
		return responseData;
	}
	
	

}
