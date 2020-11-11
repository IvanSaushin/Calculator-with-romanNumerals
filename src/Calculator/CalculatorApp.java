package Calculator;

import java.util.Scanner;

public class CalculatorApp implements ICalculate{

    Scanner userScanner = new Scanner(System.in);

    public CalculatorApp() throws ExceptionFrom1To10 {
        System.out.println("Введите пример или 0, если хотите завершить\nInput:");
        String userText = userScanner.nextLine();

        while (!checkEndApp(userText)){
            StringInputParser parser = new StringInputParser(userText);

            String firstString = parser.getX();
            String secondString = parser.getY();
            char sign = parser.getSign();

            long answer;
            if (ICalculate.isArabicNumber(firstString, secondString)) {
                int firstNum = Integer.parseInt(firstString);
                int secondNum = Integer.parseInt(secondString);
                answer = ICalculate.calculateArabicNumber(firstNum, secondNum, sign);
                System.out.println("\nOutput: \n"+ answer +"\n");
            }
            else if (ICalculate.isRomanNumber(firstString, secondString)) {
                answer = ICalculate.calculateRomanNumber(firstString, secondString, sign);
                String romanAnswer = ICalculate.arabicToRoman(answer);
                System.out.println("\nOutput: \n"+ romanAnswer +"\n");
            }
            else {
                System.out.println("Некорректно введены данные (значения)");
            }

            System.out.println("Input:");
            userText = userScanner.nextLine();
        }

        System.out.println("Completed");
    }

    private boolean checkEndApp(String string) {
        boolean res = false;
        try {
            if (Integer.parseInt(string)==0) {
                res = true;
            }
        } catch (Exception e) {
            res = false;
        }
        return  res;
    }
}
