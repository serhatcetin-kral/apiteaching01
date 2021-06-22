package pojo;

public class Data {

	private int id;
	private String name;
	private int salary;
	private String depertmant;
	private int age;
	int getId() {
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepertmant() {
		return depertmant;
	}
	public void setDepertmant(String depertmant) {
		this.depertmant = depertmant;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Data(int id, String name, int salary, String depertmant, int age) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.depertmant = depertmant;
		this.age = age;
	}
	public Data() {
	
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", salary=" + salary + ", depertmant=" + depertmant + ", age="
				+ age + "]";
	}
	
	
	
	
}
