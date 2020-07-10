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



public class Treatments extends JFrame implements ActionListener{
    JLabel treat_id,pat_id,doc_id,contents,date; 
    JTextField intreat_id,inpat_id,indoc_id,incontents,inY,inM,inD;
    JButton btn_input;
    Container con_date;
    
    JPanel pn;
    
    Statement stmt;
    static Connection con_treat;
    
	public Treatments(Connection con) {	
		  
		  super("Treatments");
		  
		  pn=new JPanel();
		  
		  con_treat = con;
		  
	      treat_id = new JLabel("치료 ID");
	      pat_id = new JLabel("환자 ID");
	      doc_id = new JLabel("의사 ID");
	      contents=new JLabel("내용");
	      date=new JLabel("진료일");
	      
	      intreat_id = new JTextField();
	      inpat_id = new JTextField();
	      indoc_id = new JTextField();
	      incontents=new JTextField();
	      inY=new JTextField();
	      inM=new JTextField();
	      inD=new JTextField();
	      
	      con_date = new Container();
	      con_date.setLayout(new GridLayout(1,3));
	      
	      btn_input=new JButton("입력");
	      
	      pn.setLayout(new GridLayout(6,2));
		   
		  pn.add(treat_id);	   
		  pn.add(intreat_id);
		   
		  pn.add(pat_id);	
		  pn.add(inpat_id);
		  
		  pn.add(doc_id);	
		  pn.add(indoc_id);
		   
		  pn.add(contents);
		  pn.add(incontents);	
		  
		  con_date.add(inY);
		  con_date.add(inM);
		  con_date.add(inD);
		  
		  pn.add(date);	   
		  pn.add(con_date);
		   
		  pn.add(btn_input);
	      
	     
	      add(pn);
	     	      
		  btn_input.addActionListener(new ActionListenerInput_treat());
	      
	      setBounds(200, 200, 500, 500);
	}

	private class ActionListenerInput_treat implements ActionListener{//전체 추가
	      public void actionPerformed(ActionEvent e) {
	    	  //com.pn.setVisible(true);
	         try {  
	            stmt = con_treat.createStatement();     
	            String sql = "insert into Treatments values("+intreat_id.getText()+",'"+inpat_id.getText()+"','"+indoc_id.getText()+"'"+",'"+incontents.getText()+"',+STR_TO_DATE('"+inY.getText()+"-"+inM.getText()+"-"+inD.getText()+"','%Y-%m-%d'))";
	             stmt.executeUpdate(sql);
	             intreat_id.setText("");
	             inpat_id.setText("");
	             indoc_id.setText("");
	             incontents.setText("");
	             inY.setText("");
	             inM.setText("");
	             inD.setText("");
	            
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
		
		 

	



