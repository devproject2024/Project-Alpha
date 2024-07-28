package com.google.firebase.perf.internal;

import android.content.Context;
import com.google.android.gms.internal.p001firebaseperf.aj;
import com.google.android.gms.internal.p001firebaseperf.bj;
import java.net.URI;
import net.one97.paytm.upi.util.UpiConstants;

final class p extends v {

    /* renamed from: a  reason: collision with root package name */
    private final bj f39222a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f39223b;

    p(bj bjVar, Context context) {
        this.f39223b = context;
        this.f39222a = bjVar;
    }

    private static boolean a(long j) {
        return j >= 0;
    }

    private static boolean b(long j) {
        return j >= 0;
    }

    public final boolean a() {
        boolean z;
        if (b(this.f39222a.zzkm)) {
            String valueOf = String.valueOf(this.f39222a.zzkm);
            if (valueOf.length() != 0) {
                "URL is missing:".concat(valueOf);
            } else {
                new String("URL is missing:");
            }
            return false;
        }
        URI a2 = a(this.f39222a.zzkm);
        if (a2 == null) {
            return false;
        }
        Context context = this.f39223b;
        if (a2 == null) {
            z = false;
        } else {
            z = aj.a(a2, context);
        }
        if (!z) {
            String valueOf2 = String.valueOf(a2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 26);
            sb.append("URL fails whitelist rule: ");
            sb.append(valueOf2);
            return false;
        }
        String host = a2.getHost();
        if (!(host != null && !b(host) && host.length() <= 255)) {
            return false;
        }
        String scheme = a2.getScheme();
        if (!(scheme != null && ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
            return false;
        }
        if (!(a2.getUserInfo() == null)) {
            return false;
        }
        int port = a2.getPort();
        if (!(port == -1 || port > 0)) {
            return false;
        }
        bj.c a3 = (this.f39222a.zzii & 2) != 0 ? this.f39222a.a() : null;
        if (!((a3 == null || a3 == bj.c.HTTP_METHOD_UNKNOWN) ? false : true)) {
            String valueOf3 = String.valueOf(this.f39222a.a());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 32);
            sb2.append("HTTP Method is null or invalid: ");
            sb2.append(valueOf3);
            return false;
        }
        if (this.f39222a.c()) {
            if (!(this.f39222a.zzkr > 0)) {
                int i2 = this.f39222a.zzkr;
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("HTTP ResponseCode is a negative value:");
                sb3.append(i2);
                return false;
            }
        }
        if (((this.f39222a.zzii & 4) != 0) && !b(this.f39222a.zzko)) {
            long j = this.f39222a.zzko;
            StringBuilder sb4 = new StringBuilder(56);
            sb4.append("Request Payload is a negative value:");
            sb4.append(j);
            return false;
        } else if (this.f39222a.b() && !b(this.f39222a.zzkp)) {
            long j2 = this.f39222a.zzkp;
            StringBuilder sb5 = new StringBuilder(57);
            sb5.append("Response Payload is a negative value:");
            sb5.append(j2);
            return false;
        } else if (!this.f39222a.d() || this.f39222a.zzkt <= 0) {
            long j3 = this.f39222a.zzkt;
            StringBuilder sb6 = new StringBuilder(84);
            sb6.append("Start time of the request is null, or zero, or a negative value:");
            sb6.append(j3);
            return false;
        } else {
            if (!((this.f39222a.zzii & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0) || a(this.f39222a.zzku)) {
                if (((this.f39222a.zzii & 512) != 0) && !a(this.f39222a.zzkv)) {
                    long j4 = this.f39222a.zzkv;
                    StringBuilder sb7 = new StringBuilder(112);
                    sb7.append("Time from the start of the request to the start of the response is null or a negative value:");
                    sb7.append(j4);
                    return false;
                } else if (!this.f39222a.e() || this.f39222a.zzkw <= 0) {
                    long j5 = this.f39222a.zzkw;
                    StringBuilder sb8 = new StringBuilder(108);
                    sb8.append("Time from the start of the request to the end of the response is null, negative or zero:");
                    sb8.append(j5);
                    return false;
                } else if (!this.f39222a.c()) {
                    return false;
                } else {
                    return true;
                }
            } else {
                long j6 = this.f39222a.zzku;
                StringBuilder sb9 = new StringBuilder(69);
                sb9.append("Time to complete the request is a negative value:");
                sb9.append(j6);
                return false;
            }
        }
    }

    private static URI a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
