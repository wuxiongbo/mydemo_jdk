package reflect.proxy.cglib.methodproxysource.cglibproxy;

import lombok.SneakyThrows;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import reflect.proxy.cglib.ConcreteClassNoInterface;
import reflect.proxy.cglib.methodproxysource.MethodInterceptor1;
import reflect.proxy.cglib.methodproxysource.MethodProxy1;

import java.lang.reflect.Method;

/**
 * 代理类
 * @author Xander Wu
 * @date 2022/10/26 13:52
 */
public class ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 extends ConcreteClassNoInterface implements Factory {
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static ThreadLocal<Callback[]> CGLIB$THREAD_CALLBACKS = null;
    private static Callback[] CGLIB$STATIC_CALLBACKS = null;

    // 方法拦截器
    private MethodInterceptor1 CGLIB$CALLBACK_0;

    private static Object CGLIB$CALLBACK_FILTER;

    /**
     * 被代理方法
     */
    private static Method CGLIB$getConcreteMethodB$0$Method = null;
    /**
     * 代理方法
     */
    private static MethodProxy1 CGLIB$getConcreteMethodB$0$Proxy = null;

    private static Object[] CGLIB$emptyArgs = null; // 空参



    /**
     * ==============代理方法==========
     */
    private static Method CGLIB$getConcreteMethodA$1$Method = null;


    /**
     * ===========被代理方法============
     */
    private static MethodProxy1 CGLIB$getConcreteMethodA$1$Proxy = null;
    private static Method CGLIB$equals$2$Method = null;
    private static MethodProxy1 CGLIB$equals$2$Proxy = null;
    private static Method CGLIB$toString$3$Method = null;
    private static MethodProxy1 CGLIB$toString$3$Proxy = null;
    private static Method CGLIB$hashCode$4$Method = null;
    private static MethodProxy1 CGLIB$hashCode$4$Proxy = null;
    private static Method CGLIB$clone$5$Method = null;
    private static MethodProxy1 CGLIB$clone$5$Proxy = null;



