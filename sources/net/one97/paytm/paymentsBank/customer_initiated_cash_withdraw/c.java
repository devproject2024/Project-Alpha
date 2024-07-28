package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.a;
import com.paytm.contactsSdk.constant.ContactsConstant;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.h.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Activity f18292a;

    /* renamed from: b  reason: collision with root package name */
    public LocationManager f18293b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18294c = false;

    public c(Activity activity) {
        this.f18292a = activity;
        this.f18293b = (LocationManager) activity.getSystemService("location");
    }

    public final boolean a() {
        return this.f18293b.isProviderEnabled("gps");
    }

    public final void b() {
        this.f18292a.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }

    public final boolean c() {
        try {
            if (a.a((Context) this.f18292a, "android.permission.ACCESS_FINE_LOCATION") == 0 || a.a((Context) this.f18292a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return true;
            }
            a.a(this.f18292a, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 100);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public final void a(final d dVar) {
        try {
            this.f18293b.requestLocationUpdates(ContactsConstant.NETWORK, 0, 0.0f, new LocationListener() {
                public final void onProviderEnabled(String str) {
                }

                public final void onStatusChanged(String str, int i2, Bundle bundle) {
                }

                public final void onLocationChanged(Location location) {
                    try {
                        if (c.this.f18294c) {
                            c.this.f18293b.removeUpdates(this);
                            return;
                        }
                        b.a(location.getLatitude(), c.this.f18292a.getApplicationContext());
                        b.b(location.getLongitude(), c.this.f18292a.getApplicationContext());
                        if (dVar != null) {
                            dVar.onFragmentAction(100, (Object) null);
                        }
                        c.this.f18294c = true;
                        c.this.f18293b.removeUpdates(this);
                    } catch (Exception unused) {
                    }
                }

                public final void onProviderDisabled(String str) {
                    d dVar = dVar;
                    if (dVar != null) {
                        dVar.onFragmentAction(100, "disabled");
                    }
                }
            });
            if (a.a((Context) this.f18292a, "android.permission.ACCESS_FINE_LOCATION") == 0 || a.a((Context) this.f18292a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                this.f18293b.requestLocationUpdates("gps", 0, 0.0f, new LocationListener() {
                    public final void onProviderEnabled(String str) {
                    }

                    public final void onStatusChanged(String str, int i2, Bundle bundle) {
                    }

                    public final void onLocationChanged(Location location) {
                        try {
                            if (c.this.f18294c) {
                                c.this.f18293b.removeUpdates(this);
                                return;
                            }
                            b.a(location.getLatitude(), c.this.f18292a.getApplicationContext());
                            b.b(location.getLongitude(), c.this.f18292a.getApplicationContext());
                            if (dVar != null) {
                                dVar.onFragmentAction(100, (Object) null);
                            }
                            c.this.f18294c = true;
                            c.this.f18293b.removeUpdates(this);
                        } catch (Exception unused) {
                        }
                    }

                    public final void onProviderDisabled(String str) {
                        d dVar = dVar;
                        if (dVar != null) {
                            dVar.onFragmentAction(100, "disabled");
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }
}
