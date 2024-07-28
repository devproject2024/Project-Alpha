package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public final Metadata a(c cVar) {
        ByteBuffer byteBuffer = cVar.f31311c;
        EventMessage a2 = a(new r(byteBuffer.array(), byteBuffer.limit()));
        if (a2 == null) {
            return null;
        }
        return new Metadata(a2);
    }

    private static EventMessage a(r rVar) {
        try {
            return new EventMessage((String) com.google.android.exoplayer2.g.a.a(rVar.q()), (String) com.google.android.exoplayer2.g.a.a(rVar.q()), rVar.g(), rVar.g(), Arrays.copyOfRange(rVar.f32566a, rVar.f32567b, rVar.f32568c));
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
