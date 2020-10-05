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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author reva
 */
public class LoginOrSignUpFrame extends JFrame implements ActionListener {
    
    private JLabel mainTitle;
    private JLabel choice;
    private JButton loginB;
    private JButton signUp;
    private Container c;
    
    
    public LoginOrSignUpFrame()
    {
        //frame related settings
       
        this.setBounds(300, 150, 800, 600);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Login or Sign up Form");
        
        mainTitle=new JLabel();
        mainTitle.setBounds(290, 20, 600, 100);
        mainTitle.setText("Welcome!");
        Font titleFont=new Font("Times New Roman", Font.BOLD, 50);
        mainTitle.setFont(titleFont);
        
        choice=new JLabel();
        choice.setBounds(200, 130, 500, 80);
        choice.setText("What would you like to do?");
        Font choiceFont=new Font("Times New Roman", Font.BOLD, 35);
        choice.setFont(choiceFont);
        
        loginB=new JButton();
        loginB.setBounds(150, 270, 500, 60);
        loginB.setText("Login with an existing account");
        Font loginBFont=new Font("Times New Roman", Font.PLAIN, 20);
        loginB.setFont(loginBFont);
        loginB.addActionListener(this);
        
        
        signUp=new JButton();
        signUp.setBounds(150, 370, 500, 60);
        signUp.setText("Sign up with a new account");
        Font signUpFont=new Font("Times New Roman", Font.PLAIN, 20);
        signUp.setFont(signUpFont);
        signUp.addActionListener(this);
       
        
        c.add(mainTitle);
        c.add(choice);
        c.add(loginB);
        c.add(signUp);
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
        if(e.getSource()==loginB)
        {
       LoginFrame lf=new LoginFrame();
       lf.setLayout(null);
       lf.setResizable(false);
       lf.setVisible(true); 
       this.dispose();
        }
       else if(e.getSource()==signUp)
       {
       CreateAnAccountFrame caa=new CreateAnAccountFrame();
       caa.setLayout(null);
       caa.setResizable(false);
       caa.setVisible(true);
       this.dispose();
       }   
      
        
    }

    
    public static void main(String args[]) {
        
        
       LoginOrSignUpFrame lsf=new LoginOrSignUpFrame();
       lsf.setLayout(null);
       lsf.setResizable(false);
       lsf.setVisible(true);
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    }

        
        
        
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
