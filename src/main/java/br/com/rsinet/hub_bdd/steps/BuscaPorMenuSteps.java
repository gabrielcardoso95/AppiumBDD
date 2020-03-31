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
public class BuscaPorMenuSteps {
	private PaginaInicial paginaInicial;
	private PaginaDeProdutos paginaDeProdutos;
	private AndroidDriver<?> driver;
	private ExtentTest test = ExtentReport.getTest();
	private ExtentReports extent = ExtentReport.getExtent();

	private TestContext testContext;

	public BuscaPorMenuSteps(TestContext context) {
		testContext = context;
		paginaInicial = testContext.getPageObjectManager().getPaginaInicial();
		paginaDeProdutos = testContext.getPageObjectManager().getPaginaDeProdutos();

	}

	@Quando("^clicar em algum menu$")
	public void clicar_em_algum_menu() throws Throwable {
		test = extent.startTest("Busca Por Menu");
		paginaInicial.clica_MenuLaptops();
	}

	@Quando("^clicar em um produto do menu \"([^\"]*)\"$")
	public void clicar_em_um_produto_do_menu(String arg1) throws Throwable {
		paginaDeProdutos.clica_Produto(arg1);
	}

	@Entao("^detalhes do produto aparecerao no menu$")
	public void detalhes_do_produto_aparecerao_no_menu() throws Throwable {
		Assert.assertTrue(paginaDeProdutos.verifica_Detalhes());
		paginaDeProdutos.produtoScreenshot();
	}

}
