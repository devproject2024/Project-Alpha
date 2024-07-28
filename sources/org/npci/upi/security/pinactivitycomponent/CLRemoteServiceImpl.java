package org.npci.upi.security.pinactivitycomponent;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import org.npci.upi.security.services.CLRemoteService;
import org.npci.upi.security.services.CLResultReceiver;

public class CLRemoteServiceImpl extends Service {

    /* renamed from: a  reason: collision with root package name */
    private CLRemoteService.Stub f72912a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public g f72913b = null;

    /* access modifiers changed from: private */
    public Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.INPUT_KEY_KEY_CODE, str);
        bundle.putString(CLConstants.INPUT_KEY_XML_PAYLOAD, str2);
        bundle.putString(CLConstants.INPUT_KEY_CONTROLS, str3);
        bundle.putString(CLConstants.INPUT_KEY_CONFIGURATION, str4);
        bundle.putString(CLConstants.INPUT_KEY_SALT, str5);
        bundle.putString(CLConstants.INPUT_KEY_PAY_INFO, str6);
        bundle.putString(CLConstants.INPUT_KEY_TRUST, str7);
        bundle.putString(CLConstants.INPUT_KEY_LANGUAGE_PREFERENCE, str8);
        v.a(new CLServerResultReceiver(cLResultReceiver));
        return bundle;
    }

    public IBinder onBind(Intent intent) {
        if (this.f72912a == null) {
            this.f72912a = new f(this, getBaseContext());
        }
        try {
            this.f72913b = new g(getBaseContext());
            return this.f72912a;
        } catch (Exception unused) {
            throw new RuntimeException("Could not initialize service provider");
        }
    }
}
