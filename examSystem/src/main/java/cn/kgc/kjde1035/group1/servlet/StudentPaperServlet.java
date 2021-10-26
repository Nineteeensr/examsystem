package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.service.ScoreService;
import cn.kgc.kjde1035.group1.service.ScoreServiceImpl;
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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("score")) {
			score(request, response);
		} else if (cmd.equals("sublist")) {
			subList(request, response);
		} else if (cmd.equals("answer")) {
			answer(request, response);
		}
	}

	// 计算得分
	private void score(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String userid = request.getParameter("userid");
		String spid = request.getParameter("spid");
		String pname = request.getParameter("pname");
		List<Subject> subList = service.findAllErr(spid, pname, Integer.parseInt(userid), 0, 0);
		System.out.println("得分时的"+spid);
		Integer count = service.rightTotalCountInPaper(spid, pname, Integer.parseInt(userid));
		Score score = new Score();
		score.setTotalScore(count*10);
		score.setPname(pname);
		score.setUserId(Integer.parseInt(userid));
		ScoreService scoreServiec = new ScoreServiceImpl();
		Boolean result = scoreServiec.appendScore(score);
		request.setAttribute("score", count);
		response.getWriter().print("您本次得分" + count * 10 + "!");

	}

	// 将学生的考试记录存入数据库
	private void answer(HttpServletRequest request, HttpServletResponse response) {
		Integer userId = (Integer)request.getSession().getAttribute("userid");
		String[] studentkeys = request.getParameterValues("studentkey");
		String[] studentState = request.getParameterValues("studentstate");
		String pname = request.getParameter("pname");
		String spid = request.getParameter("spid");
		System.out.println("交卷时：" + spid);
		request.setAttribute("spid", spid);
		String[] sid = request.getParameterValues("sid");
		List<Studentpaper> stuPList = new ArrayList<Studentpaper>();
		for (int i = 0; i < studentkeys.length; i++) {
			Studentpaper stuPaper = new Studentpaper();
			stuPaper.setUserid(userId);
			stuPaper.setStudentkey(studentkeys[i]);
			stuPaper.setStudentstate(Integer.parseInt(studentState[i]));
			stuPaper.setPname(pname);
			stuPaper.setSpid(spid);
			stuPaper.setSid(Integer.parseInt(sid[i]));
			stuPList.add(stuPaper);
		}
		Boolean result = service.addPapers(stuPList);

		/*
		 * System.out.println(""); Map<String, String[]> pMap =
		 * request.getParameterMap(); Set<String> keySet = pMap.keySet(); for (String
		 * key : keySet) { String[] value = pMap.get(key); System.out.println(key); for
		 * (String string : value) { System.out.println("   " + string); } }
		 */

	}

	// 显示试卷中的错题
	private void subList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currenNo = request.getParameter("currentPageNo");
		Integer currentPageNo = 0;
		if (currenNo == null) {
			currentPageNo = 1;
		} else {
			currentPageNo = Integer.parseInt(currenNo);
			if (currentPageNo < 1)
				currentPageNo = 1;
		}
		String pname = request.getParameter("pname");
		String spid = request.getParameter("spid");
		Integer userid = (Integer) request.getSession().getAttribute("userid");
		System.out.println("ERRO:" + userid);
		Integer totalCount = service.ErrTotalCountInPaper(spid, pname, userid);
		PageLimitUtil<Subject> pages = new PageLimitUtil<Subject>();
		pages.setTotalCount(totalCount);
		if (currentPageNo > pages.getTotalPageCount()) {
			currentPageNo = pages.getTotalPageCount();
		}
		pages.setCurrentPageNo(currentPageNo);
		List<Subject> subList = service.findAllErr(spid, pname, userid, currentPageNo, pages.getPageSize());
		for (Subject subject : subList) {
			System.out.println(subject);
		}
		pages.setList(subList);
		pages.setMinAndMax();
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("user/paper/studenterror.jsp").forward(request, response);
	}

	// 显示做过的试卷
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currenNo = request.getParameter("currentPageNo");
		Integer currentPageNo = 0;
		if (currenNo == null) {
			currentPageNo = 1;
		} else {
			currentPageNo = Integer.parseInt(currenNo);
			if (currentPageNo < 1)
				currentPageNo = 1;
		}
		Integer userId = (Integer) request.getSession().getAttribute("userid");
		Sysuser user = (Sysuser) request.getSession().getAttribute("user");
		System.out.println(user);
		System.out.println(userId);
		Integer totalCount = service.getPaperTotalCount(userId);
		PageLimitUtil<Studentpaper> pages = new PageLimitUtil<Studentpaper>();
		pages.setTotalCount(totalCount);
		if (currentPageNo > pages.getTotalPageCount()) {
			currentPageNo = pages.getTotalPageCount();
		}
		pages.setCurrentPageNo(currentPageNo);
		List<Studentpaper> stuPaperList = service.showLimit(pages.getCurrentPageNo(), pages.getPageSize(), userId);
		pages.setList(stuPaperList);
		pages.getMaxPageNo();
		request.setAttribute("pages", pages);
		request.getRequestDispatcher("user/paper/studentpaper.jsp").forward(request, response);
	}

}
