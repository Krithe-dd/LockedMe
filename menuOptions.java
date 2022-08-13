import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("\t\t\t\t   Welcome to LockedMe \n\t\t\t\tDeveloped by Krithe Kishan");
		System.out.println("Please make the selections based on the following options");
			Scanner scanner = new Scanner(System.in);
			Scanner scanner1 = new Scanner(System.in);
			int choice = -1;
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
				System.out.println("2.DISPLAY FILE");
				System.out.println("3.SEARCH FILE");
				System.out.println("4.DELETE FILE");
				System.out.println("5.SORT");
				System.out.println("6.SORT PERMANENTLY");
				System.out.println("0.EXIT");
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
					int enumb = scanner.nextInt();
					
					System.out.println("Enter employee salary");
					int salary = scanner.nextInt();
					
					al.add(new Employee(ename,enumb,salary));
					}
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
					break;
				case 2:
					if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					System.out.println("------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("------------");
					}else {
						System.out.println("File not found");
					}
					break;
				case 3:
					if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					boolean found = false;
					System.out.println("Enter employee number to search:");
					int enumb = scanner.nextInt();
					System.out.println("------------");
					li = al.listIterator();
					while(li.hasNext()) {
					Employee e = (Employee)li.next();	
					if(e.enumb == enumb) {
					System.out.println(e);
					found = true;
					}
					}
					if(!found)
						System.out.println("Record not found...");
					System.out.println("------------");
					}else {
						System.out.println("File not found");
					}
					break;
				case 4:
					if(file.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(file));
						al = (ArrayList<Employee>)ois.readObject();
						ois.close();
						boolean found = false;
						System.out.print("Enter employee number to search:");
						int enumb = scanner.nextInt();
						System.out.println("------------");
						li = al.listIterator();
						while(li.hasNext()) {
						Employee e = (Employee)li.next();	
						if(e.enumb == enumb) {
						li.remove();
						found = true;
						}
						}
						if(found) {
							oos = new ObjectOutputStream(new FileOutputStream(file));
							oos.writeObject(al);
							oos.close();
							System.out.println("Record deleted successfully");
						}else {
							System.out.println("Record not found...");
						}
							System.out.println("------------");
						}else {
							System.out.println("File not found");
						}
						break;
				case 5:
					if(file.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(file));
						al = (ArrayList<Employee>)ois.readObject();
						ois.close();
						
						Collections.sort(al,new Comparator<Employee>(){
							public int compare(Employee e1, Employee e2) {
								return e1.enumb - e2.enumb;
							}
						});
						
						System.out.println("------------");
						li = al.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("------------");
						}else {
							System.out.println("File not found");
						}
						break;
				case 6:
					if(file.isFile()) {
						ois = new ObjectInputStream(new FileInputStream(file));
						al = (ArrayList<Employee>)ois.readObject();
						ois.close();
						
						Collections.sort(al,new Comparator<Employee>(){
							public int compare(Employee e1, Employee e2) {
								return e1.enumb - e2.enumb;
							}
						});
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(al);
						oos.close();
						
						System.out.println("------------");
						li = al.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("------------");
						}else {
							System.out.println("File not found");
						}
						break;
				}
				
				
			}while (choice!=0);
		}

        
    }
