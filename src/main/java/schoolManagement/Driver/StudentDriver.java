package schoolManagement.Driver;
import java.security.Provider.Service;
import java.util.List;
import java.util.Scanner;

import schoolManagement.Service.StudentService;


public class StudentDriver{

public static void main(String[] args) {
	StudentService studentservice = new StudentService();
	Scanner sc = new Scanner(System.in);
	System.out.println("welcome to my school");
	
	
	boolean flag = true;
	
	while (flag) {
		
		System.out.println("enter 1 to register a student");
		System.out.println("enter 2 to update a student");
		System.out.println("enter 3 to fetch all students");
		System.out.println("enter 4 to delete a student");
		System.out.println("enter 5 to exit");
		//System.out.println("enter 6 to update all records");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter student id");
			int id = sc.nextInt();
			System.out.println("Enter student name");
			String name = sc.next();
			System.out.println("Enter student age");
			int age = sc.nextInt();
			System.out.println("Enter student email");
			String email = sc.next();

			System.out.println("Enter student blood group");
			String blood_group = sc.next();
		
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			student.setEmail(email);
			student.setBlood_group(blood_group);
			
			
			
			int save = studentservice.save(student);
			if(save!=0)System.out.println("student registeration is done");
			else System.out.println("student regiteration is not done---");
			break;
			
		case 2:
			System.out.println("enter the id to be updated");
			int updateid = sc.nextInt();
			System.out.println("enter the age to be updated");
			int updateage = sc.nextInt();
			
			int update = studentservice.updateage(updateid, updateage);
			
			
			if(update!=0) {
				System.out.println("update done");
			}else {
				System.out.println("update faild");
			}
			break;
//		case 6:System.out.println("enter the id to update all records");
//		int updateidd=sc.nextInt();
//		System.out.println("enter the age to be updated");
//		int updateagee=sc.nextInt();
//		System.out.println("enter the name to be updated");
//		String updatedname=sc.next();
//		System.out.println("enter the blood_group to be updated");
//		String updatedBloodGroup=sc.next();
//		System.out.println("enter the email_id to be updated");
//		String updatedemail=sc.next();
//		int updateall=studentservice.updateall()
		case 3:
			List<Student>list=studentservice.fetchAll();
			if(list!=null) {
				for(Student st:list) {
					System.out.println(st);
					
					
				}
			}
			else {
				System.out.println("no students are available");
			}
			
		case 4: 
			System.out.println("enter the id to be deleted");
			int deleteid = sc.nextInt();
			
			int delete = studentservice.delete(deleteid);
			
			if(delete != 0) {
				System.out.println("data deleted");
			}else {
				System.out.println("data not deleted");
			}
		case 5:
			if(studentservice.exits()) {
				System.out.println("application closed");
				flag=false;
			}
			else {
				System.out.println("application still working");
			}
			break;

		default:
			System.out.println();
			break;
		
		}
		
	}
	
	
	sc.close();
}
}
