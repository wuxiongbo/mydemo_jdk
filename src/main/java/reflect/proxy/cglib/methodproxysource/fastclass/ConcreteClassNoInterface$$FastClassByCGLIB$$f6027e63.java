package reflect.proxy.cglib.methodproxysource.fastclass;

import net.sf.cglib.core.Signature;
import net.sf.cglib.reflect.FastClass;
import reflect.proxy.cglib.ConcreteClassNoInterface;

import java.lang.reflect.InvocationTargetException;

/**
 * 被代理类对应的 fastclass
 * @author Xander Wu
 * @date 2022/10/26 14:05
 */
public class ConcreteClassNoInterface$$FastClassByCGLIB$$f6027e63 extends FastClass {
    public ConcreteClassNoInterface$$FastClassByCGLIB$$f6027e63(Class cls) {
        super(cls);
    }

    @Override
    public int getIndex(Signature signature) {
        String obj = signature.toString();
        switch (obj.hashCode()) {
            case 825386950:
                return obj.equals("getConcreteMethodA(Ljava/lang/String;)Ljava/lang/String;") ? 1 : -1;
            case 1741915687:
                return obj.equals("getConcreteMethodB(I)I") ? 0 : -1;
            case 1826985398:
                return obj.equals("equals(Ljava/lang/Object;)Z") ? 2 : -1;
            case 1913648695:
                return obj.equals("toString()Ljava/lang/String;") ? 3 : -1;
            case 1984935277:
                return obj.equals("hashCode()I") ? 4 : -1;
            default:
                return -1;
        }
    }

    @Override
    public int getIndex(String str, Class[] clsArr) {
        switch (str.hashCode()) {
            case -1776922004:
                if (!str.equals("toString")) {
                    return -1;
                }
                switch (clsArr.length) {
                    case 0:
                        return 3;
                    default:
                        return -1;
                }
            case -1295482945:
                if (!str.equals("equals")) {
                    return -1;
                }
                switch (clsArr.length) {
                    case 1:
                        return clsArr[0].getName().equals("java.lang.Object") ? 2 : -1;
                    default:
                        return -1;
                }
            case 147696667:
                if (!str.equals("hashCode")) {
                    return -1;
                }
                switch (clsArr.length) {
                    case 0:
                        return 4;
                    default:
                        return -1;
                }
            case 2134717189:
                if (!str.equals("getConcreteMethodA")) {
                    return -1;
                }
                switch (clsArr.length) {
                    case 1:
                        return clsArr[0].getName().equals("java.lang.String") ? 1 : -1;
                    default:
                        return -1;
                }
            case 2134717190:
                if (!str.equals("getConcreteMethodB")) {
                    return -1;
                }
                switch (clsArr.length) {
                    case 1:
                        return clsArr[0].getName().equals("int") ? 0 : -1;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }

    @Override
    public int getIndex(Class[] clsArr) {
        switch (clsArr.length) {
            case 0:
                return 0;
            default:
                return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    // 核心方法:  直接调用实例对象。并非反射
    @Override
    public Object invoke(int index, Object obj, Object[] args) throws InvocationTargetException {
        ConcreteClassNoInterface origin = (ConcreteClassNoInterface) obj;
        try {
            switch (index) {
                case 0:
                    return origin.getConcreteMethodB( ((Number) args[0]).intValue() );
                case 1:
                    return origin.getConcreteMethodA( (String) args[0] );
                case 2:
                    return origin.equals(args[0]);
                case 3:
                    return origin.toString();
                case 4:
                    return origin.hashCode();
                default:
                    throw new IllegalArgumentException("Cannot find matching method/constructor");
            }
        } catch (Throwable unused) {
            throw new InvocationTargetException(unused, index + "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override
    public Object newInstance(int i, Object[] objArr) throws InvocationTargetException {
        try {
            switch (i) {
                case 0:
                    return new ConcreteClassNoInterface();
                default:
                    throw new IllegalArgumentException("Cannot find matching method/constructor");
            }
        } catch (Throwable unused) {
            throw new InvocationTargetException(unused, i+"");
        }
    }

    @Override
    public int getMaxIndex() {
        return 4;
    }
}