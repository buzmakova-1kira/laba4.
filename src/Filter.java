import java.util.*;
import java.util.function.Predicate;

public class Filter {

    private String filterType;

    public Filter() {
        this.filterType = "StandardFilter";
    }

    public Filter(String filterType) {
        this.filterType = filterType;
    }

    // Метод фильтрации
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Filter{type='" + filterType + "'}";
    }
}