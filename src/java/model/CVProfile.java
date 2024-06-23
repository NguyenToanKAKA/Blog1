/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class CVProfile {

    private int CVId, UserID, Number;
    private String Skills, Experience, Description, Education, Certification, LinkUrl, Avatar, LinkPdf;

    public CVProfile(int UserID, String Skills, String Experience, String Description, String Education, String Certification, String LinkUrl, String Avatar, String LinkPdf) {
        this.UserID = UserID;
        this.Skills = Skills;
        this.Experience = Experience;
        this.Description = Description;
        this.Education = Education;
        this.Certification = Certification;
        this.LinkUrl = LinkUrl;
        this.Avatar = Avatar;
        this.LinkPdf = LinkPdf;
    }

    public CVProfile(int CVId, int UserID, int Number, String Skills, String Experience, String Description, String Education, String Certification, String LinkUrl, String Avatar, String LinkPdf) {
        this.CVId = CVId;
        this.UserID = UserID;
        this.Number = Number;
        this.Skills = Skills;
        this.Experience = Experience;
        this.Description = Description;
        this.Education = Education;
        this.Certification = Certification;
        this.LinkUrl = LinkUrl;
        this.Avatar = Avatar;
        this.LinkPdf = LinkPdf;
    }

    public String getLinkPdf() {
        return LinkPdf;
    }

    public void setLinkPdf(String LinkPdf) {
        this.LinkPdf = LinkPdf;
    }

    public int getCVId() {
        return CVId;
    }

    public void setCVId(int CVId) {
        this.CVId = CVId;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String Skills) {
        this.Skills = Skills;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    public String getCertification() {
        return Certification;
    }

    public void setCertification(String Certification) {
        this.Certification = Certification;
    }

    public String getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(String LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    @Override
    public String toString() {
        return "CVProfile{" + "CVId=" + CVId + ", UserID=" + UserID + ", Number=" + Number + ", Skills=" + Skills + ", Experience=" + Experience + ", Description=" + Description + ", Education=" + Education + ", Certification=" + Certification + ", LinkUrl=" + LinkUrl + ", Avatar=" + Avatar + ", LinkPdf=" + LinkPdf + '}';
    }

}
