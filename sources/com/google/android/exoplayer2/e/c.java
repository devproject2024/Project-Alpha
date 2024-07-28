package com.google.android.exoplayer2.e;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.g.a;
import java.nio.ByteBuffer;

public abstract class c extends g<i, j, g> implements f {

    /* renamed from: c  reason: collision with root package name */
    private final String f31509c;

    /* access modifiers changed from: protected */
    public abstract e a(byte[] bArr, int i2, boolean z) throws g;

    public final void a(long j) {
    }

    public final /* bridge */ /* synthetic */ void a(f fVar) {
        super.a((j) fVar);
    }

    protected c(String str) {
        super(new i[2], new j[2]);
        this.f31509c = str;
        a.b(this.f31317b == this.f31316a.length);
        for (I c2 : this.f31316a) {
            c2.c(TarConstants.EOF_BLOCK);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(j jVar) {
        super.a(jVar);
    }

    /* access modifiers changed from: private */
    public g a(i iVar, j jVar, boolean z) {
        try {
            ByteBuffer byteBuffer = iVar.f31311c;
            jVar.a(iVar.f31312d, a(byteBuffer.array(), byteBuffer.limit(), z), iVar.f31643e);
            jVar.f31289a &= Integer.MAX_VALUE;
            return null;
        } catch (g e2) {
            return e2;
        }
    }

    public final /* synthetic */ Exception a(Throwable th) {
        return new g("Unexpected decode error", th);
    }

    public final /* synthetic */ f g() {
        return new d(this);
    }

    public final /* synthetic */ e f() {
        return new i();
    }
}
