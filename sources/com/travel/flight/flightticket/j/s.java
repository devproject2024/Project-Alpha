package com.travel.flight.flightticket.j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.n;

public final class s {

    /* renamed from: com.travel.flight.flightticket.j.s$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25208a = new int[n.values().length];

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
                com.travel.flight.flightticket.f.n[] r0 = com.travel.flight.flightticket.f.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25208a = r0
                int[] r0 = f25208a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.flight.flightticket.f.n r1 = com.travel.flight.flightticket.f.n.ITEM_HEADER_VIEW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f25208a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.flight.flightticket.f.n r1 = com.travel.flight.flightticket.f.n.ITEM_ROUTE_VIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f25208a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.flight.flightticket.f.n r1 = com.travel.flight.flightticket.f.n.ITEM_POLICY_VIEW     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f25208a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.flight.flightticket.f.n r1 = com.travel.flight.flightticket.f.n.ITEM_RESCHEDULE_WINDOW     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f25208a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.travel.flight.flightticket.f.n r1 = com.travel.flight.flightticket.f.n.ITEM_CANCELLATION_WINDOW     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.s.AnonymousClass1.<clinit>():void");
        }
    }

    public static View a(ViewGroup viewGroup, n nVar) {
        int i2 = AnonymousClass1.f25208a[nVar.ordinal()];
        if (i2 == 1) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_layout_flight_fare_rules_item_header, viewGroup, false);
        }
        if (i2 == 2) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_layout_flight_fare_rules_item_flight_info, (ViewGroup) null);
        }
        if (i2 == 3) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_layout_flight_fare_rules_route_policy, (ViewGroup) null);
        }
        if (i2 == 4 || i2 == 5) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_fare_rules_icon_item, (ViewGroup) null);
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_layout_flight_fare_rules_tandc, viewGroup, false);
    }
}
