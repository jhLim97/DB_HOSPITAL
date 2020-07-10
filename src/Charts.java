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



public class Charts extends JFrame implements ActionListener{
    JLabel chart_id,treat_id,doc_id,pat_id,nur_id,contents; 
    JTextField inchart_id,intreat_id,indoc_id,inpat_id,innur_id,incontents;
    JButton btn_input;
    
    JPanel pn;
    
    Statement stmt;
    static Connection con_chart;
    
	public Charts(Connection con) {	
		  
		  super("Charts");
		  
		  pn=new JPanel();
		  
		  con_chart = con;
		  
		  chart_id = new JLabel("��Ʈ ID");
	      treat_id = new JLabel("ġ�� ID");
	      doc_id = new JLabel("�ǻ� ID");
	      pat_id = new JLabel("ȯ�� ID");
	      nur_id = new JLabel("��ȣ�� ID");
	      contents=new JLabel("����");
	      
	      inchart_id = new JTextField();
	      intreat_id = new JTextField();
	      indoc_id = new JTextField();
	      inpat_id = new JTextField();
	      innur_id = new JTextField();
	      incontents=new JTextField();
	      
	      btn_input=new JButton("�Է�");
	      
	      pn.setLayout(new GridLayout(7,2));
		   
	      pn.add(chart_id);	   
		  pn.add(inchart_id);
	      
		  pn.add(treat_id);	   
		  pn.add(intreat_id);
		   
		  
		  pn.add(doc_id);	
		  pn.add(indoc_id);
		  
		  pn.add(pat_id);	
		  pn.add(inpat_id);
		  
		  
		  pn.add(nur_id);	
		  pn.add(innur_id);
		   
		  pn.add(contents);
		  pn.add(incontents);	
		   
		  pn.add(btn_input);
	      
	     
	      add(pn);
	     	      
		  btn_input.addActionListener(new ActionListenerInput_chart());
	      
	      setBounds(200, 200, 500, 500);
	}

	private class ActionListenerInput_chart implements ActionListener{//��ü �߰�
	      public void actionPerformed(ActionEvent e) {
	    	  //com.pn.setVisible(true);
	         try {  
	            stmt = con_chart.createStatement();     
	            String sql = "insert into Charts values('"+inchart_id.getText()+"',"+intreat_id.getText()+","+indoc_id.getText()+","+inpat_id.getText()+","+innur_id.getText()+",'"+incontents.getText()+"')";
	             stmt.executeUpdate(sql);
	             inchart_id.setText("");
	             intreat_id.setText("");
	             inpat_id.setText("");
	             indoc_id.setText("");
	             innur_id.setText("");
	             incontents.setText("");
	            
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
		
		 

	



