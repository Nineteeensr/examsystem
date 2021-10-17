package cn.kgc.kjde1035.group1.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tools {

	/**
	 * 获取基地�?
	 * @param request
	 * @param response
	 * @return
	 */
	public static String Basepath(HttpServletRequest request, HttpServletResponse response){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		return basePath;
	}
	
}
