/**  
 * 
 * @Title:  BookDao.java   
 * @Package dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 11:08:46
 * @version V1.0 
 * 
 * 
 */
package dao;

import java.util.List;

import entity.Book;




/**
 * @author 10217
 *
 */
public interface BookDao {
		// 查询所有信息
		public List<Book> getAllBook();
		// 根据id查
		public Book getBookById(Integer id);

		// 分页查询
		public List<Book> getBookByLimit(Integer pageNo, Integer pageSize);

		// 添加信息
		public Integer addBook(Book book);

		// 删除信息
		public Integer deleteBook(Book book);

		// 获取总数据数
		public Integer getTotalCount();
		
		// 修改信息
		public Integer updateBook(Book book);
}
