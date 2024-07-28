package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.g.ae;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Requirements[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f32779a;

    public final int describeContents() {
        return 0;
    }

    public Requirements(int i2) {
        this.f32779a = (i2 & 2) != 0 ? i2 | 1 : i2;
    }

    static boolean a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    static boolean b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (ae.f32499a >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        return ae.f32499a >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
    }

    static boolean a(ConnectivityManager connectivityManager) {
        if (ae.f32499a < 23) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (!(networkCapabilities == null || !networkCapabilities.hasCapability(16))) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f32779a == ((Requirements) obj).f32779a;
    }

    public final int hashCode() {
        return this.f32779a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32779a);
    }
}
