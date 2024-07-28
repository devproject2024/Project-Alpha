package com.google.android.exoplayer2.source.dash.a;

import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f32900a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32901b;

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f32902c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f32903d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f32904e;

    public a(int i2, int i3, List<i> list, List<d> list2, List<d> list3) {
        List<d> list4;
        List<d> list5;
        this.f32900a = i2;
        this.f32901b = i3;
        this.f32902c = Collections.unmodifiableList(list);
        if (list2 == null) {
            list4 = Collections.emptyList();
        } else {
            list4 = Collections.unmodifiableList(list2);
        }
        this.f32903d = list4;
        if (list3 == null) {
            list5 = Collections.emptyList();
        } else {
            list5 = Collections.unmodifiableList(list3);
        }
        this.f32904e = list5;
    }
}
