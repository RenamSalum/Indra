package selenium;


import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ExecuteMethod;
import org.seleniumhq.jetty9.util.thread.ExecutorThreadPool;

public class AutomacaoRunner {

	private WebDriver driver;
	private Automacao automacao;

	
	
	@Before
	public void inicializa() {
		this.driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		automacao = new Automacao(driver);
		Sistema.main(null);
	}
	
	@Test
	public void pesquisaDiretor() {
		
		
		automacao.acessoWeb();
		
		automacao.pesquisaFilme(Sistema.nomeDiretor);
		
		System.out.println("A diretora "+Sistema.nomeDiretor+" obteve "+automacao.resultado());

	}
	
	@Test
	public void pesquisaFilme() {

		
		automacao.acessoWeb();
		
		automacao.pesquisaFilme(Sistema.nomeFilme);
		
		System.out.println("O filme "+Sistema.nomeFilme+" obteve "+automacao.resultado());

	}
	
	
	
    @After
    public void encerra() {
        driver.close();
    }
	
	
}
