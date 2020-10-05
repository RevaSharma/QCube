/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import apple.laf.JRSUIUtils.ScrollBar;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateQuestionFrame2 extends JFrame implements ActionListener{
    
    private JLabel mainTitle;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private JLabel originalQuestion;
    private JTextArea ogQues;
    private JLabel updatedQuestion;
    private JTextArea enterUpdatedQ;
    private JButton updateB;
    private JButton goBack;
    private JButton goBackMainMenu;
    private Container c;
    private Connection conn;
    private Statement stmnt;
    
    private String level;
    private String paperType;
    private String subject;
    private String topic;
    private ResultSet rs;
    private String noOfMarks;
    private String quesID;
    private String question;
    
    public UpdateQuestionFrame2()
    
    {
        this.setBounds(200, 100, 1000, 700);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(3);
        this.setTitle("Update Question Form");
        
        mainTitle=new JLabel();
        mainTitle.setBounds(140, 15, 800, 80);
        mainTitle.setText("Update a question from the database");
        Font titleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle.setFont(titleFont);
        
        mainTitleUnderline=new JLabel();
        mainTitleUnderline.setBounds(135, 39, 550, 40);
        mainTitleUnderline.setText("____________________________________");
        Font mainTitleUnderlineFont=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline.setFont(mainTitleUnderlineFont);
        
        mainTitleUnderline2=new JLabel();
        mainTitleUnderline2.setBounds(140, 42, 550, 40);
        mainTitleUnderline2.setText("_________________________________");
        Font mainTitleUnderline2Font=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline2.setFont(mainTitleUnderline2Font);
        
        originalQuestion=new JLabel();
        originalQuestion.setBounds(70, 200, 1000, 40);
        originalQuestion.setText("* Original Question is:");
        Font originalQuestionFont=new Font("Times New Roman", Font.BOLD, 27);
        originalQuestion.setFont(originalQuestionFont);
        
        ogQues=new JTextArea();
        ogQues.setBounds(360, 200, 600, 140);
        Font ogQuesFont=new Font("Times New Roman", Font.BOLD, 25);
        ogQues.setFont(ogQuesFont);
                
        ogQues.setLineWrap(true);
        ogQues.setWrapStyleWord(true);
        JScrollPane scroll2=new JScrollPane(ogQues);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(360, 200, 600, 140);
        ogQues.setEditable(false);
        
        updatedQuestion=new JLabel();
        updatedQuestion.setBounds(70, 400, 1000, 40);
        updatedQuestion.setText("* Updated Question is:");
        Font updatedQuestionFont=new Font("Times New Roman", Font.BOLD, 27);
        updatedQuestion.setFont(updatedQuestionFont);
        
        enterUpdatedQ=new JTextArea();
        enterUpdatedQ.setBounds(360, 400, 480, 140);
        Font enterUpdatedQFont=new Font("Times New Roman", Font.BOLD, 25);
        enterUpdatedQ.setFont(enterUpdatedQFont);
        
        enterUpdatedQ.setLineWrap(true);
        enterUpdatedQ.setWrapStyleWord(true);
        JScrollPane scroll=new JScrollPane(enterUpdatedQ);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(360, 400, 600, 140);
        
        updateB=new JButton();
        updateB.setBounds(70, 580, 250, 60);
        updateB.setText("Update Question");
        Font updateBFont=new Font("Times New Roman", Font.BOLD, 27);
        updateB.setFont(updateBFont);
        updateB.addActionListener(this);
        
        goBack=new JButton();
        goBack.setBounds(400, 580, 250, 60);
        goBack.setText("Go back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        goBackMainMenu=new JButton();
        goBackMainMenu.setBounds(700, 580, 250, 60);
        goBackMainMenu.setText("Go to Main Menu");
        Font goBackMainMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMainMenu.setFont(goBackMainMenuFont);
        goBackMainMenu.addActionListener(this);
        
        c.add(mainTitle);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(originalQuestion);
        //c.add(ogQues);
        c.add(scroll2);
        c.add(updatedQuestion);
        //c.add(enterUpdatedQ);
        c.add(updateB);
        c.add(goBack);
        c.add(goBackMainMenu);
        c.add(scroll);
        
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void fetchDataWithAll(String subject, String level, String paperType, String topic, String noOfMarks, String quesID)
    {
        this.noOfMarks=noOfMarks;
        this.quesID=quesID;
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        this.question=question;
        
        Connection con=DBConnect.connect2DB();
        Statement stmnt;
        String que;
        ResultSet rs;
        String lv;
        String pt;
        String tp;
        String mar;
        String sub;
        String quesNo;
        String ques="";
        
        if(con!=null)
        {
            try {
                
                stmnt=con.createStatement();
                que="select Question from QuesBank where QuesID='"+quesID+"'";
                System.out.println(que);
                rs=stmnt.executeQuery(que);
                ques=rs.getString(1);
                System.out.println(ques);
               
                //ogQues.setText("<html>"+ques+"</html>");
                ogQues.setText(ques);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuestionFrame2.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            finally 
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateQuestionFrame2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
            System.out.println("Problem in connecting to database");
    }
    
 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String updatedQues=enterUpdatedQ.getText();
        if(e.getSource()==updateB)  
        {
            conn=DBConnect.connect2DB();
            
      if(conn!=null)
        {
            try
            {
                
                stmnt=conn.createStatement();
                String que="update QuesBank set Question='"+updatedQues+"' where QuesID='"+quesID+"'";
                System.out.println(que);
                stmnt.executeUpdate(que);
                JOptionPane.showMessageDialog(null, "Record updated successfully!" , "Message",JOptionPane.INFORMATION_MESSAGE);
                //conn.close();
                
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            
            }
            }
         else
            System.out.println("Problem in connecting to database");
      
      
      UpdateQuestionFrame2 uqf2=new UpdateQuestionFrame2();
       uqf2.setLayout(null);
       uqf2.setResizable(false);
       uqf2.setVisible(true);
       this.dispose();
       uqf2.fetchDataWithAll(subject, level, paperType, topic, noOfMarks, quesID);
            
        }
        if(e.getSource()==goBack)
        {
        DatabaseFrame df=new DatabaseFrame();
        this.dispose();
        df.setLayout(null);
        df.setResizable(false);
        df.setVisible(true);
        }
        if(e.getSource()==goBackMainMenu)
        {
        AdminFrame af=new AdminFrame();
        this.dispose();
        af.setLayout(null);
        af.setResizable(false);
        af.setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        
       UpdateQuestionFrame2 uqf2=new UpdateQuestionFrame2();
       uqf2.setLayout(null);
       uqf2.setResizable(false);
       uqf2.setVisible(true);
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
