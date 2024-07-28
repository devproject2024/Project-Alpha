package org.npci.upi.security.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import org.npci.upi.security.services.CLRemoteService;
import org.npci.upi.security.services.CLResultReceiver;

public class CLServices {
    private static final Uri GET_CHALLENGE_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getChallenge");
    private static final Uri GET_CREDENTIAL_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getCredential");
    private static final String PROVIDER_NAME = "org.npci.upi.security.pinactivitycomponent.clservices";
    private static final Uri REGISTER_APP_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/registerApp");
    /* access modifiers changed from: private */
    public static CLServices clServices = null;
    /* access modifiers changed from: private */
    public CLRemoteService clRemoteService = null;
    private Context mContext;
    /* access modifiers changed from: private */
    public ServiceConnectionStatusNotifier notifier;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CLRemoteService unused = CLServices.this.clRemoteService = CLRemoteService.Stub.asInterface(iBinder);
            CLServices.this.notifier.serviceConnected(CLServices.clServices);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            CLRemoteService unused = CLServices.this.clRemoteService = null;
            CLServices.this.notifier.serviceDisconnected();
        }
    };

    public static void initService(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        if (clServices == null) {
            clServices = new CLServices(context, serviceConnectionStatusNotifier);
            return;
        }
        throw new RuntimeException("Service already initiated");
    }

    public void unbindService() {
        this.mContext.unbindService(this.serviceConnection);
    }

    private CLServices(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        this.mContext = context;
        this.notifier = serviceConnectionStatusNotifier;
        Intent intent = new Intent();
        intent.setAction("org.npci.upi.security.services.CLRemoteService");
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.bindService(intent, this.serviceConnection, 1);
    }

    public String getChallenge(String str, String str2) {
        Class<CLServices> cls = CLServices.class;
        cls.getName();
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty()) {
            cls.getName();
            return null;
        }
        try {
            return this.clRemoteService.getChallenge(str, str2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean registerApp(String str, String str2, String str3, String str4) {
        Class<CLServices> cls = CLServices.class;
        cls.getName();
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty() || str3 == null || str3.trim().isEmpty() || str4 == null || str4.trim().isEmpty()) {
            cls.getName();
            return false;
        }
        try {
            return this.clRemoteService.registerApp(str, str2, str3, str4);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLRemoteResultReceiver cLRemoteResultReceiver) {
        CLServices.class.getName();
        try {
            this.clRemoteService.getCredential(str, str2, str3, str4, str5, str6, str7, str8, CLResultReceiver.Stub.asInterface(cLRemoteResultReceiver.getBinder()));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
