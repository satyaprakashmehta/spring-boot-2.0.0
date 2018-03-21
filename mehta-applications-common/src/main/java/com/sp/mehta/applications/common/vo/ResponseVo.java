
package com.sp.mehta.applications.common.vo;

import java.io.Serializable;
import java.util.List;

public class ResponseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	private String message;
	private int pageNo;
	private int pageSize;
	private long listSize;
	private int pageTotal;
	private boolean pagingEnabled;
	private Object id;
	private List<Integer> idList;
	private Object object;
	private List<?> list;
	private String expection;

	public ResponseVo() {

	}

	public String getStatus() {

		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public int getPageNo() {

		return pageNo;
	}

	public void setPageNo(int pageNo) {

		this.pageNo = pageNo;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public long getListSize() {

		return listSize;
	}

	public void setListSize(long listSize) {

		this.listSize = listSize;
	}

	public int getPageTotal() {

		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {

		this.pageTotal = pageTotal;
	}

	public boolean isPagingEnabled() {

		return pagingEnabled;
	}

	public void setPagingEnabled(boolean pagingEnabled) {

		this.pagingEnabled = pagingEnabled;
	}

	public Object getId() {

		return id;
	}

	public void setId(Object id) {

		this.id = id;
	}

	public Object getObject() {

		return object;
	}

	public void setObject(Object object) {

		this.object = object;
	}

	public List<?> getList() {

		return list;
	}

	public void setList(List<?> list) {

		this.list = list;
	}

	public String getException() {

		return expection;
	}

	public void setException(String expection) {

		this.expection = expection;
	}

	@Override
	public String toString() {

		return "ResponseVo [status=" + status + ", message=" + message + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", listSize=" + listSize + ", pageTotal=" + pageTotal + ", pagingEnabled=" + pagingEnabled + ", id="
				+ id + ", object=" + object + ", list=" + list + ", expection=" + expection + "]";
	}

	public List<Integer> getIdList() {

		return idList;
	}

	public void setIdList(List<Integer> idList) {

		this.idList = idList;
	}

}
