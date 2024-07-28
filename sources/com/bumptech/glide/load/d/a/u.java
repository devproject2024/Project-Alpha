package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.a.m;
import com.bumptech.glide.load.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

interface u {
    Bitmap a(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType a() throws IOException;

    int b() throws IOException;

    void c();

    public static final class a implements u {

        /* renamed from: a  reason: collision with root package name */
        private final k f7179a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.b.a.b f7180b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f7181c;

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.b.a.b bVar) {
            this.f7180b = (com.bumptech.glide.load.b.a.b) j.a(bVar, "Argument must not be null");
            this.f7181c = (List) j.a(list, "Argument must not be null");
            this.f7179a = new k(inputStream, bVar);
        }

        public final Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f7179a.a(), (Rect) null, options);
        }

        public final ImageHeaderParser.ImageType a() throws IOException {
            return f.a(this.f7181c, this.f7179a.a(), this.f7180b);
        }

        public final int b() throws IOException {
            return f.b(this.f7181c, this.f7179a.a(), this.f7180b);
        }

        public final void c() {
            this.f7179a.f6710a.a();
        }
    }

    public static final class b implements u {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.load.b.a.b f7182a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f7183b;

        /* renamed from: c  reason: collision with root package name */
        private final m f7184c;

        public final void c() {
        }

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.b.a.b bVar) {
            this.f7182a = (com.bumptech.glide.load.b.a.b) j.a(bVar, "Argument must not be null");
            this.f7183b = (List) j.a(list, "Argument must not be null");
            this.f7184c = new m(parcelFileDescriptor);
        }

        public final Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f7184c.f6715a.a().getFileDescriptor(), (Rect) null, options);
        }

        public final ImageHeaderParser.ImageType a() throws IOException {
            return f.a(this.f7183b, (f.b) new f.b(this.f7182a) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ com.bumptech.glide.load.b.a.b f7259b;

                {
                    this.f7259b = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[SYNTHETIC, Splitter:B:14:0x002e] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                    /*
                        r4 = this;
                        r0 = 0
                        com.bumptech.glide.load.d.a.y r1 = new com.bumptech.glide.load.d.a.y     // Catch:{ all -> 0x002b }
                        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002b }
                        com.bumptech.glide.load.a.m r3 = com.bumptech.glide.load.a.m.this     // Catch:{ all -> 0x002b }
                        com.bumptech.glide.load.a.m$b r3 = r3.f6715a     // Catch:{ all -> 0x002b }
                        android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x002b }
                        java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x002b }
                        r2.<init>(r3)     // Catch:{ all -> 0x002b }
                        com.bumptech.glide.load.b.a.b r3 = r4.f7259b     // Catch:{ all -> 0x002b }
                        r1.<init>(r2, r3)     // Catch:{ all -> 0x002b }
                        com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.a((java.io.InputStream) r1)     // Catch:{ all -> 0x0028 }
                        r1.close()     // Catch:{ IOException -> 0x0020 }
                    L_0x0020:
                        com.bumptech.glide.load.a.m r0 = com.bumptech.glide.load.a.m.this
                        com.bumptech.glide.load.a.m$b r0 = r0.f6715a
                        r0.a()
                        return r5
                    L_0x0028:
                        r5 = move-exception
                        r0 = r1
                        goto L_0x002c
                    L_0x002b:
                        r5 = move-exception
                    L_0x002c:
                        if (r0 == 0) goto L_0x0031
                        r0.close()     // Catch:{ IOException -> 0x0031 }
                    L_0x0031:
                        com.bumptech.glide.load.a.m r0 = com.bumptech.glide.load.a.m.this
                        com.bumptech.glide.load.a.m$b r0 = r0.f6715a
                        r0.a()
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.f.AnonymousClass3.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
                }
            });
        }

        public final int b() throws IOException {
            return f.a(this.f7183b, (f.a) new f.a(this.f7182a) {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ com.bumptech.glide.load.b.a.b f7263b;

                {
                    this.f7263b = r2;
                }

                /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[SYNTHETIC, Splitter:B:14:0x0030] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final int a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                    /*
                        r4 = this;
                        r0 = 0
                        com.bumptech.glide.load.d.a.y r1 = new com.bumptech.glide.load.d.a.y     // Catch:{ all -> 0x002d }
                        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002d }
                        com.bumptech.glide.load.a.m r3 = com.bumptech.glide.load.a.m.this     // Catch:{ all -> 0x002d }
                        com.bumptech.glide.load.a.m$b r3 = r3.f6715a     // Catch:{ all -> 0x002d }
                        android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x002d }
                        java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x002d }
                        r2.<init>(r3)     // Catch:{ all -> 0x002d }
                        com.bumptech.glide.load.b.a.b r3 = r4.f7263b     // Catch:{ all -> 0x002d }
                        r1.<init>(r2, r3)     // Catch:{ all -> 0x002d }
                        com.bumptech.glide.load.b.a.b r0 = r4.f7263b     // Catch:{ all -> 0x002a }
                        int r5 = r5.a(r1, r0)     // Catch:{ all -> 0x002a }
                        r1.close()     // Catch:{ IOException -> 0x0022 }
                    L_0x0022:
                        com.bumptech.glide.load.a.m r0 = com.bumptech.glide.load.a.m.this
                        com.bumptech.glide.load.a.m$b r0 = r0.f6715a
                        r0.a()
                        return r5
                    L_0x002a:
                        r5 = move-exception
                        r0 = r1
                        goto L_0x002e
                    L_0x002d:
                        r5 = move-exception
                    L_0x002e:
                        if (r0 == 0) goto L_0x0033
                        r0.close()     // Catch:{ IOException -> 0x0033 }
                    L_0x0033:
                        com.bumptech.glide.load.a.m r0 = com.bumptech.glide.load.a.m.this
                        com.bumptech.glide.load.a.m$b r0 = r0.f6715a
                        r0.a()
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.f.AnonymousClass5.a(com.bumptech.glide.load.ImageHeaderParser):int");
                }
            });
        }
    }
}
