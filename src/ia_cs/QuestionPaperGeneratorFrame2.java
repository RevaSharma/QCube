/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import com.github.lgooddatepicker.components.DatePicker;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class QuestionPaperGeneratorFrame2 extends JFrame implements ActionListener {

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
    private JLabel mainTitle1;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private JLabel subTitle;
    private JLabel timeAllotted;
    private JLabel hoursAll;
    private JLabel minutesAll;
    private JLabel numberOfQues;
    private JTextField numberOfQuesText;
    private JLabel selectTestTopics;
    private JLabel multipleOption;
    private JLabel multipleOption2;
    private JList topicChoiceslist;
    private JButton continueAhead;
    private JButton goBackMenu;
    private JButton goBack;
    private JLabel page2of5;
    private String date;
    private Container c;
    
    //values accepted from QuestionPaperGeneratorFrame
    private String subject;
    private String level;
    private String paperType;
    private String schoolN;
    
    public QuestionPaperGeneratorFrame2()
    {
        
    }
    
    public QuestionPaperGeneratorFrame2(String subject, String level, String paperType, String date,String schoolN)
    {
        this.subject=subject;
        this.level=level;
        this.paperType=paperType;
        this.date=date;
        this.schoolN=schoolN;
        
        this.setBounds(40, 15, 1350, 860);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Question Paper Generator Form");
        
        mainTitle1=new JLabel();
        mainTitle1.setBounds(440, 15, 600, 70);
        mainTitle1.setText("Question Paper Generator");
        Font mainTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle1.setFont(mainTitleFont);
        
        mainTitleUnderline=new JLabel();
        mainTitleUnderline.setBounds(415, 40, 550, 40);
        mainTitleUnderline.setText("_________________________________");
        Font mainTitleUnderlineFont=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline.setFont(mainTitleUnderlineFont);
        
        mainTitleUnderline2=new JLabel();
        mainTitleUnderline2.setBounds(430, 45, 550, 40);
        mainTitleUnderline2.setText("_______________________________");
        Font mainTitleUnderline2Font=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline2.setFont(mainTitleUnderline2Font);
        
        subTitle=new JLabel();
        subTitle.setBounds(100, 90, 800, 70);
        subTitle.setText("Continue picking your specifications: ");
        Font subTitleFont=new Font("Times New Roman", Font.BOLD, 33);
        subTitle.setFont(subTitleFont);
        
        hoursAll=new JLabel("Hrs");
        hoursAll.setBounds(510, 160, 100, 40);
        minutesAll=new JLabel("Mins");
        minutesAll.setBounds(710, 160, 100, 40);
        Font timeFont=new Font("Times New Roman", Font.BOLD, 17);
        hoursAll.setFont(timeFont);
        minutesAll.setFont(timeFont);
        
        timeAllotted=new JLabel();
        timeAllotted.setBounds(100, 200, 1000, 40);
        timeAllotted.setText("* Time allotted for this test:");
        Font timeAllottedFont=new Font("Times New Roman", Font.BOLD, 27);
        timeAllotted.setFont(timeAllottedFont);
        
        hoursSpinner=new JSpinner();
        hoursSpinner.setBounds(500, 200, 100, 40);
        minutesSpinner=new JSpinner();
        minutesSpinner.setBounds(700, 200, 100, 40);
        Font timeSpinnerFont=new Font("Times New Roman", Font.BOLD, 27);
        hoursSpinner.setFont(timeSpinnerFont);
        minutesSpinner.setFont(timeSpinnerFont);
        
        numberOfQues=new JLabel();
        numberOfQues.setBounds(100, 300, 900, 40);
        numberOfQues.setText("* How many questions would you like to have in your paper?");
        Font numberOfQuesFont=new Font("Times New Roman", Font.BOLD, 27);
        numberOfQues.setFont(numberOfQuesFont);
        
        numberOfQuesText=new JTextField();
        numberOfQuesText.setBounds(840, 300, 100, 40);
        Font numberOfQuesTextFont=new Font("Times New Roman", Font.BOLD, 27);
        numberOfQuesText.setFont(numberOfQuesTextFont);
        
        selectTestTopics=new JLabel();//How to selecct multiple topics?
        selectTestTopics.setBounds(100, 400, 1000, 40);
        selectTestTopics.setText("* Select the topics that you would like to test:");
        Font selectTestTopicsFont=new Font("Times New Roman", Font.BOLD, 27);
        selectTestTopics.setFont(selectTestTopicsFont);
        
        multipleOption=new JLabel();//How to selecct multiple topics?
        multipleOption.setBounds(120, 430, 1000, 40);
        multipleOption.setText("(Press command/shift simultaneously while clicking");
        Font multipleOptionFont=new Font("Times New Roman", Font.BOLD, 23);
        multipleOption.setFont(multipleOptionFont);
        
        multipleOption2=new JLabel();//How to selecct multiple topics?
        multipleOption2.setBounds(130, 460, 1000, 40);
        multipleOption2.setText("to select multiple options)");
        Font multipleOption2Font=new Font("Times New Roman", Font.BOLD, 23);
        multipleOption2.setFont(multipleOption2Font);
        
        DefaultListModel dl=new DefaultListModel();
        dl.addElement("Information Representation");
        dl.addElement("Communication and Internet Technologies");
        dl.addElement("Hardware");
        dl.addElement("System Software");
        dl.addElement("Processor Fundamentals");
        dl.addElement("Security, Privacy and Data Integrity");
        dl.addElement("Ethics and Ownership");
        dl.addElement("Database and Data Modelling");
        
        topicChoiceslist=new JList(dl);
        topicChoiceslist.setBounds(650, 400, 500, 250);
        Font topicChoiceslistFont=new Font("Times New Roman", Font.BOLD, 24);
        topicChoiceslist.setFont(topicChoiceslistFont);
       
        continueAhead=new JButton();
        continueAhead.setBounds(100, 700, 350, 60);
        continueAhead.setText("Continue");
        Font continueAheadFont=new Font("Times New Roman", Font.BOLD, 27);
        continueAhead.setFont(continueAheadFont);
        continueAhead.addActionListener(this);
        
        goBack=new JButton();
        goBack.setBounds(505, 700, 350, 60);
        goBack.setText("Back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        goBackMenu=new JButton();
        goBackMenu.setBounds(915, 700, 350, 60);
        goBackMenu.setText("Return to main menu");
        Font goBackMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMenu.setFont(goBackMenuFont);
        goBackMenu.addActionListener(this);
        
        page2of5=new JLabel();
        page2of5.setBounds(630, 780, 350, 60);
        page2of5.setText("Page 2 of 5");
        Font page2of5Font=new Font("Times New Roman", Font.BOLD, 20);
        page2of5.setFont(page2of5Font);
        
        c.add(mainTitle1);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(subTitle);
        c.add(timeAllotted);
        c.add(hoursAll);
        c.add(minutesAll);
        c.add(hoursSpinner);
        c.add(minutesSpinner);
        c.add(numberOfQues);
        c.add(numberOfQuesText);
        c.add(selectTestTopics);
        c.add(multipleOption);
        c.add(multipleOption2);
        c.add(topicChoiceslist);
        c.add(continueAhead);
        c.add(goBack);
        c.add(goBackMenu);
        c.add(page2of5);
     
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String str="'";
        if(e.getSource()==continueAhead)
        {
            if(topicChoiceslist.getSelectedIndex()!=-1)
            {
                int i=0;
                for(;i<(topicChoiceslist.getSelectedValuesList().size()-1);i++)
                {
                    str+=(String)topicChoiceslist.getSelectedValuesList().get(i);
                    str+="','";
                }
                
                str+=(String)topicChoiceslist.getSelectedValuesList().get(i);
                str+="'";
                
                int hours=(Integer) hoursSpinner.getValue();
                int min=(Integer) minutesSpinner.getValue();
                String noOfQues=numberOfQuesText.getText();
              
              TwoMarkerQuestionFrame tmqf=new TwoMarkerQuestionFrame();
              tmqf.setLayout(null);
              tmqf.setResizable(false);
              tmqf.setVisible(true);
              this.dispose();
              tmqf.fetchDataWithAll(level, paperType, subject, str,date,hours,min,noOfQues,schoolN);
        
        }}
        
        else if(e.getSource()==goBack)
        {
        QuestionPaperGeneratorFrame qpf=new QuestionPaperGeneratorFrame();
        qpf.setLayout(null);
        qpf.setResizable(false);
        qpf.setVisible(true);
        this.dispose();
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
        
         /*if(e.getSource()==subChoices)
         {
                 JComboBox ref=(JComboBox)e.getSource();
                 String item1=(String)ref.getSelectedItem();
         }*/
    }
                          
public static void main(String args[])
    {
        QuestionPaperGeneratorFrame2 qpf2=new QuestionPaperGeneratorFrame2();
        qpf2.setLayout(null);
        qpf2.setResizable(false);
        qpf2.setVisible(true);
        //qpf.fetchDataWithAll("AS", "Paper1", "2", "Computer Science", "Processor Fundamentals");
    }
    // Variables declaration - do not modify                     
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JSpinner hoursSpinner;
    private javax.swing.JSpinner minutesSpinner;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

