package net.one97.paytm.acceptPayment.e.a;

import android.content.Context;
import android.util.Pair;
import com.business.common_module.b.j;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.e.i;

public final class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f52055a = new a();

    private a() {
    }

    public final void a(Context context, List<String> list) {
        k.d(context, "context");
        k.d(list, "keys");
        i a2 = i.a(context);
        k.b(a2, "SecureSharedPreferences.getInstance(context)");
        i.a a3 = a2.edit();
        k.b(a3, "preferences.edit()");
        for (String remove : list) {
            a3.remove(remove);
        }
        a3.apply();
    }

    public final void b(Context context, List<? extends Pair<String, Object>> list) {
        k.d(context, "context");
        k.d(list, "list");
        i.a a2 = i.a(context).edit();
        k.b(a2, "preferences.edit()");
        for (Pair pair : list) {
            Object obj = pair.second;
            if (obj instanceof Integer) {
                a2.putInt((String) pair.first, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                a2.putLong((String) pair.first, ((Number) obj).longValue());
            } else if (obj instanceof Float) {
                a2.putFloat((String) pair.first, ((Number) obj).floatValue());
            } else if (obj instanceof Boolean) {
                a2.putBoolean((String) pair.first, ((Boolean) obj).booleanValue());
            } else if (obj instanceof String) {
                a2.putString((String) pair.first, (String) obj);
            }
        }
        a2.apply();
    }

    public final void a(Context context, String str, String str2) {
        k.d(context, "context");
        k.d(str, "key");
        i.a a2 = i.a(context).edit();
        k.b(a2, "preferences.edit()");
        a2.putString(str, str2);
        a2.apply();
    }

    public final void a(Context context, String str, int i2) {
        k.d(context, "context");
        k.d(str, "key");
        i.a a2 = i.a(context).edit();
        k.b(a2, "preferences.edit()");
        a2.putInt(str, i2);
        a2.apply();
    }

    public final void a(Context context, String str, boolean z) {
        k.d(context, "context");
        k.d(str, "key");
        i.a a2 = i.a(context).edit();
        k.b(a2, "preferences.edit()");
        a2.putBoolean(str, z);
        a2.apply();
    }

    public final void a(Context context, String str, long j) {
        k.d(context, "context");
        k.d(str, "key");
        i.a a2 = i.a(context).edit();
        k.b(a2, "preferences.edit()");
        a2.putLong(str, j);
        a2.apply();
    }

    public final String b(Context context, String str, String str2) {
        k.d(context, "context");
        k.d(str, "key");
        return i.a(context).getString(str, str2);
    }

    public final int a(Context context, String str) {
        k.d(context, "context");
        k.d(str, "key");
        return i.a(context).getInt(str, 0);
    }

    public final boolean b(Context context, String str, boolean z) {
        k.d(context, "context");
        k.d(str, "key");
        return i.a(context).getBoolean(str, z);
    }

    public final long b(Context context, String str, long j) {
        k.d(context, "context");
        k.d(str, "key");
        return i.a(context).getLong(str, j);
    }
}
