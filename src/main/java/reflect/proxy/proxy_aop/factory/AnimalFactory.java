package reflect.proxy.proxy_aop.factory;


import reflect.proxy.proxy_aop.aop.AOPHandle;
import reflect.proxy.proxy_aop.aop.AOPMethod;

import java.lang.reflect.Proxy;

/**
 * @author Administrator
 */
public class AnimalFactory {

	/***
	 * 获取对象，基础方法
	 * @param obj
	 * @return
	 */
	private static Object getAnimalBase(Object obj, AOPMethod method){
		//获取代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), 
				new AOPHandle(
						// 这里实现了 注解的值注入
						AnnoInjection.getBean(obj),
						method));
	}
	
	/***
	 * 获取对象方法。  by  obj
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Object obj, AOPMethod aopMethod){
		return (T) getAnimalBase(obj,aopMethod);
	}
	/***
	 * 获取对象方法  by  className
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
	 * 获取对象方法  by  clazz
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Class<?> clazz, AOPMethod method){
		Object obj=null;
		try {
			// 将目标对象实例化后。，作为入参
			obj= getAnimalBase(clazz.newInstance(),method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T)obj;
	}
}
