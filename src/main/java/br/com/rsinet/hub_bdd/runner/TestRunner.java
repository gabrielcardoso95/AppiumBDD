package br.com.rsinet.hub_bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue = {"br.com.rsinet.hub_bdd.steps"},
		//tags = {"@BuscaPorLupa", "@Teste02"},
		monochrome = true
		)

public class TestRunner {
	
}