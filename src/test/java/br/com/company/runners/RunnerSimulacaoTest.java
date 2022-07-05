package br.com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
        features = "src/test/resources/features/simulacao.feature",
        glue = "br.com.company",
        //dryRun = false,
        tags = "@Regressivo"

)
public class RunnerSimulacaoTest {

}
