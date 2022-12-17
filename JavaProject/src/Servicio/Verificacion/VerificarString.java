package Servicio.Verificacion;

import Anotaciones.AnotacionInteger;
import Anotaciones.AnotacionString;
import Entidad.Persona;

import java.lang.reflect.Method;
import java.util.Arrays;

public class VerificarString implements IVerificacion {
    @Override
    public String verificarMetodo(Persona persona) throws Exception {
        StringBuilder text = new StringBuilder();

        Arrays.stream(persona.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(AnotacionString.class))
                .forEach(method -> {
                    AnotacionString anotacion = method.getAnnotation(AnotacionString.class);
                    String paramString = null;

                    try {
                        paramString = (String) method.invoke(persona);
                    }catch (Exception ex) {
                        throw new RuntimeException();
                    }

                    if (paramString.length() > anotacion.maxLenght()) {
                        text.append("\n* Error, se supero el maximo de caracter de: " + anotacion.tipo());
                    }

                    // Mas verificaciones...
                    // code...
                });

        return text.toString();
    }
}
