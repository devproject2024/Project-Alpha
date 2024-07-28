package net.one97.paytm.wifi.background.wifi.connector;

import android.net.wifi.SupplicantState;

public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f21128a;

    static {
        int[] iArr = new int[SupplicantState.values().length];
        f21128a = iArr;
        iArr[SupplicantState.COMPLETED.ordinal()] = 1;
        f21128a[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 2;
        f21128a[SupplicantState.DISCONNECTED.ordinal()] = 3;
    }
}
