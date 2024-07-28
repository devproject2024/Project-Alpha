package net.one97.paytm.utils;

import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import com.paytm.utility.q;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.k;

public final class bd {

    /* renamed from: a  reason: collision with root package name */
    public static final bd f69715a = new bd();

    /* renamed from: b  reason: collision with root package name */
    private static final String f69716b = bd.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Trace> f69717c = new ConcurrentHashMap<>();

    private bd() {
    }

    public final synchronized void a(String str) {
        k.c(str, "key");
        if (!f69717c.containsKey(str)) {
            a.a();
            Trace b2 = a.b(str);
            k.a((Object) b2, "FirebasePerformance.getInstance().newTrace(key)");
            b2.start();
            f69717c.put(str, b2);
            return;
        }
        q.b("Unable to start " + str + " trace");
    }

    public final synchronized void b(String str) {
        k.c(str, "key");
        if (f69717c.containsKey(str)) {
            Trace trace = f69717c.get(str);
            if (trace != null) {
                trace.stop();
            }
            f69717c.remove(str);
            return;
        }
        q.b("No such " + str + " found to stop firebase performance trace");
    }
}
