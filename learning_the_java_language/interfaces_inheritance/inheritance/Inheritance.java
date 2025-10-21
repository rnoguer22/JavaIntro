package learning_the_java_language.interfaces_inheritance.inheritance;



// Si hay un metodo abstracto en esta clase, debemos incluir abstract al definir la clase tambien, aunque haya metodos normales
// NO SE PUEDE INSTANCIAR UNA CLASE ABSTRACTA
// Se usan para forzar una estructura comun en todas las subclases, permitiendo polimorfismo (muchas clases con la misma estructura, pero con comportamientos diferentes)
abstract class Animal {
    // Con abstract declaramos un metodo, pero no lo que hace
    // abstract obliga a implementar este metodo en las clases hijas

    public boolean mammal;

    public Animal(boolean mammal) {
        this.mammal = mammal;
    }

    abstract void makeSound();

    public void sleep() {
        System.out.print("\nZzz...");
    }

}



class Dog extends Animal {

    public Dog(boolean mammal) {
        super(mammal); // Le pasamos mammal al constructor de Animal para que le asigne el valor correspondiente
    }

    @Override // Lo usamos al implementar un metodo abstracto
    public void makeSound() {
        System.out.println("Woof! 🐶");
    }

    public void sleep() {
        super.sleep(); // Heredamos un metodo de la clase padre con super.
        System.out.print(" 🐶\n");
    }

}

public class Inheritance {
    public static void main(String[] args) {

        // No se puede instanciar una clase abstracta
        // Animal animal = new Animal();
        Dog myDog = new Dog(true);
        myDog.makeSound();
        myDog.sleep();
        System.out.println(myDog.mammal);

    }
}
