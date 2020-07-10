
import java.awt.event.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class Input extends JFrame implements ActionListener {
   
   
   JPanel pn_input; 
   
   
   JButton btnIn1,btnIn2,btnIn3,btnIn4,btnIn5;
   
   static Connection con_input;
   
   Statement stmt;

   public Input(Connection con) {
      super("입력");
      layInit();
      con_input = con;
      setBounds(200, 200, 500, 300);       
   }

   public void layInit() {
                  
	  
	  //shop = new RepairShop(con_adm);
	   
      pn_input=new JPanel();
      
      
      btnIn1 = new JButton("Doctors");
      btnIn2 = new JButton("Nurses");
      btnIn3 = new JButton("Treatments");
      btnIn4 = new JButton("Patients");
      btnIn5 = new JButton("Charts");
     
      
      
      pn_input.setLayout(new GridLayout(2,4));
     
      pn_input.add(btnIn1);
      pn_input.add(btnIn2);
      pn_input.add(btnIn3);
      pn_input.add(btnIn4);
      pn_input.add(btnIn5);
      
      add(pn_input);
      
      pn_input.setVisible(true);
      
      btnIn1.addActionListener(this);
      btnIn2.addActionListener(this);
      btnIn3.addActionListener(this);
      btnIn4.addActionListener(this);
      btnIn5.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
    
	   try {
		   	if (e.getSource() == btnIn1) {
	        	 Doctors doc = new Doctors(con_input);	        	 
	        	 doc.setVisible(true);	        	 	        	 
	         }else if (e.getSource() == btnIn2) {  	 
	        	 Nurses nur = new Nurses(con_input);
	        	 nur.setVisible(true);
	        	 
	         }else if (e.getSource() == btnIn3) {
	        	 Treatments treat = new Treatments(con_input);	        	 
	        	 treat.setVisible(true);	        	 
	         }else if (e.getSource() == btnIn4) {
	        	 Patients pat = new Patients(con_input);
	        	 pat.setVisible(true);
	         }else if (e.getSource() == btnIn5) {
	        	 Charts cha = new Charts(con_input);
	        	 cha.setVisible(true);
	        	 
	         }
	      } catch (Exception e2) {
	         System.out.println("쿼리 읽기 실패 :" + e2);
	         System.out.println("오류 발생!"); 
	      }

   }
      
}