package com.paytm.android.chat.bean;

import com.paytm.android.chat.contact.d;
import java.io.Serializable;

public class SelectContactsBean implements Serializable {
    public boolean isForward;
    private boolean isSelect;
    private SendContactBean sendContactBean;

    public SendContactBean getSendContactBean() {
        return this.sendContactBean;
    }

    public void setSendContactBean(SendContactBean sendContactBean2) {
        this.sendContactBean = sendContactBean2;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public SelectContactsBean(SendContactBean sendContactBean2, boolean z) {
        this.sendContactBean = sendContactBean2;
        this.isSelect = z;
    }

    public SelectContactsBean() {
    }

    public SelectContactsBean(d dVar) {
        this.sendContactBean = new SendContactBean();
        this.sendContactBean.setContactName(dVar.f41852a);
        this.sendContactBean.setContactPhone(dVar.f41853b);
        this.sendContactBean.setContactPic(dVar.f41854c);
    }
}
