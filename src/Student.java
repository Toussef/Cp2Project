import java.util.*;
import java.util.InputMismatchException;
class InvalidGrade extends Exception{
	public InvalidGrade(){
		
	}
	public InvalidGrade(String message) {
		super(message);
	}
	public String toString(){
		return "Invalid grade, input a valid one";
	}
}
class InvalidType extends Exception{
	public InvalidType() {
		
	}
	public InvalidType(String message) {
		super(message);
	}
	public String toString() {
		return "Invalid type";
	}
}
public class Student {
	private int id;
	private String name;
	private String type;
	private double grade;
	private LinkedList<Student> students;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Student() {
		students = new LinkedList<Student>();
	}
	public Student(int id, String name,String type,double grade) {
		this.id = id;
		this.name=name;
		this.type= type;
		this.grade=grade;
	}
	
	public void addName(Student student) {
		students.add(student);
		sortNames();
		
	}
	public void sortNames(){
		for(int i = 0;i<students.size();i++) {
			for(int j = 1;j<students.size();j++) {
				if(students.get(i).getName().compareTo(students.get(j).getName())>0) {
					Student temp = students.get(i);
					students.set(i, students.get(j));
					students.set(j, temp);
				}
			}
		}
	}
	public void delete(String name) {
		ListIterator<Student> lt = students.listIterator();
		while(lt.hasNext()) {
			Student s = lt.next();
			if(s.getName().equalsIgnoreCase(name)) {
				lt.remove();
			}
		}
	}
	public void reverse() {
		ListIterator<Student> lt = students.listIterator();
		while(lt.hasPrevious()) {
			Student s = lt.previous();
			System.out.println(s.toString());
		}
	}
	public String toString() {
		return id+ " "+name+ type+" "+grade;
	}
	public void displayAll() {
		ListIterator<Student> lt = students.listIterator();
		while(lt.hasNext()) {
			Student s = lt.next();
			System.out.println(s.toString());
			
		}
	}

	public void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Student slist = new Student();
		for(int i = 0;i<5;i++) {
			int a = 0;
			while(a!=1) {	
				try {
					int id = scan.nextInt();
					scan.nextLine();
					a = 1;
				}catch(InputMismatchException e1) {
					e1.printStackTrace();
				}
			}
			String name = scan.nextLine();
			String type = "";
			double grade = 0;
			int x = 0;
			while(x!=1) {
			try {
				 
					String type1 = scan.nextLine();
					if (type1.equalsIgnoreCase("grad")||type1.equalsIgnoreCase("UnderGrad")) {
						type1 = type;
						x=1;
					}else {
						throw new InvalidType();
					}
				
				}catch(InvalidType e1) {
					System.out.println(e1.toString());
			}
		}
		int y = 0;
		while(y!=1) {
				try {
				
					double grade1 = scan.nextInt();
					scan.nextLine();
					if(grade1>=0&&grade1<=100) {
						grade1=grade;
						y = 1;
					}else {
						throw new InvalidGrade();
					}
				}
			catch(InvalidGrade e1) {
				System.out.println(e1.toString());
			}
			slist.addName(new Student(id,name,type,grade));
	
			
		}slist.displayAll();
		slist.delete("maya");
		slist.reverse();
	}
}

}

