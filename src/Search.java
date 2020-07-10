
import java.awt.event.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class Search extends JFrame implements ActionListener {
   
   ResultSet rs;
   JPanel pn_search; 
   JTextArea txtResult;  
   JScrollPane scrollPane;
  
   
   JButton btnIn1,btnIn2,btnIn3,btnIn4,btnIn5;
   
   static Connection con_search;
   
   Statement stmt;

   public Search(Connection con) {
      super("검색");
      layInit();
      con_search = con;
      setBounds(200, 200, 500, 300);       
   }

   public void layInit() {
                 
	   
	   
      pn_search=new JPanel();
      
      // 버튼 4개 초기화
      btnIn1 = new JButton("Doctors");
      btnIn2 = new JButton("Nurses");
      btnIn3 = new JButton("Treatments");
      btnIn4 = new JButton("Patients");
      btnIn5 = new JButton("Charts");
      txtResult = new JTextArea();
      
      
      pn_search.setLayout(new GridLayout(2,4));
      pn_search.add(btnIn1);
      pn_search.add(btnIn2);
      pn_search.add(btnIn3);
      pn_search.add(btnIn4);
      pn_search.add(btnIn5);
      
      txtResult.setEditable(false);
	  JScrollPane scrollPane = new JScrollPane(txtResult); 
      
      add("North",pn_search);
      add("Center",scrollPane);      
      
      pn_search.setVisible(true);
      
      
      btnIn1.addActionListener(this);
      btnIn2.addActionListener(this);
      btnIn3.addActionListener(this);
      btnIn4.addActionListener(this);
      btnIn5.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
    
		   try {
		         stmt = con_search.createStatement();
		         String query1 = "SELECT * FROM Doctors ";
		         String query2 = "SELECT * FROM Nurses ";
		         String query3 = "SELECT * FROM Patients ";
		         String query4 = "SELECT * FROM Treatments ";
		         String query5 = "SELECT * FROM Charts ";
		         if (e.getSource() == btnIn1) {
		            txtResult.setText("");
		            txtResult.setText("DOC_ID          MAJOR       NAME      GEN      PHONE      EMAIL      POSITION\n");
		            rs = stmt.executeQuery(query1);
		            while (rs.next()) {
		               String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) +  "\n";
		               txtResult.append(str);
		            }
		         }else if (e.getSource() == btnIn2) {
		            txtResult.setText("");
		             txtResult.setText("NUR_ID    MAJOR      NAME      GEN      PHONE     EMAIL      POSITION\n");
		             rs = stmt.executeQuery(query2);
		             while (rs.next()) {
		            	 String str = rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) +  "\n";
			               txtResult.append(str);
		             } 
		         }else if (e.getSource() == btnIn3) {
		        	 txtResult.setText("");
			         txtResult.setText("TREAT_ID         PAT_ID       DOC_ID      CONTENTS      DATE\n");
			         rs = stmt.executeQuery(query4);
			         while (rs.next()) {
			        	 String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) +  "\n";
			               txtResult.append(str);
		             } 
		         }else if (e.getSource() == btnIn4) {
		        	 txtResult.setText("");
		             txtResult.setText("PAT_ID        NUR_ID       DOC_ID     NAME      GEN     JUMIN      ADDR         PHONE       EMAIL       JOB\n");
		             rs = stmt.executeQuery(query3);
		             while (rs.next()) {
		            	 String str = rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9) + "\t" + rs.getString(10) +  "\n";
			               txtResult.append(str);
			        
			          } 
			      }else if (e.getSource() == btnIn5) {
				     txtResult.setText("");
				     txtResult.setText("CHART_ID          TREAT_ID     DOC_ID       PAT_ID      NUR_ID      CONTENTS\n");
				     rs = stmt.executeQuery(query5);
				     while (rs.next()) {
				    	 String str = rs.getString(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getInt(5)+ "\t" + rs.getString(6) +  "\n";
			               txtResult.append(str);
				      } 
				    }
		        
		   }catch (Exception e2) {
	         System.out.println("쿼리 읽기 실패 :" + e2);
	         System.out.println("오류 발생!"); 
		      }
   }
	   
   
}
	   
      
  
