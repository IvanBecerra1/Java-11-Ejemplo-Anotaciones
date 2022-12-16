package Entidad;

import Anotaciones.AnotacionInteger;
import Anotaciones.AnotacionString;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {

    }

    @AnotacionString(maxLenght = 10, tipo = "Nombre")
    public String getNombre() {
        return nombre;
    }
    @AnotacionString(maxLenght = 5, tipo = "Apellido")
    public String getApellido() {
        return apellido;
    }
    @AnotacionInteger(maxNumero = 100, tipo = "Edad")
    public int getEdad() {
        return edad;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Entidad.Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
