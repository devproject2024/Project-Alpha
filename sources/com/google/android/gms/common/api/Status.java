package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class Status extends AbstractSafeParcelable implements l, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    public static final Status f8354a = new Status(0);

    /* renamed from: b  reason: collision with root package name */
    public static final Status f8355b = new Status(14);

    /* renamed from: c  reason: collision with root package name */
    public static final Status f8356c = new Status(8);

    /* renamed from: d  reason: collision with root package name */
    public static final Status f8357d = new Status(15);

    /* renamed from: e  reason: collision with root package name */
    public static final Status f8358e = new Status(16);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f8359f = new Status(18);
    private static final Status j = new Status(17);

    /* renamed from: g  reason: collision with root package name */
    public final int f8360g;

    /* renamed from: h  reason: collision with root package name */
    public final String f8361h;

    /* renamed from: i  reason: collision with root package name */
    final PendingIntent f8362i;
    private final int k;

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.k = i2;
        this.f8360g = i3;
        this.f8361h = str;
        this.f8362i = pendingIntent;
    }

    public final Status a() {
        return this;
    }

    public Status(int i2) {
        this(i2, (String) null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, (PendingIntent) null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }

    public final void a(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (b()) {
            activity.startIntentSenderForResult(this.f8362i.getIntentSender(), i2, (Intent) null, 0, 0, 0);
        }
    }

    public final boolean b() {
        return this.f8362i != null;
    }

    public final boolean c() {
        return this.f8360g <= 0;
    }

    public final int d() {
        return this.f8360g;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Integer.valueOf(this.f8360g), this.f8361h, this.f8362i});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.k != status.k || this.f8360g != status.f8360g || !q.a(this.f8361h, status.f8361h) || !q.a(this.f8362i, status.f8362i)) {
            return false;
        }
        return true;
    }

    public final String e() {
        String str = this.f8361h;
        if (str != null) {
            return str;
        }
        return c.getStatusCodeString(this.f8360g);
    }

    public final String toString() {
        return q.a((Object) this).a("statusCode", e()).a(AppConstants.TAG_RESOLUTION, this.f8362i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8360g);
        b.a(parcel, 2, this.f8361h, false);
        b.a(parcel, 3, this.f8362i, i2, false);
        b.b(parcel, 1000, this.k);
        b.b(parcel, a2);
    }
}
