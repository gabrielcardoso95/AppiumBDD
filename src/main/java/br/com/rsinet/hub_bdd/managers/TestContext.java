package br.com.rsinet.hub_bdd.managers;

public class TestContext {
	
	private AppManager appManager;
	private PageManager pageManager;
	
	public TestContext() {
		appManager = new AppManager();
		pageManager = new PageManager(appManager.getDriver());
	}
	
	public AppManager getAppManager() {
		 return appManager;
	}
	
	public PageManager getPageObjectManager() {
		return pageManager;
	}

}