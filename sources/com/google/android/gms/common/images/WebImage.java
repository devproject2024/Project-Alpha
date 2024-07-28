package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Locale;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8716a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f8717b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8718c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8719d;

    WebImage(int i2, Uri uri, int i3, int i4) {
        this.f8716a = i2;
        this.f8717b = uri;
        this.f8718c = i3;
        this.f8719d = i4;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f8718c), Integer.valueOf(this.f8719d), this.f8717b.toString()});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            return q.a(this.f8717b, webImage.f8717b) && this.f8718c == webImage.f8718c && this.f8719d == webImage.f8719d;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8717b, Integer.valueOf(this.f8718c), Integer.valueOf(this.f8719d)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8716a);
        b.a(parcel, 2, this.f8717b, i2, false);
        b.b(parcel, 3, this.f8718c);
        b.b(parcel, 4, this.f8719d);
        b.b(parcel, a2);
    }
}
