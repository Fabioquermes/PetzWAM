package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.Base;
import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.List;
import pages.Product;

import static org.junit.Assert.assertEquals;

//  Primeiro extender a base.
public class SearchProduct extends Base {
    private Base base;
    private Home home;
    private List list;
    private Product productClass;

    public SearchProduct(WebDriver driver, Base base) {
        super(driver);
        this.base = base;
    }
// acessa o site da Petz
    @Given("^I access Petz homepage$")
    public void iAccessPetzHomepage() {
        base.driver.get("https://www.petz.com.br");
    }

//Escreve o nome do produto e dar Enter
    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product) {
        home.searchWithEnter(product);
    }

//Verifica o nome da Lista
//Verifica o nome do produto listado
    @Then("^I see a list of product \"([^\"]*)\"$")
    public void iSeeAListOfProduct(String product) {
        //Validar o nome da guia
        assertEquals(product + " - Produtos pet em promoção | Petz",list.readTitleTab());


        //Validar o texto no Resultado Para
        assertEquals("Resultado para \"" + product + "\"", list.readTitleTab() );
    }


//Clicar no produto listado
    @And("^I click at product \"([^\"]*)\"$")
    public void iClickAtProduct(String product)  {
        list.clickAtDesiredProduct(product);
    }

//Verificar se o nome e o preço do produtos estão certos
    @Then("^show the title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void showTheTitleAndPrice(String product, String price)  {
        //Validar o nome da guia
        assertEquals(product + " - Produtos pet em promoção | Petz", productClass.readTitleTab());


        //Validar o nome do produto
        assertEquals("product", productClass.readProductTitle());


        //Validar o preço
        assertEquals( price, productClass.readPriceCurrent());

    }
}
