package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.service.ScoreService;
import cn.kgc.kjde1035.group1.service.ScoreServiceImpl;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	ScoreService ss = new ScoreServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if ("clazzList".equals(cmd)) {
			clazzList(request, response);
		} else if ("showPapers".equals(cmd)) {
			showPapers(request, response);
		} else if ("showSocres".equals(cmd)) {
			showSocres(request, response);
		}
	}

	private void showSocres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer clazzId = Integer.parseInt(request.getParameter("clazzId"));
		String pname = request.getParameter("pname");
		List<Score> scoreList = ss.findScoresByClazzId(clazzId, pname);
		request.setAttribute("scoreList", scoreList);
		request.getRequestDispatcher("sys/score/scoreList.jsp").forward(request, response);
	}

	// 根据班级显示本班级的考试
	private void showPapers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer clazzId = Integer.parseInt(request.getParameter("clazzId"));
		List<Paper> paperList = ss.quryPaperByClazzId(clazzId);
		request.setAttribute("clazzId", clazzId);
		request.setAttribute("paperList", paperList);
		request.getRequestDispatcher("sys/score/paperList.jsp").forward(request, response);
	}

	// 显示班级列表（如果角色为老师只显示自己班级，如果角色为管理员显示所有班级）
	private void clazzList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		List<Clazz> clazzList = null;
		if (roleId == -1) {
			clazzList = ss.findAllClazz();
		} else {
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			clazzList = ss.findClazzByTuserId(userId);
		}

		request.setAttribute("clazzList", clazzList);
		request.getRequestDispatcher("sys/score/clazzList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

}
