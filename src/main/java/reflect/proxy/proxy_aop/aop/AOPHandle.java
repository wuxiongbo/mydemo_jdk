package reflect.proxy.proxy_aop.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class AOPHandle implements InvocationHandler {

	private AOPMethod method;

	//�������
	private Object o;

	public AOPHandle(Object o, AOPMethod method) {
		this.o=o;
		this.method=method;
	}
	/**
	 * ����������Զ�����,Java��̬�������
	 * �ᴫ�����漸������
	 * @param  proxy	Object  �������Ľӿ�,��ͬ�ڶ���
	 * @param  method	Method  �����÷���
	 * @param  args    Object[] ��������
	 * ����ʹ��invokeʱʹ��proxy��Ϊ�������ʱ,��Ϊ�������Ľӿ�,��ͬ�ڶ���
	 * ���ִ������������ӿڣ��������������
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret=null;

		//�޸ĵĵط�������Ŷ
		this.method.before(proxy, method, args);

		ret=method.invoke(o, args);

		//�޸ĵĵط�������Ŷ
		this.method.after(proxy, method, args);

		return ret;
	}
}
