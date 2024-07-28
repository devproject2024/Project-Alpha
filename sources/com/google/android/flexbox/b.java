package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    int f8013a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    int f8014b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    int f8015c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f8016d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    int f8017e;

    /* renamed from: f  reason: collision with root package name */
    int f8018f;

    /* renamed from: g  reason: collision with root package name */
    int f8019g;

    /* renamed from: h  reason: collision with root package name */
    int f8020h;

    /* renamed from: i  reason: collision with root package name */
    int f8021i;
    float j;
    float k;
    int l;
    int m;
    List<Integer> n = new ArrayList();
    int o;
    int p;

    b() {
    }

    public final int a() {
        return this.f8020h - this.f8021i;
    }

    /* access modifiers changed from: package-private */
    public final void a(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f8013a = Math.min(this.f8013a, (view.getLeft() - flexItem.m()) - i2);
        this.f8014b = Math.min(this.f8014b, (view.getTop() - flexItem.n()) - i3);
        this.f8015c = Math.max(this.f8015c, view.getRight() + flexItem.o() + i4);
        this.f8016d = Math.max(this.f8016d, view.getBottom() + flexItem.p() + i5);
    }
}
