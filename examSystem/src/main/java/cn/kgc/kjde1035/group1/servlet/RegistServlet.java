package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhenzi.sms.ZhenziSmsClient;

import cn.kgc.kjde1035.group1.entity.Sysuser;

import cn.kgc.kjde1035.group1.service.UserService;
import cn.kgc.kjde1035.group1.service.UserServiceImpl;
import cn.kgc.kjde1035.group1.utils.PhonUtil;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd.equals("insert")) {
			insert(request,response);
		}
	}
	Sysuser user = new Sysuser();
	public void insert(ServletRequest request, ServletResponse response) throws ServletException, IOException {
          String name= request.getParameter("userName");
		  String password=request.getParameter("userPwd");
		  String phone=request.getParameter("phone");
		  
		  if(name!=null&&password!=null&&phone!=null) {
			  user=new Sysuser(name,password,Integer.parseInt(phone));
			  String  str= PhonUtil.getphon(phone);
			  ((HttpServletRequest) request).getSession().setAttribute("yz", str);
			  insertyz(request, response);
			  
		  }
	}
	public void insertyz(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String yzm=request.getParameter("yzm");
		String str=(String)((HttpServletRequest) request).getSession().getAttribute("yz");
		if(yzm.equals(str)) {
			((HttpServletRequest) request).getSession().removeAttribute("yz");
	         UserService us=new UserServiceImpl();
	         Boolean result=us.regist(user);
	         System.out.println(user);
	         if(result) {
	        	 request.getRequestDispatcher("login.jsp").forward(request, response);
	         }else {
	        	 request.setAttribute("mags", "添加失败");
				 request.getRequestDispatcher("regist.jsp").forward(request, response); 
	         }
		}else {
			request.setAttribute("mags", "手机验证码错误");
			 request.getRequestDispatcher("/regist.jsp").forward(request, response);
			
		}
	}
}
