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
		// ��ѯ������Ϣ
		public List<Book> getAllBook();
		// ����id��
		public Book getBookById(Integer id);

		// ��ҳ��ѯ
		public List<Book> getBookByLimit(Integer pageNo, Integer pageSize);

		// �����Ϣ
		public Integer addBook(Book book);

		// ɾ����Ϣ
		public Integer deleteBook(Book book);

		// ��ȡ��������
		public Integer getTotalCount();
		
		// �޸���Ϣ
		public Integer updateBook(Book book);
}
