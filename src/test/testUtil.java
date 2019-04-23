package test;

import java.util.Scanner;

public class testUtil {

	// public static void main(String[] args) {
	// // System.out.println(Integer.MAX_VALUE);
	// // System.out.println(Math.pow(2, 31)-1);
	// // System.out.println(Integer.MIN_VALUE);
	// // System.out.println(Charset.defaultCharset());
	// char a = 'a';
	// int i = 2;
	// System.out.print(a + i + "abc,");
	// System.out.println("abc" + a + i);
	// }
	//

	public static void minus(String firstString, String secondString) {
		for (int i = 0; i < secondString.length(); i++) {
			int idx = 0;
			while ((idx = firstString.indexOf(secondString.charAt(i))) != -1) {
				firstString = firstString.substring(0, idx) + firstString.substring(idx + 1);
			}
		}
		System.out.println("删除后的字符串为：" + firstString);
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个字符串：");
		String firstString = scanner.nextLine();
		System.out.println("请输入第二个字符串：");
		String secondString = scanner.nextLine();
		minus(firstString, secondString);
	}

}
