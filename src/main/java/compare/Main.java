package compare;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Xander Wu
 * @date 2022/10/11 17:09
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        List<Integer> integers1 = integers.stream().sorted((o1, o2) -> {
            return - o1.compareTo(o2);
        }).toList();

        System.out.println(integers1);

    }
}
