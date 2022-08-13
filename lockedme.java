import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

class Employee{
	String ename;
	int eage;
	int salary;
	
	Employee(String ename,int eage,int salary){
		this.eage = eage;
		this.ename = ename;
		this.salary = salary;
	}
	public String toString() {
		return eage+" "+ename +salary;
	}
}
class menuOptions {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("\t\t\t\t   Welcome to LockedMe \n\t\t\t\tDeveloped by Krithe Kishan");
		System.out.println("Please make the selections based on the following options");
			Scanner scanner = new Scanner(System.in);
			Scanner scanner1 = new Scanner(System.in);
			int choice;
			File file = new File("employee.txt");
			ArrayList<Employee> al = new ArrayList<Employee>();
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			@SuppressWarnings("rawtypes")
			ListIterator li = null;
			
			if(file.isFile()) {
				ois = new ObjectInputStream(new FileInputStream(file));
				al = (ArrayList<Employee>)ois.readObject();
				ois.close();
			}
			do{
				System.out.println("1.ADD FILE");
				System.out.println("2.DELETE FILE");
				System.out.println("3.SEARCH FILE");
				System.out.println("4.EXIT");
				System.out.println("\nPlease make a choice:");
				choice = scanner.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Enter number of employees");
					int n = scanner.nextInt();
					for(int i=0; i<n; i++) {
						
					
					System.out.println("Enter employee name");
					String ename = scanner1.nextLine();
					
					System.out.println("Enter employee age");
					int eage = scanner.nextInt();
					
					System.out.println("Enter employee salary");
					int salary = scanner.nextInt();
					
					al.add(new Employee(ename,eage,salary));
					}
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					break;
				case 2:
					li = al.listIterator();
					while(li.hasNext())
					System.out.println(li.next());
					
					
					
					
					break;
					
				}
				
				
			}while (choice!=0);
		}

	
}

