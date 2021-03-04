package petz;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;


public class Simples {

	String url;
	WebDriver driver;
	HomePage homePage;
	
	@Before
	public void iniciar() {
		url = "https://www.petz.com.br";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver_89/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		
		homePage = new HomePage(driver);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void abrirPagina() {
		driver.get(url);
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle());
	}
	
}
