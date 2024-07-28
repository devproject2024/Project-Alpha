package net.one97.paytm.paymentsBank.chequebook.utils;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.b.a.a;
import com.paytm.utility.f;
import java.util.List;
import net.one97.paytm.payments.d.b;

public final class h {

    /* renamed from: c  reason: collision with root package name */
    private static h f17977c;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f17978a;

    /* renamed from: b  reason: collision with root package name */
    public String f17979b = null;

    /* renamed from: d  reason: collision with root package name */
    private Context f17980d;

    /* renamed from: e  reason: collision with root package name */
    private a f17981e;

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (f17977c == null) {
                f17977c = new h();
                if (context != null) {
                    f17977c.f17980d = context;
                    f17977c.f17981e = b.a(context.getApplicationContext(), f.a.CB_CACHE_PREF);
                }
            }
            hVar = f17977c;
        }
        return hVar;
    }

    public static synchronized void a() {
        synchronized (h.class) {
            if (f17977c != null) {
                f17977c.f17980d = null;
                if (f17977c.f17981e != null) {
                    f17977c.f17981e.a();
                }
                f17977c = null;
            }
        }
    }

    public static boolean a(String str, String str2, Context context) {
        try {
            if (f17977c == null) {
                a(context);
            }
            if (f17977c.f17981e == null && context != null) {
                f17977c.f17980d = context;
                f17977c.f17981e = b.a(context.getApplicationContext(), f.a.CB_CACHE_PREF);
            }
            if (!TextUtils.isEmpty(str) && str2 != null) {
                f17977c.f17981e.a(str, str2, false);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String a(String str) {
        if (f17977c != null && !TextUtils.isEmpty(str)) {
            return f17977c.f17981e.b(str, "", false);
        }
        return " ";
    }

    public static boolean b(String str) {
        h hVar;
        a aVar;
        if (TextUtils.isEmpty(str) || (hVar = f17977c) == null || (aVar = hVar.f17981e) == null) {
            return false;
        }
        aVar.a(str, false);
        return true;
    }

    public static boolean b() {
        try {
            if (f17977c == null || f17977c.f17981e == null) {
                return true;
            }
            f17977c.f17981e.a();
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
