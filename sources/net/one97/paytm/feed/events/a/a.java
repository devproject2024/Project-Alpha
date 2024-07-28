package net.one97.paytm.feed.events.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.events.a.b;
import net.one97.paytm.feed.utility.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34296a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Object> f34297b = new HashMap<>();

    static {
        b bVar = b.f34268c;
        Context applicationContext = b.g().getApplicationContext();
        k.a((Object) applicationContext, "FeedManager.application.applicationContext");
        b.a.C0559a aVar = b.a.f34312a;
        String a2 = b.a.f34313b;
        b.a.C0559a aVar2 = b.a.f34312a;
        f34297b.put(a2, b.a.f34314c);
        b.a.C0559a aVar3 = b.a.f34312a;
        String g2 = b.a.f34319h;
        b.a.C0559a aVar4 = b.a.f34312a;
        f34297b.put(g2, b.a.f34320i);
        b.a.C0559a aVar5 = b.a.f34312a;
        String d2 = b.a.f34316e;
        j jVar = j.f35397a;
        f34297b.put(d2, j.d(applicationContext));
        b.a.C0559a aVar6 = b.a.f34312a;
        String e2 = b.a.f34317f;
        b.a.C0559a aVar7 = b.a.f34312a;
        f34297b.put(e2, b.a.f34318g);
        b.a.C0559a aVar8 = b.a.f34312a;
        String c2 = b.a.f34315d;
        c cVar = c.f34275a;
        f34297b.put(c2, c.i());
    }

    private a() {
    }

    public static void a() {
        b.a.C0559a aVar = b.a.f34312a;
        String c2 = b.a.f34315d;
        c cVar = c.f34275a;
        f34297b.put(c2, c.i());
    }

    public static void a(String str, String str2) {
        k.c(str, "actionName");
        k.c(str2, "eventLabel");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
        if (applicationContext != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(f34297b);
            Map map = hashMap;
            map.put("event_action", str);
            if (!TextUtils.isEmpty(str2)) {
                map.put("event_label", str2);
            }
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.b(applicationContext, (Map<String, ? extends Object>) map);
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        k.c(str, "actionName");
        k.c(str2, "eventLabel");
        k.c(str3, "eventLabel2");
        k.c(str4, "eventLabel3");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
        if (applicationContext != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(f34297b);
            Map map = hashMap;
            map.put("event_action", str);
            if (!TextUtils.isEmpty(str2)) {
                map.put("event_label", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("event_label2", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                map.put("event_label3", str4);
            }
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.b(applicationContext, (Map<String, ? extends Object>) map);
        }
    }
}
