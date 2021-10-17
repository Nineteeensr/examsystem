package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhenzi.sms.ZhenziSmsClient;

import cn.kgc.kjde1035.group1.entity.Sysuser;

import cn.kgc.kjde1035.group1.service.UserService;
import cn.kgc.kjde1035.group1.service.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String apiUrl = "https://sms_developer.zhenzikj.com";
	String appId= "110214";
	String appSecret = "f1821afe-a875-4c09-864d-3dbec9a4bad8";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
		// 获取客户端提交的数据
		String name = request.getParameter("userName");
		String password = request.getParameter("userPwd");
		// 把数据封装成user对象
		Sysuser user = new Sysuser(name, password);
		// 3.调用service层方法
		Boolean res = userService.regist(user);
		
	}

}
