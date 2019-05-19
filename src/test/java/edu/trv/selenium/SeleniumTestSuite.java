package edu.trv.selenium;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Main test suite")
@SelectPackages("edu.trv.selenium.testcases")
public class SeleniumTestSuite {}
