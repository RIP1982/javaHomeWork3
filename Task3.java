/* Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. Для вывода
необходимо использовать логгер(Java.Util.Logging)
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task3 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> someList = fillList();
        System.out.println(someList);
        Logger log = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("src/log.xml");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        System.out.println("minNum = " + getMinNums(someList) + "; " + "maxNum = " + getMaxNums(someList) + "; " +
                "averegeNum = " + getAveregeNums(someList));
        log.info("minNum = " + getMinNums(someList) + "; " + "maxNum = " + getMaxNums(someList) + "; " +
                "averegeNum = " + getAveregeNums(someList));
    }

    static ArrayList<Integer> fillList() {
        ArrayList<Integer> lst = new ArrayList<>();
        Random rnd = new Random();
        int lstSize = rnd.nextInt(5, 20);
        for (int i = 0; i < lstSize; i++) {
            lst.add(rnd.nextInt(0, 100));
        }
        return lst;
    }
    static int getMinNums(ArrayList<Integer> lst) {
        lst.sort(Comparator.naturalOrder());
        int minNum = lst.get(0);
        return minNum;
    }

    static int getMaxNums(ArrayList<Integer> lst) {
        lst.sort(Comparator.naturalOrder());
        int maxNum = lst.get(lst.size()-1);
        return maxNum;
    }

    static int getAveregeNums(ArrayList<Integer> lst) {
        lst.sort(Comparator.naturalOrder());
        int minNum = lst.get(0);
        int maxNum = lst.get(lst.size()-1);
        int averegeNum = (maxNum + minNum)/2;
        return averegeNum;
    }

}
