package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p001firebaseperf.bq;
import com.google.android.gms.internal.p001firebaseperf.bx;
import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.android.gms.internal.p001firebaseperf.v;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.util.List;
import java.util.UUID;

public class zzs implements Parcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    public String f39254a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39255b;

    /* renamed from: c  reason: collision with root package name */
    zzbg f39256c;

    public static zzs a() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        new v();
        zzs zzs = new zzs(replaceAll);
        zzs.f39255b = a(FeatureControl.zzao().zzap(), FeatureControl.zzao().zzas());
        Object[] objArr = new Object[2];
        objArr[0] = zzs.f39255b ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        String.format("Creating a new %s Session: %s", objArr);
        return zzs;
    }

    public int describeContents() {
        return 0;
    }

    private zzs(String str) {
        this.f39255b = false;
        this.f39254a = str;
        this.f39256c = new zzbg();
    }

    public final bq b() {
        bq.a a2 = bq.c().a(this.f39254a);
        if (this.f39255b) {
            a2.a(bx.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (bq) ((dq) a2.k());
    }

    public static bq[] a(List<zzs> list) {
        if (list.isEmpty()) {
            return null;
        }
        bq[] bqVarArr = new bq[list.size()];
        bq b2 = list.get(0).b();
        boolean z = false;
        for (int i2 = 1; i2 < list.size(); i2++) {
            bq b3 = list.get(i2).b();
            if (z || !list.get(i2).f39255b) {
                bqVarArr[i2] = b3;
            } else {
                bqVarArr[0] = b3;
                bqVarArr[i2] = b2;
                z = true;
            }
        }
        if (!z) {
            bqVarArr[0] = b2;
        }
        return bqVarArr;
    }

    private static boolean a(boolean z, float f2) {
        return z && Math.random() * 100.0d < ((double) f2);
    }

    public static boolean c() {
        return a(true, 1.0f);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f39254a);
        parcel.writeByte(this.f39255b ? (byte) 1 : 0);
        parcel.writeParcelable(this.f39256c, 0);
    }

    private zzs(Parcel parcel) {
        boolean z = false;
        this.f39255b = false;
        this.f39254a = parcel.readString();
        this.f39255b = parcel.readByte() != 0 ? true : z;
        this.f39256c = (zzbg) parcel.readParcelable(zzbg.class.getClassLoader());
    }

    /* synthetic */ zzs(Parcel parcel, byte b2) {
        this(parcel);
    }
}
