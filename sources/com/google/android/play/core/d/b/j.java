package com.google.android.play.core.d.b;

import android.content.Intent;
import com.google.android.play.core.d.aa;
import java.util.List;

final class j implements aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f37396a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f37397b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f37398c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f37399d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ List f37400e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ a f37401f;

    j(a aVar, List list, List list2, long j, boolean z, List list3) {
        this.f37401f = aVar;
        this.f37396a = list;
        this.f37397b = list2;
        this.f37398c = j;
        this.f37399d = z;
        this.f37400e = list3;
    }

    public final void a() {
        this.f37401f.k.addAll(this.f37396a);
        this.f37401f.l.addAll(this.f37397b);
        this.f37401f.a(5, 0, Long.valueOf(this.f37398c), (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    public final void a(int i2) {
        this.f37401f.a(6, i2, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    public final void b() {
        if (!this.f37399d) {
            this.f37401f.a((List<Intent>) this.f37400e, (List<String>) this.f37396a, (List<String>) this.f37397b, this.f37398c, true);
        }
    }
}
