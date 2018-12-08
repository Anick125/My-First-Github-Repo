package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompareTwoTextFile {
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
	public void writeIntoTxtTest() throws IOException {
	File testFile = new File("C:\\Users\\user\\Desktop\\testFile.txt");
	File actualFile = new File("C:\\Users\\user\\Desktop\\actualFile.txt");
	
	testFile.createNewFile();
	actualFile.createNewFile();
	
	FileWriter fw1 = new FileWriter(testFile);
	BufferedWriter bfw1 = new BufferedWriter(fw1);
	
	FileWriter fw2 = new FileWriter(actualFile);
	BufferedWriter bfw2 = new BufferedWriter(fw2);
	
	for(int i =0; i <4; i++) {
		bfw1.write(categories.get(i));
		bfw1.newLine();
	}
	
	for(int i =0; i < categories.size();i++) {
		bfw2.write(categories.get(i));
		bfw2.newLine();
	}
	
	bfw1.flush();
	bfw2.flush();
	
	
	BufferedReader bfr1 = new BufferedReader(new FileReader(testFile));
	BufferedReader bfr2 = new BufferedReader(new FileReader(actualFile));
	
	List<String> testList = new ArrayList<String>();
	List<String> actualList = new ArrayList<String>();
	
	String line;
	while((line=bfr1.readLine())!=null) {
		testList.add(line);
	}
	
	
	while((line=bfr2.readLine())!=null) {
		actualList.add(line);
	}
	
	
	if(testList.size() == actualList.size()) {
		System.out.println("Test Case Failed");
	}
	
	else
		System.out.println("Test case passed");
	
	
	
	bfw1.close();
	bfw2.close();
	
	
	}
	
		
}
