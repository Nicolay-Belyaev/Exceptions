package homework02;


import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Task1.input();
        Task2.Doo(new int[]{1, 2, 3, 4, 6, 122, 34, 123, 4, 2, 5, 6}, 0);
        Task3.weNeedMoarExceptions(2 ,3);
        Task4.emptyStringHandler();
    }
}

class Task1 {
    public static void input() {
        System.out.println("Введите дробное число [дробное число, это число вида x.x, например, 3,7]");
        Scanner scFloat = new Scanner(System.in);
        try {
            float number = scFloat.nextFloat();
            System.out.print("Отлично! Ваше число - ");
            System.out.println(number);
        } catch (InputMismatchException e) {
            System.out.println("Что-то пошло не так. Попробуйте еще раз");
            input();
        }
    }
}

class Task2 {
    public static void Doo(int[] intArray, int d) {
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("В массиве должно быть не меньше 9 элементов.");
        } catch (ArithmeticException e) {
            System.out.println("Dividing by zero are strongly forbidden!");
        }
    }
}

class Task3 {
    public static void weNeedMoarExceptions(int a, int b) {
        try {
            System.out.println(a / b);
            printSum(23, 12);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Dividing by zero are strongly forbidden!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    private static void printSum(Integer c, Integer d) throws NullPointerException {
        System.out.println(c + d);
    }
}

class Task4 {
    public static void emptyStringHandler() throws RuntimeException {
        System.out.print("Введите непустую строку: ");
        Scanner scStringScanner = new Scanner(System.in);
        String targetString = scStringScanner.nextLine();
        if (targetString.isEmpty()) {
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
        System.out.println("Строка принята! Ваша строка: " + targetString);
    }
}