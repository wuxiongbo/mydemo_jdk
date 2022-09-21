package java17;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author wuxiongbo
 * @date 2022/7/6 09:49
 */
public class FluxTest {
    public static void main(String[] args) {
        Flux integerFlux = Flux.fromIterable(List.of(1, 2, 3));

        FluxUtil1.test(integerFlux.log()).subscribe(integer -> {
            System.out.println(integer);
        });

    }
}

 class FluxUtil1 {
    public static Flux test(Flux integerFlux) {
        return FluxUtil2.test2(integerFlux.map(Object::toString));
    }
}
 class FluxUtil2 {
    public static Flux test2(Flux stringFlux) {
        return stringFlux.map(e->Integer.valueOf(String.valueOf(e)));
    }
}