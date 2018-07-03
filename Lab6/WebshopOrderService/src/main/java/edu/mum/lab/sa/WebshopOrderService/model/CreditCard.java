package edu.mum.lab.sa.WebshopOrderService.model;

import java.util.Date;

public class CreditCard {
    private String pan;
    private Date expiryDate;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
