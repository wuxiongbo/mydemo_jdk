package reflect.proxy.proxy_aop.aop;

import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public interface AOPMethod{

	//ʵ������ִ��ǰִ�еķ���
	void after(Object proxy, Method method, Object[] args);

	//ʵ������ִ�к�ִ�еķ���
	void before(Object proxy, Method method, Object[] args);
}