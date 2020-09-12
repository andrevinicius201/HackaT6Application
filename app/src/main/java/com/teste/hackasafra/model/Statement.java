package com.teste.hackasafra.model;

public class Statement {

    private String description;
    private String date;
    private String value;
    private String stickers;

    public Statement(){

    } // That way we can instance the class without parameters

    public Statement(String description, String date, String value, String stickers) {
        this.description = description;
        this.date = date;
        this.value = value;
        this.stickers = stickers;
    } // That way we can instance the class with parameters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStickers() {
        return stickers;
    }

    public void setStickers(String stickers) {
        this.stickers = stickers;
    }
}
