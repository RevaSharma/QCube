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

public class CheckExistingDBFrame2 extends JFrame implements ActionListener {

    private JLabel mainTitle;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private Connection conn;
    private Statement stmnt;
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
    private String marksNo;
    private ResultSet rs;
   
    
    //List to keep checkboxes corresponding to questions
    private ArrayList list;
    
    public CheckExistingDBFrame2()
    {
        this.setBounds(100, 40, 1200, 800);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Check Existing Database Form");
        
        mainTitle=new JLabel();
        mainTitle.setBounds(270, 15, 1000, 80);
        mainTitle.setText("Check for existing question in the database");
        Font titleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle.setFont(titleFont);
        
        mainTitleUnderline=new JLabel();
        mainTitleUnderline.setBounds(310, 39, 550, 40);
        mainTitleUnderline.setText("____________________________________");
        Font mainTitleUnderlineFont=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline.setFont(mainTitleUnderlineFont);
        
        mainTitleUnderline2=new JLabel();
        mainTitleUnderline2.setBounds(329, 42, 550, 40);
        mainTitleUnderline2.setText("_________________________________");
        Font mainTitleUnderline2Font=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline2.setFont(mainTitleUnderline2Font);
        
        goBack=new JButton();
        goBack.setBounds(300, 700, 300, 60);
        goBack.setText("Go back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        goBackMainMenu=new JButton();
        goBackMainMenu.setBounds(600, 700, 300, 60);
        goBackMainMenu.setText("Go to Main Menu");
        Font goBackMainMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMainMenu.setFont(goBackMainMenuFont);
        goBackMainMenu.addActionListener(this);
        
        c.add(mainTitle);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(goBack);
        c.add(goBackMainMenu);
        
    }
    public void allQuestionData(String level, String paperType,String subject, String topic, String marksNo)
    {
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        this.marksNo=marksNo;
        
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
        
        list= new ArrayList();
        if(con!=null)
        {
            try {
                
                stmnt=con.createStatement();
                que="select * from QuesBank";
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
                          
                          JLabel jl=new JLabel("<html>"+quesNo+"  "+lv+"  "+pt+"  "+tp+"  "+ques+"  "+sub+"  "+mar+"</html>");
                          jl.setBounds(100, yGap, 1000, 150);
                          Font cbFont=new Font("Times New Roman", Font.BOLD, 27);
                          jl.setFont(cbFont);
                          yGap+=90;
                          c.add(jl);
                          //quess.setText(ques);
                          list.add(jl);
                          }
                
            } catch (SQLException ex) {
                Logger.getLogger(DeleteQuestionFrame2.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        else
            System.out.println("Problem in connecting to database");  
         
        
    }
    
    public void fetchDataWithAll(String level, String paperType,String subject, String topic, String marksNo)
    {
        this.level=level;
        this.paperType=paperType;
        this.subject=subject;
        this.topic=topic;
        this.marksNo=marksNo;
        
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
        
        list= new ArrayList<>();
        if(con!=null)
        {
            try {
                
                stmnt=con.createStatement();
                que="select * from QuesBank where Level='"+level+"' and PaperType='"+paperType+"' and Topic='"+topic+"' and Marks='"+marksNo+"' and Subject='"+subject+"'";
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
                          ques=rs.getString(5);
                          System.out.println(ques);
                          
                          JLabel jl=new JLabel("<html>"+quesNo+"  "+lv+"  "+pt+"  "+tp+"  "+ques+"  "+sub+"  "+mar+"</html>");
                          jl.setBounds(140, yGap, 1480, 150);
                          Font cbFont=new Font("Times New Roman", Font.BOLD, 27);
                          jl.setFont(cbFont);
                          yGap+=90;
                          c.add(jl);
                          //quess.setText(ques);
                          list.add(jl);
                          
                          
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DeleteQuestionFrame2.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        else
            System.out.println("Problem in connecting to database");
    }
    
    
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
          
          //JOptionPane.showMessageDialog(null, str , "Message",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(str);
            
            conn=DBConnect.connect2DB();
       // connect2DB();
        
      if(conn!=null)
        {
            try {
                
                stmnt=conn.createStatement();
                String que="delete from QuesBank where Question in("+str+")";
                
                //                que="select Marks,Subject,Level,PaperType,Topic,Question from QuesBank where Level='"+level+"' and PaperType='"+paperType+"' and Topic in("+topic+") and Marks='"+marks+"' and Subject='"+subject+"'";

                System.out.println(que);
               stmnt.execute(que);
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            
            }
            }
         else
            System.out.println("Problem in connecting to database");
              CheckExistingDBFrame2 cedf2=new CheckExistingDBFrame2();
              cedf2.setLayout(null);
              cedf2.setResizable(false);
              cedf2.setVisible(true);
              cedf2.fetchDataWithAll(level,paperType,subject,topic,marksNo);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        

    public static void main(String args[]) {
        
       CheckExistingDBFrame2 cedf2=new CheckExistingDBFrame2();
       cedf2.setLayout(null);
       cedf2.setResizable(false);
       cedf2.setVisible(true);
        
        
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   


/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Level", "Paper Type", "Topic", "Question", "Subject", "Marks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}