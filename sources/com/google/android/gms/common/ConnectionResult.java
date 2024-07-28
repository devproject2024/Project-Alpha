package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.H5Utils;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectionResult f8333a = new ConnectionResult(0);

    /* renamed from: b  reason: collision with root package name */
    public final int f8334b;

    /* renamed from: c  reason: collision with root package name */
    public final PendingIntent f8335c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8336d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8337e;

    ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f8337e = i2;
        this.f8334b = i3;
        this.f8335c = pendingIntent;
        this.f8336d = str;
    }

    public ConnectionResult(int i2) {
        this(i2, (PendingIntent) null, (String) null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, (String) null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }

    public final boolean a() {
        return (this.f8334b == 0 || this.f8335c == null) ? false : true;
    }

    public final boolean b() {
        return this.f8334b == 0;
    }

    static String a(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return H5Utils.NETWORK_TYPE_UNKNOWN;
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return Payload.RESPONSE_DEVELOPER_ERROR;
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return Payload.RESPONSE_TIMEOUT;
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f8334b == connectionResult.f8334b && q.a(this.f8335c, connectionResult.f8335c) && q.a(this.f8336d, connectionResult.f8336d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8334b), this.f8335c, this.f8336d});
    }

    public final String toString() {
        return q.a((Object) this).a("statusCode", a(this.f8334b)).a(AppConstants.TAG_RESOLUTION, this.f8335c).a("message", this.f8336d).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8337e);
        b.b(parcel, 2, this.f8334b);
        b.a(parcel, 3, this.f8335c, i2, false);
        b.a(parcel, 4, this.f8336d, false);
        b.b(parcel, a2);
    }
}
