package learning_the_java_language.language_basics.variables;


class Counter {
    // static in a class state means that it is shared with all the instances of the class
    static int counter = 0;
    // Esto es una variable local de la clase
    int ownCounter = 0;

    // Here we are incremeanting the counter static state everytime the class creates a new instance
    Counter() {
        counter++;
    }
}



public class Variables {
    public static void main(String[] args) {

        // final means that the variable will never be changed, it is a constant
        final int MY_NUMBER = 4;
        // number = 5; <-- this results in an error
        System.out.println(MY_NUMBER);

        // Ejemplo para ver como funciona static en los estados de una clase
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        System.out.println(counter3.counter);

    }
}
