package learning_the_java_language.language_basics.control_flow_statements;



class IfElseDemo {
    int testScore = 76;
    char grade;

    void getGrade() {
        if (testScore >= 90) {
            grade = 'A';
        } else if (testScore >= 80) {
            grade = 'B';
        } else if (testScore >= 70) {
            grade = 'C';
        } else if (testScore >= 60) {
            grade = 'D';
        } else if (testScore >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        } 
    }
}



class SwitchDemo {
    int month = 9;
    String monthString;
    // Declaramos un array del tipo java.util.ArrayList. Esta clase si que tiene el metodo add que es como el append de Python
    java.util.ArrayList<String> futureMonths = new java.util.ArrayList<String>();

    void getMonthString() {
        switch (month) {
            case 1: monthString = "January";
                    break;
            case 2: monthString = "February";
                    break;
            case 3: monthString = "March";
                    break;
            case 4: monthString = "April";
                    break;
            case 5: monthString = "May";
                    break;
            case 6: monthString = "June";
                    break;
            case 7: monthString = "July";
                    break;
            case 8: monthString = "August";
                    break;
            case 9: monthString = "September";
                    break;
            case 10: monthString = "October";
                    break;
            case 11: monthString = "November";
                    break;
            case 12: monthString = "December";
                    break;
            default: monthString = "Invalid month";
                    break;
        }
    }

    void getFutureMonths() {
        switch (month) {
            // Añadimos con .add el mes al final de la lista, y continuamos, ya que no hay break al final de cada case
            case 1:  futureMonths.add("January");
            case 2:  futureMonths.add("February");
            case 3:  futureMonths.add("March");
            case 4:  futureMonths.add("April");
            case 5:  futureMonths.add("May");
            case 6:  futureMonths.add("June");
            case 7:  futureMonths.add("July");
            case 8:  futureMonths.add("August");
            case 9:  futureMonths.add("September");
            case 10: futureMonths.add("October");
            case 11: futureMonths.add("November");
            case 12: futureMonths.add("December");
                     break;                
            default: break;
        }

        if (futureMonths.isEmpty()) {
            System.out.println("Invalid month number");
        } else {
            for (String monthName : futureMonths) {
                System.out.println(monthName.toLowerCase()); // Para ver el metodo .toLowerCase()
            }
        }
    }
}



class WhileDemo {
    int counter = 0;

    void whileDemo() {
        while (counter <= 4) {
            System.out.println("While " + counter);
            counter++;
        }
    }

    void doWhileDemo() {
        do {
            System.out.println("Do While " + counter);
            counter++;
        } while (counter <= 8);
    }
}



class ForDemo {

    void forDemo() {
        for (int i=1; i<5; i++) {
            System.out.println("Count For: " + i);
        }
    }

    // Asi se hacen las funciones que devuelven cosas
    int[] enhancedForDemo(int[] numbersList) {
        for (int number : numbersList) {
            System.out.print(number);
        }
        return numbersList;
    }
}


public class ControlFlowStatements {
    public static void main(String[] args) {

        IfElseDemo demo = new IfElseDemo();
        demo.getGrade();
        System.out.println(demo.grade);

        SwitchDemo demoSwitch = new SwitchDemo();
        demoSwitch.getMonthString();
        System.out.println(demoSwitch.monthString);
        demoSwitch.getFutureMonths();

        WhileDemo demoWhile = new WhileDemo();
        demoWhile.whileDemo();
        demoWhile.doWhileDemo();

        ForDemo demoFor = new ForDemo();
        demoFor.forDemo();
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] numbersList = demoFor.enhancedForDemo(numbers);
        System.out.println("\n" + numbersList);

    }
}
