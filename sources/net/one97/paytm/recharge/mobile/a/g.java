package net.one97.paytm.recharge.mobile.a;

import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.model.v4.ErrorAction;

public final /* synthetic */ class g {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f63646a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f63647b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f63648c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int[] f63649d;

    static {
        int[] iArr = new int[DataState.values().length];
        f63646a = iArr;
        iArr[DataState.ERROR.ordinal()] = 1;
        int[] iArr2 = new int[DataState.values().length];
        f63647b = iArr2;
        iArr2[DataState.SUCCESS.ordinal()] = 1;
        int[] iArr3 = new int[a.b.values().length];
        f63648c = iArr3;
        iArr3[a.b.AMOUNT.ordinal()] = 1;
        f63648c[a.b.INPUT_PRODUCT_TYPE.ordinal()] = 2;
        int[] iArr4 = new int[ErrorAction.values().length];
        f63649d = iArr4;
        iArr4[ErrorAction.BROWSE_PLAN.ordinal()] = 1;
        f63649d[ErrorAction.OPERATOR_LIST.ordinal()] = 2;
        f63649d[ErrorAction.NO_ACTION.ordinal()] = 3;
    }
}
