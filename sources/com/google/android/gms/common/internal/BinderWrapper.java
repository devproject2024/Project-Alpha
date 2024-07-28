package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new ak();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f8732a;

    public BinderWrapper() {
        this.f8732a = null;
    }

    public final int describeContents() {
        return 0;
    }

    private BinderWrapper(Parcel parcel) {
        this.f8732a = null;
        this.f8732a = parcel.readStrongBinder();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.f8732a);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, byte b2) {
        this(parcel);
    }
}
