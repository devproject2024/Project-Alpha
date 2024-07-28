package com.travel.bus.busticket.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.bus.R;

public final class c {

    /* renamed from: com.travel.bus.busticket.h.c$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22404a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.travel.bus.busticket.h.b[] r0 = com.travel.bus.busticket.h.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22404a = r0
                int[] r0 = f22404a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.bus.busticket.h.b r1 = com.travel.bus.busticket.h.b.NEAR_BY_ZERO_SEARCH     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f22404a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.bus.busticket.h.b r1 = com.travel.bus.busticket.h.b.N_HOP_ZERO_SEARCH_TITLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f22404a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.bus.busticket.h.b r1 = com.travel.bus.busticket.h.b.N_HOP_ZERO_SEARCH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.h.c.AnonymousClass1.<clinit>():void");
        }
    }

    public static View a(ViewGroup viewGroup, b bVar) {
        int i2 = AnonymousClass1.f22404a[bVar.ordinal()];
        if (i2 == 1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bus_search_near_by_routes_vh, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bus_search_n_hop_title_vh, viewGroup, false);
        }
        if (i2 != 3) {
            return new View(viewGroup.getContext());
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bus_search_n_hop_recycler_vh, viewGroup, false);
    }
}
