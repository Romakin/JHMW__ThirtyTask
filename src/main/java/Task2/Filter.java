package Task2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        for (int f : source) {
            if (f < treshold) {
                result.add(f);
                logger.log(String.format("Элемент \"%d\" проходит",f));
            }
            logger.log(String.format("Элемент \"%d\" не проходит",f));
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", result.size(), source.size()));
        return result;
    }
}
