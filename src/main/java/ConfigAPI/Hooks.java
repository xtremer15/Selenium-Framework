package ConfigAPI;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.net.URL;

@PropertySource("classpath:application.properties")
public class Hooks {

    String basePath = "products";
    RestAssured restAssured;
    @Value("${baseURL:https://fakerapi.it/api/v1/}")
    private String baseURL;

    @Before
    public void setup() {
        System.out.println("baseUrl este=> " + this.baseURL);
        RestAssured.baseURI = baseURL;
        RestAssured.basePath = basePath;
    }
}
