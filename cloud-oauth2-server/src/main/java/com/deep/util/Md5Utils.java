package com.deep.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Encoder;

public class Md5Utils {
	/** 生成32位码 */
	public final static String getLongToken(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	/** 生成16位码 */
	public final static String getShortToken(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	public static int getRandomSalt(){
		return rand(100000, 999999);
	}
	
	private static int rand(int min, int max){
		Random random = new Random();
		if(min < max){
			if(min > 0){
				return random.nextInt(max-min+1)+min;
			}else{
				return random.nextInt(max+1);
			}
		}else{
			return min;
		}
	}
	
	public static String generateActiveCode(String origin) {
		String activeCode = "";
		String key = origin + System.currentTimeMillis();
	    Cipher cipher = null;
	    BASE64Encoder base64 = new BASE64Encoder();
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, KeyGenerator.getInstance("DES").generateKey());
			activeCode = base64.encode(cipher.doFinal(key.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		activeCode = activeCode.replace("+", "");
		return activeCode;
	}
	
	private static String hash(String str) {  
        String ret = "";  
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");  
            sha.update(str.getBytes());  
            ret = new BASE64Encoder().encode(sha.digest());  
        } catch (Exception e) {  
            System.out.print(e.getMessage());  
        }  
        return ret; 
    }  

}