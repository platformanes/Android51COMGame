package com.five.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class FiveEvents 
	{ 
		public function FiveEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 *init 
		 */		
		public static const FIVE_SDK_STATUS:String = "FiveInit";
		
		public static const FIVE_REGISTER_STATUS :String = "FiveRegister";
		/**
		 * 用户登录
		 */
		public static const FIVE_LOGIN_STATUS : String = "FiveLogin";
		public static const FIVE_LOGINSERVER_STATUS:String = "FiveLoginServer";
		/**
		 * 用户注销
		 */
		public static const FIVE_LOGOUT_STATUS : String = "FiveExit";
		
		/**
		 * 充值
		 */
		public static const FIVE_PAY_STATUS : String = "FivePay";
	} 
}