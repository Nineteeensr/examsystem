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
		// ����id��ȡ��ϸ��Ϣ
		public Book getBookInfoById(Integer id);

		// ɾ������
		public Boolean delBook(Book book);

		// ������ҳ��
		public Integer findTotalPageCount();

		// ��ҳ��ʾ����
		public List<Book> findAllBookLimit(Integer currentPageNo, Integer pageSize);

		// ���
		public Integer addBookInfo(Book book);
		
		//�޸�
		public Boolean updateBookInfo(Book book);
}
