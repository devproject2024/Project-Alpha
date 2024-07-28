package net.one97.paytm.feed.e;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import java.util.UUID;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f34275a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static String f34276b;

    /* renamed from: c  reason: collision with root package name */
    private static String f34277c;

    /* renamed from: d  reason: collision with root package name */
    private static String f34278d;

    /* renamed from: e  reason: collision with root package name */
    private static String f34279e;

    /* renamed from: f  reason: collision with root package name */
    private static String f34280f;

    /* renamed from: g  reason: collision with root package name */
    private static String f34281g;

    /* renamed from: h  reason: collision with root package name */
    private static Float f34282h;

    /* renamed from: i  reason: collision with root package name */
    private static Float f34283i;
    private static String j;
    private static String k;

    static {
        String uuid = UUID.randomUUID().toString();
        k.a((Object) uuid, "UUID.randomUUID().toString()");
        j = uuid;
        b bVar = b.f34608a;
        String f2 = b.f();
        if (f2 == null) {
            f2 = "EN,HI";
        }
        k = f2;
    }

    private c() {
    }

    public static String a() {
        return f34276b;
    }

    public static String b() {
        return f34277c;
    }

    public static String c() {
        return f34278d;
    }

    public static String d() {
        return f34281g;
    }

    public static Float e() {
        return f34282h;
    }

    public static Float f() {
        return f34283i;
    }

    public static void a(String str) {
        k.c(str, "<set-?>");
        j = str;
    }

    public static String g() {
        return j;
    }

    public static void b(String str) {
        k.c(str, "<set-?>");
        k = str;
    }

    public static String h() {
        return k;
    }

    public static void a(Map<String, String> map) {
        k.c(map, "data");
        k.c(map, "data");
        f34276b = map.get("name");
        f34277c = map.get("avatar");
        f34278d = map.get("gender");
        f34279e = map.get("mobile");
        f34280f = map.get("cust_id");
        f34281g = map.get(StringSet.token);
        try {
            String str = map.get("latitude");
            if (str == null) {
                k.a();
            }
            float parseFloat = Float.parseFloat(str);
            String str2 = map.get("longitude");
            if (str2 == null) {
                k.a();
            }
            a(parseFloat, Float.parseFloat(str2));
        } catch (Exception unused) {
            a(0.0f, 0.0f);
        }
    }

    public static void a(float f2, float f3) {
        f34282h = Float.valueOf(f2);
        f34283i = Float.valueOf(f3);
    }

    public static String i() {
        String str = f34280f;
        if (str == null) {
            return "";
        }
        if (str == null) {
            k.a();
        }
        return str;
    }

    public static boolean j() {
        return !TextUtils.isEmpty(f34281g);
    }

    public static boolean a(Context context) {
        if (!j()) {
            if (context != null) {
                Toast.makeText(context, context.getString(R.string.feed_login), 0).show();
                b bVar = b.f34268c;
                b.a(context);
            }
            b bVar2 = b.f34268c;
            b.k();
            return false;
        }
        b bVar3 = b.f34268c;
        b.k();
        return true;
    }

    public static void k() {
        b bVar = b.f34608a;
        String f2 = b.f();
        if (f2 == null) {
            f2 = "EN,HI";
        }
        k = f2;
    }
}
