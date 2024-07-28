package kotlin.m;

import java.util.regex.Matcher;
import kotlin.g.a.b;
import kotlin.g.b.l;

public final class m {

    public static final class a extends l implements b<T, Boolean> {
        final /* synthetic */ int $value$inlined;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.$value$inlined = i2;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        public final boolean invoke(T t) {
            f fVar = (f) t;
            return (this.$value$inlined & fVar.getMask()) == fVar.getValue();
        }
    }

    static final j a(Matcher matcher, int i2, CharSequence charSequence) {
        return !matcher.find(i2) ? null : new k(matcher, charSequence);
    }

    static final int a(Iterable<? extends f> iterable) {
        int i2 = 0;
        for (f value : iterable) {
            i2 |= value.getValue();
        }
        return i2;
    }
}
