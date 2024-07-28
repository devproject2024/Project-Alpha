package net.one97.paytm.upi.registration.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.upi.util.SwipeRevealLayout;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Integer> f69089a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f69090b = false;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, SwipeRevealLayout> f69091c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f69092d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e  reason: collision with root package name */
    private final Object f69093e = new Object();

    public final void a(final SwipeRevealLayout swipeRevealLayout, final String str) {
        if (swipeRevealLayout.shouldRequestLayout()) {
            swipeRevealLayout.requestLayout();
        }
        this.f69091c.values().remove(swipeRevealLayout);
        this.f69091c.put(str, swipeRevealLayout);
        swipeRevealLayout.abort();
        swipeRevealLayout.setDragStateChangeListener(new SwipeRevealLayout.DragStateChangeListener() {
            public final void onDragStateChanged(int i2) {
                y.this.f69089a.put(str, Integer.valueOf(i2));
                if (y.this.f69090b) {
                    y.this.a(str, swipeRevealLayout);
                }
            }
        });
        if (!this.f69089a.containsKey(str)) {
            this.f69089a.put(str, 0);
            swipeRevealLayout.close(false);
        } else {
            int intValue = this.f69089a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeRevealLayout.close(false);
            } else {
                swipeRevealLayout.open(false);
            }
        }
        swipeRevealLayout.setLockDrag(this.f69092d.contains(str));
    }

    public final void a() {
        this.f69090b = true;
    }

    public final void a(String str) {
        synchronized (this.f69093e) {
            this.f69089a.put(str, 2);
            if (this.f69091c.containsKey(str)) {
                this.f69091c.get(str).open(true);
            } else if (this.f69090b) {
                a(str, this.f69091c.get(str));
            }
        }
    }

    public final void b(String str) {
        synchronized (this.f69093e) {
            this.f69089a.put(str, 0);
            if (this.f69091c.containsKey(str)) {
                this.f69091c.get(str).close(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, SwipeRevealLayout swipeRevealLayout) {
        synchronized (this.f69093e) {
            if (b() > 1) {
                for (Map.Entry next : this.f69089a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeRevealLayout next2 : this.f69091c.values()) {
                    if (next2 != swipeRevealLayout) {
                        next2.close(true);
                    }
                }
            }
        }
    }

    private int b() {
        int i2 = 0;
        for (Integer intValue : this.f69089a.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 2 || intValue2 == 3) {
                i2++;
            }
        }
        return i2;
    }
}
