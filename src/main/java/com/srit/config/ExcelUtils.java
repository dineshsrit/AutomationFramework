package com.srit.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.srit.constants.FrameworkConstants;

public final class ExcelUtils {
	
	
	private ExcelUtils()
	{
		
	}

	public static List<Map<String, String>> getTestDetails(String sheetname)
	{
		
	
		
		//FileInputStream fis = null;
		List<Map<String, String>> list = null;
		try(FileInputStream fis=new FileInputStream(FrameworkConstants.getExcelFilepath())) {

			XSSFWorkbook workbook= new XSSFWorkbook(fis);
			XSSFSheet sheet= workbook.getSheet(sheetname);
			int lastrownum=sheet.getLastRowNum();
			int lastcolnum=sheet.getRow(0).getLastCellNum();
			
			Map<String, String> map = null;
	     	list=new ArrayList<Map<String,String>>();
			
			for(int i=1; i<=lastrownum;i++)
			{
				map=new HashMap<String, String>();
				for(int j=0;j<lastcolnum;j++)
				{
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					
				}
				list.add(map);
			
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		

		return list;
		
		
	}
}
