package com.paytm.android.chat.bean;

public class MoreContactsBean {
    private boolean isSelect;
    private String phone;

    public MoreContactsBean(String str, boolean z) {
        this.phone = str;
        this.isSelect = z;
    }

    public MoreContactsBean() {
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
