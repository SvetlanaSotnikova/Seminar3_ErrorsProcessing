package Task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером
 * 3х3.
 * При подаче массива другого размера необходимо бросить исключение
 * MyArraySizeException.
 * 
 * 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int
 * и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
 * исключение MyArrayDataException
 * с детализацией, в какой именно ячейке лежат неверные данные.
 * 
 * 2. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task5 {
    static String[][] arr = new String[][] {
            { "1a", "1.5", "1.5" },
            { "1", "1.5", "1.5" },
            { "1", "1d5", "1.df" }
    };

    public static void main(String[] args) {
        System.out.println(sum2d(arr));
    }

    public static double sum2d(String[][] arr) {
        double result = 0;
        List<Point2d> hash = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr.length) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[0].length; j++) {
                if (checkIsNotNumber(arr[i][j])) {
                    // throw new MyArrayDataException(i, j);
                    hash.add(new Point2d(i, j));

                } else
                    result += Double.parseDouble(arr[i][j]);
            }
        }
        if (!hash.isEmpty()) {
            throw new MyArrayDataException(hash);
        }
        return result;
    }

    static boolean checkIsNotNumber(String data) {
        try {
            Double.parseDouble(data);
            return false;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}