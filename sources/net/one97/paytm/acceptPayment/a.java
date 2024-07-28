package net.one97.paytm.acceptPayment;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.utility.n;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.j.c;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.upi.UpiOnboardingHelperActivity;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements net.one97.paytm.acceptPayment.b.a {
    public final void a(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public final ContextWrapper a(Context context) {
        return e.a(context);
    }

    public final String a(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public final boolean a(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public final int b(String str) {
        c.a();
        return c.a(str, 0);
    }

    public final long c(String str) {
        c.a();
        return c.a(str, 0);
    }

    public final void a(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final Context a() {
        return CJRJarvisApplication.getAppContext();
    }

    public final Class<? extends AppCompatActivity> b() {
        return AJREmbedWebView.class;
    }

    public final void a(com.paytm.network.a aVar, Context context) {
        if (context != null) {
            r.a(aVar, context);
        }
    }

    public final void a(Activity activity, String str, Bundle bundle) {
        r.a(activity, str, bundle);
    }

    public final void a(String str, String str2) {
        r.a(str, str2);
    }

    public final void a(Activity activity) {
        UpiOnboardingHelperActivity.a aVar = UpiOnboardingHelperActivity.f66484a;
        k.c(activity, "activity");
        Intent intent = new Intent(activity, UpiOnboardingHelperActivity.class);
        intent.putExtra("self_destroy", true);
        activity.startActivityForResult(intent, 2001);
    }

    public final void a(Activity activity, JSONObject jSONObject) {
        if (!jSONObject.isNull("x-user-mid")) {
            try {
                net.one97.paytm.payments.d.a.a(activity, "paytmmp://redeemcoins?flowType=merchant&mId=".concat(String.valueOf(jSONObject.getString("x-user-mid"))));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String b(Context context) {
        return n.a(context, "en");
    }
}
