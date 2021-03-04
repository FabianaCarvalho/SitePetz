package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListaPage extends BasePage {

	//@FindBy(xpath = "//h3[contains(text(),'Coleira Petz Azul para Cães')]")
	//private WebElement produtoDesejado; hardcode
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/div[1]/h1[1]")
	WebElement cabecalhoResultado;

	public ListaPage(WebDriver driver) {
		super(driver);
	}
	
	public void clicarNoProduto(String produto) {
		//produtoDesejado.click(); ficaria fixo hardcode
		WebElement produtoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'" + produto + "')]"));
		produtoDesejado.click();		
	}
	
	public String lerCabecalhoResultado() {
		return cabecalhoResultado.getText();
	}

}
