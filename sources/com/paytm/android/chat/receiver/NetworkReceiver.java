package com.paytm.android.chat.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f42304a;

    public interface a {
        void f();

        void g();
    }

    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (this.f42304a == null) {
            return;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            this.f42304a.g();
        } else {
            this.f42304a.f();
        }
    }

    public final void a(a aVar) {
        this.f42304a = aVar;
    }
}
