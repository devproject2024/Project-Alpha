package com.google.android.gms.internal.p001firebaseperf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbg  reason: invalid package */
public class zzbg implements Parcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new ah();

    /* renamed from: a  reason: collision with root package name */
    public long f9736a;

    /* renamed from: b  reason: collision with root package name */
    private long f9737b;

    public zzbg() {
        this.f9736a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f9737b = System.nanoTime();
    }

    public int describeContents() {
        return 0;
    }

    public final void a() {
        this.f9736a = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.f9737b = System.nanoTime();
    }

    public final long b() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.f9737b);
    }

    public final long a(zzbg zzbg) {
        return TimeUnit.NANOSECONDS.toMicros(zzbg.f9737b - this.f9737b);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f9736a);
        parcel.writeLong(this.f9737b);
    }

    private zzbg(Parcel parcel) {
        this.f9736a = parcel.readLong();
        this.f9737b = parcel.readLong();
    }

    /* synthetic */ zzbg(Parcel parcel, byte b2) {
        this(parcel);
    }
}
