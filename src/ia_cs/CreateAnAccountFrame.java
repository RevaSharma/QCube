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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author reva
 */
public class CreateAnAccountFrame extends JFrame implements ActionListener {
 
    private JLabel formTitle;
    private JLabel username;
    private JTextField usernameTxt;
    private JLabel password;
    private JPasswordField passwordTxt;
    private JLabel reEnterPass;
    private JButton create;
    private JPasswordField reEnterTxt;
    private JButton clear;
    private JButton back;
    private Container c;
    private Connection conn;
    private Statement stmnt;
    
    public CreateAnAccountFrame()
    {
        this.setBounds(250, 150, 900, 500);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(3);
        this.setTitle("Create an Account Form");
      
        formTitle=new JLabel();
        formTitle.setBounds(300, 20, 600, 100);
        formTitle.setText("Create an Account");
        Font formTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        formTitle.setFont(formTitleFont);
        
        username=new JLabel();
        username.setText("Enter username");
        username.setBounds(200, 140, 300, 60);
        
        Font usernameFont=new Font("Times New Roman", Font.PLAIN, 20);
        username.setFont(usernameFont);
        
        usernameTxt=new JTextField();
        usernameTxt.setBounds(440, 140, 300, 40);
        usernameTxt.setFont(usernameFont);
        
        password=new JLabel();
        password.setBounds(200, 210, 300, 40);
        password.setText("Enter password");
        
        password.setFont(usernameFont);
        
        passwordTxt=new JPasswordField();
        passwordTxt.setBounds(440, 210, 300, 40);
        passwordTxt.setFont(usernameFont);
        
        reEnterPass=new JLabel();
        reEnterPass.setBounds(200, 270, 300, 40);
        reEnterPass.setText("Re enter password");
        reEnterPass.setFont(usernameFont);
        
        reEnterTxt=new JPasswordField();
        reEnterTxt.setBounds(440, 275, 300, 40);
        reEnterTxt.setFont(usernameFont);
        
        Font buttonFont=new Font("Times New Roman", Font.PLAIN, 25);
       
        create=new JButton();
        create.setBounds(200, 370, 150, 60);
        create.setText("Create");
        create.setFont(buttonFont);
        create.addActionListener(this);
        
        clear=new JButton();
        clear.setBounds(385, 370, 150, 60);
        clear.setText("Clear");
        clear.setFont(buttonFont);
        clear.addActionListener(this);
        
        back=new JButton();
        back.setBounds(570, 370, 150, 60);
        back.setText("Back");
        back.setFont(buttonFont);
        back.addActionListener(this);
        
        c.add(formTitle);
        c.add(username);
        c.add(usernameTxt);
        c.add(password);
        c.add(passwordTxt);
        c.add(reEnterPass);
        c.add(reEnterTxt);
        c.add(create);
        c.add(back);
        c.add(clear);
    }
     public void insert() throws SQLException 
    {
      conn=DBConnect.connect2DB();
        
      if(conn!=null)
    {
        String username=(String)usernameTxt.getText();
        String password=passwordTxt.getText();
        
        String query="insert into LoginPass (Username, Password) values('"+username+"', '"+password+"')";
        stmnt=conn.createStatement();
        stmnt.executeUpdate(query);
        conn.close();
    }
      else
          System.out.println("Problem in connecting to database");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create)
        {
          
          String username=(String)usernameTxt.getText();
          String password=passwordTxt.getText();
          String password2=passwordTxt.getText();
          
          
          {
              try {
                  if(password.equals(password2))
                      {
                      insert();
                      JOptionPane.showMessageDialog(null, "You have successfully signed up! " +
                              "Your username is "+username+" and your password is "+password , "Message",JOptionPane.INFORMATION_MESSAGE);
                  }
                  else
                  JOptionPane.showMessageDialog(null, "Your passwords do not match, kindly enter the same passwords" , "Message",JOptionPane.OK_OPTION);
                  
              } catch (SQLException ex) {
                  Logger.getLogger(CreateAnAccountFrame.class.getName()).log(Level.SEVERE, null, ex);
              }
           
          }
          
       LoginOrSignUpFrame lsf=new LoginOrSignUpFrame();
       lsf.setLayout(null);
       lsf.setResizable(false);
       lsf.setVisible(true);
       this.dispose();
        }
    
        if(e.getSource()==back)
        {
       LoginOrSignUpFrame lsf=new LoginOrSignUpFrame();
       lsf.setLayout(null);
       lsf.setResizable(false);
       lsf.setVisible(true);
       this.dispose();
        }
        if(e.getSource()==clear)
        {
            usernameTxt.setText("");
            passwordTxt.setText("");
            reEnterTxt.setText("");
            
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
            .addGap(0, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        
       CreateAnAccountFrame caa=new CreateAnAccountFrame();
       caa.setLayout(null);
       caa.setResizable(false);
       caa.setVisible(true);
       
            }/*
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}*/
}
