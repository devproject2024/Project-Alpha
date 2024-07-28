package kotlin.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.g.b.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.i.c;
import kotlin.m.p;

public class j extends i {
    public static final <T> boolean a(T[] tArr, T t) {
        k.d(tArr, "$this$contains");
        return f.b(tArr, t) >= 0;
    }

    public static final boolean a(char[] cArr, char c2) {
        k.d(cArr, "$this$contains");
        return f.b(cArr, c2) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        k.d(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (k.a((Object) t, (Object) tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final int b(char[] cArr, char c2) {
        k.d(cArr, "$this$indexOf");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int a(int[] iArr, c cVar) {
        k.d(iArr, "$this$random");
        k.d(cVar, "random");
        if (!(iArr.length == 0)) {
            return iArr[cVar.b(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final char a(char[] cArr) {
        k.d(cArr, "$this$single");
        return cArr[0];
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c2) {
        k.d(tArr, "$this$toCollection");
        k.d(c2, "destination");
        for (T add : tArr) {
            c2.add(add);
        }
        return c2;
    }

    public static final <T> List<T> b(T[] tArr) {
        k.d(tArr, "$this$toList");
        int length = tArr.length;
        if (length == 0) {
            return w.INSTANCE;
        }
        if (length != 1) {
            return f.c(tArr);
        }
        return k.a(tArr[0]);
    }

    public static final <T> List<T> c(T[] tArr) {
        k.d(tArr, "$this$toMutableList");
        return new ArrayList<>(k.a(tArr));
    }

    public static final <T> Set<T> d(T[] tArr) {
        k.d(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return y.INSTANCE;
        }
        if (length != 1) {
            return (Set) f.a(tArr, new LinkedHashSet(ae.a(tArr.length)));
        }
        return ak.a(tArr[0]);
    }

    public static final class a extends l implements kotlin.g.a.a<Iterator<? extends T>> {
        final /* synthetic */ Object[] $this_withIndex;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object[] objArr) {
            super(0);
            this.$this_withIndex = objArr;
        }

        public final Iterator<T> invoke() {
            return b.a(this.$this_withIndex);
        }
    }

    public static final <T, A extends Appendable> A a(T[] tArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        k.d(tArr, "$this$joinTo");
        k.d(a2, "buffer");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            p.a(a2, t, (kotlin.g.a.b) null);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <A extends Appendable> A a(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, kotlin.g.a.b<? super Byte, ? extends CharSequence> bVar) {
        k.d(bArr, "$this$joinTo");
        k.d(a2, "buffer");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (bVar != null) {
                a2.append((CharSequence) bVar.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf(b2));
            }
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(byte[] bArr, CharSequence charSequence, kotlin.g.a.b bVar) {
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        CharSequence charSequence4 = AppConstants.DOTS;
        k.d(bArr, "$this$joinToString");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        String sb = ((StringBuilder) f.a(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, charSequence4, bVar)).toString();
        k.b(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
