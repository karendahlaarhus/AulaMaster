package beans;

public class EnrolledStudent {
	private String nieStudent;
	private int idCourse;
	
	public EnrolledStudent(String nieStudent, int idCourse) {
		this.nieStudent = nieStudent;
		this.idCourse = idCourse;
	}
	
	public String getNieStudent() {
		return nieStudent;
	}
	
	public void setNieStudent(String nieStudent) {
		this.nieStudent = nieStudent;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	
}
