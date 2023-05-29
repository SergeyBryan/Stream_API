import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        list.add(random.nextInt(0, 500));
        List<Integer> emptyList = new ArrayList<>();
        Stream<Integer> streamOfEmptyList = emptyList.stream();
        findMinMax(streamOfEmptyList, Integer::compareTo, (x, y) -> System.out.printf("MIN: %s, MAX: %s \n", x, y));
        Stream<Integer> stream = list.stream();
        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.printf("MIN: %s, MAX: %s \n", x, y));
        list.forEach(System.out::println);
        counter(list);
    }


    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void counter(List<Integer> list) {
        long numbers = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Количество четных чисел:" + numbers);
    }
}