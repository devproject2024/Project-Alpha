package com.paytm.android.chat.activity;

import com.paytm.android.chat.bean.ChatType;
import com.paytm.android.chat.bean.UserType;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f41759a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f41760b;

    static {
        int[] iArr = new int[ChatType.values().length];
        f41759a = iArr;
        iArr[ChatType.P2VPA.ordinal()] = 1;
        f41759a[ChatType.P2VPAM.ordinal()] = 2;
        f41759a[ChatType.P2BK.ordinal()] = 3;
        int[] iArr2 = new int[UserType.values().length];
        f41760b = iArr2;
        iArr2[UserType.CUSTOMER.ordinal()] = 1;
        f41760b[UserType.CHANNEL.ordinal()] = 2;
        f41760b[UserType.MERCHANT.ordinal()] = 3;
    }
}
