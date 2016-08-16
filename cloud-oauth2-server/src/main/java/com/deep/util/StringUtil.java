package com.deep.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
	
	public static final Pattern LINE_END_ENTER_SYMBOL = Pattern.compile("\n+|\r+");
	public static final Pattern BLANK_SPACE = Pattern.compile(" +|\t+");
	public static final Pattern SPLIT_STRING = Pattern.compile(" |,|\\||_");
	/**
	* 将一个字符串转化为输入流
	*/
	public static InputStream getStringStream(String sInputString) {
		if (sInputString != null && !sInputString.trim().equals("")) {
			try {
				ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(
						sInputString.getBytes());
				return tInputStringStream;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * 去掉字符串中的回车换行符
	 * @param str
	 * @return
	 */
	public static String removeEnterSym(String str) {
		Matcher m = LINE_END_ENTER_SYMBOL.matcher(str);
		return m.replaceAll("");
	}
	
	
	/**
	 * 去掉字符串中的空格和制表符
	 * @param str
	 * @return
	 */
	public static String removeBlankSpace(String str) {
		Matcher m = BLANK_SPACE.matcher(str);
		return m.replaceAll("");
	}
	
	public static String[] split(String str) {
		return SPLIT_STRING.split(str);
	}
	
	
	
	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str){
		String dest = "";
		if(str != null){
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest.trim();
	}
	
	/**
	 * 通过{@link UUID}得到一个随机的UUID，并去掉中间"-"
	 * @return
	 */
	public static String generatorUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");				
	}
	
	/**
	 * 替换路径中不一致的路径分隔符
	 * @param path  例如： D:\workspace\huh\src\main\webapp\files/pdfupload\1338346756548.pdf
	 * @param oldSeparative
	 * @param newSeparative
	 * @return
	 */
	public static String formatPath(String path,char oldSeparative,char newSeparative){
		return path.replace(oldSeparative, newSeparative);
	}
	public static String formatPath(String path){
		return path.replace('/', '\\');
	}
}
