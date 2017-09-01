package com.spa.htmlToExcel;

import java.io.File;
import java.io.FileInputStream;

import com.spa.student.Student;


//import sun.nio.cs.CharsetMapping.Entry;
public class semester3 extends HtmlToExcel
{
	//public Student Student = new Student();
	
	void HtmlToExcel(String dirname){
		int i = 0;
		
	
			
		try{
			input = new FileInputStream(f);
		
			byte[] data = new byte[(int)f.length()];
		    input.read(data);
			completeFileContent = new String(data, "UTF-8");
     
      	

      	
      	Student.fatherName[i] = fatherName;
      	System.out.println(Student.fatherName[i]);
    	
      
      	Student.rollNo[i] = rollNo;
      	System.out.println(Student.rollNo[i]);
      	
      	
      	Student.enrollmentNo[i] = enrollmentNo;
      	System.out.println(Student.enrollmentNo[i]);
      	
      	
      	Student.course[i] = course;
      	System.out.println(Student.course[i]);
      	
    	
      	Student.branch[i] = branch;
      	System.out.println(Student.branch[i]);

      	
		
     	
      	Student.institute[i] = inst;
      	System.out.println(Student.institute[i]);
      
      	
      	Student.image[i] = image;
      	System.out.println(Student.image[i]);
      	
      	
      	Student.gp[i] = gp;
      	System.out.println("GP-"+Student.gp[i]);
      	
      	
      	Student.carryOver[i] = carryOver;
      	System.out.println("Carry over papers-"+Student.carryOver[i]);
		
    	
      	Student.humanValues[i] = humanValues;
      	System.out.println("human values-"+Student.humanValues[i]);
		
      	
      	Student.marksObt[i] =marksObt;
      	System.out.println("total marks-"+Student.marksObt[i]);
		
      	
      	
		}
		catch(Exception ex)
		{
		}
		
		}
	}
}
}

