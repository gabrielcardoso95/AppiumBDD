package br.com.rsinet.hub_bdd.pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.utils.ScreenShot;
import br.com.rsinet.hub_bdd.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class PaginaDeCadastro {
	private AndroidDriver driver;

	public PaginaDeCadastro(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement cx_NomeDeUsuario;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement cx_EmailDeUsuario;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement cx_Senha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement cx_ConfirmaSenha;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement cx_PrimeiroNome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement cx_Sobrenome;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement cx_Telefone;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewCountries")
	private WebElement cmbx_Pais;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement cx_Endereco;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	private WebElement cx_Cidade;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement cx_Estado;

	@FindBy(how = How.XPATH, using = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement cx_CEP;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement btn_Registrar;

	public void preenche_NomeDeUsuario(String arg1) {
		cx_NomeDeUsuario.sendKeys(arg1);
	}

	public void preenche_EmailDeUsuario(String arg1) {
		cx_EmailDeUsuario.sendKeys(arg1);
	}

	public void preenche_Senha(String arg1) {
		cx_Senha.sendKeys(arg1);
	}

	public void confirma_Senha(String arg1) {
		cx_ConfirmaSenha.sendKeys(arg1);
	}

	public void preenche_PrimeiroNome(String arg1) {
		cx_PrimeiroNome.sendKeys(arg1);
	}

	public void preenche_Sobrenome(String arg1) {
		cx_Sobrenome.sendKeys(arg1);
	}

	public void preenche_Telefone(String arg1) {
		cx_Telefone.sendKeys(arg1);
	}
	
	public void desce_Pagina() {
		Scroll.scroll(driver, "REGISTER");
	}
	
	public void seleciona_Pais(String arg1) {
		cmbx_Pais.click();
		Scroll.scrollAndClick(driver, arg1);
	}
	
	public void preenche_Estado(String arg1) {
		cx_Estado.sendKeys(arg1);
	}
	
	public void preenche_Endereço(String arg1) {
		cx_Endereco.sendKeys(arg1);
	}
	
	public void preenche_Cidade(String arg1) {
		cx_Cidade.sendKeys(arg1);
	}
	
	public void preenche_CEP(String arg1) {
		cx_CEP.sendKeys(arg1);
	}
	
	public void clica_Registrar() {
		btn_Registrar.click();
	}
	
	public boolean verifica_MensagemDeErro() {
		driver.getPageSource().contains("1 upper letter required");
		return true;
	}
	
	public void clica_Senha() {
		cx_Senha.click();
	}
	public void clica_ConfirmaSenha() {
		cx_ConfirmaSenha.click();
	}
	
	public void cadastroScreenshot() throws IOException {
		ScreenShot.capture(driver, "UsuarioLogado");
	}
	
	public void cadastroScreenshotErro() throws IOException {
		ScreenShot.capture(driver, "SenhaInvalida");
	}

}