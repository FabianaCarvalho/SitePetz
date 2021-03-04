package petz;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import pages.ListaPage;


public class ComprarProduto {
	String url;
	WebDriver driver;
	
	HomePage homePage; //objeto HomePage herdando a classe HomePage
	ListaPage listaPage;

	@Before
	public void iniciar() {
		url = "https://www.petz.com.br";

		System.setProperty("webdriver.chrome.driver", "chromedriver_89/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		
		homePage = new HomePage(driver); //instanciar a pagina
		listaPage = new ListaPage(driver);
	}

	@After
	public void finalizar() {
		driver.quit();
	}

	@Dado("^que acesso o site Petz$")
	public void que_acesso_o_site_Petz() {
		driver.get(url);

	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto) {
		homePage.buscarProdutoComEnter(produto);

	}

	@Entao("^exibe uma lista de produtos relacionados com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", listaPage.lerCabecalhoResultado());

	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto) {
		listaPage.clicarNoProduto(produto);

	}

	@Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
	public void exibe_para_o_o_preco_de(String arg1, String arg2) {

	}

}
