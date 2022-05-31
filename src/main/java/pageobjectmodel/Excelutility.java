package pageobjectmodel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int sheets;
	public  void logincredential() throws IOException {
		FileInputStream fis = new FileInputStream("C://Users//krishnaveni.B//Documents//logincredentials.xlsx");	
		workbook = new XSSFWorkbook(fis);
		 sheets=workbook.getNumberOfSheets();
		 
	}
		public String Username() throws IOException {
			String username="";
			logincredential();
		for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("logincredentials")) {
		XSSFSheet sheet=workbook.getSheetAt(i);
		DataFormatter formatter= new DataFormatter();
	 username=formatter.formatCellValue(sheet.getRow(1).getCell(0));
	
		}
		
		}
		return username;
			}
		public String Password() throws IOException {
			String password="";
			logincredential();
			for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("logincredentials")) {
			XSSFSheet sheet=workbook.getSheetAt(i);
			password=sheet.getRow(1).getCell(1).getStringCellValue();
			
				}
		}
			return password;
		}
		}



