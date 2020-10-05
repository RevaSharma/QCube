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
import javax.swing.JTextArea;

/**
 *
 * @author reva
 */
public class EightMarkerQuestionFrame extends JFrame implements ActionListener {
    
    private JLabel mainTitle1;
    private JLabel subTitle;
    private JButton continueAhead;
    private JButton goBackMenu;
    private JButton goBack;
    private JLabel page4of4;
    //private JTextArea quess;
    private Container c;
    
    private String level;
    private String paperType;
    private String subject;
    private String topic;
    private String date;
    private int hours;
    private int min;
    private String noOfQues;
    private String schoolN;
    
    private ArrayList<JCheckBox>list;
    private ArrayList<String>quesList2;
    private ArrayList<String>quesList5;
    private ArrayList<String>quesList8;
    
    public EightMarkerQuestionFrame() {
        
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
        subTitle.setText("Pick the 8 marker questions you want to include the test paper from the list below:");
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
        
        page4of4=new JLabel();
        page4of4.setBounds(675, 780, 350, 60);
        page4of4.setText("Page 5 of 5");
        Font page4of4Font=new Font("Times New Roman", Font.BOLD, 20);
        page4of4.setFont(page4of4Font);
        
        /*quess=new JTextArea();
        quess.setBounds(80, 150, 1200, 550);
        Font quessFont=new Font("Times New Roman", Font.BOLD, 27);
        quess.setFont(quessFont);*/
        
        c.add(mainTitle1);
        c.add(subTitle);
        c.add(continueAhead);
        c.add(goBackMenu);
        c.add(goBack);
        //c.add(quess);
        c.add(page4of4);
    
    }
public void fetchDataWithAll(String level, String paperType,String subject, String topic, String date,int hours, int min, String noOfQues,ArrayList<String>quesList2, ArrayList<String>quesList5,String schoolN)
    {
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        this.date=date;
        this.hours=hours;
        this.min=min;
        this.noOfQues=noOfQues;
        this.quesList2=quesList2;
        this.quesList5=quesList5;
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
        String marks="8";
        int yGap=130;
        list= new ArrayList<JCheckBox>();
        quesList8= new ArrayList<String>();
        if(con!=null)
        {
            try {
                
                stmnt=con.createStatement();
                que="select Marks,Subject,Level,PaperType,Topic,Question from QuesBank where Level='"+level+"' and PaperType='"+paperType+"' and Topic in("+topic+") and Marks='"+marks+"' and Subject='"+subject+"'";

                System.out.println(que);
                rs=stmnt.executeQuery(que);
                while(rs.next())
                {
                          count++;
                          mar=rs.getString(1);
                          sub=rs.getString(2);
                          lv=rs.getString(3);
                          pt=rs.getString(4);
                          tp=rs.getString(5);
                         // ques=ques+count+". ";
                          ques=rs.getString(6);
                          //ques=ques+"\n";
                          //System.out.println(mar+" "+sub+" "+lv+" "+pt+" "+tp+" "+ques);
                          System.out.println(ques);
                          quesList8.add(ques);
                          JCheckBox cb=new JCheckBox("<html>"+ques+"</html>");
                          cb.setBounds(80, yGap, 1200, 100);
                          Font cbFont=new Font("Times New Roman", Font.BOLD, 27);
                          cb.setFont(cbFont);
                          yGap+=90;
                          c.add(cb);
                          //quess.setText(ques);
                          list.add(cb);
                          
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(EightMarkerQuestionFrame.class.getName()).log(Level.SEVERE, null, ex);
                
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
          
          //JOptionPane.showMessageDialog(null, str , "Message",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(str);
        PreviewFrame pf=new PreviewFrame(subject,date,hours,min,noOfQues,level,paperType,quesList2,quesList5,quesList8,schoolN);
       // pf.fetchValues();
        System.out.println(subject);
        this.dispose();
        pf.setLayout(null);
        pf.setResizable(false);
        pf.setVisible(true);
        }
         else if(e.getSource()==goBack)
        {
        JOptionPane.showConfirmDialog(null,"Are you sure you want to go back? Your progress will be lost");
        FiveMarkerQuestionFrame fmqf=new FiveMarkerQuestionFrame();
        this.dispose();
        fmqf.setLayout(null);
        fmqf.setResizable(false);
        fmqf.setVisible(true);
        }
        else if(e.getSource()==goBackMenu)
        {
       JOptionPane.showConfirmDialog(null,"Are you sure you want to go back to the main menu? Your progress will be lost");
       LoginFrame lf=new LoginFrame();
       this.dispose();
       lf.setLayout(null);
       lf.setResizable(false);
       lf.setVisible(true);
        }
    }
    public static void main(String args[]) {
        
        EightMarkerQuestionFrame emqf=new EightMarkerQuestionFrame();
        emqf.setLayout(null);
        emqf.setResizable(false);
        emqf.setVisible(true);
        
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
