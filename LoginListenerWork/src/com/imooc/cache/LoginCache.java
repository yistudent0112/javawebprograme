package com.imooc.cache;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class LoginCache {
	private static LoginCache instance = new LoginCache();
    private static Map<String,String>LoginUserSession=new HashMap<String,String>();
    private static Map<String,HttpSession>LoginSession=new HashMap<String,HttpSession>();
	private LoginCache() {

	}
    public static LoginCache Getinstance() {
    	return instance;
    }
    public static String GetSessionIdByUsername(String username) {
    	return LoginUserSession.get(username);
    }
    public static HttpSession GetSessionBySessionId(String SessionId) {
    	return LoginSession.get(SessionId);
    }
    public static void SetSessionIdByUsername(String username,String SessionId) {
    	LoginUserSession.put(username, SessionId);
    }
    public static void SetSessionBySessionId(String SessionId,HttpSession Session) {
    	LoginSession.put(SessionId, Session);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
