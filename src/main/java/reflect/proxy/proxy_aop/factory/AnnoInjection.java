package reflect.proxy.proxy_aop.factory;


import reflect.proxy.proxy_aop.annon.Seven;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 实现注解注入
 * @author Administrator
 */
public class AnnoInjection {

	/**
	 *
	 * @param obj  已经实例化的对象。 可理解为纯静态
	 * @return
	 */
	public static Object getBean(Object obj) {
		try {
			// 获得类的属性
			Field f[] = obj.getClass().getDeclaredFields();
			// 遍历类的属性
			for (Field ff : f) {
				// 获得属性上的 @Seven 注解
				Seven s = ff.getAnnotation(Seven.class);
				if (s != null) {
					System.err.println("注入" + ff.getName() + "属性" + "\t\t" + s.value());
					// 反射调用 类的 public set方法，将注解的值注入到类的属性。如果为访问级别private,那么可以直接使用属性的 set(obj, value);
					obj.getClass()
							.getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
									new Class<?>[] { String.class })
							.invoke(obj, s.value());
				}
			}
			// 获得类的所有方法
			Method m[] = obj.getClass().getDeclaredMethods();
			for (Method mm : m) {
				// 获得类的方法上的注解
				Seven s = mm.getAnnotation(Seven.class);
				if (s != null) {
					System.err.println("注入" + mm.getName() + "方法" + "\t" + s.Property());
					mm.invoke(obj, s.Property());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
