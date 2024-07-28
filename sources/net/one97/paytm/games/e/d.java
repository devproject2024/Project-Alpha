package net.one97.paytm.games.e;

import android.content.Context;
import com.paytm.b.a.a;

public class d {

    /* renamed from: e  reason: collision with root package name */
    private static d f35603e;

    /* renamed from: a  reason: collision with root package name */
    private final String f35604a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final String f35605b = "gamepind_json_map_dummy_responses";

    /* renamed from: c  reason: collision with root package name */
    private final String f35606c = "gamepind_json_map_unconsumed_skus";

    /* renamed from: d  reason: collision with root package name */
    private a f35607d;

    private d(Context context) {
        this.f35607d = i.a(context.getApplicationContext());
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f35603e == null) {
                f35603e = new d(context.getApplicationContext());
            }
            dVar = f35603e;
        }
        return dVar;
    }

    public final synchronized void a(String str) {
        if (str != null) {
            this.f35607d.a("gamepind_json_map_unconsumed_skus", str, false);
        }
    }

    public final synchronized String a() {
        return this.f35607d.b("gamepind_json_map_unconsumed_skus", "{}", false);
    }

    public final synchronized void b(String str) {
        if (str != null) {
            this.f35607d.a("gamepind_json_map_dummy_responses", str, false);
        }
    }

    public final synchronized String b() {
        return this.f35607d.b("gamepind_json_map_dummy_responses", "{}", false);
    }
}
