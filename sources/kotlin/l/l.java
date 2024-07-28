package kotlin.l;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.m.p;

public class l extends k {

    public static final class a implements Iterable<T>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f47966a;

        public a(d dVar) {
            this.f47966a = dVar;
        }

        public final Iterator<T> iterator() {
            return this.f47966a.a();
        }
    }

    public static final <T, C extends Collection<? super T>> C a(d<? extends T> dVar, C c2) {
        k.d(dVar, "$this$toCollection");
        k.d(c2, "destination");
        Iterator<? extends T> a2 = dVar.a();
        while (a2.hasNext()) {
            c2.add(a2.next());
        }
        return c2;
    }

    public static final <T> List<T> a(d<? extends T> dVar) {
        k.d(dVar, "$this$toList");
        k.d(dVar, "$this$toMutableList");
        return kotlin.a.k.b((List) g.a(dVar, new ArrayList()));
    }

    public static final <T, R> d<R> a(d<? extends T> dVar, b<? super T, ? extends R> bVar) {
        k.d(dVar, "$this$map");
        k.d(bVar, "transform");
        return new m<>(dVar, bVar);
    }

    public static final <T, A extends Appendable> A a(d<? extends T> dVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        k.d(dVar, "$this$joinTo");
        k.d(a2, "buffer");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        a2.append(charSequence2);
        Iterator<? extends T> a3 = dVar.a();
        int i2 = 0;
        while (a3.hasNext()) {
            Object next = a3.next();
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            p.a(a2, next, (b) null);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(d dVar, CharSequence charSequence) {
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        CharSequence charSequence4 = AppConstants.DOTS;
        k.d(dVar, "$this$joinToString");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        String sb = ((StringBuilder) g.a(dVar, new StringBuilder(), charSequence, charSequence2, charSequence3, charSequence4)).toString();
        k.b(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> Iterable<T> b(d<? extends T> dVar) {
        k.d(dVar, "$this$asIterable");
        return new a(dVar);
    }
}
