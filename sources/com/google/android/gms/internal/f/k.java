package com.google.android.gms.internal.f;

import com.paytm.business.merchantprofile.common.utility.AppConstants;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f9475a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9476b = {1, 10, 100, 1000, AppConstants.START_OTP_FLOW, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f9477c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f9478d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e  reason: collision with root package name */
    private static int[] f9479e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int a(int i2) {
        long j = ((long) i2) << 1;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }
}
