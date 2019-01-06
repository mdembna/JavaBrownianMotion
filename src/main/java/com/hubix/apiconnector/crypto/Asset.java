package com.hubix.apiconnector.crypto;

public class Asset {

    private String symbol;

    private String rootSymbol;

    private String state;

    private String typ;  //type?

    private String quoteCurrency;

    private String reference;

    private String referenceSymbol;

    private double prevPrice24h;

    private double lastPrice;

    private double lastChangePcnt;

    private double markPrice;

    private String timestamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRootSymbol() {
        return rootSymbol;
    }

    public void setRootSymbol(String rootSymbol) {
        this.rootSymbol = rootSymbol;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceSymbol() {
        return referenceSymbol;
    }

    public void setReferenceSymbol(String referenceSymbol) {
        this.referenceSymbol = referenceSymbol;
    }

    public double getPrevPrice24h() {
        return prevPrice24h;
    }

    public void setPrevPrice24h(double prevPrice24h) {
        this.prevPrice24h = prevPrice24h;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getLastChangePcnt() {
        return lastChangePcnt;
    }

    public void setLastChangePcnt(double lastChangePcnt) {
        this.lastChangePcnt = lastChangePcnt;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(double markPrice) {
        this.markPrice = markPrice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
