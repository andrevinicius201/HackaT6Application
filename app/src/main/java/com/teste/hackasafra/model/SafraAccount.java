package com.teste.hackasafra.model;

public class SafraAccount {

    private String AccountId;
    private String Currency;
    private String Nickname;

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }
}
