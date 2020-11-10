package Calculator;

import java.util.Scanner;

public class CalculatorApp implements ICalculate{

    Scanner userScanner = new Scanner(System.in);
    private int firstNum;
    private int secondNum;


    public CalculatorApp() {
        System.out.println("Введите пример или 0, если хотите завершить\nInput:");
        String userText = userScanner.nextLine(); // ввод текста пользователем

        while (!checkEndApp(userText)){
            StringInputParser parser = new StringInputParser(userText);

            String firstString = parser.getX();
            String secondString = parser.getY();
            char sign = parser.getSign();

            long answer;
            if (isArabicNumber(firstString, secondString)) {
                firstNum = Integer.parseInt(firstString);
                secondNum = Integer.parseInt(secondString);
                answer = ICalculate.calculateArabicNumber(firstNum, secondNum, sign);
                System.out.println("\nOutput: \n"+ answer +"\n");
            }
            else if (isRomanNumber(firstString, secondString)) {
                answer = ICalculate.calculateRomanNumber(firstString, secondString, sign);
                String romanAnswer = ICalculate.arabicToRoman(answer);
                System.out.println("\nOutput: \n"+ romanAnswer + ", "+ answer +"\n");
            }
            else {
                System.out.println("Некорректно введены данные (значения)");
            }

            System.out.println("Input:");
            userText = userScanner.nextLine();
        }

        System.out.println("Completed");
    }


    private boolean isArabicNumber(String firstNum, String secondNum) throws NumberFormatException {
        try {
            Integer.parseInt(firstNum);
            Integer.parseInt(secondNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private boolean isRomanNumber(String firNum, String secNum) {
        boolean result = false;
        char[] romanString;

        try {
            romanString = firNum.concat(secNum).toCharArray();
            for (char c : romanString) {
                if (c == 'I' || c == 'V' || c == 'X') {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
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
