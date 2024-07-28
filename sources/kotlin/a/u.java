package kotlin.a;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.j.e;
import kotlin.l.d;
import kotlin.m.p;

public class u extends t {

    public static final class a implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f47891a;

        public a(Iterable iterable) {
            this.f47891a = iterable;
        }

        public final Iterator<T> a() {
            return this.f47891a.iterator();
        }
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, T t) {
        k.d(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return k.b(iterable, t) >= 0;
    }

    public static final <T> T a(Iterable<? extends T> iterable, int i2) {
        k.d(iterable, "$this$elementAt");
        if (iterable instanceof List) {
            return ((List) iterable).get(i2);
        }
        return k.a(iterable, i2, new b(i2));
    }

    static final class b extends l implements kotlin.g.a.b<Integer, T> {
        final /* synthetic */ int $index;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i2) {
            super(1);
            this.$index = i2;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }

        public final T invoke(int i2) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.$index + '.');
        }
    }

    public static final <T> T a(Iterable<? extends T> iterable, int i2, kotlin.g.a.b<? super Integer, ? extends T> bVar) {
        k.d(iterable, "$this$elementAtOrElse");
        k.d(bVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i2 < 0 || i2 > k.a(list)) ? bVar.invoke(Integer.valueOf(i2)) : list.get(i2);
        } else if (i2 < 0) {
            return bVar.invoke(Integer.valueOf(i2));
        } else {
            int i3 = 0;
            for (T next : iterable) {
                int i4 = i3 + 1;
                if (i2 == i3) {
                    return next;
                }
                i3 = i4;
            }
            return bVar.invoke(Integer.valueOf(i2));
        }
    }

    public static final <T> T c(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$first");
        if (iterable instanceof List) {
            return k.d((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T d(List<? extends T> list) {
        k.d(list, "$this$first");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T e(List<? extends T> list) {
        k.d(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T a(List<? extends T> list, int i2) {
        k.d(list, "$this$getOrNull");
        if (i2 < 0 || i2 > k.a(list)) {
            return null;
        }
        return list.get(i2);
    }

    public static final <T> int b(Iterable<? extends T> iterable, T t) {
        k.d(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i2 = 0;
        for (Object next : iterable) {
            if (i2 < 0) {
                k.a();
            }
            if (k.a((Object) t, (Object) next)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int a(List<? extends T> list, T t) {
        k.d(list, "$this$indexOf");
        return list.indexOf(t);
    }

    public static final <T> T f(List<? extends T> list) {
        k.d(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(k.a(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> List<T> a(Iterable<? extends T> iterable, kotlin.g.a.b<? super T, Boolean> bVar) {
        k.d(iterable, "$this$filter");
        k.d(bVar, "predicate");
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (bVar.invoke(next).booleanValue()) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$filterNotNull");
        return (List) k.a(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> iterable, C c2) {
        k.d(iterable, "$this$filterNotNullTo");
        k.d(c2, "destination");
        for (Object next : iterable) {
            if (next != null) {
                c2.add(next);
            }
        }
        return c2;
    }

    public static final <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        k.d(iterable, "$this$sortedWith");
        k.d(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return k.e(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } else if (array != null) {
                f.a(array, comparator);
                return f.a(array);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            List<T> f2 = k.f(iterable);
            k.a(f2, comparator);
            return f2;
        }
    }

    public static final int[] b(Collection<Integer> collection) {
        k.d(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        int i2 = 0;
        for (Integer intValue : collection) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        return iArr;
    }

    public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> iterable, C c2) {
        k.d(iterable, "$this$toCollection");
        k.d(c2, "destination");
        for (Object add : iterable) {
            c2.add(add);
        }
        return c2;
    }

    public static final <T> List<T> e(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return k.b(k.f(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return w.INSTANCE;
        }
        if (size != 1) {
            return k.c(collection);
        }
        return k.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> f(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return k.c((Collection) iterable);
        }
        return (List) k.b(iterable, new ArrayList());
    }

    public static final <T> List<T> c(Collection<? extends T> collection) {
        k.d(collection, "$this$toMutableList");
        return new ArrayList<>(collection);
    }

    static final class c extends l implements kotlin.g.a.a<Iterator<? extends T>> {
        final /* synthetic */ Iterable $this_withIndex;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Iterable iterable) {
            super(0);
            this.$this_withIndex = iterable;
        }

        public final Iterator<T> invoke() {
            return this.$this_withIndex.iterator();
        }
    }

    public static final <T> Iterable<z<T>> g(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$withIndex");
        return new aa<>(new c(iterable));
    }

    public static final <T extends Comparable<? super T>> T h(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$minOrNull");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t = (Comparable) it2.next();
        while (it2.hasNext()) {
            T t2 = (Comparable) it2.next();
            if (t.compareTo(t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    public static final <T> List<List<T>> i(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$chunked");
        return k.j(iterable);
    }

    public static final <T> List<List<T>> j(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$windowed");
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator<List<T>> a2 = ao.a(iterable.iterator());
            while (a2.hasNext()) {
                arrayList.add(a2.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / 900) + (size % 900 == 0 ? 0 : 1));
        int i2 = 0;
        while (i2 >= 0 && size > i2) {
            int c2 = e.c(900, size - i2);
            ArrayList arrayList3 = new ArrayList(c2);
            for (int i3 = 0; i3 < c2; i3++) {
                arrayList3.add(list.get(i3 + i2));
            }
            arrayList2.add(arrayList3);
            i2 += 900;
        }
        return arrayList2;
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        k.d(iterable, "$this$joinTo");
        k.d(a2, "buffer");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object next : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            p.a(a2, next, bVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b bVar, int i3) {
        if ((i3 & 1) != 0) {
        }
        CharSequence charSequence5 = charSequence;
        if ((i3 & 2) != 0) {
            charSequence2 = "";
        }
        CharSequence charSequence6 = charSequence2;
        if ((i3 & 4) != 0) {
            charSequence3 = "";
        }
        CharSequence charSequence7 = charSequence3;
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = AppConstants.DOTS;
        }
        CharSequence charSequence8 = charSequence4;
        if ((i3 & 32) != 0) {
            bVar = null;
        }
        return k.a(iterable, charSequence5, charSequence6, charSequence7, i4, charSequence8, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.g.a.b<? super T, ? extends CharSequence> bVar) {
        k.d(iterable, "$this$joinToString");
        k.d(charSequence, "separator");
        k.d(charSequence2, "prefix");
        k.d(charSequence3, "postfix");
        k.d(charSequence4, "truncated");
        String sb = ((StringBuilder) k.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, bVar)).toString();
        k.b(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> d<T> k(Iterable<? extends T> iterable) {
        k.d(iterable, "$this$asSequence");
        return new a(iterable);
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i2) {
        k.d(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        } else if (i2 == 0) {
            return w.INSTANCE;
        } else {
            if (iterable instanceof Collection) {
                if (i2 >= ((Collection) iterable).size()) {
                    return k.e(iterable);
                }
                if (i2 == 1) {
                    return k.a(k.c(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i2);
            for (Object add : iterable) {
                arrayList.add(add);
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return k.b(arrayList);
        }
    }
}
