/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author reva
 */
public class DatabaseFrame extends javax.swing.JFrame implements ActionListener {
    
    private JLabel mainTitle1;
    private JLabel databaseActions;
    private JButton addQ;
    private JButton deleteQ;
    private JButton updateQ;
    private JButton checkDB;
    private JButton mainMenu;
    private Container c;
   
    
    public DatabaseFrame() {
        
        this.setBounds(300, 100, 800, 700);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Database Form");
        
        mainTitle1=new JLabel();
        mainTitle1.setBounds(27, 20, 1000, 100);
        mainTitle1.setText("Here you can make changes to the database");
        Font mainTitleFont=new Font("Times New Roman", Font.BOLD, 40);
        mainTitle1.setFont(mainTitleFont);
       
        databaseActions=new JLabel();
        databaseActions.setBounds(190, 110, 500, 80);
        databaseActions.setText("What would you like to do?");
        Font databaseActionsFont=new Font("Times New Roman", Font.BOLD, 35);
        databaseActions.setFont(databaseActionsFont);
        
        addQ=new JButton();
        addQ.setBounds(150, 210, 500, 60);
        addQ.setText("Insert a new question");
        Font addQFont=new Font("Times New Roman", Font.PLAIN, 20);
        addQ.setFont(addQFont);
        addQ.addActionListener(this);
        
        deleteQ=new JButton();
        deleteQ.setBounds(150, 290, 500, 60);
        deleteQ.setText("Delete an existing question");
        Font deleteQFont=new Font("Times New Roman", Font.PLAIN, 20);
        deleteQ.setFont(deleteQFont);
        deleteQ.addActionListener(this);
        
        updateQ=new JButton();
        updateQ.setBounds(150, 370, 500, 60);
        updateQ.setText("Update an existing question");
        Font updateQFont=new Font("Times New Roman", Font.PLAIN, 20);
        updateQ.setFont(updateQFont);
        updateQ.addActionListener(this);
        
        checkDB=new JButton();
        checkDB.setBounds(150, 450, 500, 60);
        checkDB.setText("Check the existing database");
        Font checkDBFont=new Font("Times New Roman", Font.PLAIN, 20);
        checkDB.setFont(checkDBFont);
        checkDB.addActionListener(this);
        
        mainMenu=new JButton();
        mainMenu.setBounds(150, 530, 500, 60);
        mainMenu.setText("Go to main menu");
        Font mainMenuFont=new Font("Times New Roman", Font.PLAIN, 20);
        mainMenu.setFont(mainMenuFont);
        mainMenu.addActionListener(this);
        
   
        c.add(mainTitle1);
        c.add(databaseActions);
        c.add(addQ);
        c.add(deleteQ);
        c.add(updateQ);
        c.add(checkDB);
        c.add(mainMenu);
   
        
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
        if(e.getSource()==addQ)
        {
       AddQuestionFrame adf=new AddQuestionFrame();
       this.dispose();
       adf.setLayout(null);
       adf.setResizable(false);
       adf.setVisible(true);  
        }
        else if(e.getSource()==deleteQ)
        {
        DeleteQuestionFrame dqf=new DeleteQuestionFrame();
       this.dispose();
       dqf.setLayout(null);
       dqf.setResizable(false);
       dqf.setVisible(true);
            
        }
        else if(e.getSource()==updateQ)
        {
        UpdateQuestionFrame uqf=new UpdateQuestionFrame();
        this.dispose();
        uqf.setLayout(null);
        uqf.setResizable(false);
        uqf.setVisible(true);
            
        }
        else if(e.getSource()==checkDB)
        {
        CheckExistingDBFrame cedf=new CheckExistingDBFrame();
        this.dispose();
        cedf.setLayout(null);
        cedf.setResizable(false);
        cedf.setVisible(true);   
        }
        else if(e.getSource()==mainMenu)
        {
         LoginFrame lf=new LoginFrame();
         this.dispose();
         lf.setLayout(null);
         lf.setResizable(false);
         lf.setVisible(true);
            
        }
        
    }
    
    public static void main(String args[]) {
       
        DatabaseFrame df=new DatabaseFrame();
        df.setLayout(null);
        df.setResizable(false);
        df.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
}
