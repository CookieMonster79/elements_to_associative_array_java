import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementCounter {

    // Метод для подсчета элементов
    public static <T> Map<T, Integer> countElements(List<T> list) {
        Map<T, Integer> result = new HashMap<>();
        for (T element : list) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }

    // Метод для ввода списка с клавиатуры
    public static List<String> inputListFromKeyboard() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (true) {
            System.out.println("Введите элементы списка через запятую (например, 1, 2, a, b):");
            input = reader.readLine().trim(); // Чтение ввода и удаление лишних пробелов

            // Проверка на пустую строку или отсутствие запятых
            if (input.isEmpty() || !input.contains(",")) {
                System.out.println("Ошибка: строка должна содержать элементы, разделенные запятой. Попробуйте снова.");
            }
            // Проверка, что последний символ не запятая
            else if (input.endsWith(",")) {
                System.out.println("Ошибка: строка не должна заканчиваться запятой. Попробуйте снова.");
            } else {
                break; // Ввод корректен, выходим из цикла
            }
        }

        // Разделение строки по запятой и удаление лишних пробелов
        return Arrays.asList(input.split("\\s*,\\s*"));
    }

    public static void main(String[] args) {
        try {
            // Ввод списка с клавиатуры
            List<String> myList = inputListFromKeyboard();

            // Подсчет элементов
            Map<String, Integer> countedElements = countElements(myList);

            // Вывод результата
            System.out.println("Результат:");
            System.out.println(countedElements);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }
}
