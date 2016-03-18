package tools;

import java.io.IOException;

import dataBase.ThreadDB;
import server.ServerThread;

/*
 * 这个工具用来实现以下功能
 * 1.向目标JK号发送信息
 * 2.将未发送成功的信息存在服务器
 */
public class ChatTool {
	/*
	 * 这个方法用来向JKNum的用户发送内容为Msg的信息
	 * 
	 * @return 是否成功发送
	 */
	public static boolean sendMsg(int from,int to, String msg) {
		if (!ThreadDB.threadDB.containsKey(String.valueOf(to))) {
			return false;
		}
		
		/*
		 * 向用户发送信息
		 */
		ServerThread st = ThreadDB.threadDB.get(String.valueOf(to));
		try {
			st.SendMsg(from, msg);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 这个方法由于JKNum的用户不在线 保存向JKNum的用户发送内容为Msg的信息
	 */
	public static void saveOnServer(int from,int to, String Msg) {

	}

}
