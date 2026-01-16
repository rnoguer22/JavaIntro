package executors;

import java.util.concurrent.*;



// Clase para aprender sobre el funcionamiento de los executors en Java (executors de un solo hilo de momento)
public class SimpleExecutor {
    public static void main(String[] args) throws Exception {
        System.out.println("\n----- Iniciando prueba con executors -----");
        simpleExecutor();
        Thread.sleep(1000); // Esperamos 1s para que no se mezclen los prints en la consola
        System.out.println("\n----- Inicio prueba con pool de executors -----");
        executorSubmit();
        System.out.println("\n");
    }

    // Metodo para crear un thread simple con newSingleThreadExecutor()
    private static void simpleExecutor() {
        // 1) Creamos el executor con un solo hilo
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        // 2) Definimos la tarea que el executor debera realizar con un Runnable
        Runnable task = () -> {
            String nameThread = Thread.currentThread().getName();
            System.out.println("Ejecutando desde el hilo: " + nameThread);
        };
        // 3) Ejecutamos la tarea en el executor
        System.out.println("Ejecutando tarea...");
        for ( int i=0; i<=3; i++ ) {
            singleExecutor.execute(task);
        }
        // 4) Importante cerrar el executor al finalizar la tarea
        singleExecutor.shutdown();
    }

    // Metodo para usar submit en lugar de execute
    // Usamos submit cuando queremos que el executor devuelva algun dato
    private static void executorSubmit() throws Exception {
        // Indicamos que vamos a tener una pool de dos threads
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // En este caso usamos Callable para poder retornar un valor, en lugar de Runnable
        Callable<Integer> returnTask = () -> {
          Thread.sleep(2000);
          System.out.println("Tarea realizada por: " + Thread.currentThread().getName());
          return 7;
        };
        System.out.println("Calculando resultado...");
        Future<Integer> future = pool.submit(returnTask);
        // Mostramos un mensaje mientras el hilo esta calculando sus cosas
        System.out.println("Vemos que el hilo principal puede hacer otras cosas de mientras...");
        // Obtenemos el resultado con get(), de manera que esperamos a que el hilo termine
        int result = future.get();
        System.out.println("Resultado recibido: " + result);
        pool.shutdown();
    }
}
