package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public FileInputStream fis;
public Properties pro;
	
	@BeforeClass(alwaysRun=true)
	@Parameters("browser")
	public void setup(String br) {
		
		logger=LogManager.getLogger(this.getClass());
		
		String path=System.getProperty("user.dir")+"\\src\\test\\source\\confiure.properties";
		try {
			fis=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pro=new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.info("user lanching the desire browser");
		
		switch(br.toLowerCase()) {
		
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("invalid browser");return;
		
		}
	    
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		
		logger.info("User close the Browser");
		
		driver.quit();;
	}
	
public String randomString() {
		
		String randomstring = RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	
	public String randomNumber() {
		String randomnumaric = RandomStringUtils.randomNumeric(10);
		return randomnumaric;
	}
	
	public String randomAlphanumaric() {
		String randomstring = RandomStringUtils.randomAlphabetic(5);
		String randomnumaric = RandomStringUtils.randomNumeric(5);
		return(randomstring+randomnumaric);
	}

	public String takeScreenShot(String name) {
		
		/*SimpleDateFormat data=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
		Date dt=new Date();
		String timestamp = data.format(dt);*/
		
		String timestamp1 = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		
		TakesScreenshot sh=(TakesScreenshot)driver;
		File source = sh.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"\\screenshot\\"+name+"-"+timestamp1+".png";
		File file=new File(path);
		
		source.renameTo(file);
		
		return path;
		
	}
}
