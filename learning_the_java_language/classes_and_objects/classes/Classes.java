package learning_the_java_language.classes_and_objects.classes;



class Bicycle {

    private int cadence;
    private int gear;
    private int speed;

    // Definimos el constructor de la clase
    public Bicycle(int startCadence, int startGear, int startSpeed) {
        cadence = startCadence;
        gear = startGear;
        speed = startSpeed;
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

    public MountainBike(int startCadence, int startGear, int startSpeed, int startSeatHeight) {
        super(startCadence, startGear, startSpeed);
        seatHeight = startSeatHeight;
    }

    public void setHeight(int newSeatHeight) {
        seatHeight = newSeatHeight;
    }
}



public class Classes {
    // Cuando no sepamos el numero de Strings de la lista, lo podemos poner tambien con .... Esto se conoce como varargs
    public static void main(String... args) {

        Bicycle bike = new Bicycle(1, 2, 3);
        // System.out.println(bike.speed);
        System.out.println(bike.getSpeed());

        MountainBike mtbike = new MountainBike(2, 1, 0, -3);
        // System.out.println(mtbike.speed); <-- Error
        System.out.println(mtbike.getSpeed());
    }
}
