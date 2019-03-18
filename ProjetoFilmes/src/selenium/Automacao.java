package selenium;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import net.thucydides.core.Thucydides;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;


public class Automacao {

    private WebDriver driver;
    
    
      
    public Automacao(WebDriver driver) {
        this.driver = driver;
    }
	
    public void acessoWeb() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com.br/");
    }

	public void pesquisaFilme(String Filme) {

		WebElement pesquisa = driver.findElement(By.name("q"));
		pesquisa.sendKeys(Keys.ENTER, Filme, Keys.ENTER);

	}

	public String resultado() {
		WebElement resultado = driver.findElement(By.id("resultStats"));
		return resultado.getText();	
	}
	


	
}
