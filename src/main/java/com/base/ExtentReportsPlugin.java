package com.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsPlugin {

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static TakeScreenshot screen = new TakeScreenshot();

	public void generate() {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		reporter = new ExtentSparkReporter("Reports/" + dateName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest("MyFirstTest", "Test Description");

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

	public static void testPassWithScreenshot(String stepinfo) {
//		test.log(Status.PASS, TakeScreenshot.takeScreenshotAtEndOfTest());
//		test.log(Status.INFO, "Google Page opened"+test.addScreenCaptureFromPath(TakeScreenshot.takeScreenshotAtEndOfTest()));
		test.log(Status.PASS, stepinfo).fail("Screenshot 1: ",
				MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenshot.takeScreenshotAtEndOfTest()).build());
	}

	public void end() {
		extent.flush();
	}

}
