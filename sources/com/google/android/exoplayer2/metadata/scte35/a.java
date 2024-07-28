package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private final r f32752a = new r();

    /* renamed from: b  reason: collision with root package name */
    private final q f32753b = new q();

    /* renamed from: c  reason: collision with root package name */
    private ab f32754c;

    public final Metadata a(c cVar) {
        if (this.f32754c == null || cVar.f32646e != this.f32754c.a()) {
            this.f32754c = new ab(cVar.f31312d);
            this.f32754c.c(cVar.f31312d - cVar.f32646e);
        }
        ByteBuffer byteBuffer = cVar.f31311c;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f32752a.a(array, limit);
        this.f32753b.a(array, limit);
        this.f32753b.b(39);
        long c2 = (((long) this.f32753b.c(1)) << 32) | ((long) this.f32753b.c(32));
        this.f32753b.b(20);
        int c3 = this.f32753b.c(12);
        int c4 = this.f32753b.c(8);
        Metadata.Entry entry = null;
        this.f32752a.d(14);
        if (c4 == 0) {
            entry = new SpliceNullCommand();
        } else if (c4 == 255) {
            entry = PrivateCommand.a(this.f32752a, c3, c2);
        } else if (c4 == 4) {
            entry = SpliceScheduleCommand.a(this.f32752a);
        } else if (c4 == 5) {
            entry = SpliceInsertCommand.a(this.f32752a, c2, this.f32754c);
        } else if (c4 == 6) {
            entry = TimeSignalCommand.a(this.f32752a, c2, this.f32754c);
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
