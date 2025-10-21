package learning_the_java_language.annotations;



public class Annotations {
    // Las annotations empiezan con un @, e indica al compilador que lo que sigue es una annotation
    /* @Override
    void mySuperMethod() {

    }
    */

    // Tambien pueden contener elementos, pero hemos de definir la annotation anteriormente:
    @interface Author {
        String name();
        String date();
    }

    @Author(
        name = "Benjamin Franklin",
        date = "27/2/2003"
    )
    class MyAuthorClass {
        // ...
    }

    // Tambien hay annotations de la siguiente manera
    /*
    new @Interned MyObject();
    myString = (@NonNull String) str;
    class UnmodifiableList<T> implements
        @Readonly List<@Readonly T> { ... }
    void monitorTemperature() throws
        @Critical TemperatureException { ... }
    */

    // Annotation Types Used by the Java Language --> definidas en java.lang
    @Deprecated // Signals that the element is deprecated and should no longer be used. It generates a warning
    static void deprecatedMethod(){
        System.out.println("Oh no, I am deprecated!");
    }

    /*
    @Override // informs the compiler that the element is meant to override an element declared in a superclass
    // (lo veremos mas adelante, en interfaces_inheritance)
    int overriddenMethod() {}
    */

    // @SuppressWarnings("deprecation") // Esto nos suprime los warnings, en concreto de cosas deprecated en este caso

    // Otras annotations que se aplican a otras annotations
    /*
    @Retention
    @Documented
    @Target
    @Inherited
    @Repeatable
    */

    public static void main(String[] args) {

        deprecatedMethod();

    }
}
