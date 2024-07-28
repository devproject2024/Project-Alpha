package com.bumptech.glide.load.d.b;

import com.bumptech.glide.load.a.e;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f7198a;

    public final void b() {
    }

    public a(ByteBuffer byteBuffer) {
        this.f7198a = byteBuffer;
    }

    /* renamed from: com.bumptech.glide.load.d.b.a$a  reason: collision with other inner class name */
    public static class C0100a implements e.a<ByteBuffer> {
        public final /* synthetic */ e a(Object obj) {
            return new a((ByteBuffer) obj);
        }

        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public final /* synthetic */ Object a() throws IOException {
        this.f7198a.position(0);
        return this.f7198a;
    }
}
