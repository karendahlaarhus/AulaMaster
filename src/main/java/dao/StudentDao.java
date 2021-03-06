package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.dbConnection;
import beans.Student;

public class StudentDao {
	
	/**
	 * Creates a student in the Students table in the database
	 * @param student
	 * @throws SQLException
	 * @throws NamingException
	 */
	
	public static void createStudent(Student student) throws SQLException, NamingException {		
		Connection con = dbConnection.openConnection();
		
		String sql = "INSERT INTO Students (nie, name, surname, date_of_birth) VALUES (?,?,?,?)";
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, student.getNie());
		stm.setString(2, student.getName());
		stm.setString(3, student.getSurname());
		
		Date sqlBirthdate = new Date(student.getBirthdate().getTime());
		stm.setDate(4, sqlBirthdate);
		stm.executeUpdate();
		
		con.close();
	}
	
	
	/**
	 * Get a list of all students in the database
	 * @return a list of all students
	 * @throws SQLException
	 * @throws NamingException
	 */
	
	public static List<Student> getStudents() throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT * from Students";
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		
		
		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student s = new Student(rs.getString("nie"), rs.getString("name"), rs.getString("surname"), rs.getDate("date_of_birth"));
			students.add(s);
		}
		
		con.close();
		
		return students;
	}
	
	/**
	 * Delets a student from the database by using their NIE
	 * @param nie: uniqe ID
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static void deleteStudent(String nie) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql =  "DELETE FROM Students WHERE nie = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, nie);
		
		stm.executeUpdate();
		
		con.close();
		
	}
	
	/**
	 * Updates a student. All values are updated eventhough they might not be different
	 * @param nie
	 * @param name
	 * @param surname
	 * @param birthdate
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static void updateStudent(String nie, String name, String surname, java.util.Date birthdate) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "UPDATE Students SET name = ?, surname = ?, date_of_birth = ? WHERE nie = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, name);
		stm.setString(2, surname);
		
		Date sqlBirthdate = new Date(birthdate.getTime());
		stm.setDate(3, sqlBirthdate);
		
		stm.setString(4, nie);
		
		stm.executeUpdate();
		
		con.close();
	}
}
