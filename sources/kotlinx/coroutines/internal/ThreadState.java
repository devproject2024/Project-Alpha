package kotlinx.coroutines.internal;

import kotlin.d.f;

final class ThreadState {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f48000a;
    private final f context;

    /* renamed from: i  reason: collision with root package name */
    private int f48001i;

    public ThreadState(f fVar, int i2) {
        this.context = fVar;
        this.f48000a = new Object[i2];
    }

    public final f getContext() {
        return this.context;
    }

    public final void append(Object obj) {
        Object[] objArr = this.f48000a;
        int i2 = this.f48001i;
        this.f48001i = i2 + 1;
        objArr[i2] = obj;
    }

    public final Object take() {
        Object[] objArr = this.f48000a;
        int i2 = this.f48001i;
        this.f48001i = i2 + 1;
        return objArr[i2];
    }

    public final void start() {
        this.f48001i = 0;
    }
}
