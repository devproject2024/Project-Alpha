package com.paytm.contactsSdk.contactsSDKWorkManager;

import android.content.Context;
import androidx.work.w;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.h;

public final class ContactsSDKWorkManager implements ContactsSDKWorkManagerHelper {
    public static final ContactsSDKWorkManager INSTANCE = new ContactsSDKWorkManager();
    private static final g contactsSDKWorkManagerImpl$delegate = h.a(ContactsSDKWorkManager$contactsSDKWorkManagerImpl$2.INSTANCE);

    private final ContactsSDKWorkManagerImpl getContactsSDKWorkManagerImpl() {
        return (ContactsSDKWorkManagerImpl) contactsSDKWorkManagerImpl$delegate.getValue();
    }

    private ContactsSDKWorkManager() {
    }

    public final void initManager(Context context) {
        k.c(context, "appContext");
        getContactsSDKWorkManagerImpl().initManager(context);
    }

    public final void enqueue(w wVar) {
        k.c(wVar, "workRequest");
        getContactsSDKWorkManagerImpl().enqueue(wVar);
    }

    public final void enqueue(List<? extends w> list) {
        k.c(list, "workRequests");
        getContactsSDKWorkManagerImpl().enqueue(list);
    }
}
