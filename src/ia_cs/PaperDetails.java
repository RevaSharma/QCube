/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_cs;

/**
 *
 * @author reva
 */
public class PaperDetails {
    
    private String subject;
    private String level;
    private String paperType;
    private String date;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public String getLevel() {
        return level;
    }

    public String getPaperType() {
        return paperType;
    }

    public String getDate() {
        return date;
    }

    public PaperDetails(String subject, String level, String paperType, String date) {
        this.subject = subject;
        this.level = level;
        this.paperType = paperType;
        this.date = date;
    }
}
