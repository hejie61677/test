package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
//		System.out.println((int)(Math.random()*10));
//		System.out.format("%-8d%n", 1234);
		try {
			File file = new File("fileFolder/test.txt");		
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[(int)file.length()];
			fis.read(b);
			for(byte bt : b){
				System.out.println(bt);
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

}
