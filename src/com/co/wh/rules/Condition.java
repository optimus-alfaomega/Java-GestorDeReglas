package com.co.wh.rules;

public class Condition {

    private String name;
    private String sentence;

    public Condition(String name, String sentence) {
        this.name = name;
        this.sentence = sentence;
    }

    private Condition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

}
