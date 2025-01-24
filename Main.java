import java.util.Scanner;

class Main {
    public static String calc(String input) throws Exception {
        String[] parts = input.trim().split(" ");

        if (parts.length == 1) {
            throw new Exception("throws Exception // т.к. строка не является математической операцией !");
        } else if (parts.length > 4) {
            throw new Exception("throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (parts.length != 3) {
            throw new Exception("throws Exception");
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("throws Exception // Числа должны быть от 1 до 10 включительно !");
        }

        switch (parts[1]) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) {
                    throw new Exception("throws Exception // Деление на ноль невозможно !");
                }
                return String.valueOf(a / b);
            default:
                throw new Exception("throws Exception // Неподдерживаемый оператор !");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();

        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
