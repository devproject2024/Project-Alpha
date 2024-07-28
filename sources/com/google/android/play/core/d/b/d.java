package com.google.android.play.core.d.b;

import java.util.ArrayList;
import java.util.List;

final class d implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Integer f37377a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f37378b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f37379c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Long f37380d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Long f37381e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ List f37382f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ List f37383g;

    d(Integer num, int i2, int i3, Long l, Long l2, List list, List list2) {
        this.f37377a = num;
        this.f37378b = i2;
        this.f37379c = i3;
        this.f37380d = l;
        this.f37381e = l2;
        this.f37382f = list;
        this.f37383g = list2;
    }

    public final com.google.android.play.core.d.d a(com.google.android.play.core.d.d dVar) {
        if (dVar == null) {
            dVar = com.google.android.play.core.d.d.a(0, 0, 0, 0, 0, new ArrayList(), new ArrayList());
        }
        Integer num = this.f37377a;
        int intValue = num != null ? num.intValue() : dVar.a();
        int i2 = this.f37378b;
        int i3 = this.f37379c;
        Long l = this.f37380d;
        long longValue = l != null ? l.longValue() : dVar.d();
        Long l2 = this.f37381e;
        long e2 = l2 == null ? dVar.e() : l2.longValue();
        List<String> list = this.f37382f;
        if (list == null) {
            list = dVar.f();
        }
        List<String> list2 = list;
        List<String> list3 = this.f37383g;
        return com.google.android.play.core.d.d.a(intValue, i2, i3, longValue, e2, list2, list3 == null ? dVar.g() : list3);
    }
}
