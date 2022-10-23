/* Реализовать алгоритм сортировки слиянием. Для вывода необходимо использовать логгер(Java.Util.Logging)
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task1 {
    public static void main(String[] args) throws IOException {
        int[] someArray = fillArray();
        Logger log = Logger.getLogger(Task1.class.getName());
        FileHandler fh = new FileHandler("src/log.xml");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        System.out.println(Arrays.toString(someArray));
        System.out.println(Arrays.toString(sortArray(someArray)));
        log.info(Arrays.toString(sortArray(someArray)));
    }

    static int[] fillArray() {
        Random random = new Random();
        int length = random.nextInt(5, 10);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }

    static int[] sortArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        int[] arrA = new int[arr.length / 2];
        System.arraycopy(arr, 0, arrA, 0, arr.length / 2);
        int[] arrB = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, arrB, 0, arr.length - arr.length / 2);
        arrA = sortArray(arrA);
        arrB = sortArray(arrB);
        return mergeArray(arrA, arrB);
    }

    static int[] mergeArray(int[] arrA, int[] arrB) {
        int[] arrC = new int[arrA.length + arrB.length];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < arrC.length; i++) {
            if (posA == arrA.length) {
                arrC[i] = arrB[posB];
                posB++;
            } else if (posB == arrB.length) {
                arrC[i] = arrA[posA];
                posA++;
            } else if (arrA[posA] < arrB[posB]) {
                arrC[i] = arrA[posA];
                posA++;
            } else {
                arrC[i] = arrB[posB];
                posB++;
            }
        }
        return arrC;
    }
}