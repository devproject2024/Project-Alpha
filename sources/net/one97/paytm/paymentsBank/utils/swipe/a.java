package net.one97.paytm.paymentsBank.utils.swipe;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.paymentsBank.utils.swipe.SwipeRevealLayout;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Integer> f19603a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SwipeRevealLayout> f19604b = Collections.synchronizedMap(new HashMap());

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f19605c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Object f19606d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f19607e = Collections.synchronizedSet(new HashSet());

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, SwipeRevealLayout swipeRevealLayout, int i2) {
        this.f19603a.put(str, Integer.valueOf(i2));
        if (this.f19605c) {
            a(str, swipeRevealLayout);
        }
    }

    public final void a(String... strArr) {
        a(true, strArr);
    }

    public final void a(String str) {
        synchronized (this.f19606d) {
            this.f19603a.put(str, 0);
            if (this.f19604b.containsKey(str)) {
                this.f19604b.get(str).b(true);
            }
        }
    }

    public final void a(String str, SwipeRevealLayout swipeRevealLayout) {
        synchronized (this.f19606d) {
            if (a() > 1) {
                for (Map.Entry next : this.f19603a.entrySet()) {
                    if (!((String) next.getKey()).equals(str)) {
                        next.setValue(0);
                    }
                }
                for (SwipeRevealLayout next2 : this.f19604b.values()) {
                    if (next2 != swipeRevealLayout) {
                        next2.b(true);
                    }
                }
            }
        }
    }

    public final void a(boolean z, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            if (z) {
                this.f19607e.addAll(Arrays.asList(strArr));
            } else {
                this.f19607e.removeAll(Arrays.asList(strArr));
            }
            for (String str : strArr) {
                SwipeRevealLayout swipeRevealLayout = this.f19604b.get(str);
                if (swipeRevealLayout != null) {
                    swipeRevealLayout.setLockDrag(z);
                }
            }
        }
    }

    private int a() {
        int i2 = 0;
        for (Integer intValue : this.f19603a.values()) {
            int intValue2 = intValue.intValue();
            if (intValue2 == 2 || intValue2 == 3) {
                i2++;
            }
        }
        return i2;
    }

    public final void a(SwipeRevealLayout swipeRevealLayout, String str) {
        if (swipeRevealLayout.f19593c < 2) {
            swipeRevealLayout.requestLayout();
        }
        this.f19604b.values().remove(swipeRevealLayout);
        this.f19604b.put(str, swipeRevealLayout);
        swipeRevealLayout.f19591a = true;
        swipeRevealLayout.f19592b.e();
        swipeRevealLayout.setDragStateChangeListener(new SwipeRevealLayout.a(str, swipeRevealLayout) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ SwipeRevealLayout f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onDragStateChanged(int i2) {
                a.this.a(this.f$1, this.f$2, i2);
            }
        });
        if (!this.f19603a.containsKey(str)) {
            this.f19603a.put(str, 0);
            swipeRevealLayout.b(false);
        } else {
            int intValue = this.f19603a.get(str).intValue();
            if (intValue == 0 || intValue == 1 || intValue == 4) {
                swipeRevealLayout.b(false);
            } else {
                swipeRevealLayout.a(false);
            }
        }
        swipeRevealLayout.setLockDrag(this.f19607e.contains(str));
    }
}
