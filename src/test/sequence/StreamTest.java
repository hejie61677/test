package test.sequence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>Title:StreamTest </p>
 * <p>Description: 序列本地流</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 上午9:17:52
 */
public class StreamTest {

	public static void main(String[] args) {
		SeqTest st = new SeqTest();
		st.name = "test";
		st.id = 1;
		File file = new File("fileFolder/test.log");
		try(
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			){
				oos.writeObject(st);
				SeqTest st2 = (SeqTest)ois.readObject();
				System.out.println(st2.name);
		}catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			
		}

	}

}
