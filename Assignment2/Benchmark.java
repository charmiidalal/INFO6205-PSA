package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.simple.InsertionSort;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Interface to define the behavior of a Benchmark.
 *
 * @param <T> the underlying type which is passed into (or supplied) to the run/runFromSupplier methods.
 */
public interface Benchmark<T> {
    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param t the value that will in turn be passed to function f.
     * @param m the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    default double run(T t, int m) {
        return runFromSupplier(() -> t, m);
    }

    /**
     * Run function f m times and return the average time in milliseconds.
     *
     * @param supplier a Supplier of a T
     * @param m        the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    double runFromSupplier(Supplier<T> supplier, int m);

    public static void main(String[] args) {
        int arr_element = 50;
        /* Declare lists to store time taken for each type of arrays */
        List<Double> randomSortedTime = new ArrayList<>();
        List<Double> orderedSortedTime = new ArrayList<>();
        List<Double> partiallyOrderedSortedTime = new ArrayList<>();
        List<Double> reverseOrderedSortedTime = new ArrayList<>();
        for (int i =0; i < 5; i++) {
            /* Double the array size for each n value */
            arr_element *= 2;
            /* Declare lists to store the different type of arrays */
            List<Integer> randomList = new ArrayList<>();
            List<Integer> orderedList = new ArrayList<>();
            List<Integer> partiallyOrderedList = new ArrayList<>();
            List<Integer> reverseOrderedList = new ArrayList<>();
            Random random = new Random();
            for (int j = 0; j < arr_element; j++) {
                /* Ordered Array */
                orderedList.add(j);
                /* Random Array */
                randomList.add(random.nextInt(arr_element));
                /* Partial Ordered Array */
                if (random.nextInt(50) < 30) {
                    partiallyOrderedList.add(arr_element);
                } else {
                    partiallyOrderedList.add((random.nextInt(arr_element)));
                }
                /* Reverse Orderd Array */
                reverseOrderedList.add(arr_element - j);
            }
            /* Count time taken by Insertion Sort function  */
            GenericSort insertionSort = new InsertionSort();
            /* Run for 10 times for  Random Ordered Array Sorting */
            Benchmark<Integer> benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(randomList);
                    });
            benchmark.run(0, 10);
            double res = 0;
            res = benchmark.run(0, 10);
            randomSortedTime.add(res);
            System.out.println("Random Array: For "+arr_element+" elements insertion sort takes "+res+" ms");
            /* Run for 10 times for Ordered Array Sorting */
            benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(orderedList);
                    });
            benchmark.run(0, 10);
            res = benchmark.run(0, 10);
            orderedSortedTime.add(res);
            System.out.println("Ordered Array: For "+arr_element+" elements insertion sort takes "+res+" ms");
            /* Run for 10 times for Partially Ordered Array Sorting */
            benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(partiallyOrderedList);
                    });
            benchmark.run(0, 10);
            res = benchmark.run(0, 10);
            partiallyOrderedSortedTime.add(res);
            System.out.println("Partially Ordered Array: For "+arr_element+" elements insertion sort takes "+res+" ms");
            /* Run for 10 times for Reverse Ordered Array Sorting */
            benchmark = new Benchmark_Timer<>("",
                    blank -> {
                        insertionSort.sort(reverseOrderedList);
                    });
            benchmark.run(0, 10);
            res = benchmark.run(0, 10);
            reverseOrderedSortedTime.add(res);
            System.out.println("Reverse Ordered Array: For "+arr_element+" elements insertion sort takes "+res+" ms");
            System.out.println("************************************************************************************");
        }
    }
}
