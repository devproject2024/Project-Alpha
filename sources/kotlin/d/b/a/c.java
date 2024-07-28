package kotlin.d.b.a;

import kotlin.d.d;
import kotlin.d.f;

public final class c implements d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f47897a = new c();

    public final String toString() {
        return "This continuation is already complete";
    }

    private c() {
    }

    public final f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
