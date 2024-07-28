package net.one97.paytm.o2o.movies.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.orders.a.a;

public final class e {

    /* renamed from: net.one97.paytm.o2o.movies.c.e$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74964a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                net.one97.paytm.orders.a.a[] r0 = net.one97.paytm.orders.a.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f74964a = r0
                int[] r0 = f74964a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.orders.a.a r1 = net.one97.paytm.orders.a.a.LAYOUT_FOOTER_CARD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f74964a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.orders.a.a r1 = net.one97.paytm.orders.a.a.LAYOUT_HEADER_CARD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f74964a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.orders.a.a r1 = net.one97.paytm.orders.a.a.LAYOUT_SUCCESS_MOVIE_DESC_CARD     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f74964a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.orders.a.a r1 = net.one97.paytm.orders.a.a.LAYOUT_MOVIE_UPCOMING_MOVIE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f74964a     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.orders.a.a r1 = net.one97.paytm.orders.a.a.LAYOUT_MOVIE_SUMMARY_CATALOG     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.c.e.AnonymousClass1.<clinit>():void");
        }
    }

    public static View a(ViewGroup viewGroup, a aVar) {
        int i2 = AnonymousClass1.f74964a[aVar.ordinal()];
        if (i2 == 1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_contact_us_card_layout, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_summary_header_card_layout, viewGroup, false);
        }
        if (i2 == 3) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_order_detail_layout, viewGroup, false);
        }
        if (i2 == 4) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_upcoming_layout, viewGroup, false);
        }
        if (i2 != 5) {
            return new View(viewGroup.getContext());
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_summary_catalog, viewGroup, false);
    }
}
