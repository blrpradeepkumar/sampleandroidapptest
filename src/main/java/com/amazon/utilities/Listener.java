package com.amazon.utilities;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazon.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

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

		log.debug("The test script has failed : " + result.getName() + " , Capturing screenshot");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {

		log.debug("The test script has been skipped : " + result.getName());
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + " Skipped the test");
		report.endTest(test);
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult result) {

		log.debug("The test execution has started : " + result.getName());
		test.log(LogStatus.PASS, result.getName().toUpperCase() + " Test has passed");
		report.endTest(test);
		report.flush();
	}

}
