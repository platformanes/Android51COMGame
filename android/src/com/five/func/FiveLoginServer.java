package com.five.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.fiveone.gamecenter.sdk.GameCenterService;

/**
 * @author Rect
 * @version  Time：2013-11-22 
 */
public class FiveLoginServer implements FREFunction {

	private String TAG = "FiveLoginServer";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		int serverID = 0;
		String serverName = null;
		try
		{
			serverID = arg1[0].getAsInt();
			serverName = arg1[1].getAsString();
			String serverIDstr = null;
			if(10 > serverID)
				serverIDstr = "00"+serverID;
			else if (100 > serverID)
				serverIDstr = "0"+serverID;
			else
				serverIDstr = ""+serverID;
			
			callBack("server:"+serverIDstr+serverName);
			GameCenterService.setLoginServer(_context.getActivity(),serverIDstr,serverName);
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("login server arg1 is error");
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
