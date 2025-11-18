import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Collector {

    private String collectionType;

    public Collector() {
        this.collectionType = "GenericCollector";
    }

    public Collector(String collectionType) {
        this.collectionType = collectionType;
    }

    // Метод коллекционирования с условием
    public static <T, P extends Collection<T>> P collect(
            List<T> list,
            Supplier<P> collectionFactory,
            Function<T, Boolean> addCondition) {

        P result = collectionFactory.get();
        for (T item : list) {
            if (addCondition.apply(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Метод коллекционирования без условия
    public static <T, P extends Collection<T>> P collect(
            List<T> list,
            Supplier<P> collectionFactory) {

        P result = collectionFactory.get();
        result.addAll(list);
        return result;
    }

    @Override
    public String toString() {
        return "Collector{type='" + collectionType + "'}";
    }
}