package Task2;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner sc = new Scanner(System.in);

        logger.log("Запускаем программу");

        int[] pars = askForLengthAndMaxValue(sc);
        printResultArray(
                filterArray(
                        sc,
                        createArray(pars[0], pars[1])
                )
        );
        logger.log("Завершаем программу");
    }

    public static int[] askForLengthAndMaxValue(Scanner sc) {
        Integer arrLength = -1,
                maxArrValue;
        Logger.getInstance()
                .log("Просим пользователя ввести входные данные для списка");
        while (true) {
            if (arrLength < 0) {
                try {
                    System.out.println("Введите размер списка:");
                    arrLength = sc.nextInt();
                    if (arrLength < 1) {
                        throw new InvalidPropertiesFormatException("Must be more than 1");
                    }
                } catch (Exception e) {
                    System.out.println("Введите корректный размер");
                    continue;
                }
            }
            try {
                System.out.println("Введите верхнюю границу для значений:");
                maxArrValue = sc.nextInt();
                if (maxArrValue < 1) {
                    throw new InvalidPropertiesFormatException("Must be more than zero");
                }
                break;
            } catch (Exception e) {
                System.out.println("Введите корректное число");
            }
        }
        int[] pars = { arrLength, maxArrValue };
        return pars;
    }

    public static List<Integer> createArray( int arrLength, int maxArrValue) {
        Logger.getInstance()
                .log("Создаём и наполняем список");
        List<Integer> lst = new ArrayList<>();
        while (arrLength > 0) {
            lst.add((int) (Math.random() * maxArrValue));
            arrLength--;
        }
        printArray("Вот случайный список:", lst);
        return lst;
    }

    public static List<Integer> filterArray(Scanner sc, List<Integer> lst) {
        Logger.getInstance()
                .log("Просим пользователя ввести входные данные для фильтрации");
        int treshold = -1;
        while (true) {
            try {
                System.out.println("Введите порог для фильтра:");
                treshold = sc.nextInt();
                if (treshold <= 0) {
                    throw new InvalidPropertiesFormatException("Must be more than zero");
                }
                break;
            } catch (Exception e) {
                System.out.println("Введите корректный порог");
            }
        }
        return (new Filter(treshold)).filterOut(lst);
    }

    public static void printResultArray(List<Integer> lst) {
        Logger.getInstance()
                .log("Выводим результат на экран");
        printArray("Отфильтрованный список:", lst);
    }

    public static void printArray(String msgBefore, List<Integer> lst) {
        System.out.printf(
                "%s %s \n",
                msgBefore,
                lst.stream().map(x -> x.toString())
                        .collect(Collectors.joining(" "))
        );
    }
}
