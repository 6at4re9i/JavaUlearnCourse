import java.sql.SQLOutput;
public class Calculator {
    public static String calculate(String input){
        String[] variables = input.split(" ");
        String a = variables[0];
        String operation = variables[1];
        String b = variables[2];
        boolean isNumeric = true;
        for (int i =0; i < a.length(); i++){
            if(!Character.isDigit(a.charAt(i))){
                isNumeric = false;
                break;
            }
        }
        if(isNumeric){
           double aDouble = Double.parseDouble(a);
           double bDouble = Double.parseDouble(b);
           double answer = calculate(aDouble, bDouble, operation);
           return Double.toString(answer);
        }
        else{
            if(operation.equals("*")||operation.equals("/")){
                throw new
                        IllegalArgumentException();
            }
            else if (operation.equals("-")){
                    int index = a.indexOf(b);
                    if (index == -1){
                        throw new
                                IllegalArgumentException();
                    }
                    else{
                        return calculate(a, b, operation);
                    }
                }
            else if(operation.equals("+")){
                return calculate(a, b, operation);
            }
            else{
                throw new
                        IllegalArgumentException();
            }
        }
    }
    private static String calculate(String a, String b, String operation) {
        if (operation.equals("+")){
            return a + b;
        }
        else{
            return a.replace(b, "");
        }
    }

    private static Double calculate(double a, double b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

    public static int getNumbers(int a, int b) {
        int digit;
        int sum = a + b;
        if (sum < 0) {
            int new_sum = (-1) * sum;
            int count = 0;
            while (new_sum > 0) {
                digit = new_sum % 10;
                if (digit % 2 == 0) {
                    count++;
                }
                new_sum /= 10;
            }
            return count;
        } else {
            int count = 0;
            while (sum > 0) {
                digit = sum % 10;
                if (digit % 2 == 0) {
                    count++;
                }
                sum /= 10;
            }
            return count;
        }
    }
    public static String getMinimalType(String input) {
        long number = Long.parseLong(input);
        if (number >= Byte.MIN_VALUE && number <= Byte.MAX_VALUE) {
            return "Byte";
        }
        else if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
            return "Short";
        }
        else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
            return "Int";
        }
        else {
            return "Long";
        }
    }
}
