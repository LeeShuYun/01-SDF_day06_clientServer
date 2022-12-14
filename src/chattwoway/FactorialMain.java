package chattwoway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//inheriting/extends can only be done once, so it's a good idea to keep that for something that doesn't need a second one
//so implement an interface is more favored over subclassing/inheriting
public class FactorialMain {
    public static void main(String[] args) throws Exception{
        ExecutorService thrPool = Executors.newFixedThreadPool(2);

        //Factorial uses a callable, which returns something
        Factorial factorial = new Factorial(10);

        //Future will come back later when it's done
        Future<Integer> future = thrPool.submit(factorial);

        //wait till it's done
        while(!future.isDone()){
            System.out.println("Waiting...");
        }

        System.out.printf("The answer of 100! is %d.", future.get());
    }
    
}
