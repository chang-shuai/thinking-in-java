/**
 * thinking-in-java
 * this is test code for learning java
 */
package chapter1_all;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author Jverson
 *
 */
public class CharsetLearning {

	private static long a;
	
	public static void main(String[] args) throws IOException {
		
		String value = System.getProperty("file.encoding");
	    System.out.println("系统默认的编码为: " + value); //UTF-8

	    String str = "I am 墨言";
	    
	    System.out.println(Arrays.toString(str.getBytes())); //[73, 32, 97, 109, 32, -27, -94, -88, -24, -88, -128]
		System.out.println(Arrays.toString(str.getBytes("UTF-8"))); //[73, 32, 97, 109, 32, -27, -94, -88, -24, -88, -128]
		System.out.println(Arrays.toString(str.getBytes("UTF-16"))); //[-2, -1, 0, 73, 0, 32, 0, 97, 0, 109, 0, 32, 88, -88, -118, 0]
		System.out.println(Arrays.toString(str.getBytes("GBK"))); //[73, 32, 97, 109, 32, -60, -85, -47, -44]
		System.out.println(Arrays.toString(str.getBytes("ISO-8859-1"))); //[73, 32, 97, 109, 32, 63, 63]
	    
	    // 编码 and 解码操作
	    // 编码gbk,解码utf-8乱码。
	    String str1 = new String(str.getBytes("gbk"), "utf-8");
	    System.out.println(str1); //I am ī��
	    
	    // 编码utf-8 解码gbk，乱码
	    String str2 = new String(str.getBytes("utf-8"), "gbk");
	    System.out.println(str2); //I am 澧ㄨ█
	    
	    // gbk兼容gb2312所以，没有问题。
	    String str3 = new String(str.getBytes("gb2312"), "gbk");
	    System.out.println(str3); //I am 墨言
	    
	    // 编码utf-16 解码gbk，乱码
	    String str4 = new String(str.getBytes("utf-16"), "utf-8");
	    System.out.println(str4); //�� I   a m  X�� 
		
	}
	
	
}
