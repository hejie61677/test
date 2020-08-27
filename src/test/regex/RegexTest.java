package test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Title:RegexTest </p>
 * <p>Description:学习正则表达式 </p>
 * @author 何杰
 * @date 2019年1月15日
 * @version 1.0
 * @since JDK 1.8
 */
public class RegexTest {

	public static void main(String[] args) {
		test2();

	}
	
	public static void test1() {
		String input = "I am fanshui " + "from 55555fanshuishui.com.";
		String regex = ".*[1-5]{5}fanshui.*";
		
		boolean isMatch = Pattern.matches(regex, input);
		
		System.out.println("字符串中是否包含了'fanshui'子字符串? " + isMatch);
	}
	
	/*
	 * 捕获组
	 */
	public static void test2(){
		// 按指定模式在字符串查找
	    String input = "This order was placed for QT3000! OK?";
	    String regex = "(\\D*)(\\d+)(.*)";
	 
	    // 创建 Pattern 对象
	    Pattern pattern = Pattern.compile(regex);
	 
	    // 现在创建 matcher 对象
	    Matcher matcher = pattern.matcher(input);
	    
	    if (matcher.find( )) {
	    	
	    	System.out.println(matcher.start() + "=====" + matcher.end());
	    	System.out.println("Found value: " + matcher.group(0) );
	    	System.out.println(matcher.start(0) + "=====" + matcher.end(0));
	    	System.out.println("Found value: " + matcher.group(1) );
	    	System.out.println(matcher.start(1) + "=====" + matcher.end(1));
	    	System.out.println("Found value: " + matcher.group(2) );
	    	System.out.println(matcher.start(2) + "=====" + matcher.end(2));
	    	System.out.println("Found value: " + matcher.group(3) ); 
	    	System.out.println(matcher.start(3) + "=====" + matcher.end(3));
	       
	    } else {
	    	
	         System.out.println("NO MATCH");
	    }
	}

}
