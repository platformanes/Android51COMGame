package com.five.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 执行登录
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class FiveLogin implements FREFunction {

	private String TAG = "FiveLogin";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null;  
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做登录的操作 我这里直接传回。。
		FiveManage.FiveHandle(_context, TAG, 1);
		callBack("success");
		//--------------------------------
		
		return result;
	}

	/**
	 * 结果传给AS端
	 */
	public void callBack(String status){
		Log.d(TAG, "-----status----"+status);
		_context.dispatchStatusEventAsync(TAG, "status:"+status);
	}
}
