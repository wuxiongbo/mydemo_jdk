package reflect.proxy.cglib.methodproxysource.fastclass;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.reflect.FastClass;
import reflect.proxy.cglib.methodproxysource.cglibproxy.ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885;

import java.lang.reflect.InvocationTargetException;

/**
 * fastclass 示例
 *
 * 代理类对应的 fastclass
 *
 * FastClass并不是跟代理类一块生成的，
 * 而是在 第一次执行  MethodProxy invoke/invokeSuper 时生成的，并放在了缓存中。
 *
 * @author Xander Wu
 * @date 2022/10/26 13:22
 */
public class C0000x27e1ddf4 extends FastClass {

    public C0000x27e1ddf4(Class cls) {
        super(cls);
    }

    //根据 方法签名 获取 index
    @Override
    public int getIndex(Signature signature) {
        String str = signature.toString();
        switch (str.hashCode()) {
            case -2055565910:
                return str.equals("CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V") ? 19 : -1;
            case -1457535688:
                return str.equals("CGLIB$STATICHOOK1()V") ? 8 : -1;
            case -1411812934:
                return str.equals("CGLIB$hashCode$4()I") ? 12 : -1;
            case -1114394538:
                return str.equals("CGLIB$getConcreteMethodA$1(Ljava/lang/String;)Ljava/lang/String;") ? 11 : -1;
            case -894172689:
                return str.equals("newInstance(Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;") ? 6 : -1;
            case -623122092:
                return str.equals("CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;") ? 22 : -1;
            case -508378822:
                return str.equals("clone()Ljava/lang/Object;") ? 3 : -1;
            case -419626537:
                return str.equals("setCallbacks([Lnet/sf/cglib/proxy/Callback;)V") ? 17 : -1;
            case 374345669:
                return str.equals("CGLIB$equals$2(Ljava/lang/Object;)Z") ? 7 : -1;
            case 560567118:
                return str.equals("setCallback(ILnet/sf/cglib/proxy/Callback;)V") ? 15 : -1;
            case 811063227:
                return str.equals("newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;") ? 4 : -1;
            case 825386950:
                return str.equals("getConcreteMethodA(Ljava/lang/String;)Ljava/lang/String;") ? 16 : -1;
            case 973717575:
                return str.equals("getCallbacks()[Lnet/sf/cglib/proxy/Callback;") ? 21 : -1;
            case 1110310646:
                return str.equals("CGLIB$getConcreteMethodB$0(I)I") ? 9 : -1;
            case 1221173700:
                return str.equals("newInstance([Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;") ? 5 : -1;
            case 1230699260:
                return str.equals("getCallback(I)Lnet/sf/cglib/proxy/Callback;") ? 20 : -1;
            case 1517819849:
                return str.equals("CGLIB$toString$3()Ljava/lang/String;") ? 10 : -1;
            case 1584330438:
                return str.equals("CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V") ? 18 : -1;
            case 1741915687:
                return str.equals("getConcreteMethodB(I)I") ? 14 : -1;
            case 1826985398:
                return str.equals("equals(Ljava/lang/Object;)Z") ? 0 : -1;
            case 1913648695:
                return str.equals("toString()Ljava/lang/String;") ? 1 : -1;
            case 1984935277:
                return str.equals("hashCode()I") ? 2 : -1;
            case 2011844968:
                return str.equals("CGLIB$clone$5()Ljava/lang/Object;") ? 13 : -1;
            default:
                return -1;
        }
    }


    // 根据 方法名+参数 获取 index
    @Override
    public int getIndex(String name, Class[] parameterTypes) {
        switch (name.hashCode()) {
            case -1776922004:
                if (!name.equals("toString")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 1;
                    default:
                        return -1;
                }
            case -1295482945:
                if (!name.equals("equals")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("java.lang.Object") ? 0 : -1;
                    default:
                        return -1;
                }
            case -1053468136:
                if (!name.equals("getCallbacks")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 21;
                    default:
                        return -1;
                }
            case -124978608:
                if (!name.equals("CGLIB$equals$2")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("java.lang.Object") ? 7 : -1;
                    default:
                        return -1;
                }
            case -60403779:
                if (!name.equals("CGLIB$SET_STATIC_CALLBACKS")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;") ? 18 : -1;
                    default:
                        return -1;
                }
            case -29025554:
                if (!name.equals("CGLIB$hashCode$4")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 12;
                    default:
                        return -1;
                }
            case 85179481:
                if (!name.equals("CGLIB$SET_THREAD_CALLBACKS")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;") ? 19 : -1;
                    default:
                        return -1;
                }
            case 94756189:
                if (!name.equals("clone")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 3;
                    default:
                        return -1;
                }
            case 147696667:
                if (!name.equals("hashCode")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 2;
                    default:
                        return -1;
                }
            case 161998109:
                if (!name.equals("CGLIB$STATICHOOK1")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 8;
                    default:
                        return -1;
                }
            case 495524492:
                if (!name.equals("setCallbacks")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("[Lnet.sf.cglib.proxy.Callback;") ? 17 : -1;
                    default:
                        return -1;
                }
            case 916088725:
                if (!name.equals("CGLIB$getConcreteMethodA$1")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("java.lang.String") ? 11 : -1;
                    default:
                        return -1;
                }
            case 916089685:
                if (!name.equals("CGLIB$getConcreteMethodB$0")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("int") ? 9 : -1;
                    default:
                        return -1;
                }
            case 1154623345:
                if (!name.equals("CGLIB$findMethodProxy")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("net.sf.cglib.core.Signature") ? 22 : -1;
                    default:
                        return -1;
                }
            case 1543336190:
                if (!name.equals("CGLIB$toString$3")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 10;
                    default:
                        return -1;
                }
            case 1811874389:
                if (!name.equals("newInstance")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        String typeName = parameterTypes[0].getName();
                        switch (typeName.hashCode()) {
                            case -845341380:
                                return typeName.equals("net.sf.cglib.proxy.Callback") ? 6 : -1;
                            case 1730110032:
                                return typeName.equals("[Lnet.sf.cglib.proxy.Callback;") ? 5 : -1;
                            default:
                                return -1;
                        }
                    case 2:
                    default:
                        return -1;
                    case 3:
                        return (!parameterTypes[0].getName().equals("[Ljava.lang.Class;") || !parameterTypes[1].getName().equals("[Ljava.lang.Object;") || !parameterTypes[2].getName().equals("[Lnet.sf.cglib.proxy.Callback;")) ? -1 : 4;
                }
            case 1817099975:
                if (!name.equals("setCallback")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 2:
                        return (!parameterTypes[0].getName().equals("int") || !parameterTypes[1].getName().equals("net.sf.cglib.proxy.Callback")) ? -1 : 15;
                    default:
                        return -1;
                }
            case 1905679803:
                if (!name.equals("getCallback")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("int") ? 20 : -1;
                    default:
                        return -1;
                }
            case 1951977611:
                if (!name.equals("CGLIB$clone$5")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 0:
                        return 13;
                    default:
                        return -1;
                }
            case 2134717189:
                if (!name.equals("getConcreteMethodA")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("java.lang.String") ? 16 : -1;
                    default:
                        return -1;
                }
            case 2134717190:
                if (!name.equals("getConcreteMethodB")) {
                    return -1;
                }
                switch (parameterTypes.length) {
                    case 1:
                        return parameterTypes[0].getName().equals("int") ? 14 : -1;
                    default:
                        return -1;
                }
            default:
                return -1;
        }
    }

