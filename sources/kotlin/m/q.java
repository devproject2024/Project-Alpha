package kotlin.m;

import kotlin.g.a.b;
import kotlin.g.b.k;

public class q {
    public static final <T> void a(Appendable appendable, T t, b<? super T, ? extends CharSequence> bVar) {
        k.d(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append((CharSequence) bVar.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
