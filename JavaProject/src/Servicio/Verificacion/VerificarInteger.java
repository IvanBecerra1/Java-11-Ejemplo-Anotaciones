package Servicio.Verificacion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import Entidad.Persona;
import Anotaciones.AnotacionInteger;

public class VerificarInteger implements IVerificacion {

    @Override
    public String verificarMetodo(Persona persona) throws Exception {
        StringBuilder text = new StringBuilder();

        Arrays.stream(persona.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(AnotacionInteger.class))
                .forEach(method -> {
                    AnotacionInteger anotacion = method.getAnnotation(AnotacionInteger.class);
                    Integer paramInteger = null;

                    try {
                        paramInteger = (Integer) method.invoke(persona);
                    }catch (Exception ex) {
                        throw new RuntimeException();
                    }

                    if (paramInteger > anotacion.maxNumero()) {
                        text.append("\n* Error, se supero el maximo de: " + anotacion.tipo());
                    }

                    // mas verificaciones
                    // code..
                });

        return text.toString();
    }

}
