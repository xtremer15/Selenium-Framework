package ContextConfiguration.API;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ConfigAPI.class})
@CucumberContextConfiguration
public class CucumberSpringConfiguration {

    String basePath = "products";
    RestAssured restAssured;

    @Value("${baseURL}")
    private String baseURL;

    @Before
    public void setup() {
        RestAssured.baseURI = "https://fakerapi.it/api/v1/";
        RestAssured.basePath = basePath;
//        RestAssured.given().baseUri(baseURL).basePath(basePath);
    }

}
