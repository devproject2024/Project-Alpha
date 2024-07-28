package org.npci.upi.security.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import org.npci.upi.security.services.CLResultReceiver;

public class CLRemoteResultReceiver extends Service {
    private IBinder mBinder = new CLResultReceiver.Stub() {
        public void sendCredential(Bundle bundle) throws RemoteException {
            CLRemoteResultReceiver.this.mResultReceiver.send(1, bundle);
        }

        public void triggerOtp(Bundle bundle) throws RemoteException {
            CLRemoteResultReceiver.this.mResultReceiver.send(2, bundle);
        }
    };
    /* access modifiers changed from: private */
    public ResultReceiver mResultReceiver;

    public CLRemoteResultReceiver(ResultReceiver resultReceiver) {
        this.mResultReceiver = resultReceiver;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public IBinder getBinder() {
        return this.mBinder;
    }
}
