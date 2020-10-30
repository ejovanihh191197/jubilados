/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jubilacion;

/**
 *
 * @author erick
 */
public class Persona {
    private int edad;
    private char genero;
    private int anios;
    private boolean jubilacion;

    public Persona() {
    }

    public Persona(int edad, char genero, int anios, boolean jubilacion) {
        this.edad = edad;
        this.genero = genero;
        this.anios = anios;
        this.jubilacion = jubilacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public boolean isJubilacion() {
        return jubilacion;
    }

    public void setJubilacion(boolean jubilacion) {
        this.jubilacion = jubilacion;
    }

    @Override
    public String toString() {
        String texto = "";
        if (jubilacion){
            texto = "Tiene derecho a jubilacion";
        }else{
            texto = "No tiene derecho a jubilacion";
        }
        return "Edad: " + edad + " Genero: " + genero + " Anios: " + anios + " Jubilacion: " + texto;
    }
    
    
    
}
