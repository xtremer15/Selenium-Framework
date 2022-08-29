package Utils.factory;


import Utils.ExtendedWebElementImpl.ExtendedWebElement;
import Utils.annotation.ImplementedBy;

public final class ImplementedByProcessor {
    private ImplementedByProcessor() {
    }

    /**
     * Gets the wrapper class (descended from ExtendedWebElementImpl) for the annotation @ImplementedBy.
     *
     * @param iface iface to process for annotations
     * @param <T>   type of the wrapped class.
     * @return The class name of the class in question
     */
    public static <T> Class<?> getWrapperClass(Class<T> iface) {
        if (iface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (ExtendedWebElement.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " +
                iface.getCanonicalName() + " if you want to extend ");
    }

}
