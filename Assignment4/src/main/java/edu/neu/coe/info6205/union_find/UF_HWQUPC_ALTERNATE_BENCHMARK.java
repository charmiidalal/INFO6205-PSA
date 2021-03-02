package edu.neu.coe.info6205.union_find;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import java.util.Random;

/**
 * @Author: Charmi Dalal
 * @Version:
 * @Description:
 **/

public class UF_HWQUPC_ALTERNATE_BENCHMARK {
    Random random = new Random();

    public void unionFindBenchmark(int sites) {
        UF_HWQUPC ufObj = new UF_HWQUPC(sites);

        while (ufObj.components() != 1) {
            int site1 = random.nextInt(sites);
            int site2 = random.nextInt(sites);

            if (!ufObj.connected(site1, site2))
                ufObj.union(site1, site2);
        }
    }

    public void unionFindAlternateBenchmark(int sites) {
        UF_HWQUPC_ALTERNATE ufAlternateObj = new UF_HWQUPC_ALTERNATE(sites);

        while (ufAlternateObj.components() != 1) {
            int site1 = random.nextInt(sites);
            int site2 = random.nextInt(sites);

            if (!ufAlternateObj.connected(site1, site2))
                ufAlternateObj.union(site1, site2);
        }

    }

    public static void main(String[] args) {
        UF_HWQUPC_ALTERNATE_BENCHMARK wightObj = new UF_HWQUPC_ALTERNATE_BENCHMARK();
        Benchmark<Integer> ufPCBenchmark = new Benchmark_Timer<>("Weighted Union Find with Path Compression", black -> {
            wightObj.unionFindBenchmark(15000);
        });
        System.out.println("For Weighted Quick union with path compression takes "+String.format("%.2f",ufPCBenchmark.run(0,1000))+"ms");
        Benchmark<Integer> wightAlterObj = new Benchmark_Timer<>("Weighted Union Find Alternate (With 2 loops)", black -> {
            wightObj.unionFindAlternateBenchmark(15000);
        });
        System.out.println("For Weighted Quick union with path compression and two loops takes "+String.format("%.2f",wightAlterObj.run(0,1000))+"ms");

    }
}