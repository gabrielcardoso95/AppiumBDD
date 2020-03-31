package br.com.rsinet.hub_bdd.steps;

import static org.junit.Assert.assertTrue;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_bdd.managers.TestContext;
import br.com.rsinet.hub_bdd.pageFactory.PaginaDeCadastro;
import br.com.rsinet.hub_bdd.pageFactory.PaginaInicial;
import br.com.rsinet.hub_bdd.utils.ExtentReport;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class CadastroDeUsuarioSteps {
	private AndroidDriver driver;
	private PaginaInicial paginaInicial;
	private PaginaDeCadastro paginaDeCadastro;
	private TestContext testContext;
	private ExtentTest test = ExtentReport.getTest();
	private ExtentReports extent = ExtentReport.getExtent();

	public CadastroDeUsuarioSteps(TestContext context) {
		testContext = context;
		paginaInicial = testContext.getPageObjectManager().getPaginaInicial();
		paginaDeCadastro = testContext.getPageObjectManager().getPaginaDeCadastro();
	}

	@Dado("^que o aplicativo esteja aberto$")
	public void que_o_aplicativo_esteja_aberto() throws Throwable {
	}

	@Quando("^navegar ate a pagina de cadastro de novo usuario$")
	public void navegar_ate_a_pagina_de_cadastro_de_novo_usuario() throws Throwable {
		paginaInicial.clica_MenuDeUsuario();
		paginaInicial.clica_LogIn();
		paginaInicial.clica_Cadastrar();
	}

	@Quando("^Preencher campo de usuario \"([^\"]*)\"$")
	public void preencher_campo_de_usuario(String arg1) throws Throwable {
		test = extent.startTest("Cadastro de usuario valido");
		paginaDeCadastro.preenche_NomeDeUsuario(arg1);
	}

	@Quando("^Preencher campo de email \"([^\"]*)\"$")
	public void preencher_campo_de_email(String arg1) throws Throwable {
		paginaDeCadastro.preenche_EmailDeUsuario(arg1);
	}

	@Quando("^Preencher campo de senha \"([^\"]*)\"$")
	public void preencher_campo_de_senha(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Senha(arg1);
	}

	@Quando("^Preencher campo de confirmacao de senha \"([^\"]*)\"$")
	public void preencher_campo_de_confirmacao_de_senha(String arg1) throws Throwable {
		paginaDeCadastro.confirma_Senha(arg1);
	}

	@Quando("^Preencher campo de primeiro nome \"([^\"]*)\"$")
	public void preencher_campo_de_primeiro_nome(String arg1) throws Throwable {
		paginaDeCadastro.preenche_PrimeiroNome(arg1);
	}

	@Quando("^Preencher campo de sobrenome \"([^\"]*)\"$")
	public void preencher_campo_de_sobrenome(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Sobrenome(arg1);
	}

	@Quando("^Preencher campo de telefone \"([^\"]*)\"$")
	public void preencher_campo_de_telefone(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Telefone(arg1);
		paginaDeCadastro.desce_Pagina();
	}

	@Quando("^Selecionar o pais \"([^\"]*)\"$")
	public void selecionar_o_pais(String arg1) throws Throwable {
		paginaDeCadastro.seleciona_Pais(arg1);
	}

	@Quando("^Preencher campo de estado \"([^\"]*)\"$")
	public void preencher_campo_de_estado(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Estado(arg1);
	}

	@Quando("^Preencher campo de endereco \"([^\"]*)\"$")
	public void preencher_campo_de_endereco(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Endere�o(arg1);
	}

	@Quando("^Preencher campo de cidade \"([^\"]*)\"$")
	public void preencher_campo_de_cidade(String arg1) throws Throwable {
		paginaDeCadastro.preenche_Cidade(arg1);
	}

	@Quando("^Preencher campo de CEP \"([^\"]*)\"$")
	public void preencher_campo_de_CEP(String arg1) throws Throwable {
		paginaDeCadastro.preenche_CEP(arg1);
	}

	@Quando("^Pressiona o botao de \"([^\"]*)\"$")
	public void pressiona_o_botao_de(String arg1) throws Throwable {
		paginaDeCadastro.clica_Registrar();
	}

	@Quando("^Pressionar o botao de menu \"([^\"]*)\"$")
	public void pressionar_o_botao_de_menu(String arg1) throws Throwable {
		paginaInicial.clica_MenuDeUsuario();
	}

	@Então("^Usuario aparece logado na tela \"([^\"]*)\"$")
	public void usuario_aparece_logado_na_tela(String arg1) throws Throwable {
		assertTrue(paginaInicial.verifica_Usuario().equals(arg1));
		paginaDeCadastro.cadastroScreenshot();
	}

	@Quando("^Preencher o campo de senha com caracteres invalidos \"([^\"]*)\"$")
	public void preencher_o_campo_de_senha_com_caracteres_invalidos(String arg1) throws Throwable {
		paginaDeCadastro.clica_Senha();
		paginaDeCadastro.preenche_Senha(arg1);
		paginaDeCadastro.clica_ConfirmaSenha();
	}

	@Então("^Sera mostrada mensagem de erro$")
	public void sera_mostrada_mensagem_de_erro() throws Throwable {
		Assert.assertTrue(paginaDeCadastro.verifica_MensagemDeErro());
		paginaDeCadastro.cadastroScreenshotErro();
	}
}
