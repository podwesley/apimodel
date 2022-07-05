package br.com.company;

import br.com.company.core.RestProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Teste extends RestProvider {


    @org.junit.Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the creation of a new employee")
    public void teste (){




    }


}
