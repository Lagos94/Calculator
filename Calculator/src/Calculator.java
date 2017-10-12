/*By Juan Lagos
* CSC 201
* Professor Tanes Kanchanawanchai
* Assignment 10 Chapter 10
* Calculator
* Due Date: 10/08/17
* Comments:
* This program works as a calculator that takes 2
* separate values and performs any of the 4 primary
* operations to yield an answer.*/
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Enter a 2-value calculation (using +, -, /, or *) and proceed to " +
                "press Enter once and then Ctrl+D to display result: ");
        Scanner inputScanner = new Scanner(System.in);
        String entry = "";
        while (inputScanner.hasNext()) {
            entry += inputScanner.next();
        }
        entry = entry.replace("+", " + ")
                .replace("-", " - ")
                .replace("*", " * ")
                .replace("/", " / ");

        Scanner entryScanner = new Scanner(entry);
        System.out.println(calc(entryScanner));
    }

    static double calc(Scanner enter) {
        double a = calculator(enter);
        char operator = enter.next().charAt(0);
        double b = calculator(enter);

        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new RuntimeException("Unrecognized operator: " + operator);
        }
    }

    static double calculator(Scanner enter) {
        int res = 1;
        String token = enter.next();
        if (token.equals("-")) {
            res = -res;
            token = enter.next();
        }
        res *= Integer.parseInt(token);
        return res;
    }
}