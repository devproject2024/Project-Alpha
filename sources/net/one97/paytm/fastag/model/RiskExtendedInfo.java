package net.one97.paytm.fastag.model;

import java.util.ArrayList;

public class RiskExtendedInfo {
    private String channelID;
    private String contactCreateTime;
    private ArrayList<DeviceAccount> deviceAccounts;
    private String displayName;
    private boolean isContact;
    private boolean isRooted;
    private ArrayList<String> lci;
    private ArrayList<Boolean> lcic;
    private ArrayList<String> lco;
    private String mode;
    private boolean otpReadFlag;
    private String scanType;
    private String transactionType;
    private String userLbsLatitude;
    private String userLbsLongitude;
    private ArrayList<String> wifissid;

    public ArrayList<DeviceAccount> getDeviceAccounts() {
        return this.deviceAccounts;
    }

    public void setDeviceAccounts(ArrayList<DeviceAccount> arrayList) {
        this.deviceAccounts = arrayList;
    }

    public String getContactCreateTime() {
        return this.contactCreateTime;
    }

    public void setContactCreateTime(String str) {
        this.contactCreateTime = str;
    }

    public ArrayList<String> getWifissid() {
        return this.wifissid;
    }

    public void setWifissid(ArrayList<String> arrayList) {
        this.wifissid = arrayList;
    }

    public boolean getIsContact() {
        return this.isContact;
    }

    public void setIsContact(boolean z) {
        this.isContact = z;
    }

    public boolean getOtpReadFlag() {
        return this.otpReadFlag;
    }

    public void setOtpReadFlag(boolean z) {
        this.otpReadFlag = z;
    }

    public boolean getIsRooted() {
        return this.isRooted;
    }

    public void setIsRooted(boolean z) {
        this.isRooted = z;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getScanType() {
        return this.scanType;
    }

    public void setScanType(String str) {
        this.scanType = str;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setLci(ArrayList<String> arrayList) {
        this.lci = arrayList;
    }

    public void setLco(ArrayList<String> arrayList) {
        this.lco = arrayList;
    }

    public void setLatitude(String str) {
        this.userLbsLatitude = str;
    }

    public void setLongitude(String str) {
        this.userLbsLongitude = str;
    }

    public void setTranscationType(String str) {
        this.transactionType = str;
    }

    public void setIncomingCall(String str) {
        if (this.lci == null) {
            this.lci = new ArrayList<>();
        }
        if (!this.lci.contains(str)) {
            if (this.lci.size() >= 3) {
                this.lci.remove(0);
            }
            this.lci.add(0, str);
        }
    }

    public void setOutgoingCall(String str) {
        if (this.lco == null) {
            this.lco = new ArrayList<>();
        }
        if (!this.lco.contains(str)) {
            if (this.lco.size() >= 3) {
                this.lco.remove(0);
            }
            this.lco.add(0, str);
        }
    }

    public ArrayList<String> getLci() {
        return this.lci;
    }

    public ArrayList<String> getLco() {
        return this.lco;
    }

    public ArrayList<Boolean> getLcic() {
        return this.lcic;
    }

    public void setLcic(ArrayList<Boolean> arrayList) {
        this.lcic = arrayList;
    }

    public void setChannelID(String str) {
        this.channelID = str;
    }
}
