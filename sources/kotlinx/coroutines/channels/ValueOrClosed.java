package kotlinx.coroutines.channels;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ValueOrClosed<T> {
    public static final Companion Companion = new Companion((g) null);
    private final Object holder;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ValueOrClosed m540boximpl(Object obj) {
        return new ValueOrClosed(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m541constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m542equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ValueOrClosed) && k.a(obj, ((ValueOrClosed) obj2).m548unboximpl());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m545hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return m542equalsimpl(this.holder, obj);
    }

    public final int hashCode() {
        return m545hashCodeimpl(this.holder);
    }

    public final String toString() {
        return m547toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m548unboximpl() {
        return this.holder;
    }

    private /* synthetic */ ValueOrClosed(Object obj) {
        this.holder = obj;
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m546isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final T m544getValueimpl(Object obj) {
        if (!(obj instanceof Closed)) {
            return obj;
        }
        throw new IllegalStateException("Channel was closed".toString());
    }

    /* renamed from: getCloseCause-impl  reason: not valid java name */
    public static final Throwable m543getCloseCauseimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).cause;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m547toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public static final class Closed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof Closed) && k.a((Object) this.cause, (Object) ((Closed) obj).cause);
        }

        public final int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
