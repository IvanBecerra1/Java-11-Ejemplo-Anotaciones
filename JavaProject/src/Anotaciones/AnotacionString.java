package Anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Anotacion de ejemplo: Especifica el maximo de longitud
 * que podra tener el comportamiento de un objeto
 * que contenga la anotacion especifica.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnotacionString {
    int maxLenght();
    String tipo();
}
