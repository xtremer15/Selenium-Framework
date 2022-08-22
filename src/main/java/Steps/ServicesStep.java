package Steps;

import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import Services.Service;

import java.util.HashMap;

public class ServicesStep {
    @Autowired
    Service service;

    @Given("^i will mage a GET request$")
    public void i_will_mage_a_get_request() throws Throwable {
        HashMap<String, Integer> params = new HashMap<>() {{
            put("_price_min", 10);
            put("_price_max", 120);
            put("_taxes", 15);
            put("_categories_type", 3);
        }};

        String name = service.httpGET(params).and().extract().jsonPath().getString("data.name");
        System.out.println("name este =>" + name);

    }
}


