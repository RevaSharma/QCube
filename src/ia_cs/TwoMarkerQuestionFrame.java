/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author reva
 */
public class TwoMarkerQuestionFrame extends JFrame implements ActionListener{

    private JLabel mainTitle1;
    private JLabel subTitle;
    private JButton continueAhead;
    private JButton goBackMenu;
    private JButton goBack;
    private JLabel page2of4;
  //  public JTextArea quess;
    private Container c;
    
    
    // Data members for values passed from QuestionPaperGeneratorFrame
    private String level;
    private String paperType;
    private String subject;
    private String topic;
    private String date;
    private int hours;
    private int min;
    private String noOfQues;
    private String schoolN;
    
    //List to keep checkboxes corresponding to questions
    private ArrayList<JCheckBox>list;
    
    //list to keep retrieved questions
    private ArrayList<String>quesList2;
    
    public TwoMarkerQuestionFrame() {
        
        this.setBounds(40, 10, 1350, 860);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Pick your Questions Form");
        
        mainTitle1=new JLabel();
        mainTitle1.setBounds(330, 15, 800, 70);
        mainTitle1.setText("Choose your Questions for the Test Paper");
        Font mainTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle1.setFont(mainTitleFont);
        
        subTitle=new JLabel();
        subTitle.setBounds(100, 90, 1200, 70);
        subTitle.setText("Pick the 2 marker questions you want to include the test paper from the list below:");
        Font subTitleFont=new Font("Times New Roman", Font.BOLD, 33);
        subTitle.setFont(subTitleFont);
        
        continueAhead=new JButton();
        continueAhead.setBounds(100, 720, 350, 60);
        continueAhead.setText("Continue");
        Font continueAheadFont=new Font("Times New Roman", Font.BOLD, 27);
        continueAhead.setFont(continueAheadFont);
        continueAhead.addActionListener(this);
        
        goBackMenu=new JButton();
        goBackMenu.setBounds(915, 720, 350, 60);
        goBackMenu.setText("Return to main menu");
        Font goBackMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMenu.setFont(goBackMenuFont);
        goBackMenu.addActionListener(this);
        
        goBack=new JButton();
        goBack.setBounds(505, 720, 350, 60);
        goBack.setText("Back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        page2of4=new JLabel();
        page2of4.setBounds(675, 780, 350, 60);
        page2of4.setText("Page 3 of 5");
        Font page2of4Font=new Font("Times New Roman", Font.BOLD, 20);
        page2of4.setFont(page2of4Font);
        
        /*quess=new JTextArea();
        quess.setBounds(80, 150, 1200, 550);
        Font quessFont=new Font("Times New Roman", Font.BOLD, 27);
        quess.setFont(quessFont);*/
        
        c.add(mainTitle1);
        c.add(subTitle);
        c.add(continueAhead);
        c.add(goBackMenu);
        c.add(goBack);
      //  c.add(quess);
        c.add(page2of4);
    }
    public void fetchDataWithAll(String level, String paperType,String subject, String topic, String date, int hours, int min, String noOfQues,String schoolN)
    {
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        this.date=date;
        this.hours=hours;
        this.min=min;
        this.noOfQues=noOfQues;
        this.schoolN=schoolN;
        
        Connection con=DBConnect.connect2DB();
        Statement stmnt;
        String que;
        ResultSet rs;
        String lv;
        String pt;
        String tp;
        String mar;
        String sub;
        String ques="";
        int count=0;
        String marks="2";
        int yGap=130;
        
        list= new ArrayList<JCheckBox>();
        quesList2=new ArrayList<String>();
        if(con!=null)
        {try {
                stmnt=con.createStatement();
                que="select Marks,Subject,Level,PaperType,Topic,"
       + "Question from QuesBank where Level='"+level+"' and PaperType='"+paperType+"' and Topic in("+topic+") and Marks='"+marks+"' and Subject='"+subject+"'";
                
                rs=stmnt.executeQuery(que);
                while(rs.next())
                {
                          count++;
                          mar=rs.getString(1);
                          sub=rs.getString(2);
                          lv=rs.getString(3);
                          pt=rs.getString(4);
                          tp=rs.getString(5);
                          ques=rs.getString(6);
                          quesList2.add(ques);
                          JCheckBox cb=new JCheckBox("<html>"+ques+"</html>");
                          cb.setBounds(80, yGap, 1200, 100);
                          Font cbFont=new Font("Times New Roman", Font.BOLD, 27);
                          cb.setFont(cbFont);
                          yGap+=90;
                          c.add(cb);
                          list.add(cb);   
                }
            } catch (SQLException ex) {
                Logger.getLogger(TwoMarkerQuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            System.out.println("Problem in connecting to database");
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     @Override
    public void actionPerformed(ActionEvent e) {
       String str="";
        if(e.getSource()==continueAhead)
        {
            for(JCheckBox cb:list)
            {
                if(cb.isSelected()==true)
                str+=cb.getText();
                str+="\n\n";
            } 
            
          str=  str.replace("<html>", "");
          str=str.replace("</html>", "");
            
        FiveMarkerQuestionFrame fmqf=new FiveMarkerQuestionFrame();
        this.dispose();
        fmqf.setLayout(null);
        fmqf.setResizable(false);
        fmqf.setVisible(true);
        fmqf.fetchDataWithAll(level, paperType, subject, topic,date,hours,min,noOfQues,quesList2,schoolN);
        }
         else if(e.getSource()==goBack)
        {
       JOptionPane.showConfirmDialog(null,"Are you sure you want to go back to the main menu? Your progress will be lost");
       QuestionPaperGeneratorFrame qpf=new QuestionPaperGeneratorFrame();
       this.dispose();
        qpf.setLayout(null);
        qpf.setResizable(false);
        qpf.setVisible(true);
        }
        else if(e.getSource()==goBackMenu)
        {
       JOptionPane.showConfirmDialog(null,"Are you sure you want to go back? Your progress will be lost");
       LoginFrame lf=new LoginFrame();
       this.dispose();
       lf.setLayout(null);
       lf.setResizable(false);
       lf.setVisible(true);
        }
    }
    public static void main(String args[]) {
        
        TwoMarkerQuestionFrame tmqf=new TwoMarkerQuestionFrame();
        tmqf.setLayout(null);
        tmqf.setResizable(false);
        tmqf.setVisible(true);
        //tmqf.fetchDataWithAll("AS", "Paper1", "2", "Computer Science", "Processor Fundamentals");
        
       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
}
