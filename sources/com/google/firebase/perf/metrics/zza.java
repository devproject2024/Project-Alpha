package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f39278a;

    /* renamed from: b  reason: collision with root package name */
    AtomicLong f39279b;

    public zza(String str) {
        this.f39278a = str;
        this.f39279b = new AtomicLong(0);
    }

    public int describeContents() {
        return 0;
    }

    public final void a(long j) {
        this.f39279b.addAndGet(j);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f39278a);
        parcel.writeLong(this.f39279b.get());
    }

    private zza(Parcel parcel) {
        this.f39278a = parcel.readString();
        this.f39279b = new AtomicLong(parcel.readLong());
    }

    /* synthetic */ zza(Parcel parcel, byte b2) {
        this(parcel);
    }
}
