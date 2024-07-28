package com.paytm.android.chat.bean.jsonbean;

public class UploadImageJsonBean {
    private boolean avatarFlag;
    private String fileStr;
    private Long userId;

    public String getFileStr() {
        return this.fileStr;
    }

    public void setFileStr(String str) {
        this.fileStr = str;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public boolean isAvatarFlag() {
        return this.avatarFlag;
    }

    public void setAvatarFlag(boolean z) {
        this.avatarFlag = z;
    }

    public String toString() {
        return "UploadImageJsonBean{fileStr='" + this.fileStr + '\'' + ", userId=" + this.userId + ", avatarFlag=" + this.avatarFlag + '}';
    }
}
