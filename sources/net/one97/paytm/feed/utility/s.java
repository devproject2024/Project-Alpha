package net.one97.paytm.feed.utility;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f35433a = new s();

    private s() {
    }

    public static void a(String str, Context context) {
        k.c(str, "textShare");
        k.c(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", String.valueOf(str));
        context.startActivity(Intent.createChooser(intent, "Share Article via"));
    }

    public static void b(String str, Context context) {
        k.c(str, "textShare");
        k.c(context, "context");
        if (a(context)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str + ' ');
            intent.setPackage(AppConstants.WHATS_APP);
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Toast.makeText(context, context.getString(R.string.feed_whatsappnotinstalled), 0).show();
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        try {
            context.getPackageManager().getPackageInfo(AppConstants.WHATS_APP, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
