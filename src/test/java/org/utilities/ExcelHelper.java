package org.utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelHelper {
		
	public static  void writeInNewFile(String FB, String SheetName, int rowNo, int colNo, String value) throws IOException {
		
		File f = new File("C:\\Users\\Berlin\\eclipse-workspace\\TestNGProject\\ExcelSheet\\"+FB+".xlsx");
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet sh = wb.createSheet(SheetName);
		
		Row rn = sh.createRow(rowNo);
		
		Cell cl = rn.createCell(colNo);
		cl.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
	}

	public static  void writeInNewsheet(String FB, String SheetName, int rowNo, int colNo, String value) throws IOException {
		
		File f = new File("C:\\Users\\Berlin\\eclipse-workspace\\TestNGProject\\ExcelSheet\\"+FB+".xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet(SheetName);
		
		Row rn = sh.createRow(rowNo);
		
		Cell cl = rn.createCell(colNo);
		cl.setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
	}
	
public static String readData(String sheetName, int rowNo, int cellNo) throws IOException {
		
		
		File f = new File("C:\\Users\\bmani\\eclipse-workspace\\ArgosProject\\target\\ArgosData\\Argos.xlsx");
		
		FileInputStream finput = new FileInputStream(f);
		
		Workbook book = new XSSFWorkbook(finput);
		
		Sheet st = book.getSheet(sheetName);
		
		Row r = st.getRow(rowNo);
		
		Cell c = r.getCell(cellNo);
		
		String input = c.getStringCellValue();
		
		if(c.getCellType()==1) {
			
			return input;
		}
		
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			input = String.valueOf(l);	
			return input;
		}
	}

	}








