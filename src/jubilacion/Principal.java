/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jubilacion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author erick
 */
public class Principal {
    private ArrayList<Persona> personas = new ArrayList();
    private int hombres = 0;
    private int mujeres = 0;
    
    public int menu(){
        int opElejida;
        Scanner opcion = new Scanner(System.in);
        
        System.out.println("******** Bienvenido ********");
        System.out.println("¿Que desea realizar?");
        System.out.println("1.- Ingresar persona");
        System.out.println("2.- Ver personas");
        System.out.println("3.- Ver beneficiarios por genero");
        System.out.println("4.- Salir");
        opElejida = opcion.nextInt();
        return opElejida;
    }
    
    public void main(){
        int opcion;
        do{
            opcion = menu();
            switch(opcion){
                case 1:
                    Persona reg = new Persona();
                    reg = registrarPersona();
                    personas.add(reg);
                break;
                case 2:
                    verPersonas();
                break;
                case 3:
                    numeroPersonasGenero();
                break;
                case 4:
                    System.out.println("Hasta luego!!");
                break;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
                break;
            }
        }while(opcion != 4);
    }
    
    public Persona registrarPersona(){
        Persona nueva = new Persona();
        int edad;
        char genero;
        boolean generoC;
        int anios;
        boolean derecho;
        Scanner datos = new Scanner(System.in);
        System.out.println("Ingresa la edad de la persona");
        edad = datos.nextInt();
        do{
            System.out.println("Ingrese el genero (Hombre = H, Mujer = M)");
            genero = datos.next().charAt(0);
            generoC = generoCorrecto(genero);
        }while(!generoC);
        System.out.println("Ingresa los años de aporte");
        anios = datos.nextInt();
        derecho = derecho(genero, anios, edad);
        nueva.setEdad(edad);
        nueva.setGenero(genero);
        nueva.setAnios(anios);
        nueva.setJubilacion(derecho);
        System.out.println("Persona registrada");
        System.out.println(nueva);
        return nueva;
    }
    
    public boolean derecho( char genero, int anios, int edad){
        boolean derecho = false;
        switch(genero){
            case 'H':
                if( edad > 65 && anios >= 25 ){
                    derecho = true;
                    hombres++;
                }
            break;
            case 'M':
                if( edad > 60 && anios >= 25 ){
                    derecho = true;
                    mujeres++;
                }
            break;
        }
        return derecho;
    }
    
    public boolean generoCorrecto( char genero ){
        boolean correcto = false;
        if( genero == 'H' || genero == 'M' ){
            correcto = true;
        }else{
            System.out.println("El genero no es correcto, intente de nuevo, recuerde que debe introducir en MAYUSCULA");
        }
        return correcto;
    }
    
    public void verPersonas(){
        if(personas.size() != 0){
            for (int i = 0; i < personas.size(); i++) {
                System.out.println(personas.get(i));
            }
        }else{
            System.out.println("No hay personas registradas");
        }
    }
    
    public void numeroPersonasGenero(){
        if(personas.size() != 0){
            System.out.println("Hombres beneficiados: " + hombres);
            System.out.println("Mujeres beneficiadas: " + mujeres);
        }else{
            System.out.println("No hay personas registradas");
        }
    }
}
