package net.one97.paytm.wifi.background.wifi;

import android.net.wifi.SupplicantState;
import net.one97.paytm.wifi.models.InternetStatus;

public final /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f21118a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f21119b;

    static {
        int[] iArr = new int[SupplicantState.values().length];
        f21118a = iArr;
        iArr[SupplicantState.DISCONNECTED.ordinal()] = 1;
        f21118a[SupplicantState.INTERFACE_DISABLED.ordinal()] = 2;
        f21118a[SupplicantState.INACTIVE.ordinal()] = 3;
        f21118a[SupplicantState.INVALID.ordinal()] = 4;
        f21118a[SupplicantState.AUTHENTICATING.ordinal()] = 5;
        f21118a[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 6;
        f21118a[SupplicantState.ASSOCIATING.ordinal()] = 7;
        f21118a[SupplicantState.ASSOCIATED.ordinal()] = 8;
        f21118a[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 9;
        f21118a[SupplicantState.COMPLETED.ordinal()] = 10;
        int[] iArr2 = new int[InternetStatus.values().length];
        f21119b = iArr2;
        iArr2[InternetStatus.INTERNET_ACCESS.ordinal()] = 1;
        f21119b[InternetStatus.CONFIGURED_NO_INTERNET.ordinal()] = 2;
    }
}
