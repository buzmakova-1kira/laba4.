import java.util.*;
import java.util.function.Function;

public class FunctionApplier {

    private String name;

    public FunctionApplier() {
        this.name = "FunctionApplier";
    }

    public FunctionApplier(String name) {
        this.name = name;
    }

    // Метод применения функции
    public static <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    @Override
    public String toString() {
        return "FunctionApplier{name='" + name + "'}";
    }
}