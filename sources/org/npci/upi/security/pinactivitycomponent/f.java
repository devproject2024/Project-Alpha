package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.npci.upi.security.services.CLRemoteService;
import org.npci.upi.security.services.CLResultReceiver;

class f extends CLRemoteService.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CLRemoteServiceImpl f72981a;

    /* renamed from: b  reason: collision with root package name */
    private Context f72982b;

    private f(CLRemoteServiceImpl cLRemoteServiceImpl, Context context) {
        this.f72981a = cLRemoteServiceImpl;
        this.f72982b = null;
        this.f72982b = context;
    }

    public String getChallenge(String str, String str2) {
        return this.f72981a.f72913b.a(str, str2);
    }

    public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
        Bundle a2 = this.f72981a.a(str, str2, str3, str4, str5, str6, str7, str8, cLResultReceiver);
        Intent intent = new Intent(this.f72982b, GetCredential.class);
        intent.setFlags(268435456);
        intent.putExtras(a2);
        this.f72982b.startActivity(intent);
    }

    public boolean registerApp(String str, String str2, String str3, String str4) {
        return this.f72981a.f72913b.a(str, str2, str3, str4);
    }
}
