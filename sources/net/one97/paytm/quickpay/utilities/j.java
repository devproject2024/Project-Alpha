package net.one97.paytm.quickpay.utilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Integer> f60137a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SwipeRevealLayout> f60138b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f60139c = Collections.synchronizedSet(new HashSet());

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f60140d = false;

    /* renamed from: e  reason: collision with root package name */
    public final Object f60141e = new Object();

    public final void a(String str) {
        synchronized (this.f60141e) {
            this.f60137a.put(str, 0);
            if (this.f60138b.containsKey(str)) {
                this.f60138b.get(str).b(true);
            }
        }
    }

    public final void a(String str, SwipeRevealLayout swipeRevealLayout) {
        synchronized (this.f60141e) {
            if (a() > 1) {
                for (Map.Entry next : this.f60137a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeRevealLayout next2 : this.f60138b.values()) {
                    if (next2 != swipeRevealLayout) {
                        next2.b(true);
                    }
                }
            }
        }
    }

    private int a() {
        int i2 = 0;
        for (Integer intValue : this.f60137a.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 2 || intValue2 == 3) {
                i2++;
            }
        }
        return i2;
    }
}
