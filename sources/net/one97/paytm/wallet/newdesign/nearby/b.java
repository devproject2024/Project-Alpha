package net.one97.paytm.wallet.newdesign.nearby;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import androidx.appcompat.app.c;
import com.google.android.gms.common.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.wallet.newdesign.R;
import net.one97.paytm.wallet.newdesign.nearby.b;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f71056a;

    public interface a {
        void g();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public static b a() {
        if (f71056a == null) {
            synchronized (b.class) {
                if (f71056a == null) {
                    f71056a = new b();
                }
            }
        }
        return f71056a;
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
            private final /* synthetic */ b.a f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                b.a(this.f$0, this.f$1, dialogInterface, i2);
            }
        });
        aVar2.b(R.string.cancel, (DialogInterface.OnClickListener) $$Lambda$b$YxZhE2_CW8Z5VDbWidH0cffiFJM.INSTANCE);
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
            aVar.g();
        }
    }
}
