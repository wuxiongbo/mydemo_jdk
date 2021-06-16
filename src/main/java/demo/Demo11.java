package demo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/9
 * </pre>
 */
public class Demo11 {


    public static <T, R extends Comparable<? super R>> Comparator<T> comparing(
            Function<? super T, ? extends R> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }



}
