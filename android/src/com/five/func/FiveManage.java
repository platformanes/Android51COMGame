package com.five.func;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.fiveone.gamecenter.netconnect.bean.UserInfo;
import com.fiveone.gamecenter.netconnect.listener.AccountStatusListener;
import com.fiveone.gamecenter.sdk.GameCenterService;

/**
 * @author Rect
 * @version  Time：2013-11-22 
 */
public class FiveManage {
	private static FREContext mContext;
	private static String TAG = "FiveManage";
	private static AccountStatusListener mListener = null;
	
	public static void FiveHandle(FREContext ext,String _TAG,int key)
	{
		mContext = ext;
		TAG = _TAG;
		
		if(null == mListener)
			initLinst();
		
		switch(key)
		{
		
			case 0://注册
				GameCenterService.startRegisterActivity(mContext.getActivity());
				break;
			case 1://登录
				GameCenterService.startLoginActivity(mContext.getActivity());
				break;
			case 2://支付
				GameCenterService.startGamePayActivity(mContext.getActivity());
				break;
			default:
				break;
		}
	}
	public static void FiveInit(FREContext ext,String _TAG,String channelID)
	{
		mContext = ext;
		TAG = _TAG;
		
		if(null == mListener)
			initLinst();
		
		//"51001999"
		GameCenterService.initSDK(mContext.getActivity(),channelID,mListener);
		
	}
	
	private static void initLinst()
	{
		mListener = new AccountStatusListener() {
			@Override
			public void onFailed() {
				callBack("网络异常，请稍后重试 ");
				Toast.makeText(mContext.getActivity(), "网络异常，请稍后重试 ", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onLoginSuccess(UserInfo info) {
				GameCenterService.SessionID = "";
				GameCenterService.callOnlineAccount(mContext.getActivity());
				callBack("login*"+info.getUserId()+"*"+info.getUsername()+"*"+info.getSign());
			}

			@Override
			public void onLoginPwdError() {
				callBack("账号或密码错误 ");
				Toast.makeText(mContext.getActivity(), "账号或密码错误", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRegisterSuccess(UserInfo info) {
				callBack("regist*"+info.getUserId()+"*"+info.getUsername()+"*"+info.getSign());
			}

			@Override
			public void onRegisterAccountExists() {
				callBack("该账号已被注册 ");
				Toast.makeText(mContext.getActivity(), "该账号已被注册", Toast.LENGTH_SHORT).show();
			}

			@Override
			public boolean onLoginPageClose(Activity activity) {
				callBack("登录页面关闭 ");
				return false;
			}
		};
		
	}
	/**
	 * 结果传给AS端
	 */
	private static void callBack(String status){
		Log.d(TAG, "-----status----"+status);
		mContext.dispatchStatusEventAsync(TAG, "status:"+status);
	}
}
