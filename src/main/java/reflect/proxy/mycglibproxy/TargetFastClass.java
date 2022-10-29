package reflect.proxy.mycglibproxy;

import org.springframework.cglib.core.Signature;

/**
 * 当调用 MethodProxy 的 invoke 或 invokeSuper 方法时, 会动态生成两个类
 * TargetFastClass 记录了 Target 中方法与编号的对应关系
 * ProxyFastClass 记录了 Proxy 中方法与编号的对应关系，不过 Proxy 额外提供了下面几个方法
 * 不增强，仅是调用 super.save(long)
 *
 * -
 * <p>
 * * ProxyFastClass 配合代理对象一起使用, 避免反射
 * * TargetFastClass 配合目标对象一起使用, 避免反射 (Spring 用的这种)
 *
 * @author Jonathan
 */
public class TargetFastClass {
    static Signature s0 = new Signature("save", "()V");
    static Signature s1 = new Signature("save", "(I)V");
    static Signature s2 = new Signature("save", "(J)V");

    public static void main(String[] args) {
        TargetFastClass fastClass = new TargetFastClass();
        int index = fastClass.getIndex(new Signature("save", "(I)V"));
        System.out.println(index);
        fastClass.invoke(index, new Target(), new Object[]{100});
    }

    /**
     * 获取目标方法的编号
     * Target
     * save()              0
     * save(int)           1
     * save(long)          2
     * signature 包括方法名字、参数返回值
     */
    public int getIndex(Signature signature) {
        if (s0.equals(signature)) {
            return 0;
        }
        else if (s1.equals(signature)) {
            return 1;
        }
        else if (s2.equals(signature)) {
            return 2;
        }
        return -1;
    }

    /**
     * 根据方法编号, 正常调用目标对象方法
     */
    public Object invoke(int index, Object target, Object[] args) {
        if (index == 0) {
            ((Target) target).save();
            return null;
        }
        else if (index == 1) {
            ((Target) target).save((int) args[0]);
            return null;
        }
        else if (index == 2) {
            ((Target) target).save((long) args[0]);
            return null;
        }
        else {
            throw new RuntimeException("无此方法");
        }
    }
}
