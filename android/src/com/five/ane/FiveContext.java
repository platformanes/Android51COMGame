package com.five.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.five.func.FiveExit;
import com.five.func.FiveInit;
import com.five.func.FiveLogin;
import com.five.func.FiveLoginServer;
import com.five.func.FivePay;
import com.five.func.FiveRegister;

/**
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class FiveContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String FIVE_FUNCTION_INIT = "five_function_init";
	/**
	 * 登录Key
	 */
	public static final String FIVE_FUNCTION_LOGIN = "five_function_login";
	
	public static final String FIVE_FUNCTION_LOGINSERVER = "five_function_loginserver";
	
	public static final String FIVE_FUNCTION_REG = "five_function_reg";
	/**
	 * 付费Key
	 */
	public static final String FIVE_FUNCTION_PAY = "five_function_pay";
	/**
	 * 退出Key
	 */
	public static final String FIVE_FUNCTION_EXIT = "five_function_exit";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(FIVE_FUNCTION_INIT, new FiveInit());
	       map.put(FIVE_FUNCTION_LOGIN, new FiveLogin());
	       map.put(FIVE_FUNCTION_REG, new FiveRegister());
	       map.put(FIVE_FUNCTION_LOGINSERVER, new FiveLoginServer());
	       map.put(FIVE_FUNCTION_PAY, new FivePay());
	       map.put(FIVE_FUNCTION_EXIT, new FiveExit());
	       return map;
	}

}
