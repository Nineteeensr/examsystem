package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysrole;
import cn.kgc.kjde1035.group1.service.RoleService;
import cn.kgc.kjde1035.group1.service.RoleServiceImpl;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * Servlet implementation class RolServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService rs = new RoleServiceImpl();
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		if ("list".equals(cmd)) {
			list(request, response);
		} else if ("add".equals(cmd)) {
			add(request, response);
		} else if ("edit".equals(cmd)) {
			edit(request,response);
		} else if("doEdit".equals(cmd)) {
			doEdit(request,response);
		} else if("fun".equals(cmd)) {
			fun(request,response);
		} else if("updateFun".equals(cmd)) {
			updateFun(request,response);
		}
	}
	
	//鏇存柊瑙掕壊鐨�
	private void updateFun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		String[] functionIds = request.getParameterValues("function");
		Set<Integer> funIdSet = new HashSet<Integer>();
		if(functionIds!=null) {
			for (String string : functionIds) {
				funIdSet.add(Integer.parseInt(string));
			}
		}
		rs.clearRoleFun(roleId);
		Boolean result = rs.setFunctionsToRole(funIdSet, roleId);
		if(result) {
			this.list(request, response);
		}else {
			request.setAttribute("mess", "更改失败！");
			request.getRequestDispatcher("RoleServlet?cmd=fun").forward(request, response);
		}
		
	}

	//涓虹敤鎴风鐞嗛〉闈㈡彁渚涚敤鎴峰璞＄殑鍒楄〃
	private void fun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SysFunction> funList = rs.findAllFun();
		Set<Integer> funids = rs.findFunids(Integer.parseInt(request.getParameter("roleId").trim()));
		request.setAttribute("funids", funids);
		request.setAttribute("funList", funList);
		request.setAttribute("roleId", Integer.parseInt(request.getParameter("roleId").trim()));
		request.getRequestDispatcher("/role/fun.jsp").forward(request, response);
		
	}

	//鏍规嵁鍓嶅彴鏁版嵁瀵箂ysrole琛ㄨ繘琛屼慨鏀�
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		String roleName = request.getParameter("roleName");
		int roleState = Integer.parseInt(request.getParameter("roleState"));
		String roleDesc = request.getParameter("roleDesc");
		Sysrole role = new Sysrole(roleId, roleName, roleState, roleDesc);
		Boolean result = rs.doEdit(role);
		if(result) {
			request.getRequestDispatcher("RoleServlet?cmd=list").forward(request, response);
			
		}else {
			request.setAttribute("mess", "修改失败！");
			request.getRequestDispatcher("RoleServlet?cmd=list&id="+roleId);
		}
		
		System.out.println(role);
		
		
	}

	//涓轰慨鏀归〉闈㈡彁渚況ole瀵硅薄
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Sysrole role = rs.findRoleById(id);
		request.setAttribute("role", role);
		request.getRequestDispatcher("role/edit.jsp").forward(request, response);
		
	}

	// 娣诲姞瑙掕壊
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roleName = request.getParameter("roleName");
		Integer roleState = Integer.parseInt(request.getParameter("roleState"));
		String roleDesc = request.getParameter("roleDesc");
		Sysrole role = new Sysrole(roleName, roleState, roleDesc);
		Boolean result = rs.addRole(role);
		if (result) {
			request.getRequestDispatcher("RoleServlet?cmd=list").forward(request, response);
		} else {
			request.setAttribute("mess", "娣诲姞澶辫触锛�");
			request.getRequestDispatcher("role/add.jsp").forward(request, response);
		}
	}

	// 鍒嗛〉鏄剧ず鎵�鏈夎鑹�
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		System.out.println("sss");
		Integer currentPageNo = 1;
		String currentPageNoStr = request.getParameter("currentPageNo");
		if (currentPageNoStr != null) {
			currentPageNo = Integer.parseInt(currentPageNoStr);
			if (currentPageNo < 1) {
				currentPageNo = 1;
			}
			
		}

		Integer totalCount = rs.findCount();
		PageLimitUtil<Sysrole> pages = new PageLimitUtil<Sysrole>();
		pages.setCurrentPageNo(currentPageNo);
		pages.setTotalCount(totalCount);
		System.out.println(pages.getCurrentPageNo());
		List<Sysrole> roleList = rs.listLimit(pages.getCurrentPageNo(), pages.getPageSize());
		pages.setList(roleList);

		if (currentPageNo > pages.getTotalPageCount()) {
			currentPageNo = pages.getTotalPageCount();
		}

		// 璁剧疆鏄剧ず椤电爜鐨勬渶澶у拰鏈�灏�
		pages.setMinAndMax();
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("role/list.jsp").forward(request, response);
	}

}
