package schoolManagement.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import schoolManagement.Driver.Student;

public class StudentService{
public StudentService() {
	System.out.println("student service object created");
}
static Connection con;
static {
	 String url = "jdbc:postgresql://localhost:5432/student";
	 String user = "postgres";
	 String pswd = "123";
	 try {
		System.out.println("driver loaded");
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection(url,user,pswd);
		System.out.println("connected");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
public int save(Student st) {
	int res = 0;
	String sql = "Insert into students values(?,?,?,?,?);";
	try {
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, st.getId());
		pstm.setString(2, st.getName());
		pstm.setInt(3, st.getAge());
		pstm.setString(4,st.getEmail());
		pstm.setString(5,st.getBlood_group());
		res=pstm.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return res;
}
public int updateage(int id,int age) {
	int res=0;
	String sql="update students set age=? where id =?";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, age);
		pstm.setInt(2, id);
		
		res=pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}
public int delete(int id) {

    int result = 0;

    String sql = "DELETE FROM student WHERE id = ?";

    try (
        
        PreparedStatement ps = con.prepareStatement(sql);
    ) {

        ps.setInt(1, id);
        
        
        result = ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return result;
}
public List<Student> fetchAll() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public boolean exits() {
	boolean flag=true;
	
	try {
		con.close();
		flag=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
//public int updateall(int id, int age, String name, String bloodGroup, String emailId) {
//    int res = 0;
//    String sql = "UPDATE students SET age=?, name=?, blood_group=?, email_id=? WHERE id=?";
//
//    try {
//        PreparedStatement pstm = con.prepareStatement(sql);
//
//        pstm.setInt(1, age);
//        pstm.setString(2, name);
//        pstm.setString(3, bloodGroup);
//        pstm.setString(4, emailId);
//        pstm.setInt(5, id);
//
//        res = pstm.executeUpdate();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return res;
//}

public int updateName(int id,String name) {
	int res=0;
	String sql="update students set neme=? where id =?";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, name);
		pstm.setInt(2, id);
		
		res=pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}
public int updateblood_group(int id,String blood_group) {
	int res=0;
	String sql="update students set blood_group=? where id =?";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, blood_group);
		pstm.setInt(2, id);
		
		res=pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}
public int updateEmail(int id,String email) {
	int res=0;
	String sql="update students set email=? where id =?";
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setInt(2, id);
		
		res=pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
}
public List<Student> fetchbyage() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where age >=21 and age<=27";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<Student> fetchbyAge() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where age ";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<Student> fetchName() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where name like 'M%'";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<Student> fetchNamee() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where name like '%n";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<Student> fetchbybloodGroup() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where blood_group like'A+'or blood_group like 'A-'or blood_group like 'B+'";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
public List<Student> fetchbymail() {

    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM students where email ";

    try (PreparedStatement pstm = con.prepareStatement(sql);
         ResultSet rs = pstm.executeQuery()) {

        while (rs.next()) {

            Student student = new Student(
                rs.getInt(1),      
                rs.getString(2),  
                rs.getInt(3),      
                rs.getString(4),   
                rs.getString(5)    
            );

            list.add(student);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

	
	
}
   
