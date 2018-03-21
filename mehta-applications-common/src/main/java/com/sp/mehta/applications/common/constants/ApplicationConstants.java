package com.sp.mehta.applications.common.constants;

public class ApplicationConstants {
	
	public static final String URL_API_VERSION 			= "/v1.0";
	public static final String URL_API_BASE 			= "/api" + URL_API_VERSION;
	public static final String URL_API_UI_BASE 			= URL_API_BASE + "/ui";

	public static final String RESPONSE_ID 				= "id";
	public static final String RESPONSE_OBJECT 			= "object";
	public static final String RESPONSE_LIST 			= "list";

	public static final String RESPONSE_STATUS 			= "status";
	public static final String RESPONSE_STATUS_SUCCESS 	= "success";
	public static final String RESPONSE_STATUS_ERROR 	= "error";
	public static final String RESPONSE_MESSAGE 		= "message";
	public static final String RESPONSE_EXCEPTION 		= "exception";
	public static final String RESPONSE_PAGE_NO 		= "pageNo";
	public static final String RESPONSE_PAGE_SIZE 		= "pageSize";
	public static final String RESPONSE_LIST_SIZE 		= "listSize";
	public static final String RESPONSE_PAGE_TOTAL 		= "pageTotal";
	public static final String RESPONSE_PAGING_ENABLED 	= "pagingEnabled";
	public static final String RESPONSE_USERID 			= "userId";
	public static final String RESPONSE_ID_LIST 		= "idList";
	
	public static final String OPERATION_CREATE 		= "/create";
	public static final String OPERATION_UPDATE 		= "/update";
	public static final String OPERATION_READ 			= "/read/{id}";
	public static final String OPERATION_DELETE			= "/delete/{id}";
	public static final String OPERATION_LIST 			= "/list";
	
	public static final String URL_API_TEST_CONTROLLER 	= URL_API_UI_BASE + "/test";
	
	public static final String OPERATION_WELCOME		= "/welcome";
	public static final String OPERATION_USER			= "/user";
	public static final String OPERATION_ROLES			= "/roles";
	public static final String OPERATION_ADDRESS		= "/address";
	
	public static final String OPERATION_TEST			="/test";
	
}
