package com.google.android.exoplayer2.g;

import java.util.Collections;
import java.util.PriorityQueue;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final Object f32573a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final PriorityQueue<Integer> f32574b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    public int f32575c = Integer.MIN_VALUE;

    public final void a() {
        synchronized (this.f32573a) {
            this.f32574b.remove(0);
            this.f32575c = this.f32574b.isEmpty() ? Integer.MIN_VALUE : ((Integer) ae.a(this.f32574b.peek())).intValue();
            this.f32573a.notifyAll();
        }
    }
}
