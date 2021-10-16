package cn.kgc.kjde1035.group1.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 10217
 *
 * @param <E>
 */
public class PageLimitUtil<E> {
	// ��ǰҳ��
	private Integer currentPageNo = 0;// ��ǰ��ҳ���ȡ
	// ҳ���С
	private Integer pageSize = 5;// �̶�
	// �ܼ�¼��
	private Integer totalCount = 0;// �����ݿ��л�ȡ
	// ��ҳ��
	private Integer totalPageCount = 0;
	// ����
	private Integer minPageNo;

	private Integer maxPageNo;

	private List<E> list = new ArrayList<E>();// �����ݿ��в�ѯ�����ݺ����List������

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
	 * @Description: TODO(����ҳ����ֵ)
	 * @param: @param totalCount
	 * @return: void
	 * @throws
	 *
	 */
	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.totalPageCount = (this.totalCount % this.pageSize == 0) ? (this.totalCount / this.pageSize)
					: (this.totalCount / this.pageSize + 1);
		}
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public void setMinAndMax() {
		if (this.currentPageNo <= 2) {
			this.minPageNo = 1;
		}else {
			this.minPageNo=this.currentPageNo-2;
		}

		
		if (this.currentPageNo >= totalPageCount - 2) {
			this.maxPageNo = totalPageCount;
		}else {
			this.minPageNo=this.currentPageNo+2;
		}
	}

	public Integer getMinPageNo() {
		return minPageNo;
	}

	public Integer getMaxPageNo() {
		return maxPageNo;
	}
	

	

}
