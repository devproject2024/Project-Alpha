package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import java.util.concurrent.atomic.AtomicBoolean;

final class ay {

    /* renamed from: a  reason: collision with root package name */
    static final b f37022a = new b("ExtractorLooper");

    /* renamed from: b  reason: collision with root package name */
    final av f37023b;

    /* renamed from: c  reason: collision with root package name */
    final cq f37024c;

    /* renamed from: d  reason: collision with root package name */
    final ca f37025d;

    /* renamed from: e  reason: collision with root package name */
    final ce f37026e;

    /* renamed from: f  reason: collision with root package name */
    final cj f37027f;

    /* renamed from: g  reason: collision with root package name */
    final bh<dk> f37028g;

    /* renamed from: h  reason: collision with root package name */
    final br f37029h;

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f37030i = new AtomicBoolean(false);
    private final bo j;

    ay(bo boVar, bh<dk> bhVar, av avVar, cq cqVar, ca caVar, ce ceVar, cj cjVar, br brVar) {
        this.j = boVar;
        this.f37028g = bhVar;
        this.f37023b = avVar;
        this.f37024c = cqVar;
        this.f37025d = caVar;
        this.f37026e = ceVar;
        this.f37027f = cjVar;
        this.f37029h = brVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Exception exc) {
        try {
            this.j.c(i2);
            this.j.a(i2);
        } catch (ax unused) {
            f37022a.b("Error during error handling: %s", exc.getMessage());
        }
    }
}
