package reflect.proxy.proxy_aop.factory;


import reflect.proxy.proxy_aop.aop.AOPHandle;
import reflect.proxy.proxy_aop.aop.AOPMethod;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class AnimalFactory {

	/***
	 * ��ȡ���󣬻�������
	 * @param obj
	 * @return
	 */
	private static Object getAnimalBase(Object obj, AOPMethod method){
		//��ȡ�������
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), 
				new AOPHandle(
						// ����ʵ���� ע���ֵע��
						AnnoInjection.getBean(obj),
						method));
	}
	
	/***
	 * ��ȡ���󷽷���  by  obj
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Object obj, AOPMethod aopMethod){
		return (T) getAnimalBase(obj,aopMethod);
	}
	/***
	 * ��ȡ���󷽷�  by  className
	 * @param className
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static  <T> T getAnimal(String className, AOPMethod method){
		Object obj=null;
		try {
			obj= getAnimalBase(Class.forName(className).newInstance(),method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)obj;
	}

	/***
	 * ��ȡ���󷽷�  by  clazz
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Class<?> clazz, AOPMethod method){
		Object obj=null;
		try {
			// ��Ŀ�����ʵ�����󡣣���Ϊ���
			obj= getAnimalBase(clazz.newInstance(),method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)obj;
	}
}
