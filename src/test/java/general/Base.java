package general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    protected WebDriver driver; //objeto do Selenium WEbDriver, vulgo bola
    // ao usar o PageFactory mudar de public para protected

    //Criar um construtor e inicializar os elementos do PageFactory
    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
