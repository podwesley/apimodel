package br.com.company.core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static br.com.company.core.ConfigLoader.getProperty;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.baseURI;
/**
 * @Author: Wesley R.
 */
public class RestProvider { // teste MCP server github

    private Response response;

    public RestProvider() {
        baseURI = getProperty("base.uri");
    }


    //******* OPERAÇÕES HTTP

    /****
     * GET
     */
    protected RestProvider get(String endpoint) {

        response = given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .extract().response();
        return this;
    }

    /***
     * POST
     * @Author Wesley R
     * @return
     */
    protected <T> T post(T body, String endpoint) {

        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .contentType(ContentType.JSON)
                .and()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response()
                .body()
                .as(body.getClass().asSubclass(body.getClass()));
    }

    /***
     * GET type
     * @author wesley r
     * @param classz
     * @param endpoint
     * @return
     * @param <T>
     */
    protected <T> T get(Class<T> classz, String endpoint) {

        return given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response()
                .body()
                .as(classz);
    }


    /***
     * PUT
     * @Author Wesley R
     * @param body
     * @param endpoint
     * @return
     */
    protected <T> RestProvider put(T body, String endpoint) {

        response = given()
                .filter(new AllureRestAssured())
                .log()
                .all()
                .contentType(ContentType.JSON)
                .and()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
        return this;
    }


    /***
     * Body Validation.
     * @param data
     * @param field
     */
    protected RestProvider validarCampoPayload(String data, String field) {
        assertThat(data, containsStringIgnoringCase(response.jsonPath().getString(field)));
        return this;
    }

    /***
     * Status code validation.
     * @param statusCode
     */
    protected RestProvider validaStatusCode(int statusCode) {
        assertEquals(statusCode, response.statusCode());
        return this;
    }


}
