package br.com.rsinet.hub_bdd.steps;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import br.com.rsinet.hub_bdd.managers.AppManager;
import br.com.rsinet.hub_bdd.managers.TestContext;
import br.com.rsinet.hub_bdd.utils.ExtentReport;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

public class Hooks {

	private TestContext testContext;
	private AppManager manager;
	private AndroidDriver<?> driver;
	private ExtentTest test = ExtentReport.getTest();
	private ExtentReports extent = ExtentReport.getExtent();

	public Hooks(TestContext context) {
		testContext = context;
		manager = testContext.getAppManager();
		driver = manager.getDriver();
	}
	
	@Before()
	public void BeforeSteps() throws IOException {
		testContext.getAppManager().getDriver();
		ExtentReport.iniciaReport();
	}
	
	@After()
	public void AfterSteps() throws IOException {
		testContext.getAppManager().closeDriver();
		ExtentReport.fechaReport();
	}
}
