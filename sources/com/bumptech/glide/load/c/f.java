package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f7020a;

    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        File file = (File) obj;
        return new n.a(new com.bumptech.glide.f.d(file), new c(file, this.f7020a));
    }

    public f(d<Data> dVar) {
        this.f7020a = dVar;
    }

    static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f7022a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f7023b;

        /* renamed from: c  reason: collision with root package name */
        private Data f7024c;

        public final void c() {
        }

        c(File file, d<Data> dVar) {
            this.f7022a = file;
            this.f7023b = dVar;
        }

        public final void a(com.bumptech.glide.f fVar, d.a<? super Data> aVar) {
            try {
                this.f7024c = this.f7023b.a(this.f7022a);
                aVar.a(this.f7024c);
            } catch (FileNotFoundException e2) {
                Log.isLoggable("FileLoader", 3);
                aVar.a((Exception) e2);
            }
        }

        public final void b() {
            Data data = this.f7024c;
            if (data != null) {
                try {
                    this.f7023b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        public final Class<Data> a() {
            return this.f7023b.a();
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f7021a;

        public a(d<Data> dVar) {
            this.f7021a = dVar;
        }

        public final n<File, Data> a(r rVar) {
            return new f(this.f7021a);
        }
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                public final /* synthetic */ void a(Object obj) throws IOException {
                    ((InputStream) obj).close();
                }

                public final Class<InputStream> a() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object a(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                public final /* synthetic */ void a(Object obj) throws IOException {
                    ((ParcelFileDescriptor) obj).close();
                }

                public final Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                public final /* synthetic */ Object a(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
            });
        }
    }
}
