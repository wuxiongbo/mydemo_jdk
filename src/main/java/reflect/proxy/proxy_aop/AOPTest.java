package reflect.proxy.proxy_aop;


import reflect.proxy.proxy_aop.aop.AOPMethod;
import reflect.proxy.proxy_aop.bean.Animal;
import reflect.proxy.proxy_aop.bean.Dog;
import reflect.proxy.proxy_aop.factory.AnimalFactory;

import java.lang.reflect.Method;


public class AOPTest {

	public static void main(String[] args) {

		// �ɹ��������� dog ����ʵ��ע��ע��
		Animal dog = AnimalFactory.getAnimal(Dog.class, new AOPMethod() {
			// ����д����ִ��ǰ��AOP���뷽��
			@Override
			public void before(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("�ɹ�����" + method.getName() + "����,����");
				}
			}

			// ����д����ִ�к��AOP���뷽��
			@Override
			public void after(Object proxy, Method method, Object[] args) {
				if (method.getName().equals("getProperty")) {
					System.err.println("�ɹ�����" + method.getName() + "����,����");
				}
			}
		});


		dog.say();
		String name1 =  dog.getName();
		System.out.println("�ҵ�������" + name1);

		dog.setName("������");

		String name2 =  dog.getName();
		System.out.println("�ҵ�������" + name2);

		dog.getProperty();
	}

	private static void test(){
		Dog dog = new Dog();

		System.out.println(dog.getName());

		dog.getProperty();
	}
}
