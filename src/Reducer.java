import java.util.*;
import java.util.function.BinaryOperator;

public class Reducer {

    private String operation;

    public Reducer() {
        this.operation = "reduce";
    }

    public Reducer(String operation) {
        this.operation = operation;
    }

    // Метод сокращения
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
        if (list.isEmpty()) {
            return identity;
        }

        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Reducer{operation='" + operation + "'}";
    }
}