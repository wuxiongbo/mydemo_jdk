package reflect.proxy.proxy_aop.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class AOPHandle implements InvocationHandler {

	// 增强方法
	private AOPMethod method;

	// 保存原始对象
	private Object o;

	public AOPHandle(Object o, AOPMethod method) {
		this.o=o;
		this.method=method;
	}
	/**
	 * 这个方法会自动调用,
	 * Java动态代理机制会传入下面几个参数
	 * @param  proxy	Object  代理对象的接口,不同于对象
	 * @param  method	Method  被调用方法
	 * @param  args    Object[] 方法参数
	 * 不能使用invoke时使用proxy作为反射参数时,因为代理对象的接口,不同于对象
	 * 这种代理机制是面向接口，而不是面向类的
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret=null;

		//修改的地方在这里哦
		this.method.before(proxy, method, args);

		// 执行原始方法
		ret = method.invoke(o, args);

		//修改的地方在这里哦
		this.method.after(proxy, method, args);

		return ret;
	}
}
