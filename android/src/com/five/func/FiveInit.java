package com.five.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.fiveone.gamecenter.sdk.Config;

/**
 * 初始化SDK
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class FiveInit implements FREFunction {

	private String TAG = "FiveInit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做初始化的操作 我这里直接传回。。
		String channelID = null;
		String sdkVersion = null;
		String app_key = null;
		String private_key = null;
		try{
			channelID = arg1[0].getAsString();
			sdkVersion = arg1[1].getAsString();
			app_key = arg1[2].getAsString();
			private_key = arg1[3].getAsString();
			Config.SDK_VERSION = sdkVersion;
			Config.GAME_CENTER_APP_KEY = app_key;
			Config.GAME_CENTER_PRIVATE_KEY = private_key;
			FiveManage.FiveInit(_context, TAG, channelID);
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("init arg1 is error");
			return null;
		}
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
