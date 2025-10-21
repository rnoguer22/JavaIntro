package learning_the_java_language.classes_and_objects;

import learning_the_java_language.classes_and_objects.Calculator.IntegerMath;





class Bicycle {

    // Una clase dentro de una clase se conoce como Nested Classes, y funciona exactamente igual
    // Esto se hace por mantener las clases que unicamente nos sirven para Bicycle, encapsulacion, legibilidad y mantenimiento de codigo, etc.
    class NestedWheels {
        private int numberWheels = 2;
        public int getNumberWheels() {
            return numberWheels;
        }
    }

    private int cadence;
    private int gear;
    private int speed;
    private int id;
    private static int numberOfBicycles = 0;

    // Definimos el constructor de la clase
    // Importante saber que podemos tener varios constructores, dependiendo del tipo de valor que se pase como argumento 
    // al hacer una instancia, por ejemplo
    public Bicycle(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
        /* Incrementamos primero y luego asignamos el valor de numberOfBicycles a id
           El orden del ++ puede variar, ya que si lo ponemos al final numberOfBicycles++, primero se asigna la 
           variable y luego se incrementa, resultando en 0 la primera y 1 la segunda */
        this.id = ++numberOfBicycles;
    }

    // Lo que haya dentro de un bloque static se ejecutara cuando se cargue la clase en memoria, antes de inicializar cualquier instancia
    static {
        System.out.println("Cargando configuracion inicial de " + Bicycle.class.getSimpleName());
        // Esto se suele usar para configuraciones de la aplicacion (archivos, conexiones, etc.)
        int maxNumberBicycles = 10;
    }
    // Se puede poner directamente sin static, y se cargara el bloque de codigo cada vez que instanciemos la clase, no unicamente una sola vez como con static



    public int getId() {
        return id;
    }

    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int newValue) {
        cadence = newValue;
    }
    
    public int getGear() {
        return gear;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public int getSpeed() {
        return speed;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }

}



class MountainBike extends Bicycle {

    public int seatHeight;
    public String fork;

    public MountainBike(int cadence, int gear, int speed, int seatHeight) {
        super(cadence, gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setHeight(int newSeatHeight) {
        seatHeight = newSeatHeight;
    }
}



// Clase calculadora para explicar las funciones lambda
class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
}



// Enum se usa para definir constantes, como los dias de la semana, meses del año, norte este sur oeste, etc.
enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}





public class Classes {
    // Cuando no sepamos el numero de Strings de la lista, lo podemos poner tambien con .... Esto se conoce como varargs
    public static void main(String... args) {

        Bicycle bike = new Bicycle(1, 2, 3);
        Bicycle.NestedWheels wheels = bike.new NestedWheels(); // De esta manera instanciamos una nested class
        // System.out.println(bike.speed); <-- Error
        System.out.println("Id of the first bike: " + bike.getId());
        System.out.println("Wheels number: " + wheels.getNumberWheels());

        MountainBike mtbike = new MountainBike(2, 1, 0, -3);
        // System.out.println(mtbike.speed); <-- Error
        System.out.println("Id of the second bike: " + mtbike.getId());

        // Tambien podemos acceder a un estado de una clase de esta manera
        // Al crear este objeto MountainBike, el programa ya no tiene ninguna referencia ya que no le hemos asignado una variable, por lo que no podremos volver a acceder a el
        int gear = new MountainBike(9, 8, 120, 0).getGear();
        System.out.println(gear);

        // Hay un proceso llamado garbagecollector, el cual hace java internamente cuando no se usa una determinada clase, 
        // y la destruye para ahorrar recursos. No hay codigo, lo implementa java internamente.

        // Ahora vamos a explicar las funciones lambda
        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b; // Funcion lamda 1
        IntegerMath substraction = (a, b) -> a - b; // Funcion lambda 2
        System.out.println("2 + 3 = " + myApp.operateBinary(2, 3, addition));
        System.out.println("2 - 3 = " + myApp.operateBinary(2, 3, substraction));

        // Ejemplo de uso de los enum
        System.out.println("Enum type is used for defining constants, like " + Days.FRIDAY);

    }
}