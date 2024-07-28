package com.paytm.android.chat.utils;

import com.paytm.android.chat.bean.SelectContactsBean;
import java.util.List;

public class SendContactsBeansHolder {
    private static volatile SendContactsBeansHolder instance;
    private List<SelectContactsBean> allList;

    public static SendContactsBeansHolder getInstance() {
        if (instance == null) {
            synchronized (SendContactsBeansHolder.class) {
                if (instance == null) {
                    instance = new SendContactsBeansHolder();
                }
            }
        }
        return instance;
    }

    public void setData(List<SelectContactsBean> list) {
        this.allList = list;
    }

    public List<SelectContactsBean> getData() {
        return this.allList;
    }
}
