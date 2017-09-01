package com.spa.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.spa.student.Student;
//
public class ContentShower{
	static boolean boxNo[] = {true,true,false,false,false,false,false,false,false,false,true,true,false,true};

	
	static Object[] columns = new Object[20];
	static Object[] dupColumnNames = new Object[14];
	static Object[] columnNames = {"S.No.","Name","Father's Name", "Roll No", "Enrollment No", 
				"Semester","Branch","Course",  "Institute",
				"Image","GP", "Carry Over","Human Values", "Marks Obt"};
	
	static Object[][] data = new Object[20][100];/* = {
			{"1","-","-","-","-","-","-","-","-","-","-","-"},
			{"2","-","-","-","-","-","-","-","-","-","-","-"},
			{"3","-","-","-","-","-","-","-","-","-","-","-"},
			{"4","-","-","-","-","-","-","-","-","-","-","-"},
			{"5","-","-","-","-","-","-","-","-","-","-","-"},
			{"6","-","-","-","-","-","-","-","-","-","-","-"},
			{"7","-","-","-","-","-","-","-","-","-","-","-"},
			{"8","-","-","-","-","-","-","-","-","-","-","-"},
			{"9","-","-","-","-","-","-","-","-","-","-","-"},
			{"10","-","-","-","-","-","-","-","-","-","-","-"},
			{"11","-","-","-","-","-","-","-","-","-","-","-"},
			{"12","-","-","-","-","-","-","-","-","-","-","-"}
			};
	*/
	static void getColumnNames(int no){
			
		if(boxNo[no]==true)
		{
			boxNo[no]=false;
		}
		else
		{
			boxNo[no]=true;
		}
		for(int i=0;i<14;i++){
		
		dupColumnNames[i] = columnNames[i];
		}
		int c = 0;
		for(int i=0;i<14;i++)
		{
			if(boxNo[i]==true)
			{
				columns[c] = dupColumnNames[i];
				c++;
				System.out.println("he");
			}
			else{
				c++;
				
			}
		}
		int k=0;
		
		for(int i=14;i<20;i++){
			columns[i] = Student.sixSubject[k];
		}
		getData();
		
	}
	
	static void getData()
	{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][0]=i+1;
		}
		if(boxNo[1]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][1]=Student.name[i];
		}
		}
		if(boxNo[2]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][2]=Student.fatherName[i];
		}
		}
		if(boxNo[3]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][3]=Student.rollNo[i];
		}
		}
		if(boxNo[4]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][4]=Student.enrollmentNo[i];
		}
		}
		if(boxNo[5]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][5]=Student.semester[i];
		}
		}
		if(boxNo[6]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][6]=Student.branch[i];
		}
		}
		if(boxNo[7]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][7]=Student.course[i];
		}
		}
		if(boxNo[8]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][8]=Student.institute[i];
		}
		}
		if(boxNo[9]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][9]=Student.image[i];
		}
		}
		if(boxNo[10]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][10]=Student.sub1[i];
		}
		}
		if(boxNo[11]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][11]=Student.sub2[i];
		}
		}
		if(boxNo[12]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][12]=Student.sub3[i];
		}
		}
		if(boxNo[13]==true)
		{
		for(int i=0;i<Student.sn;i++)
		{
			data[i][13]=Student.sub4[i];
		}
		}
	
	}
	
	
	
	
	
	/*Object[] setTableColumn(int opColumn){
	
		if(opColumn==1 && branch == "CSE" && semester == "Third")
		{
			Object[] columnNames = {"S.No.","Roll No","AS301", "CS301","CS302", "EC302", "EE305", "HU301", "Marks Obt","Carry Over"};
			return columnNames;
		}
		return null;
	}
	ContentShower(Object[][] data,String[] columnNames){
		TestTableModel model = (TestTableModel) table.getModel();
		table = new JTable(new TableModel(data, columnNames));
	}*/
	
	/*String[] setTableColumn(){
			String[] columnNames = {"S.No.","Name","Roll No","AS301", "CS301","CS302", "EC302", "EE305", "HU301", "Marks Obt","Carry Over"};
			return columnNames;
			
	}*/

	
	/*Object[][] setTableData(){
			
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
		
		return data;
	}
	*/
	/*TableColumn column = null;
	{
	for (int i = 0; i < 4; i++) {
	    column = table.getColumnModel().getColumn(i);
	    if (i == 1) {
	        column.setPreferredWidth(100); //third column is bigger
	    } else {
	        column.setPreferredWidth(50);
	    }
	}
	}*/

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
