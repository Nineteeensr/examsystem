package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.service.ScoreService;
import cn.kgc.kjde1035.group1.service.ScoreServiceImpl;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/AvgScoreServlet")
public class AvgScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvgScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ScoreService service = new ScoreServiceImpl();
		PrintWriter out = response.getWriter();
		Sysuser user = (Sysuser) request.getSession().getAttribute("user");
		//获取班级每次考试的平均分
		List<Score> scoreList = service.getClazzAvgScore(user);
		List<String> pnameList = service.getClazzPaperName(user);
		Map<String, List> map = new HashMap<String, List>();
		
		request.setAttribute("clazzId", user.getClazzId());
		map.put("avg", scoreList);
		map.put("pname", pnameList);
		//转成JSON对象
		JSON json = (JSON) JSON.toJSON(map);
		out.print(json);
	}

}
