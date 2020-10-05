/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import javax.swing.ImageIcon;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginFrame extends JFrame implements ActionListener {
   
    private JLabel projectTitle;
    private JLabel loginTitle;
    private JLabel username;
    private JTextField usernameTxt;
    private JLabel password;
    private JPasswordField passwordTxt;
    private JLabel promptMsg;
    private JButton submit;
    private JButton clear;
    private JButton back;
    private Container c;
    private String uname;
    private String pword;
    private String pw;
    private String un;
    private String word="Reva";
    
    public LoginFrame()
    {
        this.setBounds(300, 150, 800, 600);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(3);
        this.setTitle("Login Form");
      
        //component related settings
        
        projectTitle=new JLabel();
        projectTitle.setBounds(160, 20, 600, 100);
        projectTitle.setText("Question Paper Generator");
        Font projectTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        projectTitle.setFont(projectTitleFont);
        
        loginTitle=new JLabel();
        loginTitle.setBounds(340, 120, 200, 80);
        loginTitle.setText("Login");
        Font loginTitleFont=new Font("Times New Roman", Font.BOLD, 31);
        loginTitle.setFont(loginTitleFont);
        
        username=new JLabel();
        username.setText("Username");
        username.setBounds(230, 210, 150, 60);
        
        Font usernameFont=new Font("Times New Roman", Font.PLAIN, 25);
        username.setFont(usernameFont);
        
        usernameTxt=new JTextField();
        usernameTxt.setBounds(430, 210, 150, 40);
        
        password=new JLabel();
        password.setBounds(230, 290, 150, 40);
        password.setText("Password");
        
        password.setFont(usernameFont);
        
        passwordTxt=new JPasswordField();
        passwordTxt.setBounds(430, 290, 150, 40);
        
        Font buttonFont=new Font("Times New Roman", 0, 25);
       
        submit=new JButton();
        submit.setBounds(150, 400, 150, 60);
        submit.setText("Submit");
        submit.setFont(buttonFont);
        submit.addActionListener(this);
        
        
        clear=new JButton();
        clear.setBounds(335, 400, 150, 60);
        clear.setText("Clear");
        clear.setFont(buttonFont);
        clear.addActionListener(this);
        
        back=new JButton();
        back.setBounds(520, 400, 150, 60);
        back.setText("Back");
        back.setFont(buttonFont);
        back.addActionListener(this);
        
        promptMsg=new JLabel();
        promptMsg.setBounds(280, 480, 300, 50);
        
        c.add(projectTitle);
        c.add(loginTitle);
        c.add(username);
        c.add(usernameTxt);
        c.add(password);
        c.add(passwordTxt);
        c.add(promptMsg);
        c.add(submit);
        c.add(clear);
        c.add(back);
    }
    
    public void fetchUsernamePass(String uname, String pword)
    {   this.uname=uname;
        this.pword=pword;
        
        Connection con=DBConnect.connect2DB();
        Statement stmnt;
        String que;
        String eg;
        ResultSet rs;
        if(con!=null)
        {       try {
                stmnt=con.createStatement();
                que="select Username,Password from LoginPass where Username='"+uname+"'";
                rs=stmnt.executeQuery(que);
                while(rs.next())
                {         un=rs.getString(1);
                          pw=rs.getString(2);     
                }   
            } catch (SQLException ex) {
                Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
        else
            System.out.println("Problem in connecting to database");
    }
      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {       String uname2=usernameTxt.getText();
                String pname=passwordTxt.getText();
                String pass=new String(pname);
                this.fetchUsernamePass(uname2, pname);
                
                Font promptMsgFont=new Font(Font.SANS_SERIF, Font.ITALIC, 20);
                if(uname.equals("")|| pass.equals(""))
                {
                    promptMsg.setForeground(Color.RED);
                    promptMsg.setFont(promptMsgFont);
                    promptMsg.setText("Username/password is empty");
                }
                else if(uname.equals("exampleAdmin")&& pass.equals("admin@123"))
                {
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome Admin!" , "Message",JOptionPane.INFORMATION_MESSAGE);
                    AdminFrame af=new AdminFrame();
                    this.dispose();
                    af.setLayout(null);
                    af.setResizable(false);
                    af.setVisible(true);
                }
                else if(uname.equals(un)&&pass.equals(pw))
                {
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome!" , "Message",JOptionPane.INFORMATION_MESSAGE);
                    TeacherFrame tf=new TeacherFrame();
                    this.dispose();
                    tf.setLayout(null);
                    tf.setResizable(false);
                    tf.setVisible(true);
                }
                else
                {   JOptionPane.showMessageDialog(null, "Invalid username/password" , "Message",JOptionPane.ERROR_MESSAGE);}
        }
        if(e.getSource()==clear)
        {
            usernameTxt.setText("");
            passwordTxt.setText("");
            promptMsg.setText("");
        }
        if(e.getSource()==back)
        {
       LoginOrSignUpFrame lsf=new LoginOrSignUpFrame();
       lsf.setLayout(null);
       lsf.setResizable(false);
       lsf.setVisible(true);
       this.dispose();
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
            .addGap(0, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LoginFrame lf=new LoginFrame();
       lf.setLayout(null);
       lf.setResizable(false);
       lf.setVisible(true);
            }
        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

