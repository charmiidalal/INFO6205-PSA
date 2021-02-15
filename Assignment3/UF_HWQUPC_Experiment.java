package edu.neu.coe.info6205.union_find;
import java.util.Random;
import java.util.Scanner;

public class UF_HWQUPC_Experiment {

    public static int count(int n) {
        UF_HWQUPC ufObj = new UF_HWQUPC(n,true);
        Random randObj = new Random();
        int randomPairs = 0;
        while(ufObj.components() != 1) {
            int randPair1 = randObj.nextInt(n);
            int randPair2 = randObj.nextInt(n);
            if(!ufObj.connected(randPair1,randPair2)) {
                ufObj.union(randPair1, randPair2);
            }
            randomPairs++;
        }
        return randomPairs;
    }

    public static void main(String[] args) {
        System.out.print("Input number of objects(N): ");
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int experimentAmt = 1000;
        int randomPairCnt = 0;
        for (int i = 0; i < experimentAmt; i++) {
            UF_HWQUPC_Experiment expObj = new UF_HWQUPC_Experiment();
            randomPairCnt += expObj.count(inputNum);
        }
        System.out.println("Number of Random Pairs Generated(M): " + randomPairCnt/experimentAmt);
    }
}