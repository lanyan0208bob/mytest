/*
 * 文件名：MD5Util.java
 * 创建人：cj
 * 创建日期：2017年6月6日 上午10:33:50
 * Copyright (c)2017 by 通铭教育 版权所有 
 */
package com.lanyan.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 项目名称：SillyGirl <br>
 * 类名称：MD5Util <br>
 * 类描述：TODO(请输入类的描述) <br>
 * 创建人：cj <br>
 * 创建时间：2017年6月6日 上午10:33:50 <br>
 * 
 * @version V1.0
 */
public class MD5Util {
	protected static char hexDigits[] = { '0', '1', '4', '7', '2', '5', '8',
		'3', '6', '9' , 'b', 'c', 'a' , 'd', 'e', 'f' };
//protected static MessageDigest messagedigest = null;

private static ThreadLocal<MessageDigest> threadLocal = new ThreadLocal<MessageDigest>(){
	@Override
	protected MessageDigest initialValue() {
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return messagedigest;
		}
	};
	
	public static String getFileMD5String(java.io.File file) throws IOException {
		InputStream fis;
		fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int numRead = 0;
		MessageDigest messagedigest = threadLocal.get();
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return bufferToHex(messagedigest.digest());
	}
	
	public static String getStringMD5(String str) {
		byte[] buffer = str.getBytes();
		MessageDigest messagedigest = threadLocal.get();
		messagedigest.update(buffer);
		return bufferToHex(messagedigest.digest());
	}
	
	public static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}
	
	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}
	
	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];// 鍙栧瓧鑺備腑楂�4 浣嶇殑鏁板瓧杞崲
		// 涓洪�杈戝彸绉伙紝灏嗙鍙蜂綅涓�捣鍙崇Щ,姝ゅ鏈彂鐜颁袱绉嶇鍙锋湁浣曚笉鍚�
		char c1 = hexDigits[bt & 0xf];// 鍙栧瓧鑺備腑浣�4 浣嶇殑鏁板瓧杞崲
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	private static final String KEY_MD5 = "MD5";
    // 全局数组
    private static final String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    /**
     * MD5加密
     * @param strObj
     * @return
     * @throws Exception
     */
    public static String GetMD5Code(String strObj) throws Exception{
        MessageDigest md = MessageDigest.getInstance(KEY_MD5);
        // md.digest() 该函数返回值为存放哈希值结果的byte数组
        return byteToString(md.digest(strObj.getBytes("UTF-8")));
    }
    
  
    // 测试主函数  
    public static void main(String args[]) throws Exception {
    	String s ="{curTime:,session:,cc:曹捷}cjSoundSY";
		for (byte i : s.getBytes()) {
			System.out.print(i);
		}
		System.out.println("原始：" + MD5Util.GetMD5Code(s));
    }  
}
