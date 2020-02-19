package Assignment1_CodeProvided;

public class Student {
	
	private String studentName;
	private String studentEmail;
	private String studentId;
	//Constructor 
	public Student(String studentName, String studentEmail,String studentId) {
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentId = studentId;
		}
			//Getter method
			public String getStudentName() {	
				return studentName;}
			public String getStudentEmail() {
				return studentEmail;} 
			public String getStudentId() {
				return studentId;} 
			//setter method
			public void setStudentName(String studentName) {
				this.studentName=studentName;} 
			public void setStudentEmail(String studentEmail) {
				this.studentEmail=studentEmail;}
			public void setStudentID(String studentId) {
				this.studentId=studentId;}
			//tostring method
		public String toString() {
			String s="";
			s="Student Name:"+"\t"+studentName+"\n"+
							 "Studen Email:"+"\t"+studentEmail+"\n"+
							 "Student ID:"+"\t"+studentId;
			return s;}
		
}
