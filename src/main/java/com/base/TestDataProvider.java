package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "testdata")
	public Object[][] testData() {
	
		try {
			FileInputStream input = new FileInputStream(new File("./TestData/TestData.xlsx"));
			//creating workbook instance that refers to .xls file  
			HSSFWorkbook book=new HSSFWorkbook(input);  
			//creating a Sheet object to retrieve the object  
			HSSFSheet sheet=book.getSheetAt(0);  
			//evaluating cell type   
			FormulaEvaluator formulaEvaluator=book.getCreationHelper().createFormulaEvaluator();  
			
			
			   
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new Object[][]{{"data one"}, {"data two"}};
		
	}
	
}
