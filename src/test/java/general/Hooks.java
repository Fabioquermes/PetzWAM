package general;

import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base {
    private Base base; //objeto local para a comunicação com a o objeto da Classe extendida

    //Contrutor para classe base
    public Hooks(Base base) {
        super(base.driver);
        this.base = base;
    }

    //Before
    @Before
    public void setup(){
        // Onde esta o Drier do Browser
        System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver029/geckodriver.exe");
        //Instanciar o driver do Firefox
        base.driver = new FirefoxDriver();

        /*
        * Comportamento da pagina
        * Dimenção da tela e espera
        * */
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    //After
    public void tearDown(){
        base.driver.quit();  //Destruir o objeto do Selenium

    }

}
