package com.amazon.utilities;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazon.base.BaseClass;

public class Listener extends BaseClass implements ITestListener {

	public void onFinish(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		log.debug("The test script has failed : " + result.getName()+" , Capturing screenshot");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		log.debug("The test script has been skipped : " + result.getName());

	}

	public void onTestStart(ITestResult result) {


	}

	public void onTestSuccess(ITestResult result) {

		log.debug("The test execution has started : "+result.getName());
	}

}
