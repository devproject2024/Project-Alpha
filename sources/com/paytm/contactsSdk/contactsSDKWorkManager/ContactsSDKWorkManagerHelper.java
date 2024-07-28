package com.paytm.contactsSdk.contactsSDKWorkManager;

import androidx.work.w;
import java.util.List;

public interface ContactsSDKWorkManagerHelper {
    void enqueue(w wVar);

    void enqueue(List<? extends w> list);
}
