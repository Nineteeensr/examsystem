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
	 * @Description: (��ѯ��ϸ����)   
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
		// ��ǰ�˽��յ�ǰҳ��
		String currNo = request.getParameter("currNo");
		// ���浱ǰҳ��
		Integer currentPageNo = 0;
		if (currNo == null) {// ��һ�η���ҳ���� ��ʾΪ��һҳ
			currentPageNo = 1;
		} else {
			currentPageNo = Integer.parseInt(currNo);
		}
		// �����ݿ��л�ȡ�ܼ�¼��
		Integer totalCount = service.getTotalCount(spId,Integer.parseInt(userId));
		// ��pages���ܼ�¼����ֵ
		pages.setTotalCount(totalCount);
		// ��ȡ��ҳ��
		Integer totalPageCount = pages.getTotalPageCount();
		// ���Ƶ�ǰҳ��
		if (currentPageNo < 1) {
			currentPageNo = 1;
		}
		if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		// ��pages�ĵ�ǰҳ�븳ֵ
		pages.setCurrentPageNo(currentPageNo);
		// ��ȡ��ǰҳ������
		list = service.list(spId, Integer.parseInt(userId), currentPageNo, pages.getPageSize());
		// ��pages���е�list��ֵ
		pages.setList(list);
		// ��pages�浽request�������� �����ݴ�servlet�㴫��ǰ����ʾ
		request.setAttribute("pages", pages);

		request.getRequestDispatcher("/user/paper/studenterror.jsp").forward(request, response);
	}

	/**   
	 * @Title: score   
	 * @Description: (��ѯ�Ծ�÷�)   
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
	 * @Description: (��ѯ��ϸ����)   
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
