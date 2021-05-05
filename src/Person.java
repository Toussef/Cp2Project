
public class Person {


	private String	name;
	private int		age;
	private String nationality;
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public Person()
	{
		
	}

	public Person(String _name,int _age,String nationality)
	{
		name = _name;
		age  = _age;
		this.nationality=nationality;
	}
	
	public String toString()
	{
		return "";
	}
}



