package com.cos.baseball.util;

public class Script {

	public static String href(String msg, String url) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("location.href = '"+url+"';");
		sb.append("</script>");
		
		return sb.toString();
	}
	
}
