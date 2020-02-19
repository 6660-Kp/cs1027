package Assignment1_CodeProvided;

public class Course {
		private String courseName;
		private String courseId;
		private String studentId;
		private int studentGrade;
	
	public Course(String courseName,String courseId,String studentId,int studentGrade) {
		this.courseName=courseName;
		this.courseId=courseId;
		this.studentId=studentId;
		this.studentGrade=studentGrade;
		
	}		
	//Getter method
			public String getCourseName() {
				return courseName;}
			public String getCourseId() {
				return courseId;}			
			public String getStudentId() {
				return studentId;}			
			public int getStudentGrade() {
			return studentGrade;}
	//setter method
			public void setCourseName(String courseName){
				this.courseName=courseName; }
			public void setCourseId(String courseId) {
				this.courseId=courseId;}
			public void setStudentId(String studentId) {
				this.studentId=studentId;}
			public void setStudentGrade(int studentGrade) {
				this.studentGrade=studentGrade;}
			
			public String toString() {
				String s="";
				s="Course Name:"+"\t"+courseName+"\n"+
								 "Studen Number:`"+"\t"+courseId+"\n"+
								 "Student ID:"+"\t"+studentId+"\n"+
								 "Student Grade:"+"\t"+studentGrade;
				return s;}
			
	
	
}
