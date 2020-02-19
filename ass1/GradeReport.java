package Assignment1_CodeProvided;

import java.text.DecimalFormat;
public class GradeReport {
	private String studentId; 
	private String courseId;
	private int studentCt;
	private int courseCt;
	private Student[] studentArray;
	private Course[] courseArray;
	//constructor of GradeReport
	public GradeReport(Student[] studentArray,Course[] courseArray,int studentCt,int courseCt
	){ 						
	this.studentCt=studentCt; this.courseCt=courseCt;  
	this.studentArray = studentArray.clone(); this.courseArray = courseArray.clone(); 
	}
	public String demo(double s) {
		DecimalFormat fmt = new DecimalFormat("#.00");
		return fmt.format(s);
	}
	// getGradeReport method
	 public String getGradesOfCourse(String courseId) {		
		 
		 String s="Grades for Course Id: "+courseId+"\n"; 												
		 double	 mark=0;
		 int count=0;
		//for loop if i smaller then the total number of the course then i+1
		 for(int i=0;i<courseCt;i++) {	
			 /*if the provide course id is equal to the course array in the course array
			 then m+the student grade and then s store the data*/
			 for(int v=0;v<studentCt;v++) {
			 if(courseId.equals(courseArray[i].getCourseId())&&
			courseArray[i].getStudentId().equals(studentArray[v].getStudentId()))
			 {
				 count++;
			 mark=mark+courseArray[i].getStudentGrade();
			s=s+"student Name: "+studentArray[v].getStudentName()+" , "
				+"Grade :"+courseArray[i].getStudentGrade()
				+"\n";
			}
			 }
		 }
		 //get the average
		 	s=s+"The Average of the Course: "+demo(mark/count)+"\n";
		 return s;
	 }
	 
	 public String getGradesOfStudent(String studentId) 
	 {
		
		 String a="Grades for Student Id: "+studentId+"\n";
		 double mark=0;
		 int count=0;
		 for(int v=0;v<studentCt;v++) {
			 //check if find the student
			 if(studentId.equals(studentArray[v].getStudentId())) {
				 
			 for(int i=0;i<courseCt;i++) {
				 //check if student took course 
				 if(studentId.equals(courseArray[i].getStudentId())) {
					mark=mark+courseArray[i].getStudentGrade();
					count++;
					a=a+"student Name: "+studentArray[v].getStudentName()+" , "
							+"Grade : "+courseArray[i].getStudentGrade()+" , "+
							"Course : "+courseArray[i].getCourseId()
							+"\n";}
			 }
			 }
			
		 	 }
		 //check if have the grade or not 
		 if(count>0) {
			 a=a+"The Average of the Course: "+demo(mark/count)+"\n";
		 }else
			 a="There are No Grades for Student Id: "+studentId;
			 
		 
		 return a;
	 }
	public String toString(){
		
		String result = "";
		for (int i = 0; i<courseCt; i ++) {
			result=result+"studentId: "+courseArray[i].getStudentId()+" , "
					+"Grade: "+courseArray[i].getStudentGrade()+" , "+
					"Course: "+courseArray[i].getCourseId()
					+"\n";}
		
		return result;
	}
}
