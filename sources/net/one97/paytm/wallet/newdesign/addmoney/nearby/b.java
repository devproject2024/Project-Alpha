package net.one97.paytm.wallet.newdesign.addmoney.nearby;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import androidx.appcompat.app.c;
import com.google.android.gms.common.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import net.one97.paytm.addmoney.R;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f70684a;

    public interface a {
        void a();
    }

    public static b a() {
        if (f70684a == null) {
            synchronized (b.class) {
                if (f70684a == null) {
                    f70684a = new b();
                }
            }
        }
        return f70684a;
    }

    public static void a(String str, String str2, Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google.com/maps?daddr=" + str + AppConstants.COMMA + str2)));
    }

    public static boolean a(LocationManager locationManager) {
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean a(final Context context, final a aVar) {
        if (c.a().a(context) == 0) {
            return true;
        }
        c.a aVar2 = new c.a(context);
        aVar2.b((CharSequence) context.getString(R.string.no_play_service_msg_addmoney)).a((CharSequence) context.getString(R.string.no_play_service_title));
        aVar2.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.gms")));
                } catch (ActivityNotFoundException unused) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.gms")));
                }
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        aVar2.b(R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        aVar2.a(false);
        aVar2.b();
        return false;
    }
}
