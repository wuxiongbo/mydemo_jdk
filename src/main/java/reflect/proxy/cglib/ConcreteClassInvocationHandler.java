package reflect.proxy.cglib;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>描述类的信息</p>
 *
 * InvocationHandler 中， 调用的任何 原代理类 的方法，均会重新代理到 invoke方法 中。从而造成死循环
 * 为了避免这种死循环，我们可以使用 MethodInterceptor
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/3/15
 * </pre>
 */
public class ConcreteClassInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws InvocationTargetException, IllegalAccessException
    {

        // 拦截条件：非 Object 方法，且 返回值为 String 。
        if(method.getDeclaringClass() != Object.class
                && method.getReturnType() == String.class){
            return "hello cglib";
        }else{
//            throw new RuntimeException("Do not know what to do");
            return method.invoke(proxy,args);
        }
    }
}
