package Servicio.Verificacion;

import java.lang.reflect.Method;
import Entidad.Persona;
import Anotaciones.AnotacionInteger;

public class VerificarInteger implements IVerificacion {

    @Override
    public String verificarMetodo(Persona persona) throws Exception {
        String message = "";

        for (Method method : persona.getClass().getDeclaredMethods()) {

            if (method.isAnnotationPresent(AnotacionInteger.class)) {
                AnotacionInteger anotacion = method.getAnnotation(AnotacionInteger.class);

                Integer paramInteger =(Integer) method.invoke(persona);

                if (paramInteger > anotacion.maxNumero()) {
                    message += ("\n* Error, se supero el maximo de caracter de: " + anotacion.tipo());
                }

                // Mas verificaciones...
                // code...
            }
        }
        return message;
    }
}
