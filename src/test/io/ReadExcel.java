package test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <p>Title:ReadExcel </p>
 * <p>Description: 读取Excel</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 上午9:49:13
 */
public class ReadExcel {
	
	private static final String SUFFIX_XLS = ".xls";
	private static final String SUFFIX_XLSX = ".xlsx";
	
	/**
	 * 获取workbook
	 * @param filePath
	 * @return Workbook
	 * @throws IOException
	 */
	private Workbook getWorkbook(String filePath) throws IOException {
		Workbook workbook = null;
		InputStream is = new FileInputStream(filePath);
		if(filePath.endsWith(SUFFIX_XLS)) {
			workbook = new HSSFWorkbook(is);
		} else if(filePath.endsWith(SUFFIX_XLSX)) {
			workbook = new XSSFWorkbook(is);
		}
		is.close();
		return workbook;
	}
	
	/**
	 * 检查文件
	 * @param filePath
	 * @throws Exception
	 */
	private void fileCheck(String filePath) throws Exception {
		
		if(!(filePath.endsWith(SUFFIX_XLS) || filePath.endsWith(SUFFIX_XLSX))) {
			throw new Exception("文件不是Excel格式");
		}
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			throw new FileNotFoundException("文件不存在");
		}			
	}
	
	public void readExcel(String filePath) throws Exception {
		//检查
		this.fileCheck(filePath);
		//获取workbook
		Workbook workbook = this.getWorkbook(filePath);
		
		for(int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
			Sheet sheet = workbook.getSheetAt(numSheet);
			
			if(sheet == null) {
				continue;
			}
			
			System.out.println("读取表格 : " + sheet.getSheetName());
			
			int firstRowIndex = sheet.getFirstRowNum();
			int lastRowIndex = sheet.getLastRowNum();
			
			//读取首行
			Row firstRow = sheet.getRow(firstRowIndex);
			for(int i = firstRow.getFirstCellNum(); i < firstRow.getLastCellNum(); i++) {
				Cell cell = firstRow.getCell(i);
				String cellValue = this.getCellValue(cell, true);
				System.out.println(" " + cellValue);
			}
			
			//读取数据行
			for(int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
				Row currentRow = sheet.getRow(rowIndex);
				int firstColumnIndex = currentRow.getFirstCellNum(); // 首列
                int lastColumnIndex = currentRow.getLastCellNum();// 最后一列
                
                for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
                    Cell currentCell = currentRow.getCell(columnIndex);// 当前单元格
                    String currentCellValue = this.getCellValue(currentCell, true);// 当前单元格的值
                    System.out.print(currentCellValue + "\t");
                }				
			}		
		}
		workbook.close();
	}
	
	/**
     * 取单元格的值
     * @param cell 单元格对象
     * @param treatAsStr 为true时，当做文本来取值 (取到的是文本，不会把"1"取成"1.0")
     * @return
     */
    private String getCellValue(Cell cell, boolean treatAsStr) {
        if (cell == null) {
            return "";
        }

        if (treatAsStr) {
            // 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
            // 加上下面这句，临时把它当做文本来读取
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }
}
