package reflect.proxy.cglib;

/*
 * Copyright 2003,2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.sf.cglib.core.AbstractClassGenerator;
import net.sf.cglib.core.CodeGenerationException;
import net.sf.cglib.core.GeneratorStrategy;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.reflect.FastClass;

/**
 * Classes generated by {@link Enhancer} pass this object to the
 * registered {@link MethodInterceptor} objects when an intercepted method is invoked. It can
 * be used to either invoke the original method, or call the same method on a different
 * object of the same type.
 * @version $Id: MethodProxy.java,v 1.16 2009/01/11 20:09:48 herbyderby Exp $
 */
public class MethodProxy1 {
    private Signature sig1;  //被代理方法签名
    private Signature sig2;  //代理方法签名
    private CreateInfo createInfo;

    private final Object initLock = new Object();
    private volatile FastClassInfo fastClassInfo;

    /**
     *
     * c1:    被代理对象Class
     * c2:    代理对象Class
     * desc：  入参类型
     * name1:  被代理方法名
     * name2:  代理方法名
     *
     * For internal use by {@link Enhancer} only; see the {@link net.sf.cglib.reflect.FastMethod} class
     * for similar functionality.
     */
    public static MethodProxy1 create(Class c1, Class c2, String desc, String name1, String name2) {
        MethodProxy1 proxy = new MethodProxy1();
        proxy.sig1 = new Signature(name1, desc);  //被代理方法签名
        proxy.sig2 = new Signature(name2, desc);  //代理方法签名
        proxy.createInfo = new MethodProxy1.CreateInfo(c1, c2);
        return proxy;
    }

    // MethodProxy 的 invoke/invokeSuper ，都调用了init()
    private void init()
    {
        /*
         * Using a volatile invariant allows us to initialize the FastClass and
         * method index pairs atomically.
         *
         * Double-checked locking is safe with volatile in Java 5.  Before 1.5 this
         * code could allow fastClassInfo to be instantiated more than once, which
         * appears to be benign.
         */
        if (fastClassInfo == null)
        {
            synchronized (initLock)
            {
                if (fastClassInfo == null)
                {
                    CreateInfo ci = createInfo;

                    //  FastClass并不是跟代理类一块生成的，而是在第一次执行 MethodProxy invoke/invokeSuper时 生成的，并放在了缓存中。
                    FastClassInfo fci = new MethodProxy1.FastClassInfo();
                    fci.f1 = helper(ci, ci.c1);      // 如果缓存中有，就取出；没有，就生成新的 FastClass
                    fci.f2 = helper(ci, ci.c2);
                    fci.i1 = fci.f1.getIndex(sig1);  // 获取方法的index
                    fci.i2 = fci.f2.getIndex(sig2);
                    fastClassInfo = fci;
                    createInfo = null;
                }
            }
        }
    }

    private static class FastClassInfo
    {
        FastClass f1;  //被代理类FastClass
        FastClass f2;  //代理类FastClass
        int i1;        //被代理类的方法签名(index)
        int i2;        //代理类的方法签名
    }

    private static class CreateInfo
    {
        Class c1;  // 被代理对象Class
        Class c2;  // 代理对象Class
        NamingPolicy namingPolicy;
        GeneratorStrategy strategy;
        boolean attemptLoad;

        public CreateInfo(Class c1, Class c2)
        {
            this.c1 = c1;
            this.c2 = c2;
            AbstractClassGenerator fromEnhancer = AbstractClassGenerator.getCurrent();
            if (fromEnhancer != null) {
                namingPolicy = fromEnhancer.getNamingPolicy();
                strategy = fromEnhancer.getStrategy();
                attemptLoad = fromEnhancer.getAttemptLoad();
            }
        }
    }

    private static FastClass helper(MethodProxy1.CreateInfo ci, Class type) {
        FastClass.Generator g = new FastClass.Generator();
        g.setType(type);
        g.setClassLoader(ci.c2.getClassLoader());
        g.setNamingPolicy(ci.namingPolicy);
        g.setStrategy(ci.strategy);
        g.setAttemptLoad(ci.attemptLoad);
        return g.create();
    }

    private MethodProxy1() {
    }

    /**
     * Return the signature of the proxied method.
     */
    public Signature getSignature() {
        return sig1;
    }

    /**
     * Return the name of the synthetic method created by CGLIB which is
     * used by {@link #invokeSuper} to invoke the superclass
     * (non-intercepted) method implementation. The parameter types are
     * the same as the proxied method.
     */
    public String getSuperName() {
        return sig2.getName();
    }

    /**
     * Return the {@link net.sf.cglib.reflect.FastClass} method index
     * for the method used by {@link #invokeSuper}. This index uniquely
     * identifies the method within the generated proxy, and therefore
     * can be useful to reference external metadata.
     * @see #getSuperName
     */
    public int getSuperIndex() {
        init();
        return fastClassInfo.i2;
    }

    // For testing
    FastClass getFastClass() {
        init();
        return fastClassInfo.f1;
    }

    // For testing
    FastClass getSuperFastClass() {
        init();
        return fastClassInfo.f2;
    }

    static final String EMPTY_ARGS_NAME = "CGLIB$emptyArgs";
    static final String FIND_PROXY_NAME = "CGLIB$findMethodProxy";
    static final Class[] FIND_PROXY_TYPES = { Signature.class };


    /**
     * Return the <code>MethodProxy</code> used when intercepting the method
     * matching the given signature.
     * @param type the class generated by Enhancer
     * @param sig the signature to match
     * @return the MethodProxy instance, or null if no applicable matching method is found
     * @throws IllegalArgumentException if the Class was not created by Enhancer or does not use a MethodInterceptor
     */
    public static MethodProxy1 find(Class type, Signature sig) {
        try {
            Method m = type.getDeclaredMethod(FIND_PROXY_NAME,
                    FIND_PROXY_TYPES);
            return (MethodProxy1)m.invoke(null, new Object[]{ sig });
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + type + " does not use a MethodInterceptor");
        } catch (IllegalAccessException e) {
            throw new CodeGenerationException(e);
        } catch (InvocationTargetException e) {
            throw new CodeGenerationException(e);
        }
    }

    /**
     * Invoke the original method, on a different object of the same type.
     * @param obj the compatible object; recursion will result if you use the object passed as the first
     * argument to the MethodInterceptor (usually not what you want)
     * @param args the arguments passed to the intercepted method; you may substitute a different
     * argument array as long as the types are compatible
     * @see MethodInterceptor#intercept
     * @throws Throwable the bare exceptions thrown by the called method are passed through
     * without wrapping in an <code>InvocationTargetException</code>
     */
    public Object invoke(Object obj, Object[] args) throws Throwable {
        try {
            init();
            MethodProxy1.FastClassInfo fci = fastClassInfo;
            return fci.f1.invoke(fci.i1, obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (IllegalArgumentException e) {
            if (fastClassInfo.i1 < 0)
                throw new IllegalArgumentException("Protected method: " + sig1);
            throw e;
        }
    }

    /**
     * Invoke the original (super) method on the specified object.
     * @param obj the enhanced object, must be the object passed as the first
     * argument to the MethodInterceptor
     * @param args the arguments passed to the intercepted method; you may substitute a different
     * argument array as long as the types are compatible
     * @see MethodInterceptor#intercept
     * @throws Throwable the bare exceptions thrown by the called method are passed through
     * without wrapping in an <code>InvocationTargetException</code>
     */
    public Object invokeSuper(Object obj, Object[] args) throws Throwable {
        try {
            init();
            FastClassInfo fci = fastClassInfo;
            return fci.f2.invoke(fci.i2, obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}