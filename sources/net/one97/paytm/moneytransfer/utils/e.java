package net.one97.paytm.moneytransfer.utils;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.g.b.k;

public final class e {
    public static final void a(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(activity, "$this$sendEvent");
        k.c(str, "cat");
        k.c(str2, "action");
        k.c(str3, "screen");
        k.c(str4, "label");
        k.c(str5, "label2");
        k.c(str6, "value");
        Context applicationContext = activity.getApplicationContext();
        if (applicationContext != null) {
            a(applicationContext, str, str2, str3, str4, str5, str6);
        }
    }

    public static /* synthetic */ void a(Fragment fragment, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        a(fragment, str, str2, str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6);
    }

    public static final void a(Fragment fragment, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(fragment, "$this$sendEvent");
        k.c(str, "cat");
        k.c(str2, "action");
        k.c(str3, "screen");
        k.c(str4, "label");
        k.c(str5, "label2");
        k.c(str6, "value");
        Context context = fragment.getContext();
        if (context != null) {
            k.a((Object) context, "it");
            a(context, str, str2, str3, str4, str5, str6);
        }
    }

    public static final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        f.a(context, str, str2, str3, str4, str5, str6);
    }
}
