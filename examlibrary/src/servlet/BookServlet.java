package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Book;
import service.BookService;
import service.BookServiceImpl;
import util.PageLimitUtil;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String flag = request.getParameter("flag");
		
		
		BookService bookService = new BookServiceImpl();
		PageLimitUtil<Book> pages = new PageLimitUtil<Book>();

		/**
		 * 分页显示信息
		 */
		if (flag == null) {
			
			String currNo = request.getParameter("currNo");
			
			Integer currentPageNo = 0;
			if (currNo == null) {
				currentPageNo = 1;
			} else {
				currentPageNo = Integer.parseInt(currNo);
			}
			
			Integer totalCount = bookService.findTotalPageCount();
			
			pages.setTotalCount(totalCount);
			
			Integer totalPageCount = pages.getTotalPageCount();
			
			if (currentPageNo < 1) {
				currentPageNo = 1;
			}
			if (currentPageNo > totalPageCount) {
				currentPageNo = totalPageCount;
			}
			
			pages.setCurrentPageNo(currentPageNo);
			
			List<Book> bookList = bookService.findAllBookLimit(currentPageNo, pages.getPageSize());
			
			pages.setList(bookList);
			
			request.setAttribute("pages", pages);

			request.getRequestDispatcher("main.jsp").forward(request, response);

			
		

			/**
			 * 添加信息
			 */
		} else if ("add".equals(flag)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String publish = request.getParameter("publish");
			String publishdate = request.getParameter("publish");
			String page = request.getParameter("page");
			String price = request.getParameter("price");
			String content = request.getParameter("content");
			Book book = new Book(Integer.parseInt(id), name,author,publish,publishdate,Integer.parseInt(page),Double.parseDouble(price),content);

			Integer result = bookService.addBookInfo(book);
			if (result > 0) {
				response.sendRedirect("BookServlet");
			} else {
				out.print("<script type='text/javascript'>alert('添加失败');history.back();</script>");
			}
			/**
			 * 删除信息
			 */
		} else if ("delete".equals(flag)) {
			String id = request.getParameter("id");
			Book book = new Book(Integer.parseInt(id));
			Boolean result = bookService.delBook(book);
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("result", "" + result);
			JSON json = (JSON) JSON.toJSON(resultMap);
			out.print(json);
		} else if ("update".equals(flag)) {
			String id = request.getParameter("id");
			Book book = bookService.getBookInfoById(Integer.parseInt(id));
			request.setAttribute("book", book);
			request.getRequestDispatcher("modifygoods.jsp").forward(request, response);
		} else if ("doUpdate".equals(flag)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			String publish = request.getParameter("publish");
			String publishdate = request.getParameter("publish");
			String page = request.getParameter("page");
			String price = request.getParameter("price");
			String content = request.getParameter("content");
			Book book = new Book(Integer.parseInt(id), name,author,publish,publishdate,Integer.parseInt(page),Double.parseDouble(price),content);
			Boolean result = bookService.updateBookInfo(book);
			if (result) {
				response.sendRedirect("BookServlet");
			} else {
				out.print("<script type='text/javascript'>alert('修改失败');history.back();</script>");
			}
		}
	}
}
