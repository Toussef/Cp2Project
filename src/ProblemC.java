import java.util.*;
public class ProblemC {

	public static void main(String[] args) {
		LinkedList<String> s1 = new LinkedList<String>();
		LinkedList<String> s2 = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		String[] line1 = scan.nextLine().split(" ");
		String[] line2 = scan.nextLine().split(" ");
		for(int i = 0;i<line1.length;i++) {
			s1.add(line1[i]);
		}//System.out.println(s1);
		for(int i = 0;i<line2.length;i++) {
			s2.add(line2[i]);
		}//System.out.println(s2);
		String cond = scan.nextLine();
		if(cond.equalsIgnoreCase("inter")) {
			LinkedList<String> s3 = new LinkedList<String>();
			for(int i = 0;i<s1.size();i++) {
				for(int j = 0;j<s2.size();j++) {
					if(s1.get(i).equalsIgnoreCase(s2.get(j))) {
						s3.add(s1.get(i));
					}
				}
			}
			for(int i  = 0;i<s3.size();i++) {
				System.out.print(s3.get(i) +" ");
			}
		}
		
		else if(cond.equalsIgnoreCase("dif")) {
			LinkedList<String> s3 = new LinkedList<String>();
			//LinkedList<String> s4 = new LinkedList<String>();
			
			for(int i  = 0;i<s1.size();i++) {
				if(!s2.contains(s1.get(i))) {
					s3.add(s1.get(i));
				}
			}
			for(int i = 0;i<s2.size();i++) {
				if(!s1.contains(s2.get(i))) {
					s3.add(s2.get(i));
				}
				}
			for(int i = 0;i<s3.size();i++) {
				System.out.print(s3.get(i)+" ");
				
			}
		}
}
}
