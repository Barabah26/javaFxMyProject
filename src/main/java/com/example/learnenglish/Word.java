package com.example.learnenglish;

public class Word {
    private int id;
    private String wordsInEnglish;
    private String translate;

    public Word(String wordsInEnglish, String translate) {
        this.wordsInEnglish = wordsInEnglish;
        this.translate = translate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordsInEnglish() {
        return wordsInEnglish;
    }

    public void setWordsInEnglish(String wordsInEnglish) {
        this.wordsInEnglish = wordsInEnglish;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}
