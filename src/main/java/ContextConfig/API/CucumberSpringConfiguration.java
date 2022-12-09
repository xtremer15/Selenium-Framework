package ContextConfig.API;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ConfigAPI.class})
//@CucumberContextConfiguration
public class CucumberSpringConfiguration {

}
