package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config()
	{
		//1.create the object of ExtentSparkReporter
		//path to store your reports
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//set the ReportName -> use config() method & setReportName method
		reporter.config().setReportName("Web Automation Results");
		//set the Document title -> use config() method & setDocumentTitle(String documentTitle) method
		reporter.config().setDocumentTitle("Test Results");
		//2.create object of ExtentReports
		 extent = new ExtentReports();
		//attach the report we created with ExtentSparkReporter
		//use attachReporter()method -> argument - object of ExtentSparkReporter
		extent.attachReporter(reporter);
		//give the tester name
		extent.setSystemInfo("Tester", "Rahul Shetty");
		
		
		
	}
	
 @Test
 public void initialDemo()
 {
	 //create one new test in the reporting file
	 //use createTest(String testName) method
	 ExtentTest test = extent.createTest("Initial Demo");
	 //invoke Chrome Browser
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\nithy\\OneDrive\\Documents\\chromedriver.exe"); 
	WebDriver driver =  new ChromeDriver();
	//go to webpage
	driver.get("https://rahulshettyacademy.com");
	//get the title of webpage
	System.out.println(driver.getTitle());
	//close the browser
	driver.close();
	//to take screenshoot
	//test.addScreenCaptureFromBase64String(s);
	//I want report a failure
	//test.fail("Result do not match");
	//test is done
	extent.flush();
 }
}
