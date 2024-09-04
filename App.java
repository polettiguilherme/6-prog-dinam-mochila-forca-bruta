import java.util.HashMap;
import java.util.Map;

public class App {
    public static int[] f;

    public static Map<Integer, Integer> resultRec = new HashMap<>();
    public static Map<Integer, Integer> resultIter = new HashMap<>();
    public static Map<Integer, Integer> resultMemo = new HashMap<>();


    public static int recursiveCalls;
    public static int iterativeLoops;
    public static int memoizationCalls;
    
    public static Map<Integer, Integer> recursiveCallsMap = new HashMap<>();
    public static Map<Integer, Integer> iterativeLoopsMap = new HashMap<>();
    public static Map<Integer, Integer> memoizationCallsMap = new HashMap<>();
    public static int[] testValues = {4, 8, 16, 32};

    public static void main(String[] args) {
        
        for (int n : testValues) {
            recursiveCalls = 0;
            resultRec.put(n, fiboRec(n));

            f = new int[n + 1];
            iterativeLoops = 0;
            resultIter.put(n, fibo(n));

            int[] memoArray = new int[n + 1];
            memoizationCalls = 0;
            resultMemo.put(n, memoizedFibo(memoArray, n));

            recursiveCallsMap.put(n, recursiveCalls);
            iterativeLoopsMap.put(n, iterativeLoops);
            memoizationCallsMap.put(n, memoizationCalls);
        }

        tabelaFibonacci();
    }

    public static void tabelaFibonacci(){
        
        String values = "     ";

        for (int n : testValues) {
            values += String.valueOf(n) + " (Reps) ";
        }

        String fiboRecursive = "Rec: ";

        for (int n : testValues) {
            fiboRecursive += String.valueOf(resultRec.get(n)) + " ( " + String.valueOf(recursiveCallsMap.get(n)) + " ) " ;
        }

        String ite = "Ite: ";

        for (int n : testValues) {
            ite += String.valueOf(resultIter.get(n)) + " ( " + String.valueOf(iterativeLoopsMap.get(n)) + " ) " ;
        }

        String mem = "Mem: ";

        for (int n : testValues) {
            mem += String.valueOf(resultMemo.get(n)) + " ( " + String.valueOf(memoizationCallsMap.get(n)) + " ) " ;
        }

        System.out.println(values);
        System.out.println(fiboRecursive);
        System.out.println(ite);
        System.out.println(mem);
    }

    public static int fiboRec(int n) {
        recursiveCalls++;

        if (n <= 1) {
            return n;
        }
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

    public static int fibo(int n) {
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            iterativeLoops++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int memoizedFibo(int[] fi, int n) {
        for (int i = 0; i < n + 1; i++) {
            fi[i] = -1;
        }
        return lookupFibo(fi, n);
    }

    public static int lookupFibo(int[] fi, int n) {
        memoizationCalls++;

        if (fi[n] >= 0) {
            return fi[n];
        }
        if (n <= 1) {
            fi[n] = n;
        } else {
            fi[n] = lookupFibo(fi, n - 1) + lookupFibo(fi, n - 2);
        }
        return fi[n];
    }
}
// FIBO-REC (n)
//       se n ≤ 1
//       então devolva n
//       senão a ← FIBO-REC (n − 1)
//             b ← FIBO-REC (n − 2)
//             devolva a + b
    
//    ```java
//    FIBO (n)
//         f [0] ← 0 
// 	f [1] ← 1
// 	para i ← 2 até n faça
//            f[i] ← f[i-1]+f[i-2]
//   	devolva f [n]
//    ```
    
//    ```java
//    MEMOIZED-FIBO (f, n)
// 	para i ← 0 até n faça
// 	     f [i] ← −1
// 	devolva LOOKUP-FIBO (f, n)

//    LOOKUP-FIBO (f, n)
// 	se f [n] ≥ 0
//         então devolva f [n]
// 	se n ≤ 1
// 	então f [n] ← n
// 	senão f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
// 	devolva f [n]
//    ``` 