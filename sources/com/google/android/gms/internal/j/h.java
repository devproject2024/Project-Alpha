package com.google.android.gms.internal.j;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;
import com.google.android.gms.safetynet.zzh;

public abstract class h extends b implements g {
    public h() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza((Status) c.a(parcel, Status.CREATOR), (zza) c.a(parcel, zza.CREATOR));
        } else if (i2 == 2) {
            zza(parcel.readString());
        } else if (i2 == 3) {
            zza((Status) c.a(parcel, Status.CREATOR), (SafeBrowsingData) c.a(parcel, SafeBrowsingData.CREATOR));
        } else if (i2 == 4) {
            zza((Status) c.a(parcel, Status.CREATOR), c.a(parcel));
        } else if (i2 == 6) {
            zza((Status) c.a(parcel, Status.CREATOR), (zzf) c.a(parcel, zzf.CREATOR));
        } else if (i2 == 8) {
            zza((Status) c.a(parcel, Status.CREATOR), (zzd) c.a(parcel, zzd.CREATOR));
        } else if (i2 == 15) {
            zza((Status) c.a(parcel, Status.CREATOR), (zzh) c.a(parcel, zzh.CREATOR));
        } else if (i2 == 10) {
            zzb((Status) c.a(parcel, Status.CREATOR), c.a(parcel));
        } else if (i2 != 11) {
            return false;
        } else {
            zza((Status) c.a(parcel, Status.CREATOR));
        }
        return true;
    }
}
