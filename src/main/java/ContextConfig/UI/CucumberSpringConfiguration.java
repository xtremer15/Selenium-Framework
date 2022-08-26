package ContextConfig.UI;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ConfigUI.class})
@CucumberContextConfiguration
public class CucumberSpringConfiguration {

}
