package Servicio;

import Entidad.Persona;
import Servicio.Verificacion.IVerificacion;
import Servicio.Verificacion.VerificarInteger;
import Servicio.Verificacion.VerificarString;

import java.util.Scanner;

public class PersonaServicio {

    /**
     * Encargado de crear el objeto Entidad.Persona
     *
     * @return: Devuelve el objeto creado
     * @throws Exception
     */
    public static Persona crearPersona() throws Exception{
        Scanner read = new Scanner(System.in);


        Persona persona = new Persona();

        System.out.println("Ingrese nombre");
        String nombre = read.nextLine();

        System.out.println("Ingrese apellido");
        String apellido = read.nextLine();

        System.out.println("Ingrese edad");
        int edad = Integer.parseInt(read.nextLine());

        persona.setApellido(apellido);
        persona.setNombre(nombre);
        persona.setEdad(edad);

        verificarObjeto(persona);

        return persona;
    }

    /**
     * Verifica el comportamiento del objeto
     * de acuerdo a criterios propios especificados en la
     * anotacion de cada atributo
     *
     * @param persona: Se recibe la instancia de la clase Entidad.Persona
     * @throws Exception: Se lanza el mensaje.
     */
    public static void verificarObjeto(Persona persona) throws Exception {
        String message = "";

        IVerificacion iVerificacion;

        iVerificacion = new VerificarString();
        message += iVerificacion.verificarMetodo(persona);

        iVerificacion = new VerificarInteger();
        message += iVerificacion.verificarMetodo(persona);


        if (message != null)
           throw new Exception(message);

        /* Before code
        for (Method method : persona.getClass().getDeclaredMethods()) {

            if (method.isAnnotationPresent(AnotacionString.class)) {
                AnotacionString anotacion = method.getAnnotation(AnotacionString.class);

                String paramString =(String) method.invoke(persona);

                if (paramString.length() > anotacion.maxLenght()) {
                    message += ("\n* Error, se supero el maximo de caracter de: " + anotacion.tipo());
                }
            }

            if (method.isAnnotationPresent(AnotacionInteger.class)) {
                AnotacionInteger anotacion = method.getAnnotation(AnotacionInteger.class);

                Integer paramInteger =(Integer) method.invoke(persona);

                if (paramInteger > anotacion.maxNumero()) {
                    message += ("\n* Error, se supero el maximo de caracter de: " + anotacion.tipo());
                }
            }


        }

        if (message != null)
            throw new Exception(message);*/

    }
}
