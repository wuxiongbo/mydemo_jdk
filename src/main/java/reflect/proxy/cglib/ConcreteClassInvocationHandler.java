package reflect.proxy.cglib;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2022/3/15
 * </pre>
 */
public class ConcreteClassInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        if(method.getDeclaringClass() != Object.class
                && method.getReturnType() == String.class){
            return "hello cglib";
        }else{
            throw new RuntimeException("Do not know what to do");
        }
    }
}
