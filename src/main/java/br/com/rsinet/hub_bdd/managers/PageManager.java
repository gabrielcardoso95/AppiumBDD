package br.com.rsinet.hub_bdd.managers;

import br.com.rsinet.hub_bdd.pageFactory.PaginaDeCadastro;
import br.com.rsinet.hub_bdd.pageFactory.PaginaDeProdutos;
import br.com.rsinet.hub_bdd.pageFactory.PaginaInicial;
import io.appium.java_client.android.AndroidDriver;

public class PageManager {
	private AndroidDriver driver;
	private PaginaInicial paginaInicial;
	private PaginaDeCadastro paginaDeCadastro;
	private PaginaDeProdutos paginaDeProdutos;
	
	public PageManager(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public PaginaInicial getPaginaInicial() {
		return (paginaInicial == null) ? paginaInicial = new PaginaInicial(driver) : paginaInicial;
	}

	public PaginaDeCadastro getPaginaDeCadastro() {
		return (paginaDeCadastro == null) ? paginaDeCadastro = new PaginaDeCadastro(driver) : paginaDeCadastro;
	}

	public PaginaDeProdutos getPaginaDeProdutos() {
		return(paginaDeProdutos == null) ? paginaDeProdutos = new PaginaDeProdutos(driver) : paginaDeProdutos;
	}
	
}