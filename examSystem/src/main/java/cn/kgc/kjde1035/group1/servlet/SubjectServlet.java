package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.service.SubjectService;
import cn.kgc.kjde1035.group1.service.SubjectServiceImpl;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SubjectService subjectService = new SubjectServiceImpl();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		if (cmd.equals("add")) {// 增加
			addSubject(request, response);
		} else if (cmd.equals("del")) {// 删除
			delSubject(request, response);
		} else if (cmd.equals("update")) {// 修改
			updateSubject(request, response);
		} else if (cmd.equals("doUpdate")) {// 做修改
			doUpdateSubject(request, response);
		} else if (cmd.equals("limit")) { // 分页查询
			limit(request, response);
		}

	}

	// 增加
	private void addSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String scontent = request.getParameter("scontent");
		String sa = request.getParameter("sa");
		String sb = request.getParameter("sb");
		String sc = request.getParameter("sc");
		String sd = request.getParameter("sd");
		String skey = request.getParameter("skey");
		String sstate = request.getParameter("sstate");
		Subject subject = new Subject(scontent, sa, sb, sc, sd, skey, Integer.parseInt(sstate));
		Integer result = subjectService.addSubject(subject);
		if (result > 0) {
			request.getRequestDispatcher("SubjectServlet?cmd=limit").forward(request, response);
		} else {
			System.out.println("1111");
			request.setAttribute("mess", "增加失败请检查是否存在此题");
			out.print("<script type='text'/javascript>history.back();<script>");
		}
	}

	// 删除
	private void delSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		Integer result = subjectService.delSubject(Integer.parseInt(sid));
		if (result > 0) {
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("result", "" + result);
			JSON json = (JSON) JSON.toJSON(resultMap);
			out.print(json);
			request.getRequestDispatcher("SubjectServlet?cmd=limit").forward(request, response);
		} else {
			out.print("<script type='text/javascript'>alert('删除失败');</script>");
			request.setAttribute("mess", "删除失败");
		}

	}

	// 修改
	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		Subject subject = subjectService.getSubjectBySid(Integer.parseInt(sid));
		request.setAttribute("subject", subject);
		request.getRequestDispatcher("sys/subject/edit.jsp").forward(request, response);
	}

	// 做修改
	private void doUpdateSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String scontent = request.getParameter("scontent");
		String sa = request.getParameter("sa");
		String sb = request.getParameter("sb");
		String sc = request.getParameter("sc");
		String sd = request.getParameter("sd");
		String skey = request.getParameter("skey");
		String sstate = request.getParameter("sstate");
		String sid = request.getParameter("sid");
		Subject subject = new Subject(Integer.parseInt(sid), scontent, sa, sb, sc, sd, skey, Integer.parseInt(sstate));
		Integer result = subjectService.updateSubject(subject);
		if (result > 0) {
			request.getRequestDispatcher("SubjectServlet?cmd=limit").forward(request, response);
		} else {
			out.print("<script type='text/javascript'>alert('修改失败');</script>");
			request.getRequestDispatcher("SubjectServlet?cmd=limit").forward(request, response);
		}
	}

	// 分页查询
	private void limit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageLimitUtil<Subject> pager = new PageLimitUtil<Subject>();
		String currNo = request.getParameter("currNo");
		String scontent = request.getParameter("scontent");
		Integer currentPageNo = 0;
		if (currNo == null) {
			currentPageNo = 1;
		} else {
			currentPageNo = Integer.parseInt(currNo);
		}
		Integer totalCount = subjectService.getTotalCount(scontent);// chuanzhi
		pager.setTotalCount(totalCount);
		Integer totalPageCount = pager.getTotalPageCount();
		if (currentPageNo < 1) {
			currentPageNo = 1;
		}
		if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		pager.setCurrentPageNo(currentPageNo);
		List<Subject> subjectList = subjectService.getAllSubjectByLimit(scontent,
				(currentPageNo - 1) * pager.getPageSize(), pager.getPageSize());
//		System.out.println(subjectList);
		pager.setList(subjectList);
		pager.setMinAndMax();
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("sys/subject/list.jsp").forward(request, response);
	}
}
