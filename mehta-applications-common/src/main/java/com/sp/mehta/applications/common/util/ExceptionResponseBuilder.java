package com.sp.mehta.applications.common.util;

import java.util.HashMap;
import java.util.Map;

public class ExceptionResponseBuilder {

	private Map<String, Object> responseMap;

	public static enum Status {
		success, error
	}

	public ExceptionResponseBuilder() {

		responseMap = new HashMap<>();
		responseMap.put("errorResponse", new HashMap<String, Object>());
	}

	public ExceptionResponseBuilder status(Status status) {

		responseMap.put("status", status.toString());
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder platformMessage(String platformMessage) {

		Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
		errorResponseMap.put("platformMessage", platformMessage);
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder applicationMessage(String applicationMessage) {

		Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
		errorResponseMap.put("applicationMessage", applicationMessage);
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder stackTrace(Exception e, boolean canWrite) {

		if (canWrite) {
			StackTraceElement[] stackTraces = e.getStackTrace();
			StringBuffer exceptionStack = new StringBuffer();
			for (StackTraceElement stackTrace : stackTraces) {
				exceptionStack.append(stackTrace.toString());
			}
			Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
			errorResponseMap.put("stackTrace", exceptionStack.toString());
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder className(String className) {

		Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
		errorResponseMap.put("className", className);
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder systemExceptionClassHandler(String systemExceptionClassHandler) {

		Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
		errorResponseMap.put("systemExceptionClassHandler", systemExceptionClassHandler);
		return this;
	}

	@SuppressWarnings("unchecked")
	public ExceptionResponseBuilder userMessage(String userMessage) {

		Map<String, Object> errorResponseMap = (Map<String, Object>) responseMap.get("errorResponse");
		errorResponseMap.put("userMessage", userMessage);
		return this;
	}

	public Map<String, Object> build() {

		return responseMap;
	}
}
