


package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
		}else if(cmd.equals("stuIndex")) {
			index(request,response);
		}
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws UnsupportedEncodingException    
	 * @Title: answer   
	 * @Description: (??????????????????????????)   
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
	 * @Description: (????????????????)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void stulogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sysuser user = new Sysuser();
		String code= (String)request.getSession().getAttribute("code");
		if(!code.equals(request.getParameter("uCode").toUpperCase())) {
			request.setAttribute("mess", "???????????????");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		user.setUserName(request.getParameter("userName"));
		user.setUserPwd(request.getParameter("userPwd"));
		user = userService.stulogin(user);
		if(user==null) {
			request.setAttribute("mess", "????????????????????????");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			session.setAttribute("userid", user.getUserId());
//			index(request,response);
			request.getRequestDispatcher("UserServlet?cmd=stuIndex&userid="+user.getUserId()).forward(request, response);
		}
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: paper   
	 * @Description: (????????????????????????????????????)   
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
	 * @Description: (??????????????????????????????????)   
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
				request.setAttribute("msg", "??????????????????????????????");
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
	 * @Description: ()   
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
			request.setAttribute("msg", "??????????????????????????????????????????????");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	/**   
	 * @Title: edit   
	 * @Description: (????????????????????????????)   
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
			String userid= request.getParameter("userid");
			String userPwd = request.getParameter("userpwd");
			String usertruename = request.getParameter("usertruename");
			String userstate = request.getParameter("userstate");
			String phone = request.getParameter("phone");
			String roleid = request.getParameter("roleid");
			String clazzId = request.getParameter("project_id");
			
			user = new Sysuser(userPwd,usertruename, Integer.parseInt(userstate), phone,Integer.parseInt(roleid),Integer.parseInt(clazzId));
			Integer result = userService.edit(user);
			if(result>0){			
				response.sendRedirect(Tools.Basepath(request, response)+"UserServlet?cmd=list");
			}else{
				request.setAttribute("msg", "?????????????????????");
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
	 * @Description: (??????????????????????????????????????)   
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
		List<Sysuser> list = userService.getClazzInfo();
		if (user!=null) {
			request.setAttribute("item",user);
			request.setAttribute("clazz",list);
			request.getRequestDispatcher("/sys/user/edit.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "??????????????????????????????");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	/**   
	 * @Title: add   
	 * @Description: (????????????????????)   
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
				request.setAttribute("msg", "??????????????????????????????????????????????????");
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
	 * @Description: (????????????????????????)   
	 * @param: @param request
	 * @param: @param response  
	 * @return:	void
	 * @throws   
	 *
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PageLimitUtil<Sysuser> pages = new PageLimitUtil<Sysuser>();
			List<Sysuser> userList = new ArrayList<Sysuser>();
			String usname = request.getParameter("usname");
			String userTrueName = request.getParameter("ustruename");
			String roleId = request.getParameter("usroleid");
			Integer rId=0;
			if(roleId!=null&&!"".equals(roleId)) {
				rId=Integer.parseInt(roleId);
			}
				Sysuser user = new Sysuser();
				user.setUserName(usname); 
				
				// ??????????????????????????????????
				String currNo = request.getParameter("currNo");
				// ??????????????????????
				Integer currentPageNo = 0;
				if (currNo == null) {// ???????????????????????????????????? ????????????????????
					currentPageNo = 1;
				} else {
					currentPageNo = Integer.parseInt(currNo);
				}
				// ??????????????????????????????????????????????
				Integer totalCount = userService.getTotalCount(usname,rId,userTrueName);
				// ??????pages??????????????????????????????
				pages.setTotalCount(totalCount);
				// ??????????????????????
				Integer totalPageCount = pages.getTotalPageCount();
				// ????????????????????????
				if (currentPageNo < 1) {
					currentPageNo = 1;
				}
				if (currentPageNo > totalPageCount) {
					currentPageNo = totalPageCount;
				}
				// ??????pages????????????????????
				pages.setCurrentPageNo(currentPageNo);
				// ????????????????????????????????????
				userList = userService.getAllUserLimit(usname,rId,userTrueName,currentPageNo, pages.getPageSize());
				// ??????pages??????????????list????????
				pages.setList(userList);
				// ??????pages??????request???????????????????????? ????????????????????servlet????????????????????????????
				request.setAttribute("pages", pages);

				request.getRequestDispatcher("/sys/user/list.jsp").forward(request, response);
			
				
			
			
	}

	/**
	 * @throws IOException    
	 * @Title: logout   
	 * @Description: (????????????????????????)   
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
	 * @Description: (??????????????????????)   
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
	 * @Description: (???????????????????????????????????????index????????)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Paper paper = new Paper();
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid);
		List<Paper> papers = paperService.list(userid);
		request.setAttribute("papers", papers);
		request.getRequestDispatcher("/user/index.jsp").forward(request, response);
	}
	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: login   
	 * @Description: (????????)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sysuser user = new Sysuser();
		user.setUserName(request.getParameter("userName"));
		user.setUserPwd(request.getParameter("userPwd"));
		String codeStr = (String)request.getSession().getAttribute("code");
		String code = request.getParameter("uCode");
		
		if(!codeStr.equals(code.toUpperCase())) {
			request.setAttribute("mess", "???????????????");
			System.err.println("???????????????");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		Sysuser result = userService.login(user);
		if (result==null) {
			request.setAttribute("mess", "????????????????????????");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", result);
			initpage(request, response);
		}
	}

	
	
}
