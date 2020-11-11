package Calculator;

public interface ICalculate {

    static long calculateArabicNumber(int x, int y, char sign) {
        long z = 0;

        switch (sign) {
            case ('+') :
                z = (x + y);
                break;
            case ('-') :
                z = (x - y);
                break;
            case ('*') :
                z =  x*y;
                break;
            case ('/') :
                try {
                    z = x/y;
                } catch (ArithmeticException e) {
                    System.err.println("На ноль делить нельзя!");
                    e.printStackTrace();
                }
                break;
        }
        return z;
    }

    static String arabicToRoman(long arabNum){
        String roman="";
        RomanNumerals[] values= RomanNumerals.values();
        for (int i = values.length-1; i>=0; i--) {
            while(arabNum>=values[i].value){
                roman+=values[i];
                arabNum=arabNum-values[i].value;
            }
        }
        return roman;
    }

    static long calculateRomanNumber(String rom1, String rom2, char sign) {
        int x = romanToArabic(rom1);
        int y = romanToArabic(rom2);

        return calculateArabicNumber(x, y, sign);
    }


    static int romanToArabic(String romanNumber) {
        int arabic = 0;
        RomanNumerals[] romanNumerals= RomanNumerals.values();

        for (int i = 0; i < romanNumerals.length; i++) {
            if (romanNumber.equals(romanNumerals[i].name())) {
                arabic = romanNumerals[i].value;
            }
        }

        return arabic;
    }

    static boolean isArabicNumber(String firstNum, String secondNum) throws NumberFormatException {
        try {
            Integer.parseInt(firstNum);
            Integer.parseInt(secondNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    static boolean isRomanNumber(String firNum, String secNum) {
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
        } catch (NumberFormatException ignored) {
        }
        return result;
    }

    enum RomanNumerals{
        I(1), II(2), III(3), IV(4),V(5),
        VI(6), VII(7), VIII(8), IX(9), X(10);
        int value;

        RomanNumerals(int value) {
            this.value = value;
        }
    };

}
