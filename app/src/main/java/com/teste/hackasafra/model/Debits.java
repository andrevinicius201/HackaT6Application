package com.teste.hackasafra.model;

public class Debits {

    private String description;
    private String value;
    private String status;

    public Debits() {
    }

    public Debits(String description, String value, String status) {
        this.description = description;
        this.value = value;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
