package com.paytm.android.chat.utils;

import com.paytm.android.chat.contact.a;
import java.util.ArrayList;

public class ContactsBeansHolder {
    private static volatile ContactsBeansHolder instance;
    private ArrayList<a> allList;
    private ArrayList<a> headList;

    public static ContactsBeansHolder getInstance() {
        if (instance == null) {
            synchronized (ContactsBeansHolder.class) {
                if (instance == null) {
                    instance = new ContactsBeansHolder();
                }
            }
        }
        return instance;
    }

    public void setData(ArrayList<a> arrayList) {
        this.allList = arrayList;
    }

    public ArrayList<a> getData() {
        return this.allList;
    }

    public void setHeanList(ArrayList<a> arrayList) {
        this.headList = arrayList;
    }

    public ArrayList<a> getHeadList() {
        return this.headList;
    }
}
