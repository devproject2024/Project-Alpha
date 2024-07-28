package com.paytm.android.chat.utils;

import com.paytm.android.chat.bean.p4b.KybData;
import java.util.List;

public class KybDataHelper {
    private static KybDataHelper ourInstance;
    private List<KybData> mKybDataList;

    private KybDataHelper() {
    }

    public static KybDataHelper getInstance() {
        if (ourInstance == null) {
            synchronized (KybDataHelper.class) {
                if (ourInstance == null) {
                    ourInstance = new KybDataHelper();
                }
            }
        }
        return ourInstance;
    }

    public List<KybData> getKybDataList() {
        return this.mKybDataList;
    }

    public void setKybDataList(List<KybData> list) {
        this.mKybDataList = list;
    }
}
