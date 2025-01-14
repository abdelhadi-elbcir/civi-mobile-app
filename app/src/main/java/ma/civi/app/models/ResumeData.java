package ma.civi.app.models;

import java.util.List;

public class ResumeData {
    private String name;
    private String email;
    private String phone;
    private String summary;
    private List<Education> educationList;
    private List<Experience> experienceList;
    private List<String> skills;

    // Constructor
    public ResumeData(String name, String email, String phone, String summary,
                      List<Education> educationList, List<Experience> experienceList, List<String> skills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.summary = summary;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.skills = skills;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
