package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsPlugin{

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	TakeScreenshot screen=new TakeScreenshot();
	
	public void generate() {
		reporter = new ExtentSparkReporter("ReportsShubham.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test=extent.createTest("MyFirstTest", "Test Description");
		
	}
	
	
	public static void testPass(String stepinfo) {
		test.log(Status.PASS, stepinfo);
	}
	
	public static void testFail(String stepinfo) {
		test.log(Status.FAIL, stepinfo);
	}
	
	public static void testLog(String stepinfo) {
		test.log(Status.INFO, stepinfo);
	}
	
	public void testPassWithScreenshot(String stepinfo) {
		test.addScreenCaptureFromBase64String(screen.takeScreenCapture().getAbsolutePath());
	}
	
	public void end() {
		extent.flush();
	}
	
}
