package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ImageLabelerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ImageLabelerOptions> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public int f12652a;

    /* renamed from: b  reason: collision with root package name */
    public float f12653b;

    /* renamed from: c  reason: collision with root package name */
    public int f12654c;

    /* renamed from: d  reason: collision with root package name */
    private int f12655d;

    public ImageLabelerOptions(int i2, int i3, float f2, int i4) {
        if (i2 == 1) {
            this.f12655d = i2;
            this.f12652a = i3;
            this.f12653b = f2;
            this.f12654c = i4;
            return;
        }
        throw new IllegalArgumentException("Unknown language.");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f12655d);
        b.b(parcel, 3, this.f12652a);
        b.a(parcel, 4, this.f12653b);
        b.b(parcel, 5, this.f12654c);
        b.b(parcel, a2);
    }
}
