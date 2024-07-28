package com.paytm.android.chat.bean;

import java.io.Serializable;

public class SendContactBean implements Serializable {
    private static final long serialVersionUID = -1;
    private String channelUrl;
    private String contactId;
    private String contactName;
    private String contactPhone;
    private String contactPic;
    private Long id;
    private String ptId;
    private String ptName;
    private String ptPic;

    public static long getSerialVersionUID() {
        return -1;
    }

    public SendContactBean(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.id = l;
        this.ptId = str;
        this.ptName = str2;
        this.ptPic = str3;
        this.channelUrl = str4;
        this.contactName = str5;
        this.contactPhone = str6;
        this.contactPic = str7;
    }

    public SendContactBean(String str, String str2, String str3, String str4) {
        this.contactName = str;
        this.contactPhone = str2;
        this.contactPic = str3;
        this.contactId = str4;
    }

    public SendContactBean() {
    }

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String getPtId() {
        return this.ptId;
    }

    public void setPtId(String str) {
        this.ptId = str;
    }

    public String getPtName() {
        return this.ptName;
    }

    public void setPtName(String str) {
        this.ptName = str;
    }

    public String getPtPic() {
        return this.ptPic;
    }

    public void setPtPic(String str) {
        this.ptPic = str;
    }

    public String getChannelUrl() {
        return this.channelUrl;
    }

    public void setChannelUrl(String str) {
        this.channelUrl = str;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String str) {
        this.contactPhone = str;
    }

    public String getContactPic() {
        return this.contactPic;
    }

    public void setContactPic(String str) {
        this.contactPic = str;
    }
}
