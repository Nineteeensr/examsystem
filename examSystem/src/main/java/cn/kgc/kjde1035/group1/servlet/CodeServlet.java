package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.kjde1035.group1.utils.PhonUtil;



/**
 * 涓撻棬鍋歝ode楠岃瘉鐨勯獙璇�
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
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
		String phoneNumber = request.getParameter("phoneNumber");
		String code = PhonUtil.getphon(phoneNumber);
		System.out.println(code);
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("code", code);
		JSON resultJson = (JSON)JSON.toJSON(resultMap);
		response.getWriter().print(resultJson);
	}

}
