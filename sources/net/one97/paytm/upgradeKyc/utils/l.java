package net.one97.paytm.upgradeKyc.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import androidx.appcompat.app.c;
import com.google.android.gms.common.c;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.utility.i;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.l;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static volatile l f66341a;

    public interface a {
        void d();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public static l a() {
        if (f66341a == null) {
            synchronized (l.class) {
                if (f66341a == null) {
                    f66341a = new l();
                }
            }
        }
        return f66341a;
    }

    public static void a(String str, String str2, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + str + AppConstants.COMMA + str2));
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static boolean a(LocationManager locationManager) {
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, a aVar) {
        if (c.a().a(context) == 0) {
            return true;
        }
        c.a aVar2 = new c.a(context);
        aVar2.b((CharSequence) context.getString(R.string.no_play_service_msg)).a((CharSequence) context.getString(R.string.no_play_service_title));
        aVar2.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(context, aVar) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ l.a f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                l.a(this.f$0, this.f$1, dialogInterface, i2);
            }
        });
        aVar2.b(R.string.cancel, (DialogInterface.OnClickListener) $$Lambda$l$8R6r9JJYYKwap8y4t6aDWSQ4UxY.INSTANCE);
        aVar2.a(false);
        aVar2.b();
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, a aVar, DialogInterface dialogInterface, int i2) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.gms")));
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gms")));
        }
        if (aVar != null) {
            aVar.d();
        }
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError) {
        if ((networkCustomError.getStatusCode() != 401 && networkCustomError.getStatusCode() != 403 && networkCustomError.getStatusCode() != 410) || !(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        e.a aVar = e.f66028b;
        e.a.b().b(activity);
        return true;
    }

    public static boolean a(Context context) {
        if (j.d(context) != 1 || !j.n(context).equalsIgnoreCase("EKYC_OTP")) {
            if (j.c() == 0) {
                e.a aVar = e.f66028b;
                if (i.a(e.a.b().a()).b("aadhaarSubmittedAs", "", false).equals("Poi_Poa")) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean b() {
        long e2 = j.e();
        if (e2 == -1) {
            return false;
        }
        long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - e2);
        d.a aVar = d.f66026a;
        d.a.a();
        if (days <= ((long) d.b("cstPriorityCustomerValidityInDays"))) {
            return true;
        }
        j.a((Long) -1L);
        return false;
    }
}
