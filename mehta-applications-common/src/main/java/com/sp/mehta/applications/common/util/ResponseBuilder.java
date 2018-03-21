package com.sp.mehta.applications.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sp.mehta.applications.common.constants.ApplicationConstants;

public class ResponseBuilder {

	private Map<String, Object> response;
	private boolean paggingEnabled;

	public static enum Status {
		success, error
	}

	public ResponseBuilder() {
		response = new HashMap<>();
	}

	public ResponseBuilder(boolean paggingEnabled) {
		response = new HashMap<>();
		this.paggingEnabled = paggingEnabled;
	}

	public ResponseBuilder status(Status status) {
		response.put(ApplicationConstants.RESPONSE_STATUS, status.toString());
		return this;
	}

	public ResponseBuilder message(String message) {
		response.put(ApplicationConstants.RESPONSE_MESSAGE, message);
		return this;
	}

	public ResponseBuilder pageNo(int pageNo) {
		if (paggingEnabled)
			response.put(ApplicationConstants.RESPONSE_PAGE_NO, pageNo);
		return this;
	}

	public ResponseBuilder pageSize(int pageSize) {
		if (paggingEnabled)
			response.put(ApplicationConstants.RESPONSE_PAGE_SIZE, pageSize);

		return this;
	}

	public ResponseBuilder listSize(long listSize) {
		response.put(ApplicationConstants.RESPONSE_LIST_SIZE, listSize);
		return this;
	}

	public ResponseBuilder idList(List<Integer> ids) {
		response.put(ApplicationConstants.RESPONSE_ID_LIST, ids);
		return this;
	}

	public ResponseBuilder pageTotal(long listSize, int pageSize) {
		if (paggingEnabled) {
			int pageTotal = 0;
			if (pageSize > 0)
				pageTotal = (int) Math.ceil((double) listSize / pageSize);
			response.put(ApplicationConstants.RESPONSE_PAGE_TOTAL, pageTotal);
		}
		return this;
	}

	public ResponseBuilder pagingEnabled(boolean pagingEnabled) {
		response.put(ApplicationConstants.RESPONSE_PAGING_ENABLED, pagingEnabled);
		return this;
	}

	public ResponseBuilder id(Object id) {
		response.put(ApplicationConstants.RESPONSE_ID, id);
		return this;
	}

	public ResponseBuilder object(Object object) {
		response.put(ApplicationConstants.RESPONSE_OBJECT, object);
		return this;
	}

	public ResponseBuilder list(List<?> list) {
		response.put(ApplicationConstants.RESPONSE_LIST, list);
		return this;
	}

	public ResponseBuilder exception(Exception e) {
		response.put(ApplicationConstants.RESPONSE_EXCEPTION, e.getClass().getName());
		return this;
	}

	public Map<String, Object> build() {
		return response;
	}
}
