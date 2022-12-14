package chattwoway;

import java.util.concurrent.Callable;

/**
 * Factorial
 * callables will return something unlike Runnable. otherwise they're similar
 */
public class Factorial implements Callable<Integer>{
    private Integer factorial = 0;

    public Factorial(Integer factorial){
        this.factorial = factorial;
    }

    @Override
    public Integer call(){
        Integer total = 1;
        for (Integer i = 2; i <= factorial; i++)
            total *= i;
        System.out.println(">>>>");
        return total;
    }
    
}