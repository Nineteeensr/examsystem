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

	// ����dao�����
	PaperDao pd = new PaperDaoImpl();
	// ����service��Ķ���
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

	// ����Ծ�
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String pname = request.getParameter("pname");
		String scount = request.getParameter("scount");
		Paper paperList = new Paper(pname, Integer.parseInt(scount));
		Integer result = ps.addPaper(paperList);
		if (result > 0) {

			request.getRequestDispatcher("PaperServlet?cmd=list").forward(request, response);
		} else {
			request.setAttribute("mess", "��������ʧ��");
			request.getRequestDispatcher("sys/paper/add.jsp").forward(request, response);
		}

	}

	// ��ʾ�Ծ�����
	private void sList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnames = new String(request.getParameter("pname"));
		String str = URLEncoder.encode(pnames, "utf-8");
		List<Subject> subjectList = pd.getSubjectListByPname(str);
		if (subjectList == null) {
			request.setAttribute("mess", "������ʾ����");
		} else {
//			System.out.println(subjectList);
			request.setAttribute("subjectList", subjectList);
			request.getRequestDispatcher("sys/paper/sdetail.jsp").forward(request, response);
		}
	}

	// ��ҳ��ʾȫ���Ծ�
	private void limit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageLimitUtil<Paper> pager = new PageLimitUtil<Paper>();
		List<Paper> paperList = new ArrayList<Paper>();
		String pname = request.getParameter("pname");
		Paper paper = new Paper();

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
		Integer totalCount = ps.getTotalCount(pname);
		// ��pages���ܼ�¼����ֵ
		pager.setTotalCount(totalCount);
		// ��ȡ��ҳ��
		Integer totalPageCount = pager.getTotalPageCount();
		// ���Ƶ�ǰҳ��
		if (currentPageNo < 1) {
			currentPageNo = 1;
		}
		if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		// ��pages�ĵ�ǰҳ�븳ֵ
		pager.setCurrentPageNo(currentPageNo);
		// ��ȡ��ǰҳ������
		paperList = ps.findPaperListByLimit(pname, currentPageNo, pager.getPageSize());
		// ��pages���е�list��ֵ
		pager.setList(paperList);
		// ��pages�浽request�������� �����ݴ�servlet�㴫��ǰ����ʾ
		request.setAttribute("pager", pager);

		request.getRequestDispatcher("/sys/paper/list.jsp").forward(request, response);

	}

//	// ɾ��
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
