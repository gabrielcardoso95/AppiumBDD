package br.com.rsinet.hub_bdd.pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.utils.ScreenShot;
import br.com.rsinet.hub_bdd.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class PaginaDeProdutos {
	private AndroidDriver driver;
	
	public PaginaDeProdutos(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductName")
	private WebElement lnk_Produto;

	@FindBy(how = How.ID, using = "52486a83-e822-406d-a12b-ed40480abc49")
	private WebElement img_Produto;
	
	public void clica_Produto(String arg1) {
		Scroll.scrollAndClick(driver, arg1);
	}
	
	public boolean verifica_Detalhes() {
		driver.getPageSource().contains("DETAILS");
		return true;
	}
	
	public boolean verifica_MensagemDeErro() throws InterruptedException {
		driver.getPageSource().contains("No results for");
		Thread.sleep(200);
		return true;
	}
	
	public void produtoScreenshot() throws IOException {
		ScreenShot.capture(driver, "ProdutoScreenshot");
	}
	
	public void produtoScreenshotErro() throws IOException {
		ScreenShot.capture(driver, "ProdutoScreenshotErro");
	}
}
