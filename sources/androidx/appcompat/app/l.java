package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class l {

    /* renamed from: c  reason: collision with root package name */
    private static l f1136c;

    /* renamed from: a  reason: collision with root package name */
    final Context f1137a;

    /* renamed from: b  reason: collision with root package name */
    final a f1138b = new a();

    /* renamed from: d  reason: collision with root package name */
    private final LocationManager f1139d;

    static l a(Context context) {
        if (f1136c == null) {
            Context applicationContext = context.getApplicationContext();
            f1136c = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1136c;
    }

    private l(Context context, LocationManager locationManager) {
        this.f1137a = context;
        this.f1139d = locationManager;
    }

    /* access modifiers changed from: package-private */
    public final Location a(String str) {
        try {
            if (this.f1139d.isProviderEnabled(str)) {
                return this.f1139d.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f1140a;

        /* renamed from: b  reason: collision with root package name */
        long f1141b;

        /* renamed from: c  reason: collision with root package name */
        long f1142c;

        /* renamed from: d  reason: collision with root package name */
        long f1143d;

        /* renamed from: e  reason: collision with root package name */
        long f1144e;

        /* renamed from: f  reason: collision with root package name */
        long f1145f;

        a() {
        }
    }
}
