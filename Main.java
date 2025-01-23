import java.util.Scanner;

class Main {
    public static String calc(String input) throws Exception {
        // Удаляем лишние пробелы и разбиваем строку на части
        String[] parts = input.trim().split(" ");

        // Проверяем, что строка соответствует формату "число оператор число"
        if (parts.length != 3) {
            throw new Exception("throws Exception // Неверный формат ввода");
        }

        // Пробуем преобразовать операнды в числа
        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("throws Exception // Операнды должны быть числами");
        }

        // Проверяем, что числа в диапазоне от 1 до 10 включительно
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("throws Exception // Числа должны быть от 1 до 10 включительно");
        }

        // Определяем оператор
        String operator = parts[1];
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("throws Exception // Деление на ноль невозможно");
                }
                result = a / b;
                break;
            default:
                throw new Exception("throws Exception // Неподдерживаемый оператор");
        }

        // Возвращаем результат в виде строки
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение (например, 2 + 3):");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
