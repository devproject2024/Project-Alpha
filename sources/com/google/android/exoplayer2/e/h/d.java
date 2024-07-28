package com.google.android.exoplayer2.e.h;

import android.text.Layout;
import java.util.Collections;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    String f31604a = "";

    /* renamed from: b  reason: collision with root package name */
    String f31605b = "";

    /* renamed from: c  reason: collision with root package name */
    List<String> f31606c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    String f31607d = "";

    /* renamed from: e  reason: collision with root package name */
    String f31608e = null;

    /* renamed from: f  reason: collision with root package name */
    int f31609f;

    /* renamed from: g  reason: collision with root package name */
    boolean f31610g = false;

    /* renamed from: h  reason: collision with root package name */
    int f31611h;

    /* renamed from: i  reason: collision with root package name */
    boolean f31612i = false;
    int j = -1;
    int k = -1;
    int l = -1;
    int m = -1;
    int n = -1;
    float o;
    Layout.Alignment p = null;

    public final int a() {
        if (this.l == -1 && this.m == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = this.l == 1 ? 1 : 0;
        if (this.m == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    static int a(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }
}
