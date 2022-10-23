/* Пусть дан произвольный список целых чисел, удалить из него четные числа. Для вывода необходимо использовать
логгер(Java.Util.Logging)
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) throws IOException {
        List<Integer> someList = fillList();
        System.out.println(someList);
        Logger log = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("src/log.xml");
        log.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        System.out.println(getEvenNums(someList));
        log.info(getEvenNums(someList).toString());
    }

    static List<Integer> fillList() {
        List<Integer> lst = new ArrayList<>();
        Random rnd = new Random();
        int lstSize = rnd.nextInt(5, 20);
        for (int i = 0; i < lstSize; i++) {
            lst.add(rnd.nextInt(0, 100));
        }
        return lst;
    }

    static List<Integer> getEvenNums(List<Integer> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i)%2 == 0) {
                lst.remove(i);
                i--;
            }
        }
        return lst;
    }
}
