package test.io;

public class Test {
	
	private String filePath = "D:/我的文档/文档/hejie/2018年年假申请延迟人员统计表.xlsx";
	
	@org.junit.Test
	public void ReadExcel() {
		
		ReadExcel re = new ReadExcel();
		try {
			re.readExcel(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
