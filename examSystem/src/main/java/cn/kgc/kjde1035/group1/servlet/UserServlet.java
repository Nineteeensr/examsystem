package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.service.PaperService;
import cn.kgc.kjde1035.group1.service.PaperServiceImpl;
import cn.kgc.kjde1035.group1.service.UserService;
import cn.kgc.kjde1035.group1.service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	PaperService paperService = new PaperServiceImpl();
	UserService userService = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd.equals("paperlist")) {
			index(request,response);
		} else if (cmd.equals("login")) {
			login(request,response);
		}else if(cmd.equals("init")){
			initpage(request,response);
		}else if(cmd.equals("logout")){
			logout(request,response);
		}else if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("add")){
			add(request,response);
		}else if(cmd.equals("toedit")){
			toedit(request,response);
		}else if(cmd.equals("edit")){
			edit(request,response);
		}else if(cmd.equals("toeditpwd")){
			toeditpwd(request,response);
		}else if(cmd.equals("editpwd")){
			editpwd(request,response);
		}else if(cmd.equals("paper")){
			paper(request,response);
		}else if(cmd.equals("stulogin")){
			stulogin(request,response);
		}else if(cmd.equals("answer")){
			answer(request,response);
		}
	}
	
	/**   
	 * @Title: answer   
	 * @Description: ()   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void answer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: stulogin   
	 * @Description: ()   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void stulogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: paper   
	 * @Description: (学生获取试卷内容)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void paper(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: editpwd   
	 * @Description: (修改用户密码功能)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void editpwd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: toeditpwd   
	 * @Description: (用户初始化密码修改)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void toeditpwd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: edit   
	 * @Description: (修改用户功能)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: toedit   
	 * @Description: (用户初始化修改页面)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void toedit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: add   
	 * @Description: (新增用户)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: list   
	 * @Description: (获取用户列表)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: logout   
	 * @Description: (注销退出登录)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: initpage   
	 * @Description: (初始化主页)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void initpage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: index   
	 * @Description: (登录后学生端进入的index页面)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paper paper = new Paper();
		String pname = request.getParameter("pname");
		paper.setPname(pname);
		List<Subject> subjects = paperService.subjectList(paper);
		request.setAttribute("subjects", subjects);
		request.setAttribute("pname", pname);
		request.getRequestDispatcher("/user/paper/paper.jsp").forward(request,response);
	}
	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: login   
	 * @Description: (登录servlet)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Sysuser user = new Sysuser();
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("userpwd"));
		Boolean result = userService.login(user);
		if (!result) {
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			initpage(request, response);
		}
	}

	
	
}
