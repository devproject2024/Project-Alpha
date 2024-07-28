package net.one97.paytm.common.entity.RiskAnalysis;

public class Contact {
    private boolean isContactExits;
    private String number;
    private String updatedTime;

    public Contact(String str, boolean z, String str2) {
        this.number = str;
        this.isContactExits = z;
        this.updatedTime = str2;
    }

    public String getNumber() {
        return this.number;
    }

    public String getUpdatedTime() {
        return this.updatedTime;
    }

    public boolean isContactExits() {
        return this.isContactExits;
    }
}
