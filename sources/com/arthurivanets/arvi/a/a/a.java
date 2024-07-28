package com.arthurivanets.arvi.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.arthurivanets.arvi.a.b;
import com.arthurivanets.arvi.a.b.c;
import com.arthurivanets.arvi.j;
import com.google.android.exoplayer2.ae;
import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.p;
import com.google.android.exoplayer2.f.r;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.i;
import java.util.Arrays;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final j f30973a;

    /* renamed from: b  reason: collision with root package name */
    private final i f30974b = new DefaultTrackSelector();

    /* renamed from: c  reason: collision with root package name */
    private final q f30975c;

    /* renamed from: d  reason: collision with root package name */
    private final d f30976d;

    /* renamed from: e  reason: collision with root package name */
    private final c f30977e;

    /* renamed from: f  reason: collision with root package name */
    private final ae f30978f;

    /* renamed from: g  reason: collision with root package name */
    private final i.a f30979g;

    /* renamed from: h  reason: collision with root package name */
    private final i.a f30980h;

    /* renamed from: i  reason: collision with root package name */
    private final e[] f30981i;

    public a(j jVar, com.arthurivanets.arvi.c cVar) {
        com.arthurivanets.arvi.b.b.c.a((Object) jVar);
        com.arthurivanets.arvi.b.b.c.a((Object) cVar);
        com.arthurivanets.arvi.b.b.c.a((Object) jVar);
        this.f30973a = jVar;
        this.f30975c = cVar.f31000c;
        this.f30976d = cVar.f30999b;
        this.f30977e = cVar.f31001d;
        this.f30978f = new com.arthurivanets.arvi.a.b.d(jVar.b(), cVar.f31002e, cVar.f30998a);
        i.a aVar = cVar.f31004g;
        p pVar = new p(jVar.b(), (ad) cVar.f30999b, aVar == null ? new r(jVar.a(), cVar.f30999b) : aVar);
        this.f30979g = cVar.f31003f != null ? new com.google.android.exoplayer2.f.a.e(cVar.f31003f, pVar) : pVar;
        this.f30980h = new p(jVar.b(), jVar.a());
        this.f30981i = cVar.f31002e;
    }

    public final b a() {
        Context b2 = this.f30973a.b();
        ae aeVar = this.f30978f;
        com.google.android.exoplayer2.trackselection.i iVar = this.f30974b;
        q qVar = this.f30975c;
        d dVar = this.f30976d;
        e[] eVarArr = this.f30981i;
        com.arthurivanets.arvi.b.b.c.a((Object) eVarArr);
        return new com.arthurivanets.arvi.a.a(b2, aeVar, iVar, qVar, dVar, eVarArr.length > 0 ? eVarArr[0] : null);
    }

    public final int hashCode() {
        return ((((((((((((((this.f30973a.hashCode() + 527) * 31) + this.f30974b.hashCode()) * 31) + this.f30975c.hashCode()) * 31) + this.f30977e.hashCode()) * 31) + this.f30978f.hashCode()) * 31) + this.f30979g.hashCode()) * 31) + this.f30980h.hashCode()) * 31) + Arrays.hashCode(this.f30981i);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && obj.hashCode() == hashCode();
    }

    public final o a(Uri uri) {
        com.arthurivanets.arvi.b.b.c.a((Object) uri);
        com.arthurivanets.arvi.b.b.c.a((Object) "");
        return this.f30977e.a(this.f30973a.b(), uri, "", new Handler(), this.f30980h, this.f30979g, (com.google.android.exoplayer2.source.p) null);
    }
}
