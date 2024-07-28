package net.one97.paytm.recharge.common.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8;

public final class bj {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Integer> f61603a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f61604b = false;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, SwipeLayoutHelperV8> f61605c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f61606d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e  reason: collision with root package name */
    private final Object f61607e = new Object();

    public final void a() {
        this.f61604b = true;
    }

    public final void a(String str) {
        synchronized (this.f61607e) {
            this.f61603a.put(str, 2);
            if (this.f61605c.containsKey(str)) {
                this.f61605c.get(str).a(true);
            } else if (this.f61604b) {
                a(str, this.f61605c.get(str));
            }
        }
    }

    public final void b(String str) {
        synchronized (this.f61607e) {
            this.f61603a.put(str, 0);
            if (this.f61605c.containsKey(str)) {
                this.f61605c.get(str).b(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, SwipeLayoutHelperV8 swipeLayoutHelperV8) {
        synchronized (this.f61607e) {
            if (b() > 1) {
                for (Map.Entry next : this.f61603a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeLayoutHelperV8 next2 : this.f61605c.values()) {
                    if (next2 != swipeLayoutHelperV8) {
                        next2.b(true);
                    }
                }
            }
        }
    }

    private int b() {
        int i2 = 0;
        for (Integer intValue : this.f61603a.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 2 || intValue2 == 3) {
                i2++;
            }
        }
        return i2;
    }

    public final void a(final SwipeLayoutHelperV8 swipeLayoutHelperV8, final String str) {
        if (swipeLayoutHelperV8.f61483c < 2) {
            swipeLayoutHelperV8.requestLayout();
        }
        this.f61605c.values().remove(swipeLayoutHelperV8);
        this.f61605c.put(str, swipeLayoutHelperV8);
        swipeLayoutHelperV8.f61481a = true;
        swipeLayoutHelperV8.f61482b.e();
        swipeLayoutHelperV8.setDragStateChangeListener(new SwipeLayoutHelperV8.a() {
            public final void a(int i2) {
                bj.this.f61603a.put(str, Integer.valueOf(i2));
                if (bj.this.f61604b) {
                    bj.this.a(str, swipeLayoutHelperV8);
                }
            }
        });
        if (!this.f61603a.containsKey(str)) {
            this.f61603a.put(str, 0);
            swipeLayoutHelperV8.b(false);
        } else {
            int intValue = this.f61603a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeLayoutHelperV8.b(false);
            } else {
                swipeLayoutHelperV8.a(false);
            }
        }
        swipeLayoutHelperV8.setLockDrag(this.f61606d.contains(str));
    }
}
