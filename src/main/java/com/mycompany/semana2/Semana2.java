package com.mycompany.semana2;

/**
 * Tarea POO Semana 2: Uso de Técnicas de Programación:
 * - Abstracción 
 * - Encapsulación
 * - Herencia 
 * - Polimorfismo 
 * Alumno: Stalin Mendieta
 */

public class Semana2 {
    public static void main(String[] args) {
        // === ABSTRACCION ===
        System.out.println("== ABSTRACCION ==");
        // Creamos un arreglo de figuras, cada una con su propia implementación de obtenerNumeroDeLados()
        Figura[] figuras = {
            new Rectangulo(),
            new Triangulo(),
            new Cuadrado()
        };

        // Recorremos el arreglo y mostramos el número de lados de cada figura
        for (Figura f : figuras) {
            System.out.println(f.getClass().getSimpleName() + " - Numero de lados: " + f.obtenerNumeroDeLados());
        }

        // === ENCAPSULACION ===
        System.out.println("\n== ENCAPSULACION ==");
        // Creamos un objeto Persona con datos privados accesibles solo mediante métodos públicos
        Persona persona = new Persona("Stalin", 25);
        persona.mostrarInformacion();  // Mostramos información inicial
        persona.setEdad(30);            // Modificamos la edad usando método set con validación
        System.out.println("Edad actualizada: " + persona.getEdad());

        // === HERENCIA ===
        System.out.println("\n== HERENCIA ==");
        // Creamos un objeto Estudiante que hereda atributos y métodos de PersonaBase
        Estudiante estudiante = new Estudiante("Gabriel", 27, "UEA");
        estudiante.saludar();  // Método heredado de PersonaBase
        estudiante.estudiar(); // Método propio de Estudiante

        // === POLIMORFISMO ===
        System.out.println("\n== POLIMORFISMO ==");
        // Creamos objetos de tipo Vehiculo, pero de clases derivadas Coche, Bicicleta y Avion
        Vehiculo[] vehiculos = { new Coche(), new Bicicleta(), new Avion() };
        // Llamamos a los métodos mover() y detener() que tienen comportamiento diferente según la clase real del objeto
        for (Vehiculo v : vehiculos) {
            v.mover();
            v.detener();
        }
    }
}

// -------- ABSTRACCIÓN --------

// Clase abstracta que define un método abstracto que las subclases deben implementar
abstract class Figura {
    public abstract int obtenerNumeroDeLados();
}

// Clases concretas que implementan el método abstracto de acuerdo a su forma geométrica
class Rectangulo extends Figura {
    @Override
    public int obtenerNumeroDeLados() {
        return 4;
    }
}

class Triangulo extends Figura {
    @Override
    public int obtenerNumeroDeLados() {
        return 3;
    }
}

class Cuadrado extends Figura {
    @Override
    public int obtenerNumeroDeLados() {
        return 4;
    }
}

// -------- ENCAPSULACIÓN --------

// Clase con atributos privados y métodos públicos para acceder y modificar esos atributos
class Persona {
    private String nombre;
    private int edad;

    // Constructor para inicializar los atributos
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Métodos get y set para controlar acceso a los atributos
    public String getNombre() {  // Getter para nombre
        return nombre;
    }

    public void setNombre(String nombre) { // Setter para nombre
        this.nombre = nombre;
    }

    public int getEdad() { // Getter para edad
        return edad;
    }

    // Validación sencilla para no permitir edades negativas o cero
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        }
    }

    // Método para mostrar la información de la persona
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}

// -------- HERENCIA --------

// Clase base con atributos y métodos comunes
class PersonaBase {
    private String nombre;
    private int edad;

    public PersonaBase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters para encapsulación
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        }
    }

    // Método común para saludar
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}

// Clase derivada que hereda de PersonaBase y añade atributos y métodos propios
class Estudiante extends PersonaBase {
    private String universidad;

    public Estudiante(String nombre, int edad, String universidad) {
        super(nombre, edad);
        this.universidad = universidad;
    }

    // Getter y setter para universidad
    public String getUniversidad() {
        return universidad;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    // Método específico para mostrar dónde estudia
    public void estudiar() {
        System.out.println(getNombre() + " estudia en " + universidad);
    }
}

// -------- POLIMORFISMO --------

// Clase base con métodos que serán sobrescritos en las subclases
class Vehiculo {
    public void mover() {
        System.out.println("El vehículo se está moviendo.");
    }

    public void detener() {
        System.out.println("El vehiculo se ha detenido.");
    }
}

// Subclase que sobrescribe el método mover() con comportamiento específico
class Coche extends Vehiculo {
    @Override
    public void mover() {
        System.out.println("El coche esta conduciendo por la carretera.");
    }

    @Override
    public void detener() {
        System.out.println("El coche freno en un semaforo.");
    }
}

// Subclase Bicicleta con comportamiento diferente para mover y detener
class Bicicleta extends Vehiculo {
    @Override
    public void mover() {
        System.out.println("La bicicleta esta siendo pedaleada en el parque.");
    }

    @Override
    public void detener() {
        System.out.println("La bicicleta se detuvo al llegar al parque.");
    }
}

// Subclase Avion con sus propias acciones para mover y detener
class Avion extends Vehiculo {
    @Override
    public void mover() {
        System.out.println("El avion esta despegando.");
    }

    @Override
    public void detener() {
        System.out.println("El avion aterrizo y esta detenido en la pista.");
    }
}