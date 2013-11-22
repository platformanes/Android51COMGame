package com.five.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class FiveExtension extends EventDispatcher 
	{ 
		
		
		private static const FIVE_FUNCTION_INIT:String = "five_function_init";//与java端中Map里的key一致
		private static const FIVE_FUNCTION_LOGIN:String = "five_function_login";//与java端中Map里的key一致
		private static const FIVE_FUNCTION_PAY:String = "five_function_pay";//与java端中Map里的key一致
		private static const FIVE_FUNCTION_EXIT:String = "five_function_exit";//与java端中Map里的key一致
		private static const FIVE_FUNCTION_REG:String = "five_function_reg";//与java端中Map里的key一致
		private static const FIVE_FUNCTION_LOGINSERVER:String = "five_function_loginserver";//与java端中Map里的key一致
		
		private static const EXTENSION_ID:String = "com.five.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:FiveExtension; 
		public function FiveExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():FiveExtension
		{
			if(_instance == null) 
				_instance = new FiveExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		/**
		 *init发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function FiveInit(channelID:String,sdkVersion:String,app_key:String,private_key:String):String{
			if(extContext ){
				return extContext.call(FIVE_FUNCTION_INIT,channelID,sdkVersion,app_key,private_key) as String;
			}
			return "call login failed";
		} 
		
		/**
		 *登录发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function FiveLogIn(key:int):String{
			if(extContext ){
				return extContext.call(FIVE_FUNCTION_LOGIN,key) as String;
			}
			return "call login failed";
		} 
		
		public function FiveReg(key:int):String{
			if(extContext ){
				return extContext.call(FIVE_FUNCTION_REG,key) as String;
			}
			return "call FiveReg failed";
		}
		
		public function FiveServer(serverID:int,serverName:String):String{
			if(extContext ){
				return extContext.call(FIVE_FUNCTION_LOGINSERVER,serverID,serverName) as String;
			}
			return "call FiveServer failed";
		}
		/**
		 *付费发送函数 
		 * @param key 暂时传什么都可以 留着以后可能要用
		 * @return 
		 * 
		 */		 
		public function FivePay(key:int):String{
			if(extContext){ 
				return extContext.call(FIVE_FUNCTION_PAY,key)as String;
			}
			return "call pay failed";
		}
		
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function FiveExit(key:int):String{
			if(extContext){ 
				return extContext.call(FIVE_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
	} 
}