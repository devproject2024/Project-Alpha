package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.a;

public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private Messenger f8331a;

    /* renamed from: b  reason: collision with root package name */
    private a f8332b;

    public zza(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8331a = new Messenger(iBinder);
        } else {
            this.f8332b = new a.C0124a(iBinder);
        }
    }

    public int describeContents() {
        return 0;
    }

    private final IBinder a() {
        Messenger messenger = this.f8331a;
        return messenger != null ? messenger.getBinder() : this.f8332b.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zza) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f8331a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f8332b.asBinder());
        }
    }
}
