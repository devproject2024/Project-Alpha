package net.one97.paytm.passbook.customview;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Integer> f57217a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f57218b = false;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, SwipeRevealLayoutPassbook> f57219c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f57220d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e  reason: collision with root package name */
    private final Object f57221e = new Object();

    public final void a() {
        this.f57218b = true;
    }

    public final void a(String str) {
        synchronized (this.f57221e) {
            this.f57217a.put(str, 2);
            if (this.f57219c.containsKey(str)) {
                this.f57219c.get(str).a(true);
            } else if (this.f57218b) {
                a(str, this.f57219c.get(str));
            }
        }
    }

    public final void b(String str) {
        synchronized (this.f57221e) {
            this.f57217a.put(str, 0);
            if (this.f57219c.containsKey(str)) {
                this.f57219c.get(str).b(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, SwipeRevealLayoutPassbook swipeRevealLayoutPassbook) {
        synchronized (this.f57221e) {
            if (b() > 1) {
                for (Map.Entry next : this.f57217a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeRevealLayoutPassbook next2 : this.f57219c.values()) {
                    if (next2 != swipeRevealLayoutPassbook) {
                        next2.b(true);
                    }
                }
            }
        }
    }

    private int b() {
        int i2 = 0;
        for (Integer intValue : this.f57217a.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 2 || intValue2 == 3) {
                i2++;
            }
        }
        return i2;
    }

    public final void a(final SwipeRevealLayoutPassbook swipeRevealLayoutPassbook, final String str) {
        if (swipeRevealLayoutPassbook.f57189c < 2) {
            swipeRevealLayoutPassbook.requestLayout();
        }
        this.f57219c.values().remove(swipeRevealLayoutPassbook);
        this.f57219c.put(str, swipeRevealLayoutPassbook);
        swipeRevealLayoutPassbook.f57187a = true;
        swipeRevealLayoutPassbook.f57188b.e();
        swipeRevealLayoutPassbook.setDragStateChangeListener(new SwipeRevealLayoutPassbook.a() {
            public final void a(int i2) {
                d.this.f57217a.put(str, Integer.valueOf(i2));
                if (d.this.f57218b) {
                    d.this.a(str, swipeRevealLayoutPassbook);
                }
            }
        });
        if (!this.f57217a.containsKey(str)) {
            this.f57217a.put(str, 0);
            swipeRevealLayoutPassbook.b(false);
        } else {
            int intValue = this.f57217a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeRevealLayoutPassbook.b(false);
            } else {
                swipeRevealLayoutPassbook.a(false);
            }
        }
        swipeRevealLayoutPassbook.setLockDrag(this.f57220d.contains(str));
    }
}
