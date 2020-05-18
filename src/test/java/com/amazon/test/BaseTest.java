package com.amazon.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.amazon.base.BaseClass;

public class BaseTest extends BaseClass {

	@BeforeSuite
	public void initialize() {

		service = startAppiumServer();
		driver = initializeCapabilities();

	}

	@AfterSuite
	public void stopTheServer() {

		stopAppiumServer();
	}

}
