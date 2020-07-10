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
		  
	      id = new JLabel("의사 ID");
	      major=new JLabel("전공");
	      name=new JLabel("이름");
	      gen=new JLabel("성별");
	      phone=new JLabel("전화번호");
	      email=new JLabel("이메일");
	      position = new JLabel("직위");
	      
	      inid=new JTextField();
	      inmajor=new JTextField();
	      inname=new JTextField();
	      ingen=new JTextField();
	      inphone=new JTextField();
	      inemail=new JTextField();
	      inposition = new JTextField();
	      
	      btn_input=new JButton("입력");
	      
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

	private class ActionListenerInput_com implements ActionListener{//전체 추가
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
	               System.out.println("쿼리 읽기 실패 :" + e1);
	               System.out.println("오류 발생!"); 
	         }
	      }
 }
	
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
		
		 

	



