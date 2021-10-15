/**  
 * 
 * @Title:  BookDaoImpl.java   
 * @Package dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 11:11:20
 * @version V1.0 
 * 
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

/**
 * @author 10217
 *
 */
public class BookDaoImpl extends BaseDao implements BookDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	/**
	 * ²éËùÓÐ
	 */
	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = new ArrayList<Book>();
		conn = this.getConnection();
		String sql = "select id,name,author,publish,publishdate,page,price,content from book";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPage(rs.getInt("page"));
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getString("content"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		return bookList;
	}



	

	@Override
	public List<Book> getBookByLimit(Integer pageNo, Integer pageSize) {
		List<Book> bookList = new ArrayList<Book>();
		conn = this.getConnection();
		String sql = "select id,name,author,publish,publishdate,page,price,content from book limit ?,?";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, (pageNo - 1) * pageSize);
			p.setInt(2, pageSize);
			rs = p.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPage(rs.getInt("page"));
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getString("content"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return bookList;
	}

	@Override
	public Integer addBook(Book book) {
		String sql = "insert into book(id,name,author,publish,publishdate,page,price,content) values(?,?,?,?,?,?,?,?)";
		Object[] params = {book.getId(),book.getName(),book.getAuthor(),book.getPublish(),book.getPublishdate(),book.getPage(),book.getPrice(),book.getContent()};
		return this.executeUpdate(sql, params);
		}

	@Override
	public Integer deleteBook(Book book) {
		String sql = "delete from book where id=?";
		Object[] params= {book.getId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public Integer getTotalCount() {
		Integer result=0;
		conn=this.getConnection();
		String sql="select count(1) c from book";
		try {
			p=conn.prepareStatement(sql);
			rs=p.executeQuery();
			while (rs.next()) {
				 result=rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		
		return result;
	}

	@Override
	public Integer updateBook(Book book) {
		String sql = "update book set `id`=?,name=?,author=?,publish=?,publishdate=?,page=?,price=?,content=? where id=?";
		Object[] params = {book.getId(),book.getName(),book.getAuthor(),book.getPublish(),book.getPublishdate(),book.getPage(),book.getPrice(),book.getContent()};
		Integer result = this.executeUpdate(sql, params);
		return result;
	}


	@Override
	public Book getBookById(Integer id) {
		Book book = null;
		conn = this.getConnection();
		String sql = "select id,name,author,publish,publishdate,page,price,content from book where id=?";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			rs = p.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setPublish(rs.getString("publish"));
				book.setPublishdate(rs.getString("publishdate"));
				book.setPage(rs.getInt("page"));
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return book;
	}

}
