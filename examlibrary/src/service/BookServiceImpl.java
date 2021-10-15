/**  
 * 
 * @Title:  BookServiceImpl.java   
 * @Package service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 11:33:52
 * @version V1.0 
 * 
 * 
 */
package service;

import java.util.List;

import dao.BookDao;
import dao.BookDaoImpl;
import entity.Book;

/**
 * @author 10217
 *
 */
public class BookServiceImpl implements BookService {
	BookDao bookDao = new BookDaoImpl();
	@Override
	public Book getBookInfoById(Integer id) {
		
		return bookDao.getBookById(id);
	}

	@Override
	public Boolean delBook(Book book) {
		Integer result = bookDao.deleteBook(book);
		if (result>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Integer findTotalPageCount() {
		return bookDao.getTotalCount();
	}

	@Override
	public List<Book> findAllBookLimit(Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return bookDao.getBookByLimit(currentPageNo, pageSize);
	}

	@Override
	public Integer addBookInfo(Book book) {
		// TODO Auto-generated method stub
		return bookDao.addBook(book);
	}

	@Override
	public Boolean updateBookInfo(Book book) {
		Integer result = bookDao.updateBook(book);
		if (result>0) {
			return true;
		}else {
			return false;
		}
	}

}
