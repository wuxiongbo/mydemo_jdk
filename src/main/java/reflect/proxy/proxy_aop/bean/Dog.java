package reflect.proxy.proxy_aop.bean;


import reflect.proxy.proxy_aop.annon.Seven;

public class Dog implements Animal {

	@Seven(value = "Lumia")
	private String name;

	private String Property;

	public Dog() {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void say() {
		System.out.println("С��:��������.....");
	}

	@Override
	@Seven(Property = "ˮ½����սʿ")
	public void setProperty(String Property) {
		this.Property = Property;
	}

	@Override
	public void getProperty() {
		System.out.println(this.name + this.Property);
	}
}
