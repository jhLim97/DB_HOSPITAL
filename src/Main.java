
import java.awt.event.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;


public class Main extends JFrame implements ActionListener {
   JButton btnIn,btnOk1,btnOk2,btnOk3, btnInit;
   JTextArea txtResult;
   JPanel pn1;
   JLabel laOrderno,laCustno,laBookno,laSaleprice,laOrderdate;
   JTextField inOrderno,inCustno,inBookno,inSaleprice,inY,inM,inD;
   JScrollPane scrollPane;
   
   Input input;
   Search search;

   static Connection con;
   Statement stmt;
   ResultSet rs;
   String Driver = "";
   String url = "jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul&useSSL=false";
   String userid = "madang";
   String pwd = "madang";

   public Main() {
      super("HOSPITAL");
      conDB();
      layInit();
      
      setVisible(true);
      setBounds(200, 200, 400, 400); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void layInit() {
	   
	  input = new Input(con); 
	  search = new Search(con);
	   
      btnInit = new JButton("DB�ʱ�ȭ");
      btnIn = new JButton("�Է�");
      btnOk1 = new JButton("�˻�1");
      btnOk2 = new JButton("�˻�2");
      btnOk3 = new JButton("�˻�3");
      txtResult = new JTextArea();
 
      
      pn1 = new JPanel();
      pn1.add(btnInit);
      pn1.add(btnIn);
      pn1.add(btnOk1);
      pn1.add(btnOk2);
      pn1.add(btnOk3);

      
      txtResult.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(txtResult);
      add("North", pn1);
      add("Center", scrollPane);
    
      btnIn.addActionListener(new ActionListenerInput());
      btnOk1.addActionListener(new ActionListenerSearch());
      btnOk2.addActionListener(this);
      btnOk3.addActionListener(this);
      btnInit.addActionListener(new ActionListenerInit());
   }

   public void conDB() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("����̹� �ε� ����");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      
      try { /* �����ͺ��̽��� �����ϴ� ���� */
          System.out.println("�����ͺ��̽� ���� �غ�...");
          con = DriverManager.getConnection(url, userid, pwd);
          System.out.println("�����ͺ��̽� ���� ����");
       } catch (SQLException e1) {
          e1.printStackTrace();
       }
   }
   
