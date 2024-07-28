package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d implements n<File, ByteBuffer> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        File file = (File) obj;
        return new n.a(new com.bumptech.glide.f.d(file), new a(file));
    }

    public static class b implements o<File, ByteBuffer> {
        public final n<File, ByteBuffer> a(r rVar) {
            return new d();
        }
    }

    static final class a implements com.bumptech.glide.load.a.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f7013a;

        public final void b() {
        }

        public final void c() {
        }

        a(File file) {
            this.f7013a = file;
        }

        public final void a(f fVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.bumptech.glide.g.a.a(this.f7013a));
            } catch (IOException e2) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.a((Exception) e2);
            }
        }

        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }
}
