package com.airbnb.lottie.c;

import com.airbnb.lottie.c.b.n;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f5958a;

    /* renamed from: b  reason: collision with root package name */
    public final double f5959b;

    /* renamed from: c  reason: collision with root package name */
    private final char f5960c;

    /* renamed from: d  reason: collision with root package name */
    private final double f5961d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5962e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5963f;

    public static int a(char c2, String str, String str2) {
        return ((((c2 + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.f5958a = list;
        this.f5960c = c2;
        this.f5961d = d2;
        this.f5959b = d3;
        this.f5962e = str;
        this.f5963f = str2;
    }

    public final int hashCode() {
        return a(this.f5960c, this.f5963f, this.f5962e);
    }
}
