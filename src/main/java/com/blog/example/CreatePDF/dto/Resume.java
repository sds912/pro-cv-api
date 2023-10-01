package com.blog.example.CreatePDF.dto;

import java.util.Set;

public class Resume {
    private Header header;
    private Set<Experience> experiences;
    private Set<Education> educations;
    private Set<Skill> skills;
    private Set<Language> languages;
    private Integer step;
    private Theme theme;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "header=" + header +
                ", experiences=" + experiences +
                ", educations=" + educations +
                ", skills=" + skills +
                ", languages=" + languages +
                ", step=" + step +
                ", theme=" + theme +
                '}';
    }
}
