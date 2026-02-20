package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import ConstantsData.ConstantData;

public class FetchDataFromExcel {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	FetchDataFromExcel(String excelPath,String sheetName) throws IOException
	{
		 workbook=new XSSFWorkbook(ConstantData.EXCEL_PATH);
	     sheet=workbook.getSheet(ConstantData.SHEET_NAME);
	}
	
	
	
	
	
	
	@Test
	
	public static Object getDataExcel(int x,int y) throws IOException
	{
		
	    DataFormatter obj=new DataFormatter();
	  Object value=  obj.formatCellValue(sheet.getRow(x).getCell(y));
	  return value;
		
	}
	
	

}
