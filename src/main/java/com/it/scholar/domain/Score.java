package com.it.scholar.domain;

public class Score {
    //分数记录id
    private Integer id;
    //人员ID
    private Integer user_id;
    //人员名字
    private String name;
    //语文分数
    private double languageScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLanguageScore() {
        return languageScore;
    }

    public void setLanguageScore(double languageScore) {
        this.languageScore = languageScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", languageScore=" + languageScore +
                '}';
    }
}
