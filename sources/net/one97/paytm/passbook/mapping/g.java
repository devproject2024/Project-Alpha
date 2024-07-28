package net.one97.paytm.passbook.mapping;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import net.one97.paytm.passbook.d;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f57893a;

    private g() {
    }

    public static g a() {
        if (f57893a == null) {
            synchronized (g.class) {
                if (f57893a == null) {
                    f57893a = new g();
                }
            }
        }
        return f57893a;
    }

    public static void a(Activity activity, String... strArr) {
        if (activity != null && !activity.isFinishing()) {
            try {
                String str = strArr[0];
                if (!d.b().m() || "wallet".equalsIgnoreCase(str)) {
                    Intent intent = new Intent(activity, d.b().A());
                    intent.putExtra("intent_extra_wallet_type", "wallet_type_add");
                    activity.startActivityForResult(intent, 128);
                    return;
                }
                activity.startActivityForResult(new Intent(activity, d.b().v()), 128);
            } catch (Exception unused) {
            }
        }
    }

    public static ArrayList<String> a(String[] strArr) {
        try {
            return new ArrayList<>(Arrays.asList(strArr));
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }
}
