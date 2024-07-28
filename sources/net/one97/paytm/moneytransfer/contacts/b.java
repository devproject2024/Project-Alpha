package net.one97.paytm.moneytransfer.contacts;

import net.one97.paytm.moneytransfer.model.d;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f53965a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f53966b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f53967c;

    static {
        int[] iArr = new int[d.values().length];
        f53965a = iArr;
        iArr[d.SUCCESS.ordinal()] = 1;
        int[] iArr2 = new int[d.values().length];
        f53966b = iArr2;
        iArr2[d.LOADING.ordinal()] = 1;
        f53966b[d.SUCCESS.ordinal()] = 2;
        f53966b[d.ERROR.ordinal()] = 3;
        int[] iArr3 = new int[d.values().length];
        f53967c = iArr3;
        iArr3[d.LOADING.ordinal()] = 1;
        f53967c[d.SUCCESS.ordinal()] = 2;
        f53967c[d.ERROR.ordinal()] = 3;
    }
}
