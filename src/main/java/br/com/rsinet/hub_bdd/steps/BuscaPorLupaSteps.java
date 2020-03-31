package br.com.rsinet.hub_bdd.steps;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import br.com.rsinet.hub_bdd.managers.TestContext;
import br.com.rsinet.hub_bdd.pageFactory.PaginaDeProdutos;
import br.com.rsinet.hub_bdd.pageFactory.PaginaInicial;
import br.com.rsinet.hub_bdd.utils.ExtentReport;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BuscaPorLupaSteps {
	private PaginaInicial paginaInicial;
	private PaginaDeProdutos paginaDeProdutos;
	AndroidDriver<?> driver;
	ExtentTest test = ExtentReport.getTest();
	ExtentReports extent = ExtentReport.getExtent();

	private TestContext testContext;

	public BuscaPorLupaSteps(TestContext context) {
		testContext = context;
		paginaInicial = testContext.getPageObjectManager().getPaginaInicial();
		paginaDeProdutos = testContext.getPageObjectManager().getPaginaDeProdutos();
	}

	@Quando("^pressionar o botao da lupa$")
	public void pressionar_o_botao_da_lupa() throws Throwable {
		paginaInicial.clica_Lupa();
	}

	@Quando("^preencher a barra de pesquisa com produto valido \"([^\"]*)\"$")
	public void preencher_a_barra_de_pesquisa_com_produto_valido(String arg1) throws Throwable {
		test = extent.startTest("Busca de produto valido por lupa");
		paginaInicial.preenche_BarraDePesquisa(arg1);
		test.log(LogStatus.PASS, "Preencheu barra de pesquisa com produto valido");
	}

	@Quando("^pressionar novamente o botao da lupa$")
	public void pressionar_novamente_o_botao_da_lupa() throws Throwable {
		paginaInicial.clica_Lupa();
		test.log(LogStatus.PASS, "Clicou novamente no botao de lupa");
	}

	@Quando("^clicar em um produto da lista \"([^\"]*)\"$")
	public void clicar_em_um_produto_da_lista(String arg1) throws Throwable {
		paginaDeProdutos.clica_Produto(arg1);
		test.log(LogStatus.PASS, "Clicou no produto");
	}

	@Entao("^detalhes do produto aparecerao na tela$")
	public void detalhes_do_produto_aparecerao_na_tela() throws Throwable {
		Assert.assertTrue(paginaDeProdutos.verifica_Detalhes());
		paginaDeProdutos.produtoScreenshot();
		test.log(LogStatus.PASS, "Produto aparece na tela " + test.addScreenCapture(
				"C:\\Users\\gabriel.cardoso\\workspace\\AppiumBDD-master\\test-output\\Screenshot\\ProdutoScreenshot.png"));
	}

	@Quando("^preencher a barra de pesquisa com produto invalido \"([^\"]*)\"$")
	public void preencher_a_barra_de_pesquisa_com_produto_invalido(String arg1) throws Throwable {
		test = extent.startTest("Busca de produto invalido por lupa");
		paginaInicial.preenche_BarraDePesquisa(arg1);
		test.log(LogStatus.PASS, "Preencheu barra de pesquisa com informacoes invalidas");
	}

	@Entao("^aparecera a mensagem \"([^\"]*)\"$")
	public void aparecera_a_mensagem(String arg1) throws Throwable {
		Assert.assertTrue(paginaDeProdutos.verifica_MensagemDeErro());
		paginaDeProdutos.produtoScreenshotErro();
		test.log(LogStatus.PASS, "Sem resultados para o produto pesquisado" + test.addScreenCapture(
				"C:\\Users\\gabriel.cardoso\\workspace\\AppiumBDD-master\\test-output\\Screenshot\\ProdutoScreenshotErro.png"));
	}
}
