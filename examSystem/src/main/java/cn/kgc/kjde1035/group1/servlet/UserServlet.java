package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.service.PaperService;
import cn.kgc.kjde1035.group1.service.PaperServiceImpl;
import cn.kgc.kjde1035.group1.service.StudentPaperService;
import cn.kgc.kjde1035.group1.service.StudentPaperServiceImpl;
import cn.kgc.kjde1035.group1.service.UserService;
import cn.kgc.kjde1035.group1.service.UserServiceImpl;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;
import cn.kgc.kjde1035.group1.utils.Tools;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	PaperService paperService = new PaperServiceImpl();
	UserService userService = new UserServiceImpl();
	StudentPaperService spService = new StudentPaperServiceImpl();
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
	 * @throws UnsupportedEncodingException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws UnsupportedEncodingException    
	 * @Title: answer   
	 * @Description: (提交回答问题)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void answer(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String	pname = new String (request.getParameter("pname").getBytes("iso-8859-1"),"utf-8");
		Studentpaper studentpaper = new Studentpaper();
		try {
			BeanUtils.populate(studentpaper, request.getParameterMap());
			studentpaper.setPname(pname);
			Integer result = spService.addPaper(studentpaper);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: stulogin   
	 * @Description: (学生登录)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void stulogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sysuser user = new Sysuser();
		user.setUserName(request.getParameter("username"));
		user.setUserPwd(request.getParameter("userpwd"));
		user = userService.stulogin(user);
		if(user==null) {
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			session.setAttribute("userid", user.getUserId());
			index(request,response);
		}
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: paper   
	 * @Description: (学生获取试卷内容)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void paper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paper paper = new Paper();
		String pname = request.getParameter("pname");
		paper.setPname(pname);
		List<Subject> subjects = paperService.subjectList(paper);
		request.setAttribute("subjects", subjects);
		request.setAttribute("pname", pname);
		request.getRequestDispatcher("/user/paper/paper.jsp").forward(request,response);
		
	}

	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException    
	 * @Title: editpwd   
	 * @Description: (修改用户密码功能)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void editpwd(HttpServletRequest request, HttpServletResponse response)   {
		Sysuser user = new Sysuser();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			Integer result = userService.editpwd(user);
			if (result>0) {
				response.sendRedirect(Tools.Basepath(request, response)+"UserServlet?cmd=list");
			}else {
				request.setAttribute("msg", "保存用户失败！");
				request.getRequestDispatcher("/sys/user/editpwd.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: toeditpwd   
	 * @Description: (用户初始化密码修改)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void toeditpwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sysuser user = new Sysuser();
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		user = userService.detail(user);
		if (user!=null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/sys/user/editpwd.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "需要修改的用户不存在。");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
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
		Sysuser user = new Sysuser();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			Integer result = userService.edit(user);
			if(result>0){			
				response.sendRedirect(Tools.Basepath(request, response)+"UserServlet?cmd=list");
			}else{
				request.setAttribute("msg", "保存用户失败！");
				request.getRequestDispatcher("/sys/user/edit.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: toedit   
	 * @Description: (用户初始化修改页面)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void toedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sysuser user = new Sysuser();
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		user = userService.detail(user);
		if (user!=null) {
			request.setAttribute("user",user);
			request.getRequestDispatcher("/sys/user/editpwd.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "需要修改的用户不存在");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
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
		Sysuser user = new Sysuser();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			Integer result = userService.add(user);
			if (result>0) {
				response.sendRedirect(Tools.Basepath(request, response)+"UserServlet?cmd=lsit");
			}else {
				request.setAttribute("msg", "添加用户失败请不要重复添加");
				request.getRequestDispatcher("/sys/user/add.jsp").forward(request, response);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: list   
	 * @Description: (获取用户列表)   
	 * @param: @param request
	 * @param: @param response  
	 * @return:	void
	 * @throws   
	 *
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PageLimitUtil<Sysuser> pages = new PageLimitUtil<Sysuser>();
			// 从前端接收当前页码
			String currNo = request.getParameter("currNo");
			// 保存当前页码
			Integer currentPageNo = 0;
			if (currNo == null) {// 第一次访问页面是 显示为第一页
				currentPageNo = 1;
			} else {
				currentPageNo = Integer.parseInt(currNo);
			}
			// 从数据库中获取总记录数
			Integer totalCount = userService.getTotalCount();
			// 给pages的总记录数赋值
			pages.setTotalCount(totalCount);
			// 获取总页数
			Integer totalPageCount = pages.getTotalPageCount();
			// 控制当前页码
			if (currentPageNo < 1) {
				currentPageNo = 1;
			}
			if (currentPageNo > totalPageCount) {
				currentPageNo = totalPageCount;
			}
			// 给pages的当前页码赋值
			pages.setCurrentPageNo(currentPageNo);
			// 获取当前页的数据
			List<Sysuser> userList = userService.getAllUserLimit(currentPageNo, pages.getPageSize());
			// 给pages类中的list赋值
			pages.setList(userList);
			// 将pages存到request作用域中 将数据从servlet层传到前端显示
			request.setAttribute("pages", pages);

			request.getRequestDispatcher("/sys/user/list.jsp").forward(request, response);
		
	}

	/**
	 * @throws IOException    
	 * @Title: logout   
	 * @Description: (注销退出登录)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.sendRedirect(Tools.Basepath(request, response)+"login.jsp");
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: initpage   
	 * @Description: (初始化主页)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void initpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Sysuser user = (Sysuser)session.getAttribute("user");
		List<SysFunction> list = userService.initpage(user);
		request.setAttribute("list", list);
		RequestDispatcher rds = request.getRequestDispatcher("/index.jsp");
		rds.forward(request,response);
		return;
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
		List<Paper> papers = paperService.list(paper);
		request.setAttribute("papers", papers);
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
	}
	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: login   
	 * @Description: (登录)   
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
		Sysuser result = userService.login(user);
		if (result==null) {
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", result);
			initpage(request, response);
		}
	}

	
	
}
