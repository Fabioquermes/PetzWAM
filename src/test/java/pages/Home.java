package pages;

import general.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Base {

    // 1 - Mapeamentos de Elementos
    @FindBy(id = "search")
    private WebElement txtInputSearch;

    @FindBy(css = "button.button-search")
    private WebElement btnSearch;



    // 2 - Construtor

    public Home(WebDriver driver) {
        super(driver);
    }


    // 3 - Ações dos Elementos

    public void search(String product){
        txtInputSearch.click(); //clicar na caixa de pesquisa
        txtInputSearch.clear(); //Limpar o conteudo da caixa de texto
        txtInputSearch.sendKeys(product);// escreve na caixa de texto

    }

    public void searchWithMagnifierButton(String product){
        search(product);
        btnSearch.click(); //clicar no botão lupa

    }

    public void searchWithEnter(String product){
        search(product);
        txtInputSearch.sendKeys(Keys.ENTER);

    }

}
