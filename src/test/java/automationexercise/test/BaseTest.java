package automationexercise.test;

import automationexercise.factory.service.SeleniumService;
import org.junit.After;
import org.junit.Before;


public class BaseTest extends SeleniumService {

    @Before
    public void abrirNavegador(){
        initChromeDriver("https://www.automationexercise.com/login");
    }


    @After
    public void fecharNavegador(){
        quit();
    }

}
