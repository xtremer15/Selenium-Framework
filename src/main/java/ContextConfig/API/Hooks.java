package ContextConfig.API;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class Hooks {

    String basePath = "products";
    RestAssured restAssured;
    @Value("${baseURL:https://fakerapi.it/api/v1/}")
    private String baseURL;

    @Before
    public void setup() {
        RestAssured.baseURI = baseURL;
        RestAssured.basePath = basePath;
    }
}
