package Services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class Service {

    RequestSpecification httpRequest = RestAssured.given();

    private String name ="tito";
    private String pass =  "ceva";


    public ValidatableResponse httpGET(HashMap<String, Integer> params) {
        return httpRequest.header("Content-Type", "application/json")
                .accept(ContentType.JSON)
                .params(params)
                .and().get()
                .then().log().all().and().extract().response()
                .then().assertThat().statusCode(200);
    }


    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
