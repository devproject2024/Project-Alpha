package net.one97.paytm.h5.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.y;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.utils.d;

public final class h implements y {
    public final Intent a(String str, Context context) {
        k.c(str, "deeplink");
        k.c(context, "context");
        Intent intent = new Intent("android.intent.action.MAIN", Uri.EMPTY, context, AJRMainActivity.class);
        intent.putExtra("urlToCheck", str);
        return intent;
    }

    public final ArrayList<ShortcutInfo> a(Context context) {
        k.c(context, "context");
        return d.a(context);
    }
}
