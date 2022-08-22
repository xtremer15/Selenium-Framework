package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.Policy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryExtendedWebElement {
    Class<? extends  AbstractExtendedWebElement> value();
}
