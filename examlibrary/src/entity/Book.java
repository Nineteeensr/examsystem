/**  
 * 
 * @Title:  Book.java   
 * @Package entity   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 10:47:04
 * @version V1.0 
 * 
 * 
 */
package entity;

import java.util.Date;

/**
 * @author 10217
 *
 */
public class Book {
	private Integer id;
	private String name;
	private String author;
	private String publish;
	private String publishdate;
	private Integer page;
	private Double price;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String name, String author, String publish, String publishdate, Integer page, Double price,
			String content) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.publishdate = publishdate;
		this.page = page;
		this.price = price;
		this.content = content;
	}
	public Book(Integer id) {
		super();
		this.id = id;
	}
	
}
