package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.b.bh;
import com.google.android.play.core.e.b;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.f;
import com.google.android.play.core.e.g;
import com.google.android.play.core.e.u;
import com.google.android.play.core.splitcompat.r;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

final class am {

    /* renamed from: a  reason: collision with root package name */
    private final bh<dk> f36984a;

    am(bh<dk> bhVar) {
        this.f36984a = bhVar;
    }

    /* access modifiers changed from: package-private */
    public final InputStream a(int i2, String str, String str2, int i3) {
        e b2 = this.f36984a.a().b(i2, str, str2, i3);
        try {
            r.a(b2, (Object) "Task must not be null");
            if (!b2.a()) {
                u uVar = new u((byte) 0);
                b2.a(f.f37457b, uVar);
                b2.a(f.f37457b, (b) uVar);
                uVar.f37483a.await();
            }
            return new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) g.a(b2));
        } catch (ExecutionException e2) {
            throw new ax(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3)}), e2, i2);
        } catch (InterruptedException e3) {
            throw new ax("Extractor was interrupted while waiting for chunk file.", e3, i2);
        }
    }
}
