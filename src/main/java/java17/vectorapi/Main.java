package java17.vectorapi;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Arrays;

/**
 * VM参数：--add-modules jdk.incubator.vector
 * @author 10027088
 */
public class Main {
    /**
     * 在代码能够运行并利用SIMD加速之前，必须确定数据宽度。
     * AVX兼容CPU可以处理256比特，而AVX-512可以提供512比特的数据宽度。
     */
    private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;


    /**
     * 因此，我们需要正确配置循环的大小。
     * 简单的for-loop使用i++将索引递增1；{@link SimpleDemo}
     *
     * 在这个例子中，需要根据SIMD寄存器的数据宽度进行转移。
     * 在AVX-512（512位）上运行的整数运算的情况下，我们必须以16为单位递增。
     * 第一个迭代执行a[0]+b[0]到a[15]+b[15]的操作。
     * 下一个操作对 a[16]+b[16]到a[31]+b[31]执行同样的操作，以此类推
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] vectorSum(int[] a, int[] b) {
        var c = new int[a.length];

        var upperBound = SPECIES.loopBound(a.length);

        var i = 0;
        for (; i < upperBound; i += SPECIES.length()) {
            var va = IntVector.fromArray(SPECIES, a, i);
            var vb = IntVector.fromArray(SPECIES, b, i);
            var vc = va.add(vb);
            vc.intoArray(c, i);
        }
        // Compute elements not fitting in the vector alignment.
        for (; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }

        return c;

    }


    public static void main(String[] args) {
        int [] a = new int[30];
        int value = 1;
        for (int i = 0; i < a.length; i++) {
            a[i] = value++;
        }

        int [] b = new int[30];
        value = 1;
        for (int i = 0; i < b.length; i++) {
            b[i] = value++;
        }

        int[] ints = vectorSum(a, b);

        System.out.println(Arrays.toString(ints));
    }
}
