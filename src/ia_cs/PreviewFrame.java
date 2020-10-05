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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reva
 */
public class PreviewFrame extends JFrame implements ActionListener {
    
    private JLabel mainTitle1;
    private JLabel mainTitle2;
    private JButton saveAsDoc;
    private JButton viewDoc;
    private JButton printDoc;
    private JButton goToMainMenu;
    private String subChoice;
    private String paperType;
    private String level;
    private String date;
    private int hours;
    private int min;
    private String subject; 
    private String subject2; 
    private String noOfQues;
    private String schoolN;
    private Container c;
    private ArrayList<String>quesList2;
    private ArrayList<String>quesList5;
    private ArrayList<String>quesList8;
    private int quesCount=1;
    
    public PreviewFrame()
    {
       
    }
    public PreviewFrame(String subject, String date,int hours, int min, String noOfQues,String level, String paperType,ArrayList<String>quesList2,ArrayList<String>quesList5 ,ArrayList<String>quesList8, String schoolN)
    {
        
        this.subject=subject; 
        this.date=date;
        this.quesList2=quesList2;
        this.quesList5=quesList5;
        this.quesList8=quesList8;
        this.hours=hours;
        this.min=min;
        this.noOfQues=noOfQues;
        this.level=level;
        this.paperType=paperType;
        this.schoolN=schoolN;
        
        this.setBounds(300, 100, 800, 700);
        c=this.getContentPane();
        c.setBackground(Color.decode("#B0C4DE"));
        this.setDefaultCloseOperation(2);
        this.setTitle("Preview Form");
        
        mainTitle1=new JLabel();
        mainTitle1.setBounds(130, 20, 1000, 100);
        mainTitle1.setText("Your Question Paper is Ready!");
        Font mainTitle1Font=new Font(Font.SERIF, Font.BOLD, 40);
        mainTitle1.setFont(mainTitle1Font);
        
        mainTitle2=new JLabel();
        mainTitle2.setBounds(20, 140, 800, 80);
        mainTitle2.setText("Click below to save your question paper as a word document:");
        Font mainTitle2Font=new Font(Font.SERIF, Font.BOLD, 29);
        mainTitle2.setFont(mainTitle2Font);
        
        saveAsDoc=new JButton();
        saveAsDoc.setBounds(150, 250, 500, 60);
        saveAsDoc.setText("Save as word document");
        Font saveAsDocFont=new Font("Times New Roman", Font.BOLD, 27);
        saveAsDoc.setFont(saveAsDocFont);
        saveAsDoc.addActionListener(this);
        
        viewDoc=new JButton();
        viewDoc.setBounds(150, 350, 500, 60);
        viewDoc.setText("View your Question Paper");
        Font viewDocFont=new Font("Times New Roman", Font.BOLD, 27);
        viewDoc.setFont(viewDocFont);
        viewDoc.addActionListener(this);
        
        printDoc=new JButton();
        printDoc.setBounds(150, 450, 500, 60);
        printDoc.setText("Print Question Paper");
        Font printDocFont=new Font("Times New Roman", Font.BOLD, 27);
        printDoc.setFont(printDocFont);
        printDoc.addActionListener(this);
        
        goToMainMenu=new JButton();
        goToMainMenu.setBounds(150, 550, 500, 60);
        goToMainMenu.setText("Return to main menu");
        Font goToMainMenuFont=new Font("Times New Roman", Font.BOLD, 27);
        goToMainMenu.setFont(goToMainMenuFont);
        goToMainMenu.addActionListener(this);
        
        c.add(mainTitle1);
        c.add(mainTitle2);
        c.add(saveAsDoc);
        c.add(viewDoc);
        c.add(printDoc);
        c.add(goToMainMenu);
    }
    public void fetchValues()      
    {
      
      subject2=subject;
      for (String q:quesList2)
          System.out.println(q);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==saveAsDoc)
        {
            
             XWPFDocument doc=new XWPFDocument();//
             File file=new File("Question_Paper.docx");   //mention full path incase it is not in the current directory
             FileOutputStream out;
             try {
             out = new FileOutputStream(file);
             XWPFParagraph para1=doc.createParagraph();
             para1.setAlignment(ParagraphAlignment.CENTER);
             XWPFRun run=para1.createRun();
             run.setBold(true);
             run.setCapitalized(true);
             run.setFontFamily("Times New Roman");
             run.setFontSize(18);
             run.setUnderline(UnderlinePatterns.THICK);
             run.setText(schoolN);
             
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para2=doc.createParagraph();
             para2.setAlignment(ParagraphAlignment.CENTER);
             XWPFRun run2=para2.createRun();
             run2.setBold(true);
             run2.setCapitalized(true);
             run2.setFontFamily("Times New Roman");
             run2.setFontSize(14);
             run2.setText("Subject: "+subject);
             
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para3=doc.createParagraph();
             para3.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run3=para3.createRun();
             run3.setBold(true);
             run3.setCapitalized(true);
             run3.setFontFamily("Times New Roman");
             run3.setFontSize(14);
             run3.setText("DATE OF TEST: "+date);
             
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para4=doc.createParagraph();
             para4.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run4=para4.createRun();
             run4.setBold(true);
             run4.setCapitalized(true);
             run4.setFontFamily("Times New Roman");
             run4.setFontSize(14);
             run4.setText("TOTAL TIME ALLOTTED: "+hours+" hours "+ min+" mins");
             
             //run4.setText("Number of questions: "+noOfQues);
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para5=doc.createParagraph();
             para5.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run5=para5.createRun();
             run5.setBold(true);
             run5.setCapitalized(true);
             run5.setFontFamily("Times New Roman");
             run5.setFontSize(14);
             run5.setText("Number of questions: "+noOfQues);
             
             //run5.setText(level+" "+paperType);
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para6=doc.createParagraph();
             para6.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run6=para6.createRun();
             run6.setBold(true);
             run6.setCapitalized(true);
             run6.setFontFamily("Times New Roman");
             run6.setFontSize(14);
             if(level.equals("AS"))
             run6.setText("Paper type: Advanced Subsidiary (AS) "+paperType);
             else
             run6.setText("Paper type: Advanced (A) "+paperType);
             
             //run6.setText("General guidelines:");
             XWPFParagraph para7=doc.createParagraph();
             para7.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run7=para7.createRun();
             run7.setBold(true);
             //run7.setCapitalized(true);
             run7.setFontFamily("Times New Roman");
             run7.setFontSize(14);
             //run7.setText("1. All the questions compulsory");
             run7.setText(" ");
             
             XWPFParagraph para8=doc.createParagraph();
             para8.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run8=para8.createRun();
             run8.setBold(true);
             run8.setCapitalized(true);
             run8.setFontFamily("Times New Roman");
             run8.setFontSize(14);
             //run8.setText("2. Read all the questions very carefully before answering. Write to the point answers");
             run8.setText("General guidelines:");
             
             XWPFParagraph para9=doc.createParagraph();
             para9.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run9=para9.createRun();
             run9.setBold(true);
             run9.setCapitalized(true);
             run9.setFontFamily("Times New Roman");
             run9.setFontSize(14);
             run9.setText("1. All the questions are compulsory.");
             
             XWPFParagraph para10=doc.createParagraph();
             para10.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run10=para10.createRun();
             run10.setBold(true);
             run10.setCapitalized(true);
             run10.setFontFamily("Times New Roman");
             run10.setFontSize(14);
             run10.setText("2. Read all the questions very carefully before answering. Write to the point answers.");
             
             XWPFParagraph para11=doc.createParagraph();
             para11.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run11=para11.createRun();
             run11.setBold(true);
             run11.setCapitalized(true);
             run11.setFontFamily("Times New Roman");
             run11.setFontSize(14);
             run11.setText(" ");
             
             doc.createParagraph().createRun().setText(" ");
             
             XWPFParagraph para12=doc.createParagraph();
             para12.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run12=para12.createRun();
             run12.setBold(true);
             run12.setCapitalized(true);
             run12.setFontFamily("Times New Roman");
             run12.setFontSize(14);
             run12.setText("Questions are as follows:");
             run12.setUnderline(UnderlinePatterns.SINGLE);
             
             XWPFParagraph para13=doc.createParagraph();
             para13.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run13=para13.createRun();
             run13.setBold(true);
             run13.setCapitalized(true);
             run13.setFontFamily("Times New Roman");
             run13.setFontSize(14);
             run13.setText(" ");
             
             int twoMarkerCount=quesList2.size();
             for(int i=0;i<twoMarkerCount;i++)
             {
             XWPFParagraph para=doc.createParagraph();
             para.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun runn=para.createRun();
             //runn.setBold(true);
             //runn.setCapitalized(true);
             runn.setFontFamily("Times New Roman");
             runn.setFontSize(14);
             runn.setText(quesCount+". "+quesList2.get(i)+" (2 marks)");
             quesCount++;
             XWPFParagraph para14=doc.createParagraph();
             para14.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run14=para.createRun();
             //run14.setBold(true);
             //run14.setCapitalized(true);
             run14.setFontFamily("Times New Roman");
             run14.setFontSize(14);
             run14.setText(" ");
             }
             
             int fiveMarkerCount=quesList5.size();
             for(int i=0;i<fiveMarkerCount;i++)
             {
             XWPFParagraph para=doc.createParagraph();
             para.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun runn=para.createRun();
             //runn.setBold(true);
             //runn.setCapitalized(true);
             runn.setFontFamily("Times New Roman");
             runn.setFontSize(14);
             runn.setText(quesCount+". "+quesList5.get(i)+" (5 marks)");
             quesCount++;
             XWPFParagraph para14=doc.createParagraph();
             para14.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run14=para.createRun();
             //run14.setBold(true);
            // run14.setCapitalized(true);
             run14.setFontFamily("Times New Roman");
             run14.setFontSize(14);
             run14.setText(" ");
             }
             
             int eightMarkerCount=quesList8.size();
             for(int i=0;i<eightMarkerCount;i++)
             {
             XWPFParagraph para=doc.createParagraph();
             para.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun runn=para.createRun();
             //runn.setBold(true);
            // runn.setCapitalized(true);
             runn.setFontFamily("Times New Roman");
             runn.setFontSize(14);
             runn.setText(quesCount+". "+quesList8.get(i)+" (8 marks)");
             quesCount++;
             XWPFParagraph para14=doc.createParagraph();
             para14.setAlignment(ParagraphAlignment.LEFT);
             XWPFRun run14=para.createRun();
             //run14.setBold(true);
            // run14.setCapitalized(true);
             run14.setFontFamily("Times New Roman");
             run14.setFontSize(14);
             run14.setText(" ");
             }
            doc.write(out);
            out.close();
            System.out.println("Document created successfully");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PreviewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (IOException ex) {
            Logger.getLogger(PreviewFrame.class.getName()).log(Level.SEVERE, null, ex);
     
         }
       
         JOptionPane.showMessageDialog(null, "Saved as word file!" , "Message",JOptionPane.INFORMATION_MESSAGE);   
        }
        
        if(e.getSource()==viewDoc)
        {
            Runtime rt=Runtime.getRuntime();
            try {
                
                rt.exec("open Question_Paper.docx");
               
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(PreviewFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        if(e.getSource()==printDoc)
        {
            
        }
        if(e.getSource()==goToMainMenu)
        {
            LoginFrame lf=new LoginFrame();
            this.dispose();
            lf.setLayout(null);
            lf.setResizable(false);
            lf.setVisible(true);
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

    public static void main(String args[])
    {
        PreviewFrame pf=new PreviewFrame();
        pf.setLayout(null);
        pf.setResizable(false);
        pf.setVisible(true);
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
