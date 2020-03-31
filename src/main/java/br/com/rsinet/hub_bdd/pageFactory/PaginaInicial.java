package br.com.rsinet.hub_bdd.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class PaginaInicial {
	private AndroidDriver driver;

	private PaginaInicial(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement btn_Menu;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement btn_LogIn;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewSingUpToday")
	private WebElement btn_Cadastrar;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement btn_Lupa;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement txtbx_Pesquisar;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement txt_usuarioLogado;

	public void clica_MenuDeUsuario() throws InterruptedException {
		Thread.sleep(4000);
		btn_Menu.click();
	}

	public void clica_LogIn() {
		btn_LogIn.click();
	}

	public void clica_Cadastrar() {
		btn_Cadastrar.click();
	}

	public void clica_Lupa() {
		btn_Lupa.click();
	}

	public String verifica_Usuario() {
		return txt_usuarioLogado.getText();
	}
	
	public void preenche_BarraDePesquisa(String arg1) {
		txtbx_Pesquisar.sendKeys(arg1);
	}
	
	public void clica_MenuLaptops() {
		Scroll.scrollAndClick(driver, "LAPTOPS");
	}
	
	public void clica_MenuMice() {
		Scroll.scrollAndClick(driver, "MICE");
	}
	
	public void clica_MenuSpeakers() {
		Scroll.scrollAndClick(driver, "SPEAKERS");
	}
	
	
}