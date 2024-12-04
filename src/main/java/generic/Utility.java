package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String getExcelData(String path,String sheet,int row,int col)
	{
		String value="";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			Sheet s = wb.getSheet(sheet);
			value = s.getRow(row).getCell(col).toString();
			wb.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return value;
	}
	

	public static String getProperty(String path,String key)
	{
		String value="";
		
		try 
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			value=p.getProperty(key);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	
}