   private class ActionListenerInit implements ActionListener {
      public void actionPerformed (ActionEvent e) {
         int rowcount;
         
         System.out.println("DB �ʱ�ȭ�� ���⿡");
         
         try {
            stmt = con.createStatement();
            
            String query = "delete FROM Charts";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Charts ���̺��� " +rowcount+ " Ʃ�� ����");
            
            query = "delete FROM Treatments";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Treatments ���̺��� " +rowcount+ " Ʃ�� ����");
            
            query = "delete FROM Patients";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Patients ���̺��� " +rowcount+ " Ʃ�� ����");
            
            query = "delete FROM Doctors";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Doctors ���̺��� " +rowcount+ " Ʃ�� ����");
            
            query = "delete FROM Nurses";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Nurses ���̺��� " +rowcount+ " Ʃ�� ����");
            
            //�ǻ�
            stmt.executeUpdate("insert into Doctors values(980312, '�Ҿư�', '������', 'M', '010-333-1340', 'ltj@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(000601, '����', '�ȼ���', 'M', '011-222-0987', 'ask@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(001208, '�ܰ�', '�����', 'M', '010-333-8743', 'kmj@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(020403, '�Ǻΰ�', '���¼�', 'M', '019-777-3764', 'lts@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(050900, '�Ҿư�', '�迬��', 'F', '010-555-3746', 'kya@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(050101, '����', '������', 'M', '011-222-7643', 'cth@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(062019, '�Ҿư�', '������', 'F', '010-999-1265', 'jjh@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(070576, '�Ǻΰ�', 'ȫ�浿', 'M', '016-333-7263', 'hgd@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(080543, '��缱��', '���缮', 'M', '010-222-1263', 'yjs@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(091001, '�ܰ�', '�躴��', 'M', '010-555-3542', 'kbm@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(100001, '�Ҿư�', '������', 'M', '010-333-1341', 'lt1@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100002, '����', '�̿���', 'F', '010-333-1342', 'lt2@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(100003, '����', '�����', 'M', '010-333-1343', 'lt3@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100004, '�Ҿư�', '��ȣ��', 'M', '010-333-1344', 'lt4@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(100005, '�Ǻΰ�', '�̵���', 'M', '010-333-1345', 'lt5@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100006, '�Ҿư�', '�����', 'M', '010-333-1346', 'lt66@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100007, '�Ǻΰ�', '������', 'M', '010-333-1347', 'lt7@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100008, '�Ҿư�', '������', 'M', '010-333-1348', 'lt8@hanbh.com','������');");
            stmt.executeUpdate("insert into Doctors values(100009, '�ܰ�', '�̹���', 'M', '010-333-1349', 'lt9@hanbh.com','����');");
            stmt.executeUpdate("insert into Doctors values(100010, '�Ҿư�', '�̳���', 'F', '010-333-1350', 'lt10@hanbh.com','����');");
            //��ȣ��
            stmt.executeUpdate("insert into Nurses values(050302, '�Ҿư�', '������','F', '010-555-8751', 'key@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(050021, '����', '������','F', '016-333-8745', 'ysa@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(040089, '�Ǻΰ�', '������','M', '010-666-7646', 'sjw@hanbh.com', '����');");
            stmt.executeUpdate("insert into Nurses values(070605, '��缱��', '����ȭ','F', '010-333-4588', 'yjh@hanbh.com', '����');");
            stmt.executeUpdate("insert into Nurses values(070804, '����', '���ϳ�','F', '010-222-1340', 'nhn@hanbh.com', '����');");
            stmt.executeUpdate("insert into Nurses values(071018, '�Ҿư�', '��ȭ��','F', '019-888-4116', 'khk@hanbh.com', '����');");
            stmt.executeUpdate("insert into Nurses values(100356, '�Ҿư�', '�̼���','M', '010-777-1234', 'lsy@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(104145, '�ܰ�', '����','M', '010-999-8520', 'kh@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(120309, '�Ǻΰ�', '�ڼ���','M', '010-777-4996', 'psw@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(130211, '�ܰ�', '�̼���','F', '010-222-3214', 'lsy2@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200001, '�Ҿư�', '�̽���','F', '010-555-9001', 'key1@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200002, '�Ҿư�', '�ΰ���','F', '010-555-9002', 'key2@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200003, '�Ҿư�', '��ȣ��','F', '010-555-8752', 'key3@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200004, '�ܰ�', '�̼���','F', '010-555-8753', 'key4@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200005, '�Ҿư�', '�̽±�','F', '010-555-8754', 'key5@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200006, '�Ҿư�', '�ڳ���','F', '010-555-8755', 'key6@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200007, '�Ǻΰ�', '������','F', '010-555-8756', 'key7@hanbh.com', '��ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200008, '�Ҿư�', '������','F', '010-555-8757', 'key8@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200009, '�ܰ�', '�赿��','F', '010-555-8758', 'key9@hanbh.com', '����ȣ��');");
            stmt.executeUpdate("insert into Nurses values(200010, '����', '������','F', '010-555-8759', 'key10@hanbh.com', '����ȣ��');");
            //ȯ��
            stmt.executeUpdate("insert into Patients values(2345, 050302, 980312, '�Ȼ��', 'M', '232345', '����', '010-555-7845', 'ask@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(3545, 040089, 020403, '�輺��', 'M', '543545', '����', '010-333-7812', 'ksr@ab.com', '�ڿ���');");
            stmt.executeUpdate("insert into Patients values(3424, 070605, 080543, '������', 'M', '433424', '�λ�', '010-888-4859', 'ljj@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(7675, 100356, 050900, '�ֱ���', 'M', '677675', '����', '010-222-4847', 'cks@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(4533, 070804, 000601, '���Ѱ�', 'M', '744533', '����', '010-777-9630', 'jhk@ab.com', '����');");
            stmt.executeUpdate("insert into Patients values(5546, 120309, 070576, '������', 'M', '765546', '�뱸', '010-777-0214', 'ywh@ab.com', '�ڿ���');");
            stmt.executeUpdate("insert into Patients values(4543, 070804, 050101, '������', 'M', '454543', '�λ�', '010-555-4187', 'cjj@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(9768, 130211, 091001, '������', 'F', '119768', '����', '010-888-3675', 'ljh@ab.com', '����');");
            stmt.executeUpdate("insert into Patients values(4234, 130211, 091001, '������', 'F', '234234', '����', '010-999-6541', 'onm@ab.com', '�л�');");
            stmt.executeUpdate("insert into Patients values(7643, 071018, 062019, '�ۼ���', 'M', '987643', '����', '010-222-5874', 'ssm@ab.com', '�л�');");
            stmt.executeUpdate("insert into Patients values(1001, 050302, 980312, '������', 'M', '232341', '����', '010-555-7841', 'ask1@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1002, 050302, 980312, '�ȼ���', 'M', '232342', '����', '010-555-7842', 'ask2@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1003, 050302, 980312, '�̺���', 'M', '232343', '����', '010-555-7843', 'ask3@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1004, 050302, 980312, '������', 'M', '232344', '����', '010-555-7844', 'ask4@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1005, 050302, 980312, '�ջ��', 'M', '232346', '����', '010-555-7846', 'ask5@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1006, 050302, 980312, '�ۺ���', 'M', '232347', '����', '010-555-7847', 'ask66@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1007, 050302, 980312, '�̽þ�', 'M', '232348', '����', '010-555-7848', 'ask7@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1008, 050302, 980312, '����', 'M', '232349', '����', '010-555-7849', 'ask8@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1009, 050302, 980312, '�ǳ���', 'F', '232350', '����', '010-555-7850', 'ask9@ab.com', 'ȸ���');");
            stmt.executeUpdate("insert into Patients values(1010, 050302, 980312, '����', 'F', '232351', '����', '010-555-7851', 'ask10@ab.com', 'ȸ���');");
            //ġ��
            stmt.executeUpdate("insert into Treatments values(130516023, 2345, 980312, '����,����', STR_TO_DATE('2013-05-16','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(130628100, 3545, 020403, '�Ǻ� Ʈ���� ġ��', STR_TO_DATE('2013-06-28','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131205056, 3424, 080543, '�� ��ũ�� MRI�Կ�', STR_TO_DATE('2013-12-05','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131218024, 7675, 050900, '���̿�', STR_TO_DATE('2013-12-18','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131224012, 4533, 000601, '�忰', STR_TO_DATE('2013-12-24','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(140103001, 5546, 070576, '���帧 ġ��', STR_TO_DATE('2014-01-03','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140109026, 4543, 050101, '����', STR_TO_DATE('2014-01-09','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140226102, 9768, 091001, 'ȭ��ġ��', STR_TO_DATE('2014-02-26','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140303003, 4234, 091001, '������ �ܻ�ġ��', STR_TO_DATE('2014-03-03','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140308087, 7643, 062019, '�忰', STR_TO_DATE('2014-03-08','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(150516021, 1001, 980312, '����,����', STR_TO_DATE('2014-05-17','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516022, 1002, 980312, '�忰', STR_TO_DATE('2014-05-18','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516023, 1003, 980312, '�忰', STR_TO_DATE('2014-05-19','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516024, 1004, 980312, '����,����', STR_TO_DATE('2014-05-20','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516025, 1005, 980312, '�Ǻο�', STR_TO_DATE('2014-05-21','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(150516026, 1006, 980312, '����', STR_TO_DATE('2014-05-22','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516027, 1007, 980312, '����', STR_TO_DATE('2014-05-23','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516028, 1008, 980312, '�Ƿ�', STR_TO_DATE('2014-05-24','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516029, 1009, 980312, '�δ�', STR_TO_DATE('2014-05-25','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516030, 1010, 980312, '����', STR_TO_DATE('2014-05-26','%Y-%m-%d'));");
            
            
            //��Ʈ 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('1', 130516023, 980312, 2345, 050302, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('2', 130628100, 020403, 3545, 040089, '�Ѵ� �Ŀ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('3', 131205056, 080543, 3424, 070605, '���� �Ŀ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('4', 131218024, 050900, 7675, 100356, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('5', 131224012, 000601, 4533, 070804, '�����ֿ� �����ϼ���');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('6', 140103001, 070576, 5546, 120309, '�ȿ��ŵ� �˴ϴ�');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('7', 140109026, 050101, 4543, 070804, '�� �׸� �弼��');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('8', 140226102, 091001, 9768, 130211, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('9', 140303003, 091001, 4234, 130211, '�ȿ��ŵ� �˴ϴ�');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('10', 140308087, 062019, 7643, 071018, '�����ֿ� �����ϼ���');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('11', 150516021, 980312, 1001, 050302, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('12', 150516022, 980312, 1002, 050302, '���� �Ŀ� ������');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('13', 150516023, 980312, 1003, 050302, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('14', 150516024, 980312, 1004, 050302, '�Ѵ� �Ŀ� ������');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('15', 150516025, 980312, 1005, 050302, '�����ֿ� �����ϼ���');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('16', 150516026, 980312, 1006, 050302, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('17', 150516027, 980312, 1007, 050302, '�� ���ŵ� �˴ϴ�');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('18', 150516028, 980312, 1008, 050302, '�����ֿ� �����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('19', 150516029, 980312, 1009, 050302, '�����ϼ���');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('20', 150516030, 980312, 1010, 050302, '�����ֿ� �����ϼ���');"); 
  
         } catch (Exception e4) {
            System.out.println("DB �ʱ�ȭ ����" + e4);
         }
         txtResult.setText("");//5��1��
      }
   }

   
   private class ActionListenerInput implements ActionListener{//��ü �߰�
      public void actionPerformed(ActionEvent e) {
          //pn2.setVisible(true);
         try {  
            //stmt = con.createStatement();
        	 input.setVisible(true);
         }catch (Exception e1) {
               System.out.println("���� �б� ���� :" + e1);
         }
      }
   }
   
