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
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author reva
 */
public class DeleteQuestionFrame extends javax.swing.JFrame implements ActionListener {
    
    private JLabel mainTitle;
    private JLabel mainTitleUnderline;
    private JLabel mainTitleUnderline2;
    private Connection conn;
    private Statement stmnt;
    private JLabel pickSubject;
    public JComboBox subChoices;
    private JLabel pickLevel;
    private JRadioButton asLevel;
    private JRadioButton aLevel;
    private JLabel pickPaperType;
    private JRadioButton paper1;
    private JRadioButton paper2;
    private JLabel selectTestTopics;
    private JComboBox topicChoices;
    private JButton continueB;
    private JButton goBack;
    private JButton clear;
    private JButton goBackMainMenu;
    private Container c;
    private String q;
    // Data members for values passed from QuestionPaperGeneratorFrame
    private String level;
    private String paperType;
    private String subject;
    private String topic;
    
    
    //List to keep checkboxes corresponding to questions
    private ArrayList<JCheckBox>list;
    
    public DeleteQuestionFrame ()
    {
        this.setBounds(100, 100, 1200, 600);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Delete Question Form");
        
        mainTitle=new JLabel();
        mainTitle.setBounds(310, 15, 800, 80);
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
        
        pickSubject=new JLabel();
        pickSubject.setBounds(70, 100, 1000, 40);
        pickSubject.setText("* Pick your subject:");
        Font pickSubjectTitleFont=new Font("Times New Roman", Font.BOLD, 27);
        pickSubject.setFont(pickSubjectTitleFont);
        
        String[] subjects={"Select subject", "Computer Science", "Economics", "English", "Hindi", "Psychology"};
        subChoices=new JComboBox(subjects);
        subChoices.setBounds(500, 100, 500, 40);
        subChoices.addActionListener(this);
        Font subChoicesFont=new Font("Times New Roman", Font.BOLD, 24);
        subChoices.setFont(subChoicesFont);
        
        pickLevel=new JLabel();
        pickLevel.setBounds(70, 200, 1000, 40);
        pickLevel.setText("* Pick the level of the subject:");
        Font pickLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        pickLevel.setFont(pickLevelFont);
        
        asLevel=new JRadioButton("Advanced Subsidiary (AS)");
        asLevel.setBounds(500, 195, 400, 60);
        //asLevel.setText("Advanced Subsidiary (AS)");
        Font asLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        asLevel.setFont(asLevelFont);
        
        aLevel=new JRadioButton("Advanced (A)");
        aLevel.setBounds(900, 195, 400, 60);
        //aLevel.setText("Advanced (A)");
        Font aLevelFont=new Font("Times New Roman", Font.BOLD, 27);
        aLevel.setFont(aLevelFont);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(asLevel);
        bg.add(aLevel);
        
        pickPaperType=new JLabel();
        pickPaperType.setBounds(70, 300, 1000, 40);
        pickPaperType.setText("* Pick the type of paper:");
        Font pickPaperTypeFont=new Font("Times New Roman", Font.BOLD, 27);
        pickPaperType.setFont(pickPaperTypeFont);
        
        paper1=new JRadioButton();
        paper1.setBounds(500, 295, 400, 60);
        paper1.setText("Paper 1");
        Font paper1Font=new Font("Times New Roman", Font.BOLD, 27);
        paper1.setFont(paper1Font);
        
        paper2=new JRadioButton();
        paper2.setBounds(900, 295, 400, 60);
        paper2.setText("Paper 2");
        Font paper2Font=new Font("Times New Roman", Font.BOLD, 27);
        paper2.setFont(paper2Font);
        
        ButtonGroup bg2=new ButtonGroup();
        bg2.add(paper1);
        bg2.add(paper2);
        
        selectTestTopics=new JLabel();//How to selecct multiple topics?
        selectTestTopics.setBounds(70, 400, 1000, 40);
        selectTestTopics.setText("* Topic:");
        Font selectTestTopicsFont=new Font("Times New Roman", Font.BOLD, 27);
        selectTestTopics.setFont(selectTestTopicsFont);
        
        String[] topics={"Select topic(s)", "Information Representation", "Communication and Internet Technologies", "Hardware", "Processor Fundamentals", "System Software", "Security, Privacy and Data Integrity", "Ethics and Ownership", "Database and Data Modelling"};
        topicChoices=new JComboBox(topics);
        topicChoices.setBounds(500, 395, 500, 40);
        topicChoices.addActionListener(this);
        Font topicChoicesFont=new Font("Times New Roman", Font.BOLD, 24);
        topicChoices.setFont(topicChoicesFont);
       
        continueB=new JButton();
        continueB.setBounds(50, 500, 250, 60);
        continueB.setText("Continue");
        Font continueBFont=new Font("Times New Roman", Font.BOLD, 27);
        continueB.setFont(continueBFont);
        continueB.addActionListener(this);
        
        goBack=new JButton();
        goBack.setBounds(340, 500, 250, 60);
        goBack.setText("Go back");
        Font goBackFont=new Font("Times New Roman", Font.BOLD, 27);
        goBack.setFont(goBackFont);
        goBack.addActionListener(this);
        
        clear=new JButton();
        clear.setBounds(630, 500, 250, 60);
        clear.setText("Clear");
        Font clearFont=new Font("Times New Roman", Font.BOLD, 27);
        clear.setFont(clearFont);
        clear.addActionListener(this);
        
        goBackMainMenu=new JButton();
        goBackMainMenu.setBounds(920, 500, 250, 60);
        goBackMainMenu.setText("Go to Main Menu");
        Font goBackMainMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goBackMainMenu.setFont(goBackMainMenuFont);
        goBackMainMenu.addActionListener(this);
        
        c.add(mainTitle);
        c.add(mainTitleUnderline);
        c.add(mainTitleUnderline2);
        c.add(pickSubject);
        c.add(subChoices);
        c.add(pickLevel);
        c.add(asLevel);
        c.add(aLevel);
        c.add(pickPaperType); 
        c.add(paper1);
        c.add(paper2);
        c.add(selectTestTopics);
        c.add(topicChoices);
        c.add(continueB);
        c.add(goBack);
        c.add(goBackMainMenu);
        c.add(clear);
    }
   
    
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==continueB)
        {
       DeleteQuestionFrame2 dqf2=new DeleteQuestionFrame2();
       dqf2.setLayout(null);
       dqf2.setResizable(false);
       dqf2.setVisible(true);
       this.dispose();
       
        String level;
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
              
              String tpChoice=(String)topicChoices.getSelectedItem();
              String subChoice=(String)subChoices.getSelectedItem();
              dqf2.fetchDataWithAll(level,paperType,subChoice,tpChoice);
        }
        if(e.getSource()==goBack)
        {
        DatabaseFrame df=new DatabaseFrame();
        this.dispose();
        df.setLayout(null);
        df.setResizable(false);
        df.setVisible(true);
        }
        if(e.getSource()==clear)    
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
        
       DeleteQuestionFrame dqf=new DeleteQuestionFrame();
       dqf.setLayout(null);
       dqf.setResizable(false);
       dqf.setVisible(true);
       
        
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  
  
