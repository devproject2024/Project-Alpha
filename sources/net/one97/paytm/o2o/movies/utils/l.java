package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.location.LocationManager;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.b;
import com.google.android.gms.location.d;
import com.google.android.gms.location.f;
import com.paytm.contactsSdk.constant.ContactsConstant;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public b f75954a = f.b(this.f75959f);

    /* renamed from: b  reason: collision with root package name */
    public LocationRequest f75955b = new LocationRequest();

    /* renamed from: c  reason: collision with root package name */
    public d f75956c = new d() {
        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            i.a().f75931a = locationResult.a();
            l lVar = l.this;
            lVar.f75954a.a(lVar.f75956c);
            if (i.a().f75931a != null) {
                lVar.f75957d = false;
            }
            if (l.this.f75958e != null) {
                l.this.f75958e.b();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public boolean f75957d = true;

    /* renamed from: e  reason: collision with root package name */
    public a f75958e;

    /* renamed from: f  reason: collision with root package name */
    public Context f75959f;

    public interface a {
        void b();

        void c();
    }

    public l(Context context, a aVar) {
        this.f75959f = context;
        this.f75958e = aVar;
        this.f75955b.a(10000);
        this.f75955b.b(5000);
        this.f75955b.a(100);
        LocationSettingsRequest.a aVar2 = new LocationSettingsRequest.a();
        aVar2.a(this.f75955b);
        aVar2.b();
    }

    public final boolean a() {
        boolean z;
        boolean z2;
        try {
            LocationManager locationManager = (LocationManager) this.f75959f.getSystemService("location");
            try {
                z = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                z = false;
            }
            try {
                z2 = locationManager.isProviderEnabled(ContactsConstant.NETWORK);
            } catch (Exception unused2) {
                z2 = false;
            }
            if (z || z2) {
                return true;
            }
            return false;
        } catch (Exception unused3) {
            return false;
        }
    }
}
