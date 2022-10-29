package reflect.proxy.cglib.mixin;

import net.sf.cglib.proxy.Mixin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface Interface1 {
    String first();
}

interface Interface2 {
    String second();
}

class Class1 implements Interface1 {
    @Override
    public String first() {
        return "first";
    }
}

class Class2 implements Interface2 {
    @Override
    public String second() {
        return "second";
    }
}

interface MixinInterface extends Interface1, Interface2 {
}


/**
 * Mixin能够让我们将多个对象整合到一个对象中去，前提是这些对象必须是接口的实现。
 *
 * Mixin类比较尴尬，因为他要求Minix的类（例如MixinInterface）实现一些接口。
 * 既然被Minix的类已经实现了相应的接口，那么我就直接可以通过纯Java的方式实现，没有必要使用Minix类。
 *
 * @author Xander Wu
 * @date 2022/10/25 16:27
 */
public class MixinInterfaceTest {


    @Test
    public void testMixin() throws Exception {
        Mixin mixin = Mixin.create(
                new Class[]{
                        Interface1.class,
                        Interface2.class,
                        MixinInterface.class},
                new Object[]{
                        new Class1(),
                        new Class2()});

        MixinInterface mixinDelegate = (MixinInterface) mixin;

        assertEquals("first", mixinDelegate.first());
        assertEquals("second", mixinDelegate.second());
    }
}
