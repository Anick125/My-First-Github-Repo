package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WriteCategory {
	
	WebDriver dr;
	List<WebElement> elements;
	List<String> categories;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.get("https://www.eshopper24.com/");
		
	}
	
	@Test(priority=0)
	public void readCategory() {
		elements = dr.findElements(By.xpath("//ul[@class='category-navigation-list sticky-flyout']/li"));
		categories = new ArrayList<String>();
		for(int i =0; i< elements.size();i++) {
			String s = elements.get(i).getText();
			categories.add(s);
		}
		
//		for(String s: categories)
//			System.out.println(s);
		
	}
	
	@Test(priority=1)
	public void writeIntoExcelTest() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet1 = wb.createSheet("eshoppers");
		for(int j = 0; j< elements.size(); j++) {
			sheet1.createRow(j).createCell(0, CellType.STRING).setCellValue(categories.get(j));
			
		}
		
		FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\user\\Desktop\\shoppers.xlsx"));
		
		wb.write(fout);
		wb.close();
		
		
		
	}
	
	
	

}
