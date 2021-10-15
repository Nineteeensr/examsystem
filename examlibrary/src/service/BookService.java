/**  
 * 
 * @Title:  BookService.java   
 * @Package service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 11:31:15
 * @version V1.0 
 * 
 * 
 */
package service;

import java.util.List;

import entity.Book;



/**
 * @author 10217
 *
 */
public interface BookService {
		// 根据id获取详细信息
		public Book getBookInfoById(Integer id);

		// 删除数据
		public Boolean delBook(Book book);

		// 查找总页数
		public Integer findTotalPageCount();

		// 分页显示数据
		public List<Book> findAllBookLimit(Integer currentPageNo, Integer pageSize);

		// 添加
		public Integer addBookInfo(Book book);
		
		//修改
		public Boolean updateBookInfo(Book book);
}
