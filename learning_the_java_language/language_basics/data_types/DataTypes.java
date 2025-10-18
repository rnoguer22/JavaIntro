package learning_the_java_language.language_basics.data_types;



class ArrayDemo {

}



public class DataTypes {
    public static void main(String[] args) {

        // Estos dos primeros no se usan mucho, pueden servir para ahorrar memoria en un array grande pero poco mas
        byte myByte = 127; // Rango de -128 a 127 (byte xd)
        short myShort = 32767; // Igual que el byte pero con 16 bits (rango -32768 a 32767)


        int myInt = 1; // int clásico, 32 bits
        long myLong = 2; // Como el int pero para 64 bits
        float myFloat = 3.57f; // float tiene una f al final (because yes) y tiene menos precision que el double
        double myDouble = 3.57;
        boolean myBool = false;
        char myChar = 'a';

        // No se considera un data type, pero bueno yo lo pongo que esta bien
        String myString = "salchichonsito"; // Hay que ponerlo entre "" no vale ''
        // Y el valor de un String en Java es inmutable

    }
}
