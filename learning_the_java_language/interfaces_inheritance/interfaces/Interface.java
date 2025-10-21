package learning_the_java_language.interfaces_inheritance.interfaces;



interface Relatable {
    public int isLargerThan(Relatable other);
}

// Imaginemos que queremos añadir un nuevo metodo a nuestra interface, los objetos que la implementen se veran desactualizados
// ya que no tendran este metodo, causando un error. Para solucionar esto, evolucionamos la interface con extends, 
// añadiendo asi un nuevo metodo, por lo que el usuario unicamente tendria que actualizar la interfaz en el codigo
interface RelatablePlus extends Relatable {

    // En metodos default no hace falta poner public
    // Con default podemos escribir el cuerpo de un metodo, para usarlo directamente
    default int getPointX(Point p) {
        return p.x;
    }
    default int getPointY(Point p) {
        return p.y;
    }

    public int calculateDiffArea(RelatablePlus other);
}



class Point {
    public int x;
    public int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Con final decimos que este metodo no se puede modificar por ningun hijo
    public final void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}



class RectanglePlus implements RelatablePlus {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // Tenemos cuatro constructores en esta clase
    public RectanglePlus() {
        origin = new Point(0, 0);
    }
    public RectanglePlus(Point p) {
        origin = p;
    }
    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public RectanglePlus(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    public int getArea() {
        return width * height;
    }
    
    // Este metodo requiere un objeto que cumpla con la estructura de Relatable (other)
    public int isLargerThan(Relatable other) {
        // Hacemos un cast explicito para que se trate a other como un objeto del tipo RectanglePlus
        RectanglePlus otherRect = (RectanglePlus) other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;               
    }

    public int calculateDiffArea(RelatablePlus other) {
        RectanglePlus otherRect = (RectanglePlus) other;
        return Math.abs(this.getArea() - otherRect.getArea());
    }
}



public class Interface {
    public static void main(String[] args) {

        // Instanciamos un rectangulo
        Point pointRect = new Point(1, 2);
        RectanglePlus myRect = new RectanglePlus(pointRect, 12, 6);
        System.out.println("Coordinates from the first rectangle origin: " + myRect.getPointX(pointRect) + "," + myRect.getPointY(pointRect));

        // Instanciamos el segundo rectangulo
        pointRect.move(4, 6);
        RectanglePlus myRect2 = new RectanglePlus(pointRect, 15, 5);
        System.out.println("Coordenates from the second rectangle origin: " + myRect2.getPointX(pointRect) + "," + myRect2.getPointY(pointRect));

        //Llamamos al metodo isLargerThan para compararlos
        int compareRects = myRect.isLargerThan(myRect2);
        System.out.println(compareRects); // Sale -1 ya que el area del primer rectangulo es menor
        int newCompareRects = myRect2.isLargerThan(myRect);
        System.out.println(newCompareRects); // Lo mismo que antes pero al reves

        System.out.println(myRect.calculateDiffArea(myRect2));

    }
}