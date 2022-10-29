package reflect.proxy.cglib.methodproxysource;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 * @author Xander Wu
 * @date 2022/10/26 13:57
 */
public interface MethodInterceptor1 extends Callback
{
    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     * @param obj "this", the enhanced object
     * @param method intercepted Method
     * @param args argument array; primitive types are wrapped
     * @param proxy used to invoke super (non-intercepted method); may be called
     * as many times as needed
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @see MethodProxy
     */
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy1 proxy) throws Throwable;

}