    /* JADX INFO: Access modifiers changed from: package-private */
    @SneakyThrows(Exception.class)
    public static void CGLIB$STATICHOOK1() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];

        //初始化 代理类 的方法引用
        Class<?> proxyCls = Class.forName("reflect.proxy.cglib.ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885");
        Class<?> objectCls = Class.forName("java.lang.Object");
        Method[] findMethods = ReflectUtils.findMethods(new String[]{
                    "equals", "(Ljava/lang/Object;)Z",
                    "toString", "()Ljava/lang/String;",
                    "hashCode", "()I",
                    "clone", "()Ljava/lang/Object;"},
                objectCls.getDeclaredMethods());
        // equals
        CGLIB$equals$2$Method = findMethods[0];
        CGLIB$equals$2$Proxy = MethodProxy1.create(
                objectCls, proxyCls,
                "(Ljava/lang/Object;)Z",
                "equals",
                "CGLIB$equals$2");
        // toString
        CGLIB$toString$3$Method = findMethods[1];
        CGLIB$toString$3$Proxy = MethodProxy1.create(
                objectCls, proxyCls,
                "()Ljava/lang/String;",
                "toString",
                "CGLIB$toString$3");
        // hashCode
        CGLIB$hashCode$4$Method = findMethods[2];
        CGLIB$hashCode$4$Proxy = MethodProxy1.create(
                objectCls, proxyCls,
                "()I",
                "hashCode",
                "CGLIB$hashCode$4");
        // clone
        CGLIB$clone$5$Method = findMethods[3];
        CGLIB$clone$5$Proxy = MethodProxy1.create(
                objectCls, proxyCls, "()Ljava/lang/Object;",
                "clone",
                "CGLIB$clone$5");



        // 初始化 被代理类 的方法引用
        Class<?> originCls = Class.forName("reflect.proxy.cglib.ConcreteClassNoInterface");
        Method[] findMethods2 = ReflectUtils.findMethods(new String[]{
                    "getConcreteMethodB", "(I)I",
                    "getConcreteMethodA", "(Ljava/lang/String;)Ljava/lang/String;"},
                originCls.getDeclaredMethods());
        // getConcreteMethodB
        CGLIB$getConcreteMethodB$0$Method = findMethods2[0];
        CGLIB$getConcreteMethodB$0$Proxy = MethodProxy1.create(
                originCls, proxyCls,
                "(I)I",
                "getConcreteMethodB",
                "CGLIB$getConcreteMethodB$0");
        // getConcreteMethodA
        CGLIB$getConcreteMethodA$1$Method = findMethods2[1];
        CGLIB$getConcreteMethodA$1$Proxy = MethodProxy1.create(
                originCls, proxyCls,
                "(Ljava/lang/String;)Ljava/lang/String;",
                "getConcreteMethodA",
                "CGLIB$getConcreteMethodA$1");
    }

    /* JADX INFO: Access modifiers changed from: package-private */

    //被代理方法 ( 由 methodProxy.invoke 调用。 这就是为什么在拦截器中调用methodProxy.invoke会死循环，一直在调用拦截器)
    public final int CGLIB$getConcreteMethodB$0(int i) {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.getConcreteMethodB(i);
    }

    //代理方法（ 由 methodProxy.invokeSuper 调用）
    @SneakyThrows(Exception.class)
    @Override
    public final int getConcreteMethodB(int i) {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.getConcreteMethodB(i);
        }
        Object result = null;
        try {
            result = methodInterceptor.intercept(
                    this,
                    CGLIB$getConcreteMethodB$0$Method,
                    new Object[]{ i },
                    CGLIB$getConcreteMethodB$0$Proxy);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        if (result == null) {
            return 0;
        }
        return ((Number) result).intValue();
    }





    /* JADX INFO: Access modifiers changed from: package-private */
    // 原方法
    public final String CGLIB$getConcreteMethodA$1(String str) {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.getConcreteMethodA(str);
    }

    //代理方法（methodProxy.invokeSuper会调用）
    @SneakyThrows(Exception.class)
    @Override
    public final String getConcreteMethodA(String agr0) {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;

        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }

        try {
            return methodInterceptor != null ?
                    (String) methodInterceptor.intercept(
                            this,
                            CGLIB$getConcreteMethodA$1$Method,
                            new Object[]{agr0},
                            CGLIB$getConcreteMethodA$1$Proxy)

                    : ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.getConcreteMethodA(agr0);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean CGLIB$equals$2(Object obj) {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.equals(obj);
    }

    @SneakyThrows(Exception.class)
    @Override
    public final boolean equals(Object obj) {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.equals(obj);
        }
        Object intercept = null;
        try {
            intercept = methodInterceptor.intercept(this, CGLIB$equals$2$Method, new Object[]{obj}, CGLIB$equals$2$Proxy);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        if (intercept == null) {
            return false;
        }
        return ((Boolean) intercept).booleanValue();
    }




    /* JADX INFO: Access modifiers changed from: package-private */
    public final String CGLIB$toString$3() {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.toString();
    }

    @Override
    public final String toString() {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        try {
            return methodInterceptor != null ? (String) methodInterceptor.intercept(this, CGLIB$toString$3$Method, CGLIB$emptyArgs, CGLIB$toString$3$Proxy) : ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }





    /* JADX INFO: Access modifiers changed from: package-private */
    public final int CGLIB$hashCode$4() {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.hashCode();
    }

    @SneakyThrows(Exception.class)
    @Override
    public final int hashCode() {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor == null) {
            return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.hashCode();
        }

        Object intercept = null;
        try {
            intercept = methodInterceptor.intercept(this, CGLIB$hashCode$4$Method, CGLIB$emptyArgs, CGLIB$hashCode$4$Proxy);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        if (intercept == null) {
            return 0;
        }
        return ((Number) intercept).intValue();
    }





    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object CGLIB$clone$5() throws CloneNotSupportedException {
        return ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SneakyThrows(Exception.class)
    @Override
    public final Object clone() throws CloneNotSupportedException {
        MethodInterceptor1 methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        try {
            return methodInterceptor != null ?
                    methodInterceptor.intercept(this, CGLIB$clone$5$Method, CGLIB$emptyArgs, CGLIB$clone$5$Proxy)
                    : ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885.super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }



    public static MethodProxy1 CGLIB$findMethodProxy(Signature signature) {
        String obj = signature.toString();
        switch (obj.hashCode()) {
            case -508378822:
                if (obj.equals("clone()Ljava/lang/Object;")) {
                    return CGLIB$clone$5$Proxy;
                }
                return null;
            case 825386950:
                if (obj.equals("getConcreteMethodA(Ljava/lang/String;)Ljava/lang/String;")) {
                    return CGLIB$getConcreteMethodA$1$Proxy;
                }
                return null;
            case 1741915687:
                if (obj.equals("getConcreteMethodB(I)I")) {
                    return CGLIB$getConcreteMethodB$0$Proxy;
                }
                return null;
            case 1826985398:
                if (obj.equals("equals(Ljava/lang/Object;)Z")) {
                    return CGLIB$equals$2$Proxy;
                }
                return null;
            case 1913648695:
                if (obj.equals("toString()Ljava/lang/String;")) {
                    return CGLIB$toString$3$Proxy;
                }
                return null;
            case 1984935277:
                if (obj.equals("hashCode()I")) {
                    return CGLIB$hashCode$4$Proxy;
                }
                return null;
            default:
                return null;
        }
    }

    public ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885() {
        CGLIB$BIND_CALLBACKS(this);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArr) {
        CGLIB$THREAD_CALLBACKS.set(callbackArr);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArr) {
        CGLIB$STATIC_CALLBACKS = callbackArr;
    }

    // 从 当前线程  获取回调数组，然后获取方法拦截器 填充到成员变量
    private static void CGLIB$BIND_CALLBACKS(Object obj) {
        ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 proxy = (ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885) obj;
        if (!proxy.CGLIB$BOUND) {
            proxy.CGLIB$BOUND = true;
            Object callbackArr = CGLIB$THREAD_CALLBACKS.get();
            if (callbackArr == null) {
                callbackArr = CGLIB$STATIC_CALLBACKS;
                if (callbackArr == null) {
                    return;
                }
            }
            proxy.CGLIB$CALLBACK_0 = (MethodInterceptor1) ((Callback[]) callbackArr)[0];
        }
    }

    @Override
    public Object newInstance(Callback[] callbackArr) {
        CGLIB$SET_THREAD_CALLBACKS(callbackArr); // 绑定callback 到 当前线程

        ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 proxy = new ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885();

        CGLIB$SET_THREAD_CALLBACKS(null); // 相当于 threadLocal.remove()
        return proxy;
    }

    @Override
    public Object newInstance(Callback callback) {
        // 绑定callback 到 当前线程
        CGLIB$SET_THREAD_CALLBACKS(new Callback[]{callback});

        ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 proxy = new ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885();

        CGLIB$SET_THREAD_CALLBACKS(null); // 相当于 threadLocal.remove()
        return proxy;
    }

    @Override
    public Object newInstance(Class[] clsArr, Object[] objArr, Callback[] callbackArr) {
        CGLIB$SET_THREAD_CALLBACKS(callbackArr);  // 绑定callback 到 当前线程

        switch (clsArr.length) {
            case 0:

                ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885 proxy = new ConcreteClassNoInterface$$EnhancerByCGLIB$$bd737885();

                CGLIB$SET_THREAD_CALLBACKS(null);  // 相当于 threadLocal.remove()
                return proxy;
            default:
                throw new IllegalArgumentException("Constructor not found");
        }
    }

    @Override
    public Callback getCallback(int i) {
        CGLIB$BIND_CALLBACKS(this);
        switch (i) {
            case 0:
                return this.CGLIB$CALLBACK_0;
            default:
                return null;
        }
    }

    @Override
    public void setCallback(int i, Callback callback) {
        switch (i) {
            case 0:
                this.CGLIB$CALLBACK_0 = (MethodInterceptor1) callback;
                return;
            default:
                return;
        }
    }

    @Override
    public Callback[] getCallbacks() {
        CGLIB$BIND_CALLBACKS(this);
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    @Override
    public void setCallbacks(Callback[] callbackArr) {
        this.CGLIB$CALLBACK_0 = (MethodInterceptor1) callbackArr[0];
    }

    static {
        CGLIB$STATICHOOK1();
    }
}