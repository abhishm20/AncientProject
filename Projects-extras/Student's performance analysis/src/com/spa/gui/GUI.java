package com.spa.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.spa.htmlToExcel.WriteInExcel;




public class GUI{
	JFrame frame;
	JPanel contentShower;
	JTable table;
	JMenuBar menuBar;
	JPanel central;
	JPanel footer;
	JFileChooser saver;
	JPanel ribbon;
	
	//Object[] columnNames = {"S.No.","Roll No","AS301", "CS301","CS302", "EC302", "EE305", "HU301", "Marks Obt","Carry Over"};
	
	GUI() {
		frame = new JFrame(" Performance Statistics (Beta version 1.0)"); 
		frame.setBackground(UIManager.getColor("Label.disabledForeground"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		createAndShowGUI();
		frame.getContentPane().add(menuBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(central, BorderLayout.CENTER);
		frame.getContentPane().add(footer, BorderLayout.PAGE_END);

		}
		void createAndShowGUI()
		{
			menuBar = new JMenuBar();
			JMenu mnFile = new JMenu("File");
			menuBar.setBounds(0, 0, 230, 24);
			menuBar.add(mnFile);
			
			JMenu mnNewMenu = new JMenu("New");
			mnFile.add(mnNewMenu);
			
			JMenuItem mntmExcelFromHtml = new JMenuItem("Excel from HTML");
			mntmExcelFromHtml.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				new SubjectSelector();
			}});
			
			
			mnNewMenu.add(mntmExcelFromHtml);
			
			JMenuItem mntmDbFromExcel = new JMenuItem("DB from Excel");
			mnNewMenu.add(mntmDbFromExcel);
			
			JMenuItem mntmOpen = new JMenuItem("Open");
			mnFile.add(mntmOpen);
			
			JMenuItem mntmSaveAs = new JMenuItem("Save as");
			mntmSaveAs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saver = new JFileChooser("Choose Directory to save file");
					if (saver.showSaveDialog(saver) == JFileChooser.APPROVE_OPTION) {
					File savingDir = saver.getSelectedFile();
					System.out.println(savingDir);
					new WriteInExcel(savingDir);
				}
			}});
			mnFile.add(mntmSaveAs);
			
			JMenuItem mntmPrint = new JMenuItem("Print");
			mnFile.add(mntmPrint);
			
			JMenuItem mntmSend = new JMenuItem("Send");
			mnFile.add(mntmSend);
			
			JMenuItem mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mnFile.add(mntmExit);
			
			JMenu mnEdit = new JMenu("Edit");
			menuBar.add(mnEdit);
			
			JMenuItem mntmUndo = new JMenuItem("Undo");
			mnEdit.add(mntmUndo);
			
			JMenuItem mntmRedo = new JMenuItem("Redo");
			mnEdit.add(mntmRedo);
			
			JMenuItem mntmCut = new JMenuItem("Cut");
			mnEdit.add(mntmCut);
			
			JMenuItem mntmCopy = new JMenuItem("Copy");
			mnEdit.add(mntmCopy);
			
			JMenuItem mntmPaste = new JMenuItem("Paste");
			mnEdit.add(mntmPaste);
			
			JMenuItem mntmDelete = new JMenuItem("Delete");
			mnEdit.add(mntmDelete);
			
			JMenuItem mntmFind = new JMenuItem("Find");
			mnEdit.add(mntmFind);
			
			JMenuItem mntmReplaceAll = new JMenuItem("Replace all");
			mnEdit.add(mntmReplaceAll);
			
			JMenu mnView = new JMenu("View");
			menuBar.add(mnView);
			
			JMenu mnPersonalDetails = new JMenu("Personal details");
			mnView.add(mnPersonalDetails);
			
			JCheckBoxMenuItem chckbxmntmName = new JCheckBoxMenuItem("Name");
			chckbxmntmName.setSelected(true);
			chckbxmntmName.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					//ContentShower.setTableColumn();
				}
			});
			mnPersonalDetails.add(chckbxmntmName);
			
			JCheckBoxMenuItem chckbxmntmFathersName = new JCheckBoxMenuItem("Father's Name");
			mnPersonalDetails.add(chckbxmntmFathersName);
			
			JCheckBoxMenuItem chckbxmntmRollNo = new JCheckBoxMenuItem("Roll no.");
			chckbxmntmRollNo.setSelected(true);
			mnPersonalDetails.add(chckbxmntmRollNo);
			
			JCheckBoxMenuItem chckbxmntmEnrollmentNo = new JCheckBoxMenuItem("Enrollment no.");
			mnPersonalDetails.add(chckbxmntmEnrollmentNo);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Branch");
			mnPersonalDetails.add(chckbxmntmNewCheckItem);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("Semester");
			mnPersonalDetails.add(chckbxmntmNewCheckItem_1);
			
			JCheckBoxMenuItem chckbxmntmCourse = new JCheckBoxMenuItem("Course");
			mnPersonalDetails.add(chckbxmntmCourse);
			
			JCheckBoxMenuItem chckbxmntmInstitute = new JCheckBoxMenuItem("Institute");
			mnPersonalDetails.add(chckbxmntmInstitute);
			
			JCheckBoxMenuItem chckbxmntmImage = new JCheckBoxMenuItem("Image");
			mnPersonalDetails.add(chckbxmntmImage);
			
			JMenu mnAcademicDetails = new JMenu("Academic details");
			mnView.add(mnAcademicDetails);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("GP");
			mnAcademicDetails.add(chckbxmntmNewCheckItem_2);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem_3 = new JCheckBoxMenuItem("Carry over");
			chckbxmntmNewCheckItem_3.setSelected(true);
			mnAcademicDetails.add(chckbxmntmNewCheckItem_3);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem_4 = new JCheckBoxMenuItem("Human Values");
			mnAcademicDetails.add(chckbxmntmNewCheckItem_4);
			
			JCheckBoxMenuItem chckbxmntmM = new JCheckBoxMenuItem("Marks obt.");
			chckbxmntmM.setSelected(true);
			mnAcademicDetails.add(chckbxmntmM);
			
			JCheckBoxMenuItem chckbxmntmNewCheckItem_5 = new JCheckBoxMenuItem("Status");
			mnAcademicDetails.add(chckbxmntmNewCheckItem_5);
			
			
			
			
			
			central = new JPanel();
			central.setBackground(Color.ORANGE);
			central.setLayout(new BorderLayout(0, 0));
			
			ribbon = new JPanel();
			ribbon.setBackground(SystemColor.textInactiveText);
			central.add(ribbon, BorderLayout.PAGE_START);
			ribbon.setPreferredSize(new Dimension(600, 100));
			
			contentShower = new JPanel();
			central.add(contentShower, BorderLayout.CENTER);
			contentShower.setLayout(new BorderLayout(0, 0));
			System.out.println("hrllo");
			table = new JTable(ContentShower.data,ContentShower.columns);System.out.println("hrllo");
			table.setBackground(Color.WHITE);System.out.println("hrllo");
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));System.out.println("hrllo");
			table.setFillsViewportHeight(true);System.out.println("hrllo");
			
			contentShower.add(table.getTableHeader(), BorderLayout.CENTER);System.out.println("hrllo");
			contentShower.add(table, BorderLayout.CENTER);System.out.println("hrllo");
			
			//JScrollPane scrollPane = new JScrollPane(contentShower);

			
			/*showTable(contentShower);*/
			
			
						
			
			
			
			
			
			
			/*JScrollPane scrollPane = new JScrollPane(table);
			table.setFillsViewportHeight(true);*/
			//panelInContentShower.setPreferredSize(new Dimension(, 100));
			
			
			
			footer = new JPanel();
			footer.setBackground(SystemColor.window);
			footer.setBounds(0, 0, 17, 50);
			footer.setPreferredSize(new Dimension(600, 25));
		}
		
	/*	void showTable(JPanel contentShow)
		{
			ContentShower.getColumnNames(0);
		contentShow.add(table.getTableHeader(), BorderLayout.PAGE_START);
		contentShow.add(table, BorderLayout.CENTER);
		table = new JTable(ContentShower.data,ContentShower.columns);
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		}*/
	
	
	public static void main(String[] args)  {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          new GUI();
        }
    });

}
}
