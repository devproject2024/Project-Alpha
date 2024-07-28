package com.bumptech.glide.load.c;

import com.bumptech.glide.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0098b<Data> f7008a;

    /* renamed from: com.bumptech.glide.load.c.b$b  reason: collision with other inner class name */
    public interface C0098b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        byte[] bArr = (byte[]) obj;
        return new n.a(new com.bumptech.glide.f.d(bArr), new c(bArr, this.f7008a));
    }

    public b(C0098b<Data> bVar) {
        this.f7008a = bVar;
    }

    static class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f7010a;

        /* renamed from: b  reason: collision with root package name */
        private final C0098b<Data> f7011b;

        public final void b() {
        }

        public final void c() {
        }

        c(byte[] bArr, C0098b<Data> bVar) {
            this.f7010a = bArr;
            this.f7011b = bVar;
        }

        public final void a(f fVar, d.a<? super Data> aVar) {
            aVar.a(this.f7011b.a(this.f7010a));
        }

        public final Class<Data> a() {
            return this.f7011b.a();
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a implements o<byte[], ByteBuffer> {
        public final n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0098b<ByteBuffer>() {
                public final Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                public final /* synthetic */ Object a(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    public static class d implements o<byte[], InputStream> {
        public final n<byte[], InputStream> a(r rVar) {
            return new b(new C0098b<InputStream>() {
                public final Class<InputStream> a() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object a(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }
}
