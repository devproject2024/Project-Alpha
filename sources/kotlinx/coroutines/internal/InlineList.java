package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlinx.coroutines.DebugKt;

public final class InlineList<E> {
    private final Object holder;

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m549constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m551equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && k.a(obj, ((InlineList) obj2).m555unboximpl());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m552hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m554toStringimpl(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public final boolean equals(Object obj) {
        return m551equalsimpl(this.holder, obj);
    }

    public final int hashCode() {
        return m552hashCodeimpl(this.holder);
    }

    public final String toString() {
        return m554toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m555unboximpl() {
        return this.holder;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ Object m550constructorimpl$default(Object obj, int i2, g gVar) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return m549constructorimpl(obj);
    }

    /* renamed from: plus-impl  reason: not valid java name */
    public static final Object m553plusimpl(Object obj, E e2) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(e2 instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return m549constructorimpl(e2);
        } else {
            if (!(obj instanceof ArrayList)) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(obj);
                arrayList.add(e2);
                return m549constructorimpl(arrayList);
            } else if (obj != null) {
                ((ArrayList) obj).add(e2);
                return m549constructorimpl(obj);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
            }
        }
    }
}
