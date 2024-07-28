package net.one97.paytm.p2b.view.c;

import net.one97.paytm.p2b.data.b;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f12961a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f12962b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f12963c;

    static {
        int[] iArr = new int[b.values().length];
        f12961a = iArr;
        iArr[b.SUCCESS.ordinal()] = 1;
        int[] iArr2 = new int[b.values().length];
        f12962b = iArr2;
        iArr2[b.SUCCESS.ordinal()] = 1;
        int[] iArr3 = new int[b.values().length];
        f12963c = iArr3;
        iArr3[b.LOADING.ordinal()] = 1;
        f12963c[b.ERROR.ordinal()] = 2;
        f12963c[b.ABORTED.ordinal()] = 3;
        f12963c[b.AUTHENTICATION_FAILURE.ordinal()] = 4;
        f12963c[b.SUCCESS.ordinal()] = 5;
    }
}
