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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TeacherFrame extends JFrame implements ActionListener{
    
    
    private JLabel mainTitle1;
    private JLabel teacherChoice;
    private JButton makePaper;
    private JButton mainMenu;
    private Container c;
    
    public TeacherFrame()
    {
        this.setBounds(300, 150, 800, 600);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Teacher Form");
        
        mainTitle1=new JLabel();
        mainTitle1.setBounds(250, 20, 600, 100);
        mainTitle1.setText("Welcome Teacher!");
        Font mainTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle1.setFont(mainTitleFont);
       
        teacherChoice=new JLabel();
        teacherChoice.setBounds(230, 130, 500, 80);
        teacherChoice.setText("What would you like to do?");
        Font teacherChoiceFont=new Font("Times New Roman", Font.BOLD, 30);
        teacherChoice.setFont(teacherChoiceFont);
        
        makePaper=new JButton();
        makePaper.setBounds(150, 270, 500, 60);
        makePaper.setText("Generate question paper");
        Font makePaperFont=new Font("Times New Roman", Font.PLAIN, 20);
        makePaper.setFont(makePaperFont);
        makePaper.addActionListener(this);
        
        mainMenu=new JButton();
        mainMenu.setBounds(150, 370, 500, 60);
        mainMenu.setText("Go back to the main menu");
        Font mainMenuFont=new Font("Times New Roman", Font.PLAIN, 20);
        mainMenu.setFont(mainMenuFont);
        mainMenu.addActionListener(this);
        
        c.add(mainTitle1);
        c.add(teacherChoice);
        c.add(makePaper);
        c.add(mainMenu);
   
    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==makePaper)
        {
          QuestionPaperGeneratorFrame qpf=new QuestionPaperGeneratorFrame();
          this.dispose();
          qpf.setLayout(null);
          qpf.setResizable(false);
          qpf.setVisible(true);
        }
         
        if(e.getSource()==mainMenu)
        {
            LoginFrame lf=new LoginFrame();
            this.dispose();
            lf.setLayout(null);
            lf.setResizable(false);
            lf.setVisible(true);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
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
        
        TeacherFrame tf=new TeacherFrame();
        tf.setLayout(null);
        tf.setResizable(false);
        tf.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
