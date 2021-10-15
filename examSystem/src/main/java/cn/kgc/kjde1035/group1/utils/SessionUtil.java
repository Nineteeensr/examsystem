/**  
 * 
 * @Title:  SessionUtil.java   
 * @Package cn.kgc.kjde1035.group1.utils   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 14:58:16
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.utils;
import javax.servlet.http.HttpSession;
/**
 * @author 10217
 *
 */
public class SessionUtil {
	 /**
     * ������֤����Ϣ
     * @param session 
     * @param mobile  �ֻ�����
     * @param code  ��֤��
     * @param expire ��Чʱ�䣬��λ(��)
     */
	public static void save(
			HttpSession session,
			String mobile,
			String code,
			int expire){
		session.setAttribute("zhenzisms_mobile", mobile);
		session.setAttribute("zhenzisms_code", code);
		session.setAttribute("zhenzisms_createTime", System.currentTimeMillis());
		session.setAttribute("zhenzisms_expire", expire);
	}
	/**
     * У����֤��
     * @param session 
     * @param mobile  �ֻ�����
     * @param code  ��֤��
     * @param expire ��Чʱ�䣬��λ(��)
     */
	public static String validate(
			HttpSession session,
			String mobile,
			String code){
		String sessionMobile = blank(session.getAttribute("zhenzisms_mobile"));
		String sessionCode = blank(session.getAttribute("zhenzisms_code"));
		String createTime = blank(session.getAttribute("zhenzisms_createTime"));
		String expire = blank(session.getAttribute("zhenzisms_expire"));
		if(sessionMobile.equals(""))
			return "δ������֤��";
		if(!sessionMobile.equals(mobile)){
			return "�ֻ��Ŵ���";
		}
		if(!sessionCode.equals(code)){
			return "��֤�����";
		}
		if((System.currentTimeMillis() - Long.parseLong(createTime)) > 1000 * Integer.parseInt(expire)){
			return "��֤���ѹ���";
		}
		save(session, "", "", 0);
		return "";
	}
	private static String blank(Object s){
		if(s == null)
			return "";
		return s.toString();
	}
}
