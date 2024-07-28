package net.one97.paytm.wallet.newdesign.models;

import net.one97.paytm.common.entity.IJRDataModel;

public class ScanAadhaarCardModel implements IJRDataModel {
    String address;
    String dob;
    String gender;
    String loc;
    String name;
    String po;
    String uid;
    String yob;

    public String getPo() {
        return this.po;
    }

    public void setPo(String str) {
        this.po = str;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String str) {
        this.loc = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getYob() {
        return this.yob;
    }

    public void setYob(String str) {
        this.yob = str;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String str) {
        this.dob = str;
    }
}
