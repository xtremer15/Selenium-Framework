package Annotations;

import org.openqa.selenium.support.PageFactoryFinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomAnnotation extends AbstractCustomAnnotation {
    private Field field;

    public CustomAnnotation(Field field) {
        this.field = field;
    }

    @Override
    public boolean isElementVisible() {
        boolean visible = false;
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            AbstractExtendedWebElement builder = null;
            if (annotation.annotationType().isAnnotationPresent(FactoryExtendedWebElement.class)) {
                try {
                    builder = annotation.annotationType()
                            .getAnnotation(FactoryExtendedWebElement.class).value()
                            .newInstance();
                } catch (ReflectiveOperationException exception) {
                    exception.notify();
                }
                if (builder != null) {
                    visible = builder.isVisible(annotation, field);
                }
            }
        }
        return visible;
    }
}
