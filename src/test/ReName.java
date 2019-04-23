package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReName {
	
	private String path;
	private String newPath;
	private String content;
	
	public ReName(String path, String newPath, String content){
		this.path = path;
		this.newPath = newPath;
		this.content = content;
		int num = 2;
		if(num == 1){
			readFile1();
		}else{
			readFile2();
		}
	}
	
	private void readFile1(){
		File fileOld = new File(path);
		File fileNew = new File(newPath);
		reContent(fileOld, fileNew, content);
	}
	
	private void readFile2(){
		File fileOld = new File(path);
		File fileNew = new File(newPath);
		addSpace(fileOld, fileNew);
	}
	
	private void reContent(File fileOld, File fileNew, String content){
		BufferedReader bufReader;
		BufferedWriter bufWriter;
		try {
			bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOld)));
			bufWriter = new BufferedWriter(new FileWriter(fileNew));
			for(String temp = ""; (temp = bufReader.readLine()) != null; temp = ""){
				if(temp.matches(content)){
					temp = "第" + temp;
					System.out.println(temp);				
				}
				bufWriter.write(temp+"\n\r");
			}
			bufReader.close();
			bufWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addSpace(File fileOld, File fileNew){
		BufferedReader bufReader;
		BufferedWriter bufWriter;
		try {
			bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileOld)));
			bufWriter = new BufferedWriter(new FileWriter(fileNew));
			for(String temp = ""; (temp = bufReader.readLine()) != null; temp = ""){
				bufWriter.write(temp+"\r\n");
			}
			bufReader.close();
			bufWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new ReName("D:/我的文档/文档/小说/网游之彪悍人生.txt", "D:/我的文档/文档/小说/网游之彪悍人生new.txt", "[0-9]{4}['章'] [\\u4e00-\\u9fa5]{0,}");
	}

}