    // 构造函数 索引
    @Override
    public int getIndex(Class[] parameterTypes) {
        switch (parameterTypes.length) {
            case 0:
                return 0;
            default:
                return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    // 核心方法： 执行 索引对应的方法
    @Override
    public Object invoke(int i, Object obj, Object[] objArr) throws InvocationTargetException {
        ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 proxy = (ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885) obj;
        try {
            switch (i) {
                case 0:
                    // 代理 equals
                    return proxy.equals(objArr[0]);
                case 1:
                    // 代理 toString
                    return proxy.toString();
                case 2:
                    // 代理 hashCode
                    return proxy.hashCode();
                case 3:
                    // 代理 clone
                    return proxy.clone();



                case 4:
                    // 构造方法：构造 新的代理类实例
                    return proxy.newInstance(
                                (Class[]) objArr[0],
                                (Object[]) objArr[1],
                                (Callback[]) objArr[2]);
                case 5:
                    // 构造方法：构造 新的代理类实例
                    return proxy.newInstance(
                                (Callback[]) objArr[0]);
                case 6:
                    // 构造方法：构造 新的代理类实例
                    return proxy.newInstance(
                                (Callback) objArr[0]);


                case 7:
                    // 原始 equals
                    return proxy.CGLIB$equals$2(objArr[0]);

                case 8:
                    // 静态钩子
                    ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.CGLIB$STATICHOOK1();
                    return null;

                // ========通常走这里=========
                case 9:
                    // 原始 getConcreteMethodB
                    return proxy.CGLIB$getConcreteMethodB$0(((Number) objArr[0]).intValue());
                case 14:
                    // 代理 getConcreteMethodB
                    return proxy.getConcreteMethodB(((Number) objArr[0]).intValue());

                case 11:
                    // 原始 getConcreteMethodA
                    return proxy.CGLIB$getConcreteMethodA$1((String) objArr[0]);
                case 16:
                    // 代理 getConcreteMethodA
                    return proxy.getConcreteMethodA((String) objArr[0]);


                case 10:
                    // 原始 toString
                    return proxy.CGLIB$toString$3();
                case 12:
                    // 原始 hashCode
                    return proxy.CGLIB$hashCode$4();
                case 13:
                    // 原始 clone
                    return proxy.CGLIB$clone$5();




                case 15:
                    proxy.setCallback(((Number) objArr[0]).intValue(), (Callback) objArr[1]);
                    return null;





                case 17:
                    proxy.setCallbacks((Callback[]) objArr[0]);
                    return null;

                case 18:
                    // 静态方法
                    ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.CGLIB$SET_STATIC_CALLBACKS((Callback[]) objArr[0]);
                    return null;
                case 19:
                    // 静态方法
                    ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.CGLIB$SET_THREAD_CALLBACKS((Callback[]) objArr[0]);
                    return null;


                case 20:
                    return proxy.getCallback(((Number) objArr[0]).intValue());
                case 21:
                    return proxy.getCallbacks();


                case 22:
                    // 静态方法
                    return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.CGLIB$findMethodProxy((Signature) objArr[0]);

                default:
                    throw new IllegalArgumentException("Cannot find matching method/constructor");
            }
        } catch (Throwable unused) {
            throw new InvocationTargetException(unused, i+"");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    // 构造 代理类 实例
    @Override
    public Object newInstance(int i, Object[] objArr) throws InvocationTargetException {
        try {
            switch (i) {
                case 0:
                    return new ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885();
                default:
                    throw new IllegalArgumentException("Cannot find matching method/constructor");
            }
        } catch (Throwable unused) {
            throw new InvocationTargetException(unused, i+"");
        }
    }

    @Override
    public int getMaxIndex() {
        return 22;
    }
}