package Servicio.Verificacion;

import Anotaciones.AnotacionString;
import Entidad.Persona;

import java.lang.reflect.Method;

public class VerificarString implements IVerificacion {
    @Override
    public String verificarMetodo(Persona persona) throws Exception {
        String message = "";

        for (Method method : persona.getClass().getDeclaredMethods()) {

            if (!method.isAnnotationPresent(AnotacionString.class)) {
                continue;
            }

            AnotacionString anotacion = method.getAnnotation(AnotacionString.class);

            String paramString =(String) method.invoke(persona);

            if (paramString.length() > anotacion.maxLenght()) {
                message += ("\n* Error, se supero el maximo de caracter de: " + anotacion.tipo());
            }

            // Mas verificaciones...
            // code...
        }

        return message;
    }
}
