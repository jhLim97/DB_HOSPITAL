
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
   String userid = "[userid]";
   String pwd = "[password]";

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
	   
      btnInit = new JButton("DB초기화");
      btnIn = new JButton("입력");
      btnOk1 = new JButton("검색1");
      btnOk2 = new JButton("검색2");
      btnOk3 = new JButton("검색3");
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
         System.out.println("드라이버 로드 성공");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      
      try { /* 데이터베이스를 연결하는 과정 */
          System.out.println("데이터베이스 연결 준비...");
          con = DriverManager.getConnection(url, userid, pwd);
          System.out.println("데이터베이스 연결 성공");
       } catch (SQLException e1) {
          e1.printStackTrace();
       }
   }
   
   private class ActionListenerInit implements ActionListener {
      public void actionPerformed (ActionEvent e) {
         int rowcount;
         
         System.out.println("DB 초기화는 여기에");
         
         try {
            stmt = con.createStatement();
            
            String query = "delete FROM Charts";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Charts 테이블에서 " +rowcount+ " 튜플 삭제");
            
            query = "delete FROM Treatments";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Treatments 테이블에서 " +rowcount+ " 튜플 삭제");
            
            query = "delete FROM Patients";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Patients 테이블에서 " +rowcount+ " 튜플 삭제");
            
            query = "delete FROM Doctors";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Doctors 테이블에서 " +rowcount+ " 튜플 삭제");
            
            query = "delete FROM Nurses";
            rowcount = stmt.executeUpdate(query);
            System.out.println("Nurses 테이블에서 " +rowcount+ " 튜플 삭제");
            
            //의사
            stmt.executeUpdate("insert into Doctors values(980312, '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(000601, '내과', '안성기', 'M', '011-222-0987', 'ask@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(001208, '외과', '김민종', 'M', '010-333-8743', 'kmj@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(020403, '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(050900, '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(050101, '내과', '차태현', 'M', '011-222-7643', 'cth@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(062019, '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(070576, '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(080543, '방사선과', '유재석', 'M', '010-222-1263', 'yjs@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(091001, '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(100001, '소아과', '임준혁', 'M', '010-333-1341', 'lt1@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100002, '내과', '이예지', 'F', '010-333-1342', 'lt2@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(100003, '내과', '이재민', 'M', '010-333-1343', 'lt3@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100004, '소아과', '윤호민', 'M', '010-333-1344', 'lt4@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(100005, '피부과', '이동재', 'M', '010-333-1345', 'lt5@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100006, '소아과', '장우혁', 'M', '010-333-1346', 'lt66@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100007, '피부과', '강진혁', 'M', '010-333-1347', 'lt7@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100008, '소아과', '김진우', 'M', '010-333-1348', 'lt8@hanbh.com','전문의');");
            stmt.executeUpdate("insert into Doctors values(100009, '외과', '이민지', 'M', '010-333-1349', 'lt9@hanbh.com','과장');");
            stmt.executeUpdate("insert into Doctors values(100010, '소아과', '이나희', 'F', '010-333-1350', 'lt10@hanbh.com','과장');");
            //간호사
            stmt.executeUpdate("insert into Nurses values(050302, '소아과', '김은영','F', '010-555-8751', 'key@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(050021, '내과', '윤성애','F', '016-333-8745', 'ysa@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(040089, '피부과', '신지원','M', '010-666-7646', 'sjw@hanbh.com', '주임');");
            stmt.executeUpdate("insert into Nurses values(070605, '방사선과', '유정화','F', '010-333-4588', 'yjh@hanbh.com', '주임');");
            stmt.executeUpdate("insert into Nurses values(070804, '내과', '라하나','F', '010-222-1340', 'nhn@hanbh.com', '주임');");
            stmt.executeUpdate("insert into Nurses values(071018, '소아과', '김화경','F', '019-888-4116', 'khk@hanbh.com', '주임');");
            stmt.executeUpdate("insert into Nurses values(100356, '소아과', '이선용','M', '010-777-1234', 'lsy@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(104145, '외과', '김현','M', '010-999-8520', 'kh@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(120309, '피부과', '박성완','M', '010-777-4996', 'psw@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(130211, '외과', '이서연','F', '010-222-3214', 'lsy2@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(200001, '소아과', '이슬기','F', '010-555-9001', 'key1@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(200002, '소아과', '민경훈','F', '010-555-9002', 'key2@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(200003, '소아과', '강호동','F', '010-555-8752', 'key3@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(200004, '외과', '이수근','F', '010-555-8753', 'key4@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(200005, '소아과', '이승기','F', '010-555-8754', 'key5@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(200006, '소아과', '박나래','F', '010-555-8755', 'key6@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(200007, '피부과', '한혜진','F', '010-555-8756', 'key7@hanbh.com', '간호사');");
            stmt.executeUpdate("insert into Nurses values(200008, '소아과', '고은아','F', '010-555-8757', 'key8@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(200009, '외과', '김동현','F', '010-555-8758', 'key9@hanbh.com', '수간호사');");
            stmt.executeUpdate("insert into Nurses values(200010, '내과', '정찬성','F', '010-555-8759', 'key10@hanbh.com', '수간호사');");
            //환자
            stmt.executeUpdate("insert into Patients values(2345, 050302, 980312, '안상건', 'M', '232345', '서울', '010-555-7845', 'ask@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(3545, 040089, 020403, '김성룡', 'M', '543545', '서울', '010-333-7812', 'ksr@ab.com', '자영업');");
            stmt.executeUpdate("insert into Patients values(3424, 070605, 080543, '이종진', 'M', '433424', '부산', '010-888-4859', 'ljj@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(7675, 100356, 050900, '최광석', 'M', '677675', '당진', '010-222-4847', 'cks@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(4533, 070804, 000601, '정한경', 'M', '744533', '강릉', '010-777-9630', 'jhk@ab.com', '교수');");
            stmt.executeUpdate("insert into Patients values(5546, 120309, 070576, '유원현', 'M', '765546', '대구', '010-777-0214', 'ywh@ab.com', '자영업');");
            stmt.executeUpdate("insert into Patients values(4543, 070804, 050101, '최재정', 'M', '454543', '부산', '010-555-4187', 'cjj@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(9768, 130211, 091001, '이진희', 'F', '119768', '서울', '010-888-3675', 'ljh@ab.com', '교수');");
            stmt.executeUpdate("insert into Patients values(4234, 130211, 091001, '오나미', 'F', '234234', '속초', '010-999-6541', 'onm@ab.com', '학생');");
            stmt.executeUpdate("insert into Patients values(7643, 071018, 062019, '송성묵', 'M', '987643', '서울', '010-222-5874', 'ssm@ab.com', '학생');");
            stmt.executeUpdate("insert into Patients values(1001, 050302, 980312, '조진웅', 'M', '232341', '서울', '010-555-7841', 'ask1@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1002, 050302, 980312, '안성기', 'M', '232342', '서울', '010-555-7842', 'ask2@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1003, 050302, 980312, '이병헌', 'M', '232343', '서울', '010-555-7843', 'ask3@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1004, 050302, 980312, '하정우', 'M', '232344', '서울', '010-555-7844', 'ask4@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1005, 050302, 980312, '손상우', 'M', '232346', '서울', '010-555-7846', 'ask5@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1006, 050302, 980312, '송병헌', 'M', '232347', '서울', '010-555-7847', 'ask66@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1007, 050302, 980312, '이시언', 'M', '232348', '서울', '010-555-7848', 'ask7@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1008, 050302, 980312, '성훈', 'M', '232349', '서울', '010-555-7849', 'ask8@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1009, 050302, 980312, '권나라', 'F', '232350', '서울', '010-555-7850', 'ask9@ab.com', '회사원');");
            stmt.executeUpdate("insert into Patients values(1010, 050302, 980312, '혜리', 'F', '232351', '서울', '010-555-7851', 'ask10@ab.com', '회사원');");
            //치료
            stmt.executeUpdate("insert into Treatments values(130516023, 2345, 980312, '감기,몸살', STR_TO_DATE('2013-05-16','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(130628100, 3545, 020403, '피부 트러블 치료', STR_TO_DATE('2013-06-28','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131205056, 3424, 080543, '목 디스크로 MRI촬영', STR_TO_DATE('2013-12-05','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131218024, 7675, 050900, '중이염', STR_TO_DATE('2013-12-18','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(131224012, 4533, 000601, '장염', STR_TO_DATE('2013-12-24','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(140103001, 5546, 070576, '여드름 치료', STR_TO_DATE('2014-01-03','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140109026, 4543, 050101, '위염', STR_TO_DATE('2014-01-09','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140226102, 9768, 091001, '화상치료', STR_TO_DATE('2014-02-26','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140303003, 4234, 091001, '교통사고 외상치료', STR_TO_DATE('2014-03-03','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(140308087, 7643, 062019, '장염', STR_TO_DATE('2014-03-08','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(150516021, 1001, 980312, '감기,몸살', STR_TO_DATE('2014-05-17','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516022, 1002, 980312, '장염', STR_TO_DATE('2014-05-18','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516023, 1003, 980312, '장염', STR_TO_DATE('2014-05-19','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516024, 1004, 980312, '감기,몸살', STR_TO_DATE('2014-05-20','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516025, 1005, 980312, '피부염', STR_TO_DATE('2014-05-21','%Y-%m-%d'));");
            
            stmt.executeUpdate("insert into Treatments values(150516026, 1006, 980312, '몸살', STR_TO_DATE('2014-05-22','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516027, 1007, 980312, '두통', STR_TO_DATE('2014-05-23','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516028, 1008, 980312, '피로', STR_TO_DATE('2014-05-24','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516029, 1009, 980312, '인대', STR_TO_DATE('2014-05-25','%Y-%m-%d'));");
            stmt.executeUpdate("insert into Treatments values(150516030, 1010, 980312, '감기', STR_TO_DATE('2014-05-26','%Y-%m-%d'));");
            
            
            //차트 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('1', 130516023, 980312, 2345, 050302, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('2', 130628100, 020403, 3545, 040089, '한달 후에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('3', 131205056, 080543, 3424, 070605, '이주 후에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('4', 131218024, 050900, 7675, 100356, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('5', 131224012, 000601, 4533, 070804, '다음주에 내원하세요');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('6', 140103001, 070576, 5546, 120309, '안오셔도 됩니다');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('7', 140109026, 050101, 4543, 070804, '술 그만 드세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('8', 140226102, 091001, 9768, 130211, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('9', 140303003, 091001, 4234, 130211, '안오셔도 됩니다');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('10', 140308087, 062019, 7643, 071018, '다음주에 내원하세요');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('11', 150516021, 980312, 1001, 050302, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('12', 150516022, 980312, 1002, 050302, '이주 후에 오세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('13', 150516023, 980312, 1003, 050302, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('14', 150516024, 980312, 1004, 050302, '한달 후에 오세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('15', 150516025, 980312, 1005, 050302, '다음주에 내원하세요');"); 
            
            stmt.executeUpdate("INSERT INTO Charts VALUES ('16', 150516026, 980312, 1006, 050302, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('17', 150516027, 980312, 1007, 050302, '안 오셔도 됩니다');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('18', 150516028, 980312, 1008, 050302, '다음주에 내원하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('19', 150516029, 980312, 1009, 050302, '쾌차하세요');"); 
            stmt.executeUpdate("INSERT INTO Charts VALUES ('20', 150516030, 980312, 1010, 050302, '다음주에 내원하세요');"); 
  
         } catch (Exception e4) {
            System.out.println("DB 초기화 실패" + e4);
         }
         txtResult.setText("");//5월1일
      }
   }

   
   private class ActionListenerInput implements ActionListener{//전체 추가
      public void actionPerformed(ActionEvent e) {
          //pn2.setVisible(true);
         try {  
            //stmt = con.createStatement();
        	 input.setVisible(true);
         }catch (Exception e1) {
               System.out.println("쿼리 읽기 실패 :" + e1);
         }
      }
   }
   
   private class ActionListenerSearch implements ActionListener{//전체 추가
	      public void actionPerformed(ActionEvent e) {
	          //pn2.setVisible(true);
	         try {  
	            //stmt = con.createStatement();
	        	 search.setVisible(true);
	         }catch (Exception e1) {
	               System.out.println("쿼리 읽기 실패 :" + e1);
	         }
	      }
	   }

   @Override
   public void actionPerformed(ActionEvent e) {
    
      try {
         stmt = con.createStatement();
         String query1 = "SELECT doc_position,COUNT(*) AS '직위별 의사 수' FROM Doctors where doc_id IN(select doc_id from Patients where pat_addr = '서울') GROUP BY doc_position  ";
         String query2 = "SELECT pat_job,COUNT(*) FROM Patients where pat_id IN (select pat_id from Treatments where treat_date between '2013-12-01' and '2014-03-31' AND doc_id IN (select doc_id from Doctors where doc_gen = 'M')) GROUP BY pat_job";
         if (e.getSource() == btnOk2) {
            txtResult.setText("");
             txtResult.setText("SELECT doc_position,COUNT(*) AS '직위별 의사 수' FROM Doctors where doc_id IN(select doc_id from Patients where pat_addr = '서울') GROUP BY doc_position  \n직위     서울에 거주하는 환자를 진료한 의사 수\n");
             rs = stmt.executeQuery(query1);
             while (rs.next()) {
                String str = rs.getString(1) + "\t" + rs.getInt(2) + "\n";
                txtResult.append(str);
             } 
         }else if (e.getSource() == btnOk3) {
            txtResult.setText("");
             txtResult.setText("SELECT pat_job,COUNT(*) FROM Patients where pat_id IN (select pat_id from Treatments where treat_date between '2013-12-01' and '2014-03-31' AND doc_id IN (select doc_id from Doctors where doc_gen = 'M')) GROUP BY pat_job \n직업          2013년 12월부터 2014년 3월에 성별이 남자인 의사에게 진료받은 환자 수\n");
             rs = stmt.executeQuery(query2);
             while (rs.next()) {
                String str = rs.getString(1) + "\t" + rs.getInt(2) + "\n";
                txtResult.append(str);
             } 
         }
        
      } catch (Exception e2) {
         System.out.println("쿼리 읽기 실패 :" + e2);
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
          System.out.println("프로그램 완전 종료!");          
           System.exit(0);//메모리 제거
         }
       });
   }
}
