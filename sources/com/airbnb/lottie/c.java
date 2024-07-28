package com.airbnb.lottie;

import androidx.core.d.m;
import com.business.merchant_payments.common.utility.AppUtility;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5801a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5802b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f5803c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f5804d;

    /* renamed from: e  reason: collision with root package name */
    private static int f5805e;

    /* renamed from: f  reason: collision with root package name */
    private static int f5806f;

    public static void a(String str) {
        if (f5802b) {
            int i2 = f5805e;
            if (i2 == 20) {
                f5806f++;
                return;
            }
            f5803c[i2] = str;
            f5804d[i2] = System.nanoTime();
            m.a(str);
            f5805e++;
        }
    }

    public static float b(String str) {
        int i2 = f5806f;
        if (i2 > 0) {
            f5806f = i2 - 1;
            return 0.0f;
        } else if (!f5802b) {
            return 0.0f;
        } else {
            int i3 = f5805e - 1;
            f5805e = i3;
            if (i3 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f5803c[f5805e])) {
                m.a();
                return ((float) (System.nanoTime() - f5804d[f5805e])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f5803c[f5805e] + AppUtility.CENTER_DOT);
            }
        }
    }
}
