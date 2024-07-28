package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;

abstract class d {

    /* renamed from: b  reason: collision with root package name */
    protected final q f31701b;

    /* access modifiers changed from: protected */
    public abstract boolean a(r rVar) throws v;

    /* access modifiers changed from: protected */
    public abstract boolean a(r rVar, long j) throws v;

    public static final class a extends v {
        public a(String str) {
            super(str);
        }
    }

    protected d(q qVar) {
        this.f31701b = qVar;
    }

    public final boolean b(r rVar, long j) throws v {
        return a(rVar) && a(rVar, j);
    }
}
