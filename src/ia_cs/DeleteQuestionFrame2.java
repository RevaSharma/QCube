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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;


public class DeleteQuestionFrame2 extends JFrame implements ActionListener{
    
    private JLabel mainTitle;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private Connection conn;
    private Statement stmnt;
    private JLabel queToBeDel;
    private JTextArea tbdeleted;
    private JButton deleteQ;
    private JButton goBack;
    private JButton goBackMainMenu;
    private Container c;
    private String q;
    // Data members for values passed from QuestionPaperGeneratorFrame
    private String level;
    private String paperType;
    private String subject;
    private String topic;
    private ResultSet rs;
   
    
    //List to keep checkboxes corresponding to questions
    private ArrayList<JCheckBox>list;
    
    public DeleteQuestionFrame2 ()
    {
        this.setBounds(100, 50, 1200, 800);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Delete Question Form");
        
        mainTitle=new JLabel();
        mainTitle.setBounds(330, 15, 800, 80);
        mainTitle.setText("Delete a question from the database");
        Font titleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle.setFont(titleFont);
        
        mainTitleUnderline=new JLabel();
        mainTitleUnderline.setBounds(360, 39, 550, 40);
        mainTitleUnderline.setText("____________________________________");
        Font mainTitleUnderlineFont=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline.setFont(mainTitleUnderlineFont);
        
        mainTitleUnderline2=new JLabel();
        mainTitleUnderline2.setBounds(379, 42, 550, 40);
        mainTitleUnderline2.setText("_________________________________");
        Font mainTitleUnderline2Font=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline2.setFont(mainTitleUnderline2Font);
        
        queToBeDel=new JLabel();//How to select multiple topics?
        queToBeDel.setBounds(70, 100, 1000, 40);
        queToBeDel.setText("* Select the questions to be deleted:");
        Font queToBeDelFont=new Font("Times New Roman", Font.BOLD, 27);
        queToBeDel.setFont(queToBeDelFont);
        
        /*ogQues=new JTextArea();
        ogQues.setBounds(360, 200, 600, 140);
        Font ogQuesFont=new Font("Times New Roman", Font.BOLD, 25);
        ogQues.setFont(ogQuesFont);
                
        ogQues.setLineWrap(true);
        ogQues.setWrapStyleWord(true);
        JScrollPane scroll2=new JScrollPane(ogQues);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(360, 200, 600, 140);
        ogQues.setEditable(false);*/
        tbdeleted=new JTextArea();
        tbdeleted.setBounds(70, 120, 1000, 500);
        Font tbdeletedFont=new Font("Times New Roman", Font.BOLD, 25);
        tbdeleted.setFont(tbdeletedFont);
        
        tbdeleted.setLineWrap(true);
        tbdeleted.setWrapStyleWord(true);
        JScrollPane scroll2=new JScrollPane(tbdeleted);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(70, 140, 1100, 600);
        tbdeleted.setEditable(false);
        
       
        deleteQ=new JButton();
        deleteQ.setBounds(100, 700, 250, 60);
        deleteQ.setText("Delete question");
        Font deleteQFont=new Font("Times New Roman", Font.BOLD, 27);
        deleteQ.setFont(deleteQFont);
        deleteQ.addActionListener(this);
        
        goBack=new JButton();
        goBack.setBounds(480, 700, 250, 60);
        goBack.setText("Go back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        goBackMainMenu=new JButton();
        goBackMainMenu.setBounds(850, 700, 250, 60);
        goBackMainMenu.setText("Go to Main Menu");
        Font goBackMainMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMainMenu.setFont(goBackMainMenuFont);
        goBackMainMenu.addActionListener(this);
        
        c.add(mainTitle);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(queToBeDel);
        c.add(scroll2);
        c.add(deleteQ);
        c.add(goBack);
        c.add(goBackMainMenu);
        
    }
    
    public void fetchDataWithAll(String level, String paperType,String subject, String topic)
    {
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        
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
        
        
        int yGap=130;
        
        list= new ArrayList<JCheckBox>();
        if(con!=null)
        {
            try {
                
                stmnt=con.createStatement();
                que="select Question from QuesBank where Level='"+level+"' and PaperType='"+paperType+"' and Topic='"+topic+"' and Subject='"+subject+"'";
                System.out.println(que);
                rs=stmnt.executeQuery(que);
                while(rs.next())
                {
                          quesNo=rs.getString(1);
                          mar=rs.getString(7);
                          sub=rs.getString(6);
                          lv=rs.getString(2);
                          pt=rs.getString(3);
                          tp=rs.getString(4);
                         // ques=ques+count+". ";
                          ques=rs.getString(5);
                          //ques=ques+"\n";
                          //System.out.println(mar+" "+sub+" "+lv+" "+pt+" "+tp+" "+ques);
                          System.out.println(ques);
                          
                          //JCheckBox cb=new JCheckBox("<html>"+ques+"</html>");
                          JCheckBox cb=new JCheckBox(ques);
                          cb.setBounds(140, yGap, 1000, 150);
                          Font cbFont=new Font("Times New Roman", Font.BOLD, 27);
                          cb.setFont(cbFont);
                          yGap+=90;
                          c.add(cb);
                          //quess.setText(ques);
                          list.add(cb);
                          tbdeleted.setText(list.toString());
                          for (int index = 0; index < list.size(); index++) {
                         // tbdeleted.append(list.getElementAt(index).toString());
                              tbdeleted.append(list.get(index).toString());
}
                          
                          
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DeleteQuestionFrame2.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        else
            System.out.println("Problem in connecting to database");
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String str="'";
        JCheckBox cb=null;
        if(e.getSource()==deleteQ)
        {
            System.out.println(list.size());
            int i=0;
            for(;i<list.size();i++)
            {
                 cb=(JCheckBox)list.get(i);
                if(cb.isSelected()==true)
                {
                    str+=cb.getText();
                    str+="','";
                }
                
            }
          
            
          str=  str.replace("<html>", "");
          str=str.replace("</html>", "");
          str=str.substring(0, str.length()-2);
          
            conn=DBConnect.connect2DB();
  
        
      if(conn!=null)
        {
            try {
                
                stmnt=conn.createStatement();
                String que="delete from QuesBank where Question in("+str+")";
               stmnt.execute(que);
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            
            }
            }
         else
            System.out.println("Problem in connecting to database");
      
      JOptionPane.showMessageDialog(null, "Record deleted successfully!" , "Message",JOptionPane.INFORMATION_MESSAGE);
       DeleteQuestionFrame2 dqf2=new DeleteQuestionFrame2();
       dqf2.setLayout(null);
       dqf2.setResizable(false);
       dqf2.setVisible(true);
       this.dispose();
       
              dqf2.fetchDataWithAll(level,paperType,subject,topic);
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

    public static void main(String args[]) {
        
       DeleteQuestionFrame2 dqf2=new DeleteQuestionFrame2();
       dqf2.setLayout(null);
       dqf2.setResizable(false);
       dqf2.setVisible(true);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
