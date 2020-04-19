package com.excelreader.models;

public class DummyData {
    private String sNo;
    private String group;
    private String sec;
    private String name;
    private String kauid;
    private String Q1;
    private String Q2;
    private String Q3;
    private String Q4;

    public DummyData(String sNo, String group, String sec, String name, String kauid, String q1, String q2, String q3, String q4) {
        this.sNo = sNo;
        this.group = group;
        this.sec = sec;
        this.name = name;
        this.kauid = kauid;
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        Q4 = q4;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKauid() {
        return kauid;
    }

    public void setKauid(String kauid) {
        this.kauid = kauid;
    }

    public String getQ1() {
        return Q1;
    }

    public void setQ1(String q1) {
        Q1 = q1;
    }

    public String getQ2() {
        return Q2;
    }

    public void setQ2(String q2) {
        Q2 = q2;
    }

    public String getQ3() {
        return Q3;
    }

    public void setQ3(String q3) {
        Q3 = q3;
    }

    public String getQ4() {
        return Q4;
    }

    public void setQ4(String q4) {
        Q4 = q4;
    }
}
