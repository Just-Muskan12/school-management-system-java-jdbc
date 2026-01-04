package schoolManagement.Driver;

public class Student {
	private int id;
	private String name;
	private int age;
	private String email;
	private String blood_group;
	public Student() {
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", blood_group="
				+ blood_group + "]";
	}
	public Student(int id, String name, int age, String email, String blood_group) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.blood_group = blood_group;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
}
	