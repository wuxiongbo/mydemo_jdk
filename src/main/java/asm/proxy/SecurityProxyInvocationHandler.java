package asm.proxy;

import asm.decorator.Account;
import asm.decorator.SecurityChecker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/23
 * </pre>
 */
public class SecurityProxyInvocationHandler implements InvocationHandler {
    private Object proxyedObject;
    public SecurityProxyInvocationHandler(Object o) {
        proxyedObject = o;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] arguments)
            throws Throwable {
        if (object instanceof Account && method.getName().equals("operation")) {
            SecurityChecker.checkSecurity();
        }
        return method.invoke(proxyedObject, arguments);
    }
}
