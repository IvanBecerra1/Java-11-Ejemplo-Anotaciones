import Entidad.Persona;
import Servicio.PersonaServicio;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Persona pp = new Persona();

        try {
            pp = PersonaServicio.crearPersona();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}