package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.service.StudentPaperService;
import cn.kgc.kjde1035.group1.service.StudentPaperServiceImpl;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * Servlet implementation class StudentPaperServlet
 */
@WebServlet("/StudentPaperServlet")
public class StudentPaperServlet extends HttpServlet {
	StudentPaperService service = new StudentPaperServiceImpl();
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("score")){
			score(request,response);
		}else if(cmd.equals("stupaper")){
			StudentPaperList(request,response);
		}
	}

	/**
	 * @throws IOException 
	 * @throws ServletException    
	 * @Title: list   
	 * @Description: (查询详细错题)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void list(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		List<Studentpaper> list = new ArrayList<Studentpaper>();
		Studentpaper stupaper = new Studentpaper();
		PageLimitUtil<Studentpaper> pages = new PageLimitUtil<Studentpaper>();
		String userId=(String) ((HttpServletRequest) request).getSession().getAttribute("userid");
		String spId = request.getParameter("spid");
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
		Integer totalCount = service.getTotalCount(spId,Integer.parseInt(userId));
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
		list = service.list(spId, Integer.parseInt(userId), currentPageNo, pages.getPageSize());
		// 给pages类中的list赋值
		pages.setList(list);
		// 将pages存到request作用域中 将数据从servlet层传到前端显示
		request.setAttribute("pages", pages);

		request.getRequestDispatcher("/user/paper/studenterror.jsp").forward(request, response);
	}

	/**   
	 * @Title: score   
	 * @Description: (查询试卷得分)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void score(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * @Title: StudentPaperList   
	 * @Description: (查询详细错题)   
	 * @param: @param request
	 * @param: @param response
	 * @return:	void
	 * @throws   
	 *
	 */
	private void StudentPaperList(ServletRequest request, ServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	

}
