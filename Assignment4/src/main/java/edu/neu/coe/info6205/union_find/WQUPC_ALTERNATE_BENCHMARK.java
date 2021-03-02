package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.util.Random;

/**
 * @Author: Charmi Dalal
 * @Version:
 * @Description:
 **/

public class WQUPC_ALTERNATE_BENCHMARK {
    Random random = new Random();

    public void WeightedUnionFindRun(int sites) {
        WQUPC weightedUnionFind = new WQUPC(sites);


        while (weightedUnionFind.count() != 1) {
            int site1 = random.nextInt(sites);
            int site2 = random.nextInt(sites);

            if (!weightedUnionFind.connected(site1, site2))
                weightedUnionFind.union(site1, site2);
        }
    }

    public void WeightedUnionFindAlterRun(int sites) {
        WQUPC_ALTERNATE weightedUnionFindAlter = new WQUPC_ALTERNATE(sites);

        while (weightedUnionFindAlter.count() != 1) {
            int site1 = random.nextInt(sites);
            int site2 = random.nextInt(sites);

            if (!weightedUnionFindAlter.connected(site1, site2))
                weightedUnionFindAlter.union(site1, site2);
        }
    }

    public static void main(String[] args) {
        WQUPC_ALTERNATE_BENCHMARK wightObj = new WQUPC_ALTERNATE_BENCHMARK();
        Benchmark<Integer> weightedObj = new Benchmark_Timer<>("Weighted Union Find with Size ", black -> {
            wightObj.WeightedUnionFindRun(15000);
        });
        System.out.println("For Weighted Quick Union, storing size takes "+String.format("%.2f",weightedObj.run(0,1000))+"ms");

        Benchmark<Integer> weightedAlterObj = new Benchmark_Timer<>("Weighted Union Find with Depth ", black -> {
            wightObj.WeightedUnionFindAlterRun(15000);
        });
        System.out.println("For Weighted Quick Union, storing depth takes "+String.format("%.2f",weightedAlterObj.run(0,1000))+"ms");
    }
}