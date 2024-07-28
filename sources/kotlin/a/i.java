package kotlin.a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.g.b.k;

public class i extends h {

    public static final class a extends d<Character> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ char[] f47890b;

        public a(char[] cArr) {
            this.f47890b = cArr;
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Character)) {
                return false;
            }
            return f.a(this.f47890b, ((Character) obj).charValue());
        }

        public final int indexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            return f.b(this.f47890b, ((Character) obj).charValue());
        }

        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Character)) {
                return -1;
            }
            char charValue = ((Character) obj).charValue();
            char[] cArr = this.f47890b;
            k.d(cArr, "$this$lastIndexOf");
            for (int length = cArr.length - 1; length >= 0; length--) {
                if (charValue == cArr[length]) {
                    return length;
                }
            }
            return -1;
        }

        public final int a() {
            return this.f47890b.length;
        }

        public final boolean isEmpty() {
            return this.f47890b.length == 0;
        }

        public final /* synthetic */ Object get(int i2) {
            return Character.valueOf(this.f47890b[i2]);
        }
    }

    public static /* synthetic */ Object[] a(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        k.d(objArr, "$this$copyInto");
        k.d(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
        return objArr2;
    }

    public static final <T> void a(T[] tArr, int i2, int i3) {
        k.d(tArr, "$this$fill");
        Arrays.fill(tArr, i2, i3, (Object) null);
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        k.d(tArr, "$this$sortWith");
        k.d(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final <T> List<T> a(T[] tArr) {
        k.d(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        k.b(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }
}
