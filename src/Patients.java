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



public class Patients extends JFrame implements ActionListener{
    JLabel pat_id,nur_id,doc_id,name,gen,jumin,addr,phone,email,job; 
    JTextField inpat_id,innur_id,indoc_id,inname,ingen,injumin,inaddr,inphone,inemail,injob;
    JButton btn_input;
    
    JPanel pn;
    
    Statement stmt;
    static Connection con_pat;
    
	public Patients(Connection con) {	
		  
		  super("Patients");
		  
		  pn=new JPanel();
		  
		  con_pat = con;
		  
	      pat_id = new JLabel("환자 ID");
	      nur_id = new JLabel("간호사 ID");
	      doc_id = new JLabel("의사 ID");
	      name=new JLabel("이름");
	      gen=new JLabel("성별");
	      jumin=new JLabel("주민등록번호");
	      addr=new JLabel("주소");
	      phone=new JLabel("전화번호");
	      email=new JLabel("이메일");
	      job = new JLabel("직업");
	      
	      inpat_id = new JTextField();
	      innur_id = new JTextField();
	      indoc_id = new JTextField();
	      inname=new JTextField();
	      ingen=new JTextField();
	      injumin=new JTextField();
	      inaddr=new JTextField();
	      inphone=new JTextField();
	      inemail=new JTextField();
	      injob = new JTextField();
	      
	      btn_input=new JButton("입력");
	      
	      pn.setLayout(new GridLayout(11,2));
		   
		  pn.add(pat_id);	   
		  pn.add(inpat_id);
		  
		  pn.add(nur_id);	   
		  pn.add(innur_id);
		  
		  pn.add(doc_id);	   
		  pn.add(indoc_id);
		  
		  pn.add(name);	
		  pn.add(inname);
		   
		  pn.add(gen);
		  pn.add(ingen);
		  
		  pn.add(jumin);
		  pn.add(injumin);
		  
		  pn.add(addr);
		  pn.add(inaddr);
		   
		  pn.add(phone);	   
		  pn.add(inphone);
		   
		  pn.add(email);	
		  pn.add(inemail);
		   
		  pn.add(job);
		  pn.add(injob);
		  
		  pn.add(btn_input);
	      
	     
	      add(pn);
	     	      
		  btn_input.addActionListener(new ActionListenerInput_pat());
	      
	      setBounds(200, 200, 500, 500);
	}

	private class ActionListenerInput_pat implements ActionListener{//전체 추가
	      public void actionPerformed(ActionEvent e) {
	    	  //com.pn.setVisible(true);
	         try {  
	            stmt = con_pat.createStatement();     
	            String sql = "insert into Patients values("+inpat_id.getText()+","+innur_id.getText()+","+indoc_id.getText()+",'"+inname.getText()+"'"+",'"+ingen.getText()+"','"+injumin.getText()+"','"+inaddr.getText()+"','"+inphone.getText()+"','"+inemail.getText()+"','"+injob.getText()+"')";
	             stmt.executeUpdate(sql);
	             inpat_id.setText("");
	             innur_id.setText("");
	             indoc_id.setText("");
	             inname.setText("");
	             ingen.setText("");
	             injumin.setText("");
	             inaddr.setText("");
	             inphone.setText("");
	             inemail.setText("");
	             injob.setText("");
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
		
		 

	



