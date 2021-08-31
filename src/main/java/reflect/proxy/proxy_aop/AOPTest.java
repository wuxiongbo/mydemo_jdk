package reflect.proxy.proxy_aop;


import reflect.proxy.proxy_aop.aop.AOPMethod;
import reflect.proxy.proxy_aop.bean.Animal;
import reflect.proxy.proxy_aop.bean.Dog;
import reflect.proxy.proxy_aop.factory.AnimalFactory;

import java.lang.reflect.Method;


public class AOPTest {

	public static void main(String[] args) {

		// 由工厂创建的 dog 可以实现注解注入
		Animal dog = AnimalFactory.getAnimal(Dog.class, new AOPMethod() {
			// 这里写方法执行前的AOP切入方法
			@Override
			public void before(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("成功拦截" + method.getName() + "方法,启动");
				}
			}

			// 这里写方法执行后的AOP切入方法
			@Override
			public void after(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("成功拦截" + method.getName() + "方法,结束");
				}
			}
		});


		dog.say();
		String name1 =  dog.getName();
		System.out.println("我的名字是" + name1);

		dog.setName("二狗子");

		String name2 =  dog.getName();
		System.out.println("我的名字是" + name2);

		dog.getProperty();
	}

	private static void test(){
		Dog dog = new Dog();

		System.out.println(dog.getName());

		dog.getProperty();
	}
}
