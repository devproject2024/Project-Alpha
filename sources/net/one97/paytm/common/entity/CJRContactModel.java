package net.one97.paytm.common.entity;

public class CJRContactModel implements IJRDataModel {
    private int mIconResourceID = -1;
    private boolean mIsFrequentContact;
    private boolean mIsSection;
    private String mName;
    private String mPhoneNumber;

    public void setName(String str) {
        this.mName = str;
    }

    public void setPhoneNumber(String str) {
        this.mPhoneNumber = str;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public boolean isFrequentContact() {
        return this.mIsFrequentContact;
    }

    public void setIsFrequentContact(boolean z) {
        this.mIsFrequentContact = z;
    }

    public boolean isIsSection() {
        return this.mIsSection;
    }

    public void setIsSection(boolean z) {
        this.mIsSection = z;
    }

    public int getIconResourceID() {
        return this.mIconResourceID;
    }

    public void setIconResourceID(int i2) {
        this.mIconResourceID = i2;
    }
}
