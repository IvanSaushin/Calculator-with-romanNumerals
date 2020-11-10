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
        Roman[] values= Roman.values();
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
        Roman[] romanNumerals= Roman.values();

        for (int i = 0; i < romanNumerals.length; i++) {
            if (romanNumber.equals(romanNumerals[i].name())) {
                arabic = romanNumerals[i].value;
            }
        }

        return arabic;
    }

    enum Roman{
        I(1), II(2), III(3), IV(4),V(5),
        VI(6), VII(7), VIII(8), IX(9), X(10);
        int value;

        Roman(int value) {
            this.value = value;
        }
    };

}
