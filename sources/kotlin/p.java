package kotlin;

import java.io.Serializable;
import kotlin.g.b.k;

public final class p<T> implements Serializable {
    public static final a Companion = new a((byte) 0);
    private final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ p m529boximpl(Object obj) {
        return new p(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m530constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m531equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof p) && k.a(obj, ((p) obj2).m539unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m532equalsimpl0(Object obj, Object obj2) {
        return k.a(obj, obj2);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m535hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return m531equalsimpl(this.value, obj);
    }

    public final int hashCode() {
        return m535hashCodeimpl(this.value);
    }

    public final String toString() {
        return m538toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m539unboximpl() {
        return this.value;
    }

    private /* synthetic */ p(Object obj) {
        this.value = obj;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m537isSuccessimpl(Object obj) {
        return !(obj instanceof b);
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m536isFailureimpl(Object obj) {
        return obj instanceof b;
    }

    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m534getOrNullimpl(Object obj) {
        if (m536isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m533exceptionOrNullimpl(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m538toStringimpl(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            k.d(th, "exception");
            this.exception = th;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof b) && k.a((Object) this.exception, (Object) ((b) obj).exception);
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
