package cn.kgc.kjde1035.group1.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;

import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.service.SubjectService;
import cn.kgc.kjde1035.group1.service.SubjectServiceImpl;
import cn.kgc.kjde1035.group1.utils.ExcelUtils;
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
		if (cmd.equals("add")) {// ����
			addSubject(request, response);
		} else if (cmd.equals("del")) {// ɾ��
			delSubject(request, response);
		} else if (cmd.equals("update")) {// �޸�
			updateSubject(request, response);
		} else if (cmd.equals("doUpdate")) {// ���޸�
			doUpdateSubject(request, response);
		} else if (cmd.equals("limit")) { // ��ҳ��ѯ
			limit(request, response);
		} else if ("addbyExcel".equals(cmd)) {
			addbyExcel(request,response);
		}

	}

	// ����
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
			request.setAttribute("mess", "����ʧ�������Ƿ���ڴ���");
			out.print("<script type='text'/javascript>history.back();<script>");
		}
	}

	// ɾ��
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
			out.print("<script type='text/javascript'>alert('ɾ��ʧ��');</script>");
			request.setAttribute("mess", "ɾ��ʧ��");
		}

	}

	// �޸�
	private void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		Subject subject = subjectService.getSubjectBySid(Integer.parseInt(sid));
		request.setAttribute("subject", subject);
		request.getRequestDispatcher("sys/subject/edit.jsp").forward(request, response);
	}

	// ���޸�
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
			out.print("<script type='text/javascript'>alert('�޸�ʧ��');</script>");
			request.getRequestDispatcher("SubjectServlet?cmd=limit").forward(request, response);
		}
	}

	// ��ҳ��ѯ
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
	
	private void addbyExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(itemFactory);
			try {
				List<FileItem> itemList = upload.parseRequest(request);
				Iterator<FileItem> it = itemList.iterator();
				while(it.hasNext()) {
					FileItem item = it.next();
					if(!item.isFormField()) {
						InputStream is = item.getInputStream();
						String name = item.getName();
						String filetype = name.substring(name.lastIndexOf("."));
						List<Subject> subList = ExcelUtils.parseSubject(filetype, is);
						Integer result = subjectService.addSubjects(subList);  
						
					}
				}
			} catch (FileUploadException|IOException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("sys/subject/add.jsp").forward(request, response);
			
		}
	}
	
	
}
