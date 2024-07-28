package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.a;
import com.google.android.gms.internal.measurement.r;
import java.util.ArrayList;
import java.util.List;

public final class ds extends a implements dq {
    ds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void a(zzan zzan, zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzan);
        r.a(a2, (Parcelable) zzm);
        b(1, a2);
    }

    public final void a(zzkl zzkl, zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzkl);
        r.a(a2, (Parcelable) zzm);
        b(2, a2);
    }

    public final void a(zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzm);
        b(4, a2);
    }

    public final void a(zzan zzan, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzan);
        a2.writeString(str);
        a2.writeString(str2);
        b(5, a2);
    }

    public final void b(zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzm);
        b(6, a2);
    }

    public final List<zzkl> a(zzm zzm, boolean z) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzm);
        r.a(a2, z);
        Parcel a3 = a(7, a2);
        ArrayList<zzkl> createTypedArrayList = a3.createTypedArrayList(zzkl.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    public final byte[] a(zzan zzan, String str) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzan);
        a2.writeString(str);
        Parcel a3 = a(9, a2);
        byte[] createByteArray = a3.createByteArray();
        a3.recycle();
        return createByteArray;
    }

    public final void a(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        b(10, a2);
    }

    public final String c(zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzm);
        Parcel a3 = a(11, a2);
        String readString = a3.readString();
        a3.recycle();
        return readString;
    }

    public final void a(zzv zzv, zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzv);
        r.a(a2, (Parcelable) zzm);
        b(12, a2);
    }

    public final void a(zzv zzv) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzv);
        b(13, a2);
    }

    public final List<zzkl> a(String str, String str2, boolean z, zzm zzm) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, z);
        r.a(a2, (Parcelable) zzm);
        Parcel a3 = a(14, a2);
        ArrayList<zzkl> createTypedArrayList = a3.createTypedArrayList(zzkl.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    public final List<zzkl> a(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        r.a(a2, z);
        Parcel a3 = a(15, a2);
        ArrayList<zzkl> createTypedArrayList = a3.createTypedArrayList(zzkl.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    public final List<zzv> a(String str, String str2, zzm zzm) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        r.a(a2, (Parcelable) zzm);
        Parcel a3 = a(16, a2);
        ArrayList<zzv> createTypedArrayList = a3.createTypedArrayList(zzv.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    public final List<zzv> a(String str, String str2, String str3) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        Parcel a3 = a(17, a2);
        ArrayList<zzv> createTypedArrayList = a3.createTypedArrayList(zzv.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    public final void d(zzm zzm) throws RemoteException {
        Parcel a2 = a();
        r.a(a2, (Parcelable) zzm);
        b(18, a2);
    }
}
