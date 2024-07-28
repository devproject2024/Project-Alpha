package net.one97.paytm.recharge.automatic.g;

import java.util.Comparator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60295a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static List<CJRAggsItem> a(List<CJRAggsItem> list) {
        k.c(list, "variants");
        return kotlin.a.k.a(list, new b());
    }

    public static boolean a(CJRUtilityVariantV2 cJRUtilityVariantV2) {
        if (cJRUtilityVariantV2 != null) {
            return cJRUtilityVariantV2.isSchedulable();
        }
        return false;
    }

    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(Boolean.valueOf(((CJRAggsItem) t2).isSchedulable()), Boolean.valueOf(((CJRAggsItem) t).isSchedulable()));
        }
    }
}