   private class ActionListenerSearch implements ActionListener{//��ü �߰�
	      public void actionPerformed(ActionEvent e) {
	          //pn2.setVisible(true);
	         try {  
	            //stmt = con.createStatement();
	        	 search.setVisible(true);
	         }catch (Exception e1) {
	               System.out.println("���� �б� ���� :" + e1);
	         }
	      }
	   }

   @Override
   public void actionPerformed(ActionEvent e) {
    
      try {
         stmt = con.createStatement();
         String query1 = "SELECT doc_position,COUNT(*) AS '������ �ǻ� ��' FROM Doctors where doc_id IN(select doc_id from Patients where pat_addr = '����') GROUP BY doc_position  ";
         String query2 = "SELECT pat_job,COUNT(*) FROM Patients where pat_id IN (select pat_id from Treatments where treat_date between '2013-12-01' and '2014-03-31' AND doc_id IN (select doc_id from Doctors where doc_gen = 'M')) GROUP BY pat_job";
         if (e.getSource() == btnOk2) {
            txtResult.setText("");
             txtResult.setText("SELECT doc_position,COUNT(*) AS '������ �ǻ� ��' FROM Doctors where doc_id IN(select doc_id from Patients where pat_addr = '����') GROUP BY doc_position  \n����     ���￡ �����ϴ� ȯ�ڸ� ������ �ǻ� ��\n");
             rs = stmt.executeQuery(query1);
             while (rs.next()) {
                String str = rs.getString(1) + "\t" + rs.getInt(2) + "\n";
                txtResult.append(str);
             } 
         }else if (e.getSource() == btnOk3) {
            txtResult.setText("");
             txtResult.setText("SELECT pat_job,COUNT(*) FROM Patients where pat_id IN (select pat_id from Treatments where treat_date between '2013-12-01' and '2014-03-31' AND doc_id IN (select doc_id from Doctors where doc_gen = 'M')) GROUP BY pat_job \n����          2013�� 12������ 2014�� 3���� ������ ������ �ǻ翡�� ������� ȯ�� ��\n");
             rs = stmt.executeQuery(query2);
             while (rs.next()) {
                String str = rs.getString(1) + "\t" + rs.getInt(2) + "\n";
                txtResult.append(str);
             } 
         }
        
      } catch (Exception e2) {
         System.out.println("���� �б� ���� :" + e2);
/*      } finally {
         try {
            if (rs != null)
               rs.close();
            if (stmt != null)
               stmt.close();
            if (con != null)
               con.close();
         } catch (Exception e3) {
            // TODO: handle exception
         }
  */
      }

   }

   public static void main(String[] args) {
      Main BLS = new Main();
      
      //BLS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      //BLS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      BLS.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
          try {
             con.close();
          } catch (Exception e4) {    }
          System.out.println("���α׷� ���� ����!");          
           System.exit(0);//�޸� ����
         }
       });
   }
}
