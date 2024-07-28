package org.npci.upi.security.pinactivitycomponent;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import org.npci.upi.security.services.CLResultReceiver;

public class CLServerResultReceiver extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    private CLResultReceiver f72914a;

    public CLServerResultReceiver(CLResultReceiver cLResultReceiver) {
        super(new Handler());
        this.f72914a = cLResultReceiver;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        if (i2 == 2) {
            try {
                this.f72914a.triggerOtp(bundle);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } else {
            this.f72914a.sendCredential(bundle);
        }
    }
}
