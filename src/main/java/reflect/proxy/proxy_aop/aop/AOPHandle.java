package reflect.proxy.proxy_aop.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class AOPHandle implements InvocationHandler {

	// 保存的 增强实现
	private AOPMethod method;

	// 保存的 原始对象
	private Object o;

	public AOPHandle(Object o, AOPMethod method) {
		this.o=o;
		this.method=method;
	}
	/**
	 * 对原始方法进行增强。
	 * @param  proxy	Object   生成的代理对象。  代理对象 与 原始对象  实现了相同的接口。 ‘代理对象’ 内部保存了 ‘原始对象’
	 * @param  method	Method   接口的方法对象
	 * @param  args     Object[] 调用接口方法时，传的参数值
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 返回值
		Object ret=null;


		//====增强逻辑在这里====
		this.method.before(proxy, method, args);



		// 执行 原始类o 的目标方法
		ret = method.invoke(o, args);



		//====增强逻辑在这里====
		this.method.after(proxy, method, args);


		return ret;
	}
}
