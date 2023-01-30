package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshot extends Base{
	
//public File takeScreenCapture() {
//	TakesScreenshot scrShot =((TakesScreenshot)driver);
//	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//	return SrcFile;
//}
	
	public static String takeScreenshotAtEndOfTest(){
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
	            + ".png";
	    File finalDestination = new File(destination);
	    try {
			FileHandler.copy(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return destination;
	}
}
