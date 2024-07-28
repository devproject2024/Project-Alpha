package net.one97.paytm.recharge.common.fragment;

import net.one97.paytm.recharge.model.v4.DataState;

public final /* synthetic */ class p {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f61371a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f61372b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f61373c;

    static {
        int[] iArr = new int[DataState.values().length];
        f61371a = iArr;
        iArr[DataState.LOADING.ordinal()] = 1;
        f61371a[DataState.ERROR.ordinal()] = 2;
        f61371a[DataState.SUCCESS.ordinal()] = 3;
        int[] iArr2 = new int[DataState.values().length];
        f61372b = iArr2;
        iArr2[DataState.LOADING.ordinal()] = 1;
        f61372b[DataState.SUCCESS.ordinal()] = 2;
        f61372b[DataState.ERROR.ordinal()] = 3;
        int[] iArr3 = new int[DataState.values().length];
        f61373c = iArr3;
        iArr3[DataState.FULL_SCREEN_LOADING.ordinal()] = 1;
        f61373c[DataState.LOADING.ordinal()] = 2;
        f61373c[DataState.ERROR.ordinal()] = 3;
    }
}
