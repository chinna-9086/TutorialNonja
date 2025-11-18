package utillity;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

public class ExtentReportUtils implements ITestListener{
	String path;
	 ExtentSparkReporter spark;
	 ExtentReports report;
	 ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
	    Date dt=new Date();
	    String timestamp1 = df.format(dt);*/
	    
	    String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
	    
	    path="Test Report"+timestamp+".html";
	    
	    spark=new ExtentSparkReporter("C:\\Users\\M MAHESH NAIK\\eclipse-workspace\\bts\\reports\\"+path);
	    spark.config().setDocumentTitle("Automation Tetsing");
	    spark.config().setReportName("Functuional testing");
	    spark.config().setTheme(Theme.DARK);
	    
	    report=new ExtentReports();
	    report.attachReporter(spark);
	    report.setSystemInfo("application", "tutorial ninja");
	    report.setSystemInfo("module", "admin");
	    report.setSystemInfo("sub module", "custumer");
	    report.setSystemInfo("user", System.getProperty("user.name"));
	    report.setSystemInfo("environment", "qa");
	    
	    String browser = context.getCurrentXmlTest().getParameter("browser");
	    report.setSystemInfo("browser", browser);
	    
	    List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
	    if(!groups.isEmpty()) {
	    	report.setSystemInfo("groups", groups.toString());
	    }
	    
	  }

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.PASS,result.getName()+"test got successfully ecxecute");
	  }

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    
	    test.log(Status.FAIL,result.getName()+"tset is failed");
	    test.log(Status.FAIL,result.getThrowable().getMessage());
	    
	    String pathOfscreenshot = new BaseClass().takeScreenShot(result.getName());
	    test.addScreenCaptureFromPath(pathOfscreenshot);
	  }
	
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		    
		  }
	
	public void onFinish(ITestContext context) {
		report.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+path;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	    
	  }

	

}
