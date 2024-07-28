package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new zzc();
    public final int apkCategory;
    public final String apkPackageName;
    public final byte[] apkSha256;

    public HarmfulAppsData(String str, byte[] bArr, int i2) {
        this.apkPackageName = str;
        this.apkSha256 = bArr;
        this.apkCategory = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.apkPackageName, false);
        b.a(parcel, 3, this.apkSha256, false);
        b.b(parcel, 4, this.apkCategory);
        b.b(parcel, a2);
    }
}
