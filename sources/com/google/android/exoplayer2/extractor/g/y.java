package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.r;

public final class y implements v {

    /* renamed from: a  reason: collision with root package name */
    private ab f32120a;

    /* renamed from: b  reason: collision with root package name */
    private q f32121b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32122c;

    public final void a(ab abVar, i iVar, ac.d dVar) {
        this.f32120a = abVar;
        dVar.a();
        this.f32121b = iVar.a(dVar.b(), 4);
        this.f32121b.a(Format.a(dVar.c(), "application/x-scte35"));
    }

    public final void a(r rVar) {
        long j = -9223372036854775807L;
        if (!this.f32122c) {
            if (this.f32120a.a() != -9223372036854775807L) {
                this.f32121b.a(Format.b((String) null, "application/x-scte35", this.f32120a.a()));
                this.f32122c = true;
            } else {
                return;
            }
        }
        int b2 = rVar.b();
        this.f32121b.a(rVar, b2);
        q qVar = this.f32121b;
        ab abVar = this.f32120a;
        if (abVar.f32498c != -9223372036854775807L) {
            j = abVar.f32498c + abVar.f32497b;
        } else if (abVar.f32496a != Long.MAX_VALUE) {
            j = abVar.f32496a;
        }
        qVar.a(j, 1, b2, 0, (q.a) null);
    }
}
