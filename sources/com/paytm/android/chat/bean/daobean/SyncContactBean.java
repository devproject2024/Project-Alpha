package com.paytm.android.chat.bean.daobean;

public class SyncContactBean {
    private String channelUrl;
    private String contactId;
    private String contactName;
    private String contactPhone;
    private String contactPic;
    private Long id;
    private boolean isPaytm = false;
    private long lastMessageTimeStamp = 0;
    private String ptId;
    private String ptName;
    private String ptPic;
    private String selfId;
    private String sendbirdId;

    public static class Status {
        public static final String STATUS_ADDED = "added";
        public static final String STATUS_MODIFIED = "modified";
        public static final String STATUS_SYNCED = "synced";
        public static final String STATUS_UNSYNCED = "unsynced";
    }

    public SyncContactBean(String str, String str2, String str3, String str4) {
        this.contactName = str;
        this.contactPhone = str2;
        this.contactPic = str3;
        this.contactId = str4;
    }

    public SyncContactBean(Long l, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, long j) {
        this.id = l;
        this.ptId = str;
        this.ptName = str2;
        this.ptPic = str3;
        this.channelUrl = str4;
        this.contactName = str5;
        this.contactPhone = str6;
        this.contactPic = str7;
        this.contactId = str8;
        this.isPaytm = z;
        this.selfId = str9;
        this.sendbirdId = str10;
        this.lastMessageTimeStamp = j;
    }

    public SyncContactBean() {
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

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public boolean getIsPaytm() {
        return this.isPaytm;
    }

    public void setIsPaytm(boolean z) {
        this.isPaytm = z;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public void setSelfId(String str) {
        this.selfId = str;
    }

    public String getSendbirdId() {
        return this.sendbirdId;
    }

    public void setSendbirdId(String str) {
        this.sendbirdId = str;
    }

    public long getLastMessageTimeStamp() {
        return this.lastMessageTimeStamp;
    }

    public void setLastMessageTimeStamp(long j) {
        this.lastMessageTimeStamp = j;
    }
}
