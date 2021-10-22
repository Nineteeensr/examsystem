package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.alibaba.fastjson.JSON;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.dao.PaperDao;
import cn.kgc.kjde1035.group1.dao.PaperDaoImpl;
import cn.kgc.kjde1035.group1.service.PaperService;
import cn.kgc.kjde1035.group1.service.PaperServiceImpl;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * Servlet implementation class pperServlet
 */
@WebServlet("/PaperServlet")
public class PaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 创建dao层对象
	PaperDao pd = new PaperDaoImpl();
	// 创建service层的对象
	PaperService ps = new PaperServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String cmd = request.getParameter("cmd");

		if (cmd.equals("add")) {
			add(request, response);
		} else if (cmd.equals("list")) {
			limit(request, response);
		} else if (cmd.equals("sList")) {
			sList(request, response);
		} else if (cmd.equals("delete")) {
			String pname = new String(request.getParameter("pname"));
			Paper paperDelete = new Paper();
			paperDelete.setPname(pname);
			ps.removePaperByPname(pname);
			request.getRequestDispatcher("PaperServlet?cmd=list").forward(request, response);
//			delete(request, response);
		}
	}

	// 添加试卷
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String pname = request.getParameter("pname");
		String scount = request.getParameter("scount");
		Paper paperList = new Paper(pname, Integer.parseInt(scount));
		Integer result = ps.addPaper(paperList);
		if (result > 0) {

			request.getRequestDispatcher("PaperServlet?cmd=list").forward(request, response);
		} else {
			request.setAttribute("mess", "试题增加失败");
			request.getRequestDispatcher("sys/paper/add.jsp").forward(request, response);
		}

	}

	// 显示试卷内容
	private void sList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnames = new String(request.getParameter("pname"));
		String str = URLEncoder.encode(pnames, "utf-8");
		List<Subject> subjectList = pd.getSubjectListByPname(str);
		if (subjectList == null) {
			request.setAttribute("mess", "试题显示错误");
		} else {
//			System.out.println(subjectList);
			request.setAttribute("subjectList", subjectList);
			request.getRequestDispatcher("sys/paper/sdetail.jsp").forward(request, response);
		}
	}

	// 分页显示全部试卷
	private void limit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageLimitUtil<Paper> pager = new PageLimitUtil<Paper>();
		List<Paper> paperList = new ArrayList<Paper>();
		String pname = request.getParameter("pname");
		Paper paper = new Paper();

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
		Integer totalCount = ps.getTotalCount(pname);
		// 给pages的总记录数赋值
		pager.setTotalCount(totalCount);
		// 获取总页数
		Integer totalPageCount = pager.getTotalPageCount();
		// 控制当前页码
		if (currentPageNo < 1) {
			currentPageNo = 1;
		}
		if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		// 给pages的当前页码赋值
		pager.setCurrentPageNo(currentPageNo);
		// 获取当前页的数据
		paperList = ps.findPaperListByLimit(pname, currentPageNo, pager.getPageSize());
		// 给pages类中的list赋值
		pager.setList(paperList);
		// 将pages存到request作用域中 将数据从servlet层传到前端显示
		request.setAttribute("pager", pager);

		request.getRequestDispatcher("/sys/paper/list.jsp").forward(request, response);

	}

//	// 删除
//	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		String pnames = new String(request.getParameter("pname"));
//		Boolean delResult = ps.removePaperByPname(pnames);
//		Map<String, String> resultMap = new HashMap<String, String>();
//		resultMap.put("result", "" + delResult);
//		JSON json = (JSON) JSON.toJSON(resultMap);
//		out.print(json);
//	}
}
