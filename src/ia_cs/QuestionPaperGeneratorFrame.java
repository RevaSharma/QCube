/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.sql.Statement;
import javax.management.Query;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reva
 */
public class QuestionPaperGeneratorFrame extends JFrame implements ActionListener {
    
    private JLabel mainTitle1;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private JLabel subTitle;
    private JLabel schoolName;
    private JTextField enterSchoolName;
    private JLabel pickSubject;
    private JComboBox subChoices;
    private JLabel pickLevel;
    private JRadioButton asLevel;
    private JRadioButton aLevel;
    private JLabel pickPaperType;
    private JRadioButton paper1;
    private JRadioButton paper2;
    private JLabel dateOfTest;
    private JButton continueAhead;
    private JButton goBackMenu;
    private JLabel page1of5;
    private Container c;
    
    public QuestionPaperGeneratorFrame()
    {
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
        mainTitleUnderline2.setText("_______________________________       ");
        Font mainTitleUnderline2Font=new Font("Times New Roman", Font.BOLD, 30);
        mainTitleUnderline2.setFont(mainTitleUnderline2Font);
        
        subTitle=new JLabel();
        subTitle.setBounds(100, 90, 500, 70);
        subTitle.setText("Pick your specifications: ");
        Font subTitleFont=new Font("Times New Roman", Font.BOLD, 33);
        subTitle.setFont(subTitleFont);
        
        schoolName=new JLabel();
        schoolName.setBounds(100, 200, 1000, 40);
        schoolName.setText("* Enter the school name:");
        Font schoolNameFont=new Font("Times New Roman", Font.BOLD, 27);
        schoolName.setFont(schoolNameFont);
        
        enterSchoolName=new JTextField();
        enterSchoolName.setBounds(500, 200, 400, 40);
        Font enterSchoolNameFont=new Font("Times New Roman", Font.BOLD, 27);
        enterSchoolName.setFont(enterSchoolNameFont);
        
        pickSubject=new JLabel();
        pickSubject.setBounds(100, 300, 1000, 40);
        pickSubject.setText("* Pick your subject:");
        Font pickSubjectTitleFont=new Font("Times New Roman", Font.BOLD, 27);
        pickSubject.setFont(pickSubjectTitleFont);
        
        String[] subjects={"Select subject", "Computer Science", "Economics", "English", "Hindi", "Psychology"};
        subChoices=new JComboBox(subjects);
        subChoices.setBounds(500, 295, 500, 40);
        subChoices.addActionListener(this);
        Font subChoicesFont=new Font("Times New Roman", Font.BOLD, 24);
        subChoices.setFont(subChoicesFont);
       
        pickLevel=new JLabel();
        pickLevel.setBounds(100, 400, 1000, 40);
        pickLevel.setText("* Pick the level of the subject:");
        Font pickLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        pickLevel.setFont(pickLevelFont);
        
        asLevel=new JRadioButton("Advanced Subsidiary (AS)");
        asLevel.setBounds(500, 395, 400, 60);
        //asLevel.setText("Advanced Subsidiary (AS)");
        Font asLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        asLevel.setFont(asLevelFont);
        
        aLevel=new JRadioButton("Advanced (A)");
        aLevel.setBounds(900, 395, 400, 60);
        //aLevel.setText("Advanced (A)");
        Font aLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        aLevel.setFont(aLevelFont);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(asLevel);
        bg.add(aLevel);
    
        pickPaperType=new JLabel();
        pickPaperType.setBounds(100, 500, 1000, 40);
        pickPaperType.setText("* Pick the type of paper:");
        Font pickPaperTypeFont=new Font("Times New Roman", Font.BOLD, 27);
        pickPaperType.setFont(pickPaperTypeFont);
        
        paper1=new JRadioButton();
        paper1.setBounds(500, 495, 400, 60);
        paper1.setText("Paper 1");
        Font paper1Font=new Font("Times New Roman", Font.BOLD, 27);
        paper1.setFont(paper1Font);
        
        paper2=new JRadioButton();
        paper2.setBounds(900, 495, 400, 60);
        paper2.setText("Paper 2");
        Font paper2Font=new Font("Times New Roman", Font.BOLD, 27);
        paper2.setFont(paper2Font);
        
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(paper1);
        bg2.add(paper2);
        
        /*paper3=new JRadioButton();
        paper3.setBounds(1100, 240, 700, 60);
        paper3.setText("Paper 3");
        Font paper3Font=new Font("Times New Roman", Font.BOLD, 24);
        paper3.setFont(paper3Font);*/
        
        dateOfTest=new JLabel();
        dateOfTest.setBounds(100, 600, 1000, 40);
        dateOfTest.setText("* Date of the test:");
        Font dateOfTestFont=new Font("Times New Roman", Font.BOLD, 27);
        dateOfTest.setFont(dateOfTestFont);
        
        datePicker1=new DatePicker();
        datePicker1.setBounds(500, 590, 400, 50);
        Font datePicker1Font=new Font("Times New Roman", Font.BOLD, 27);
        datePicker1.setFont(datePicker1Font);
       
        continueAhead=new JButton();
        continueAhead.setBounds(300, 700, 350, 60);
        continueAhead.setText("Continue");
        Font continueAheadFont=new Font("Times New Roman", Font.BOLD, 27);
        continueAhead.setFont(continueAheadFont);
        continueAhead.addActionListener(this);
        
        goBackMenu=new JButton();
        goBackMenu.setBounds(715, 700, 350, 60);
        goBackMenu.setText("Return to main menu");
        Font goBackMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMenu.setFont(goBackMenuFont);
        goBackMenu.addActionListener(this);
        
        page1of5=new JLabel();
        page1of5.setBounds(630, 765, 350, 60);
        page1of5.setText("Page 1 of 5");
        Font page1of5Font=new Font("Times New Roman", Font.BOLD, 20);
        page1of5.setFont(page1of5Font);
        
        c.add(mainTitle1);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(subTitle);
        c.add(schoolName);
        c.add(enterSchoolName);
        c.add(pickSubject);
        c.add(subChoices);
        c.add(pickLevel);
        c.add(asLevel);
        c.add(aLevel);
        c.add(pickPaperType); 
        c.add(paper1);
        c.add(paper2);
        c.add(dateOfTest);
        c.add(datePicker1);
        c.add(continueAhead);
        c.add(goBackMenu);
        c.add(page1of5);
     
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==continueAhead)
        {     String level;
              if(asLevel.isSelected())
              {
                  level="AS";
              }
              else
                  level="A";
              String paperType;
              if(paper1.isSelected())
                  paperType="Paper 1";
              else
                  paperType="Paper 2";
              
              String subChoice=(String)subChoices.getSelectedItem();
              String date=(String)datePicker1.getDateStringOrEmptyString();
              String schoolN=enterSchoolName.getText();
              
              PaperDetails pd=new PaperDetails(subChoice,level,paperType,date);
              QuestionPaperGeneratorFrame2 qpf2=new QuestionPaperGeneratorFrame2(subChoice,level,paperType,date,schoolN);
              qpf2.setLayout(null);
              qpf2.setResizable(false);
              qpf2.setVisible(true);
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
        
         if(e.getSource()==subChoices)
         {
                 JComboBox ref=(JComboBox)e.getSource();
                 String item1=(String)ref.getSelectedItem();
         }
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        hoursSpinner = new javax.swing.JSpinner();
        minutesSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(hoursSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(minutesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static void main(String args[])
    {
        QuestionPaperGeneratorFrame qpf=new QuestionPaperGeneratorFrame();
        qpf.setLayout(null);
        qpf.setResizable(false);
        qpf.setVisible(true);
        //qpf.fetchDataWithAll("AS", "Paper1", "2", "Computer Science", "Processor Fundamentals");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JSpinner hoursSpinner;
    private javax.swing.JSpinner minutesSpinner;
    // End of variables declaration//GEN-END:variables
}
