package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.service.UserService;
import cn.kgc.kjde1035.group1.service.UserServiceImpl;

/**
 * Servlet implementation class ForgetpwdServlet
 */
@WebServlet("/ForgetpwdServlet")
public class ForgetpwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      UserService service = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetpwdServlet() {
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
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String newPwd = request.getParameter("userPwd");
		Sysuser user = new Sysuser();
		user.setPhone(phone);
		user.setUserPwd(newPwd);
		Integer result = 0;
		// ��ʼ�޸�
		result = service.forgetPwd(user);
		if(result>0) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("mess", "失败！");
			request.getRequestDispatcher("forget.jsp").forward(request, response);
		}
	}

}
