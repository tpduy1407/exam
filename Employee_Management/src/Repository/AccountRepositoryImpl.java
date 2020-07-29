package Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AccountRepositoryImpl implements AccountRepository {
  
	@Override
	public  void login() {
		Scanner scan = new Scanner(System.in);
		boolean isExist = true;
		System.out.println("*=====Login=====*");
		while(isExist) {
			System.out.println("Username: ");
	        String input = scan.nextLine();
			System.out.println("Password");
			String input1 = scan.nextLine();
			isExist(input,input1);
			System.out.println("*===============*");
		}
		
	
	}

	public boolean isExist( String username , String password) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employee_management", "root", "123");
			Statement stmt = con.createStatement();
			String SQL = "SELECT * FROM account Where username='" + username +  "'" + "and password = '" + password +"'";
			ResultSet rs = stmt.executeQuery(SQL);
			if(rs.next()) {
				
				System.out.println(" already logined");
				isAdmin();
				
			}else {
				System.out.println("Login failed - " + " " + "please insert again !!!");
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
 		}
		return true;
	}

	@Override
	public boolean isAdmin(String role_id) {
		System.out.print("----ADMIN----");
		System.out.println("1. Create new employee");
		System.out.println("1. Update Employee's Information");
		System.out.println("1. Delete Employee's Information");
		return false;
	}

//	@Override
//	public boolean isExist(String username, String password) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
