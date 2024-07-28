package net.one97.paytm.moneytransfer.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.moneytransfer.utils.SwipeRevealLayout;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Integer> f54190a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SwipeRevealLayout> f54191b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f54192c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f54193d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f54194e = Collections.synchronizedSet(new HashSet());

    public final void a() {
        this.f54192c = true;
    }

    public final void a(String str) {
        synchronized (this.f54193d) {
            this.f54190a.put(str, 0);
            if (this.f54191b.containsKey(str)) {
                this.f54191b.get(str).b(true);
            }
        }
    }

    public final void a(String str, SwipeRevealLayout swipeRevealLayout) {
        synchronized (this.f54193d) {
            int i2 = 0;
            for (Integer intValue : this.f54190a.values()) {
                int intValue2 = intValue.intValue();
                if (intValue2 == 2 || intValue2 == 3) {
                    i2++;
                }
            }
            if (i2 > 1) {
                for (Map.Entry next : this.f54190a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeRevealLayout next2 : this.f54191b.values()) {
                    if (next2 != swipeRevealLayout) {
                        next2.b(true);
                    }
                }
            }
        }
    }

    public final void a(final SwipeRevealLayout swipeRevealLayout, final String str) {
        if (swipeRevealLayout.f54146c < 2) {
            swipeRevealLayout.requestLayout();
        }
        this.f54191b.values().remove(swipeRevealLayout);
        this.f54191b.put(str, swipeRevealLayout);
        swipeRevealLayout.f54144a = true;
        swipeRevealLayout.f54145b.e();
        swipeRevealLayout.setDragStateChangeListener(new SwipeRevealLayout.a() {
            public final void a(int i2) {
                q.this.f54190a.put(str, Integer.valueOf(i2));
                if (q.this.f54192c) {
                    q.this.a(str, swipeRevealLayout);
                }
            }
        });
        if (!this.f54190a.containsKey(str)) {
            this.f54190a.put(str, 0);
            swipeRevealLayout.b(false);
        } else {
            int intValue = this.f54190a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeRevealLayout.b(false);
            } else {
                swipeRevealLayout.a(false);
            }
        }
        swipeRevealLayout.setLockDrag(this.f54194e.contains(str));
    }
}
