package util;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author 10217
 *
 * @param <E>
 */
public class PageLimitUtil <E>{
	//当前页码
	private Integer currentPageNo = 0;//从前端页面获取
	//页面大小
	private Integer pageSize = 5;//固定
	//总记录数
	private Integer totalCount = 0;//从数据库中获取
	//总页数
	private Integer totalPageCount = 0;
	//容器
	private List<E> list = new ArrayList<E>();//从数据库中查询出数据后存入List集合中 
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	/**
	 * 	
	 * @Title: setTotalCount   
	 * @Description: TODO(给总页数赋值)   
	 * @param: @param totalCount      
	 * @return: void      
	 * @throws   
	 *
	 */
	public void setTotalCount(Integer totalCount) {
		if(totalCount>0) {
			this.totalCount = totalCount;
			this.totalPageCount = (this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);
		}
	}
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount=totalPageCount;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	
}
