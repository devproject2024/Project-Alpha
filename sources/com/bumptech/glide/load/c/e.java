package com.bumptech.glide.load.c;

import android.util.Base64;
import com.bumptech.glide.f;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f7014a;

    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    public e(a<Data> aVar) {
        this.f7014a = aVar;
    }

    public final n.a<Data> a(Model model, int i2, int i3, i iVar) {
        return new n.a<>(new d(model), new b(model.toString(), this.f7014a));
    }

    public final boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    static final class b<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f7015a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f7016b;

        /* renamed from: c  reason: collision with root package name */
        private Data f7017c;

        public final void c() {
        }

        b(String str, a<Data> aVar) {
            this.f7015a = str;
            this.f7016b = aVar;
        }

        public final void a(f fVar, d.a<? super Data> aVar) {
            try {
                this.f7017c = this.f7016b.a(this.f7015a);
                aVar.a(this.f7017c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public final void b() {
            try {
                this.f7016b.a(this.f7017c);
            } catch (IOException unused) {
            }
        }

        public final Class<Data> a() {
            return this.f7016b.a();
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f7018a = new a<InputStream>() {
            public final /* synthetic */ void a(Object obj) throws IOException {
                ((InputStream) obj).close();
            }

            public final Class<InputStream> a() {
                return InputStream.class;
            }

            public final /* synthetic */ Object a(String str) throws IllegalArgumentException {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public final n<Model, InputStream> a(r rVar) {
            return new e(this.f7018a);
        }
    }
}
