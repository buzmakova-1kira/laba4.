import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Box<Integer> integerBox;

    public static void main(String[] args) {

        // ЗАДАЧА 1: КОРОБКА
        demonstrateTask1();

        // ЗАДАЧА 2: ХРАНИЛИЩЕ
        demonstrateTask2();

        // ЗАДАЧА 3: КОРОБКА С ТРЕХМЕРНОЙ ТОЧКОЙ
        demonstrateTask3();

        // ЗАДАЧА 4: ФУНКЦИЯ
        demonstrateTask4();

        // ЗАДАЧА 5: ФИЛЬТР
        demonstrateTask5();

        // ЗАДАЧА 6: СОКРАЩЕНИЕ
        demonstrateTask6();

        // ЗАДАЧА 7: КОЛЛЕКЦИОНИРОВАНИЕ
        demonstrateTask7();

        scanner.close();
    }

    // ЗАДАЧА 1: КОРОБКА
    private static void demonstrateTask1() {
        System.out.println("ЗАДАЧА 1: КОРОБКА");

        integerBox = new Box<>();
        boolean running = true;

        while (running) {
            System.out.println("\nМЕНЮ:");
            System.out.println("1. Разместить число в коробке");
            System.out.println("2. Извлечь число из коробки");
            System.out.println("3. Проверить заполненность коробки");
            System.out.println("4. Показать состояние коробки");
            System.out.println("5. Перейти к следующей задаче");
            System.out.print("Выберите действие: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    putNumber();
                    break;
                case 2:
                    getNumber();
                    break;
                case 3:
                    checkFullness();
                    break;
                case 4:
                    showStatus();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        System.out.println();
    }

    // ЗАДАЧА 2: ХРАНИЛИЩЕ
    private static void demonstrateTask2() {
        System.out.println("ЗАДАЧА 2: ХРАНИЛИЩЕ");

        System.out.println("1. Хранилище чисел с null (альтернатива 0):");
        Storage<Integer> storage1 = new Storage<>(null);
        System.out.println("Состояние: " + storage1);
        System.out.println("Значение: " + storage1.getOrDefault(0));

        System.out.println("\n2. Хранилище чисел с 99 (альтернатива -1):");
        Storage<Integer> storage2 = new Storage<>(99);
        System.out.println("Состояние: " + storage2);
        System.out.println("Значение: " + storage2.getOrDefault(-1));

        System.out.println("\n3. Хранилище строк с null (альтернатива 'default'):");
        Storage<String> storage3 = new Storage<>(null);
        System.out.println("Состояние: " + storage3);
        System.out.println("Значение: " + storage3.getOrDefault("default"));

        System.out.println("\n4. Хранилище строк с 'hello' (альтернатива 'hello world'):");
        Storage<String> storage4 = new Storage<>("hello");
        System.out.println("Состояние: " + storage4);
        System.out.println("Значение: " + storage4.getOrDefault("hello world"));
        System.out.println();
    }

    // ЗАДАЧА 3: КОРОБКА С ТРЕХМЕРНОЙ ТОЧКОЙ
    private static void demonstrateTask3() {
        System.out.println("ЗАДАЧА 3: КОРОБКА С ТРЕХМЕРНОЙ ТОЧКОЙ");

        Box<Point3D> pointBox = new Box<>();
        System.out.println("1. Создана коробка для точек: " + pointBox);

        putPointInBox(pointBox);
        System.out.println();
    }

    // ЗАДАЧА 4: ФУНКЦИЯ
    private static void demonstrateTask4() {
        System.out.println("ЗАДАЧА 4: ФУНКЦИЯ");

        System.out.println("1. Строки в длины:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = FunctionApplier.applyFunction(strings, String::length);
        System.out.println("Исходно: " + strings);
        System.out.println("Результат: " + lengths);

        System.out.println("\n2. Абсолютные значения:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absolute = FunctionApplier.applyFunction(numbers, Math::abs);
        System.out.println("Исходно: " + numbers);
        System.out.println("Результат: " + absolute);

        System.out.println("\n3. Максимумы массивов:");
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 5, 3},
                new int[]{-2, 8, 0},
                new int[]{10, -4, 7}
        );
        List<Integer> maxValues = FunctionApplier.applyFunction(arrays, arr -> {
            int max = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
            }
            return max;
        });
        System.out.println("Исходные массивы: " + Arrays.deepToString(arrays.toArray()));
        System.out.println("Максимумы: " + maxValues);
        System.out.println();
    }

    // ЗАДАЧА 5: ФИЛЬТР
    private static void demonstrateTask5() {
        System.out.println("ЗАДАЧА 5: ФИЛЬТР");

        System.out.println("1. Фильтрация строк с длиной >= 3:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<String> filteredStrings = Filter.filterList(strings, s -> s.length() >= 3);
        System.out.println("Исходно: " + strings);
        System.out.println("После фильтрации: " + filteredStrings);

        System.out.println("\n2. Фильтрация положительных чисел:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> filteredNumbers = Filter.filterList(numbers, n -> n > 0);
        System.out.println("Исходно: " + numbers);
        System.out.println("После фильтрации: " + filteredNumbers);

        System.out.println("\n3. Фильтрация массивов без положительных элементов:");
        List<int[]> arrays = Arrays.asList(
                new int[]{-1, -5, -3},
                new int[]{-2, 8, 0},
                new int[]{-10, -4, -7}
        );
        List<int[]> filteredArrays = Filter.filterList(arrays, arr -> {
            for (int num : arr) {
                if (num > 0) return false;
            }
            return true;
        });
        System.out.println("Исходные массивы: " + Arrays.deepToString(arrays.toArray()));
        System.out.println("После фильтрации: " + Arrays.deepToString(filteredArrays.toArray()));
        System.out.println();
    }

    // ЗАДАЧА 6: СОКРАЩЕНИЕ
    private static void demonstrateTask6() {
        System.out.println("ЗАДАЧА 6: СОКРАЩЕНИЕ");

        System.out.println("1. Объединение строк в одну большую строку:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        String concatenated = Reducer.reduce(strings, (s1, s2) -> s1 + s2, "");
        System.out.println("Исходный список: " + strings);
        System.out.println("Результат: \"" + concatenated + "\"");

        System.out.println("\n2. Сумма всех чисел:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        Integer sum = Reducer.reduce(numbers, (a, b) -> a + b, 0);
        System.out.println("Исходный список: " + numbers);
        System.out.println("Сумма: " + sum);

        System.out.println("\n3. Общее количество элементов во всех списках:");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> sizes = new ArrayList<>();
        for (List<Integer> list : listOfLists) {
            sizes.add(list.size());
        }
        Integer totalCount = Reducer.reduce(sizes, (a, b) -> a + b, 0);

        System.out.println("Исходные списки: " + listOfLists);
        System.out.println("Общее количество элементов: " + totalCount);

        System.out.println("\n4. Проверка с пустым списком:");
        List<String> emptyList = new ArrayList<>();
        String emptyResult = Reducer.reduce(emptyList, (s1, s2) -> s1 + s2, "пусто");
        System.out.println("Пустой список: " + emptyList);
        System.out.println("Результат: \"" + emptyResult + "\"");
        System.out.println();
    }

    // ЗАДАЧА 7: КОЛЛЕКЦИОНИРОВАНИЕ
    private static void demonstrateTask7() {
        System.out.println("ЗАДАЧА 7: КОЛЛЕКЦИОНИРОВАНИЕ");

        System.out.println("1. Разделение чисел на положительные и отрицательные:");
        List<Integer> numbers = Arrays.asList(1, -3, 7, -2, 0, -5);

        List<Integer> positiveNumbers = Collector.collect(numbers, ArrayList::new, n -> n > 0);
        List<Integer> negativeNumbers = Collector.collect(numbers, ArrayList::new, n -> n < 0);

        System.out.println("Исходный список: " + numbers);
        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        System.out.println("\n2. Группировка строк по длине:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw", "hello", "a");

        Map<Integer, List<String>> groupedByLength = new HashMap<>();
        for (String str : strings) {
            int length = str.length();
            groupedByLength.computeIfAbsent(length, k -> new ArrayList<>()).add(str);
        }

        System.out.println("Исходный список: " + strings);
        System.out.println("Сгруппировано по длине: " + groupedByLength);

        System.out.println("\n3. Уникальные строки (удаление дубликатов):");
        List<String> stringsWithDuplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

        Set<String> uniqueStrings = Collector.collect(stringsWithDuplicates, HashSet::new);

        System.out.println("Исходный список: " + stringsWithDuplicates);
        System.out.println("Уникальные строкы: " + uniqueStrings);
        System.out.println();
    }

    // Методы для работы с коробкой
    private static void putNumber() {
        try {
            System.out.print("Введите целое число для размещения в коробке: ");
            int number = getIntInput();
            integerBox.put(number);
            System.out.println("Число " + number + " успешно размещено в коробке");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void getNumber() {
        try {
            Integer number = integerBox.get();
            System.out.println("Извлеченное число: " + number);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void checkFullness() {
        System.out.println("Коробка заполнена: " + integerBox.isFull());
    }

    private static void showStatus() {
        System.out.println("Состояние коробки: " + integerBox);
    }

    private static <T> void putPointInBox(Box<T> box) {
        Point3D point = new Point3D(1.5, 2.7, 3.9);
        try {
            T item = (T) point;
            box.put(item);
            System.out.println("Точка " + point + " размещена в коробке");
            System.out.println("Состояние коробки: " + box);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Некорректный ввод. Введите целое число: ");
            }
        }
    }
}