package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите пример");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Ответ: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {

        String result = "";

        Pattern pattern = Pattern.compile("^(\\d+)\\s*([-+*/])\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            if (matcher.groupCount() != 3) {
                throw new IllegalArgumentException("Неверный формат");
            }

            int num1 = Integer.parseInt(matcher.group(1));
            char oper = matcher.group(2).charAt(0);
            int num2 = Integer.parseInt(matcher.group(3));

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа не могут быть меньше 1 или больше 10");
            }

            switch (oper) {
                case '+':
                    result = String.valueOf(num1 + num2);
                    break;
                case '-':
                    result = String.valueOf(num1 - num2);
                    break;
                case '*':
                    result = String.valueOf(num1 * num2);
                    break;
                case '/':
                    result = String.valueOf(num1 / num2);
                    break;
                default:
                    throw new IllegalArgumentException("Неправильный оператор");
            }
        } else {
            throw new IllegalArgumentException("Неверный формат");
        }

        return result;
    }
}


