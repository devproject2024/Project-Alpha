package com.paytm.contactsSdk.contactsSDKWorkManager;

import android.content.Context;
import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;

final /* synthetic */ class ContactsSDKWorkManagerImpl$sendMessage$1 extends n {
    ContactsSDKWorkManagerImpl$sendMessage$1(ContactsSDKWorkManagerImpl contactsSDKWorkManagerImpl) {
        super(contactsSDKWorkManagerImpl);
    }

    public final String getName() {
        return "appContext";
    }

    public final d getOwner() {
        return y.b(ContactsSDKWorkManagerImpl.class);
    }

    public final String getSignature() {
        return "getAppContext()Landroid/content/Context;";
    }

    public final Object get() {
        return ContactsSDKWorkManagerImpl.access$getAppContext$p((ContactsSDKWorkManagerImpl) this.receiver);
    }

    public final void set(Object obj) {
        ((ContactsSDKWorkManagerImpl) this.receiver).appContext = (Context) obj;
    }
}
