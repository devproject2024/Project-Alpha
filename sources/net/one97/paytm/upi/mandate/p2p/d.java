package net.one97.paytm.upi.mandate.p2p;

import net.one97.paytm.upi.mandate.utils.g;
import net.one97.paytm.upi.mandate.utils.p;

public final /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f67324a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f67325b;

    static {
        int[] iArr = new int[g.values().length];
        f67324a = iArr;
        iArr[g.START_DATE.ordinal()] = 1;
        f67324a[g.END_DATE.ordinal()] = 2;
        int[] iArr2 = new int[p.values().length];
        f67325b = iArr2;
        iArr2[p.MONTHLY.ordinal()] = 1;
        f67325b[p.DAILY.ordinal()] = 2;
        f67325b[p.WEEKLY.ordinal()] = 3;
        f67325b[p.FORTNIGHTLY.ordinal()] = 4;
        f67325b[p.BIMONTHLY.ordinal()] = 5;
        f67325b[p.QUARTERLY.ordinal()] = 6;
        f67325b[p.HALF_YEARLY.ordinal()] = 7;
        f67325b[p.YEARLY.ordinal()] = 8;
    }
}
