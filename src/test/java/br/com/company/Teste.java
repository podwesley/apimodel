package br.com.company;

import br.com.company.core.RestProvider;
import br.com.company.domain.SimpleUser;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/***
 * Testes de serialização/(de)-serialização com RestAssured.
 */
public class Teste extends RestProvider {


    /***
     * @Author: Wesley Rodrigues Soares 2022.
     * usar o get que ja faz a de-serialização
     */
    @Test
    public void testeDeserializar() {

        SimpleUser simpleUser = new SimpleUser();

        simpleUser.setName("Teste");
        simpleUser.setAge(12);

        SimpleUser newUser =  given()
                .when()
                .get("http://resources")
                .as(SimpleUser.class);

    }


    @Test
    public void testeSerializar() {



    }



}
