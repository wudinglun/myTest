package myTest;

public class student {
	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	private String name;
	private String age;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
