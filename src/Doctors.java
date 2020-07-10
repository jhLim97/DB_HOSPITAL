import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Doctors extends JFrame implements ActionListener{
    JLabel id,major,name,gen,phone,email,position; 
    JTextField inid,inmajor,inname,ingen,inphone,inemail,inposition;
    JButton btn_input;
    
    JPanel pn;
    
    Statement stmt;
    static Connection con_doc;
    
	public Doctors(Connection con) {	
		  
		  super("Doctors");
		  
		  pn=new JPanel();
		  
		  con_doc = con;
		  
	      id = new JLabel("�ǻ� ID");
	      major=new JLabel("����");
	      name=new JLabel("�̸�");
	      gen=new JLabel("����");
	      phone=new JLabel("��ȭ��ȣ");
	      email=new JLabel("�̸���");
	      position = new JLabel("����");
	      
	      inid=new JTextField();
	      inmajor=new JTextField();
	      inname=new JTextField();
	      ingen=new JTextField();
	      inphone=new JTextField();
	      inemail=new JTextField();
	      inposition = new JTextField();
	      
	      btn_input=new JButton("�Է�");
	      
	      pn.setLayout(new GridLayout(8,2));
		   
		  pn.add(id);	   
		  pn.add(inid);
		   
		  pn.add(major);	
		  pn.add(inmajor);
		  
		  pn.add(name);	
		  pn.add(inname);
		   
		  pn.add(gen);
		  pn.add(ingen);	
		   
		  pn.add(phone);	   
		  pn.add(inphone);
		   
		  pn.add(email);	
		  pn.add(inemail);
		   
		  pn.add(position);
		  pn.add(inposition);
		  
		  pn.add(btn_input);
	      
	     
	      add(pn);
	     	      
		  btn_input.addActionListener(new ActionListenerInput_com());
	      
	      setBounds(200, 200, 500, 500);
	}

	private class ActionListenerInput_com implements ActionListener{//��ü �߰�
	      public void actionPerformed(ActionEvent e) {
	    	  //com.pn.setVisible(true);
	         try {  
	            stmt = con_doc.createStatement();     
	            String sql = "insert into Doctors values("+inid.getText()+",'"+inmajor.getText()+"','"+inname.getText()+"'"+",'"+ingen.getText()+"','"+inphone.getText()+"','"+inemail.getText()+"','"+inposition.getText()+"')";
	             stmt.executeUpdate(sql);
	             inid.setText("");
	             inmajor.setText("");
	             inname.setText("");
	             ingen.setText("");
	             inphone.setText("");
	             inemail.setText("");
	             inposition.setText("");
	         }catch (Exception e1) {
	               System.out.println("���� �б� ���� :" + e1);
	               System.out.println("���� �߻�!"); 
	         }
	      }
 }
	
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
		
		 

	



