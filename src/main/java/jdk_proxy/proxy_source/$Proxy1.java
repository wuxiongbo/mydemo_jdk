package jdk_proxy.proxy_source;

import jdk_proxy.bean.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * <p> jdk生成的代理类 </p>
 *
 *   m4 sayGoodBye
 *   m3 sayHello
 *
 *   m2 toString
 *   m1 equals
 *   m0 hashCode
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/31
 * </pre>
 */
public final class $Proxy1 extends Proxy implements Person {
    // 接口的方法对象
    private static Method m4;
    private static Method m3;

    // Object的方法对象
    private static Method m2;
    private static Method m1;
    private static Method m0;

    // 2） 依赖注入 委托类 InvocationHandler h。  保存为  Proxy 的成员变量
    public $Proxy1(InvocationHandler var1)  {
        super(var1);
    }


    @Override
    public final void sayGoodBye(boolean var1, double var2)  {
        try {
            // 无返回值。调用被代理类的方法时，都会委托给这个委托类的invoke方法
            super.h.invoke(this, m4, new Object[]{var1, var2});
        } catch (RuntimeException | Error var5) {
            throw var5;
        } catch (Throwable var6) {
            throw new UndeclaredThrowableException(var6);
        }
    }

    @Override
    public final void sayHello(String var1, int var2)  {
        try {
            // 无返回值。调用被代理类的方法时，都会委托给这个委托类的invoke方法
            super.h.invoke(this, m3, new Object[]{var1, var2});
        } catch (RuntimeException | Error var4) {
            throw var4;
        } catch (Throwable var5) {
            throw new UndeclaredThrowableException(var5);
        }
    }


    // Object 的方法
    @Override
    public final String toString()  {
        try {
            // 有返回值。 调用被代理类的方法时，都会委托给这个委托类的invoke方法
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
    @Override
    public final boolean equals(Object var1)  {
        try {
            // 有返回值。 调用被代理类的方法时，都会委托给这个委托类的invoke方法
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }
    @Override
    public final int hashCode()  {
        try {
            // 有返回值。 调用被代理类的方法时，都会委托给这个委托类的invoke方法
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }




    // 1）反射获取 接口的方法对象
    static {
        try {

            m4 = Class.forName("jdk_proxy.bean.Person").getMethod("sayGoodBye", Boolean.TYPE, Double.TYPE);
            m3 = Class.forName("jdk_proxy.bean.Person").getMethod("sayHello", Class.forName("java.lang.String"), Integer.TYPE);

            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");

        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
}
