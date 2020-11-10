package Calculator;

public class StringInputParser {
    private String example;

    public StringInputParser(String example) {
        this.example = example;
    }

    public String[] parserExample() {
        String[] result = new String[example.length()];

        if (example.contains(" ")) {
            result = example.split(" ");
        } else if (example.contains("+") || example.contains("-") ||
                    example.contains("*") || example.contains("/")) {
            /*

             */
        } else  {
            System.err.print("Некорректно введены данные. Введите через пробел");
        }

        return result;
    }

    public String getX() {
        return parserExample()[0];
    }

    public String getY() {
        try {
            return parserExample()[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка ввода");
        }
        return "Input error";
    }

    public char getSign() {
        char sign = ' ';
        try {
            sign = parserExample()[1].charAt(0);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return sign;
    }

}
