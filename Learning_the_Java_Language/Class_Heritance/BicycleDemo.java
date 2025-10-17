package Learning_the_Java_Language.Class_Heritance;



class Bicycle {

    // Object state's
    int cadence = 0;
    int speed = 0;
    int gear = 1;

    // Method changeCadence
    void changeCadence(int newCadence) {
        cadence = newCadence;
    }

    // Method changeGear
    void changeGear(int newGear) {
        gear = newGear;
    }

    // Method speedUp
    void speedUp(int incrementSpeed) {
        speed += incrementSpeed;
    }

    // Method applyBrakes
    void applyBrakes(int decrementSpeed) {
        speed -= decrementSpeed;
    }

    // Method printStates
    void printStates() {
        System.out.println(
            "cadence: " + cadence +
            "\nspeed: " + speed + 
            "\ngear: " + gear
        );
    }
}



class MountainBike extends Bicycle {
    // New fields and methods containing a MountainBike would go here

    boolean fork = true;

    void changeFork(boolean newFork) {
        fork = newFork;
    }

    void printStates() {
        System.out.println(
            "cadence: " + cadence +
            "\nspeed: " + speed + 
            "\ngear: " + gear +
            "\nfork: " + fork
        );
    }
}



// The name of the class contain the main void must be the only public class, and its name must match with the name of the file
public class BicycleDemo {
    public static void main(String[] args) {
        
        // Create two different Bicycle objects
        Bicycle bike = new Bicycle();
        MountainBike mtbBike = new MountainBike();

        // Invoke methods to change our Bicycle states
        bike.changeCadence(50);
        bike.speedUp(10);
        bike.changeGear(2);
        System.out.println("\nStandard Bike");
        bike.printStates();

        // NOw for the MountainBike, which is the child class of Bicycle
        mtbBike.changeCadence(50);
        mtbBike.speedUp(10);
        mtbBike.changeGear(2);
        mtbBike.changeCadence(40);
        mtbBike.speedUp(10);
        mtbBike.changeGear(3);
        mtbBike.changeFork(false);
        System.out.println("\nMountain Bike");
        mtbBike.printStates();
    }
}