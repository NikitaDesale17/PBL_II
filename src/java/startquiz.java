

import java.awt.Frame;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikita
 */
public class startquiz extends javax.swing.JFrame {

    /*private static startquiz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
        Connection con;
        ResultSet rs1;
        PreparedStatement s;
        public int questionId;
        public String answer;
        public int min=0;
        public int sec=0;
        public int marks=0;
        Timer time;
        public int question_count;
        public int question_count_id=1;
        public int cr;
        ButtonGroup g1=new ButtonGroup();
        public String rln;
        ResultSet rs;
        String name;
        public String studentAnswer="";
   
        
    /*
     Creates new form startquiz
     */
    public startquiz(String rollno,int csrid,int q) {
        
        initComponents(); 
        rln = rollno;
        cr = csrid;
        questionId=q;
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);
        rn.setText(rln);
      
        
        try{
            String s1="select *from student where rollno='"+rln+"'";
            String driverName="oracle.jdbc.driver.OracleDriver";
         Class.forName(driverName);
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
         PreparedStatement s= con.prepareStatement(s1);
         rs =s.executeQuery();
          if(rs.next())
        {
            name=rs.getString(2);
            nm.setText(rs.getString(2));
            //rn.setEditable(false);
        }
        else
        {
            Frame jf = new JFrame();
                jf.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jf,"Student does not exists");
    
        } 
         
          
        try
        {
         Class.forName(driverName);
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
        Statement st1=con.createStatement();
        String qr="select * from quiz where c_id='"+cr+"' and q_id='"+questionId+"'";
        rs1=st1.executeQuery(qr);
        questionId++;
//        answercheck();  
        while(rs1.next())
    { 
        
      qn.setText(String.valueOf(question_count_id));
    //qn.setText(rs1.getString(1));
    askedque.setText(rs1.getString(2));
    r1.setText(rs1.getString(3));
    r2.setText(rs1.getString(4));
    r3.setText(rs1.getString(5));
    r4.setText(rs1.getString(6));
    answer=rs1.getString(7);   
    
    }
       
    }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,e);
  
  }
        
          try
        {
         Class.forName(driverName);
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
        Statement st1=con.createStatement();
        String qr="select count(*) from quiz where c_id='"+cr+"'";
        rs1=st1.executeQuery(qr);
        rs1.next(); 
        question_count=rs1.getInt(1);    
        tq.setText(String.valueOf(question_count));
    }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,e);
  
  }
          
            SimpleDateFormat dFormat=new SimpleDateFormat("dd-mm-yyyy");
            Date date=new Date();
            dt.setText(dFormat.format(date));
         
        }catch(Exception es){
            JOptionPane.showMessageDialog(null,es);
        } 
        
        
        
        
        
        
        
        
        
        
       
    }
    //functions of answer and question
    
public void answerCheck()
{
    try
    {
    
    if(r1.isSelected())
    {
        studentAnswer=r1.getText();
    }
    else if(r2.isSelected())
    {
        studentAnswer=r2.getText();

    }
    else if(r3.isSelected())
    {

        studentAnswer=r3.getText();

    }
    else if(r4.isSelected())
    {

        studentAnswer=r4.getText();

    }
    else{
        System.out.println("Select the option.");
    }
    
    if(studentAnswer.equals(answer))
    {

        marks++;
        String marks1=String.valueOf(marks);
        //scr.setText(marks1);
    } 
   
    questionId++;
    }catch(Exception xe){
        JOptionPane.showMessageDialog(null,xe);
    }


}


public void question()
{
try
  {
        
        
        String driverName="oracle.jdbc.driver.OracleDriver";
         Class.forName(driverName); 
         question_count_id++;
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
        //Statement st1=con.createStatement();
        String qr="select * from quiz where c_id='"+cr+"'and q_id='"+questionId+"'";
        Statement stm=con.createStatement(); 
        rs1=stm.executeQuery(qr); 
       
    while(rs1.next())
    { 
        qn.setText(String.valueOf(question_count_id));
        tq.setText(String.valueOf(question_count));
        //    qn.setText(rs1.getString(1));
        askedque.setText(rs1.getString(2));
        r1.setText(rs1.getString(3));
        r2.setText(rs1.getString(4));
        r3.setText(rs1.getString(5));
        r4.setText(rs1.getString(6));
        answer=rs1.getString(7);    
    }
   
  
  }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,e);
  
  }
 
}
    
    

    private startquiz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        tt = new javax.swing.JLabel();
        rn = new javax.swing.JLabel();
        nm = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tq = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        qn = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        askedque = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));

        jLabel14.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("All The Best");

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel4.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel3.setText("Total time:");

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel1.setText("Roll no:");

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel6.setText("Name:");

        dt.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        dt.setText("dt");

        tt.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        tt.setText("10 min");

        rn.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        rn.setText("rn");

        nm.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        nm.setText("nm");

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel7.setText("Total Questions:");

        tq.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        tq.setText("tq");

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jLabel8.setText("Questions No:");

        qn.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        qn.setText("1");

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jLabel9.setText("Question:");

        askedque.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        askedque.setText("askedque");

        r1.setBackground(new java.awt.Color(255, 255, 255));
        r1.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        r1.setText("r1");

        r2.setBackground(new java.awt.Color(255, 255, 255));
        r2.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        r2.setText("r2");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        r3.setBackground(new java.awt.Color(255, 255, 255));
        r3.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        r3.setText("r3");

        r4.setBackground(new java.awt.Color(255, 255, 255));
        r4.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        r4.setText("r4");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit & next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(askedque, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(313, 313, 313)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(185, 185, 185)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(qn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addGap(76, 76, 76)
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(tq, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(dt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tt))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qn))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(askedque)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
     
    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    
    
         
          if(question_count_id<=question_count)
          {
                question();
                answerCheck();
          }
          else 
          {   
              //redirection 
             
                 new congratulations(name,marks).setVisible(true); 
                 this.dispose();
             
//           else if(marks<=3){
//                new needimp(name,marks).setVisible(true); 
//                this.dispose();
//             }

              
              try{
                    String s1="insert into selectquiz values(?,?,?)";
                    String driverName="oracle.jdbc.driver.OracleDriver";
                    Class.forName(driverName);
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
                    s= con.prepareStatement(s1);
                    
                    s.setString(1,String.valueOf(rln));
                    s.setString(2,String.valueOf(cr));
                    s.setString(3,String.valueOf(marks));
                    s.executeUpdate();
                    //JOptionPane.showMessageDialog(null,studentAnswer);
              }catch( HeadlessException | ClassNotFoundException | SQLException ex)
              {
                JOptionPane.showMessageDialog(null,ex);
                }
              
          
//             else if(marks>3 && marks<7){
//                
//            }
              //JOptionPane.showMessageDialog(null,"Thank you"); 
              
          
              
          
            
//                   else if(marks<=3){
//                 //new needimp(rln,marks).setVisible(true); 
//                 this.dispose();
//             }
//             else if(marks>3 && marks<7){
//                 
//             }
              //JOptionPane.showMessageDialog(null,"Thank you"); 
              
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startquiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form 
        instructionStudent i= new instructionStudent();
        
        */
        //startquiz(){}
        
        //startquiz str = new startquiz();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startquiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel askedque;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel dt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel qn;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JLabel rn;
    private javax.swing.JLabel tq;
    private javax.swing.JLabel tt;
    // End of variables declaration//GEN-END:variables

    private void answercheck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
