package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public C0164b f12542a;

    /* renamed from: b  reason: collision with root package name */
    ByteBuffer f12543b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f12544c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private b f12545a = new b((byte) 0);

        public final a a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            b bVar = this.f12545a;
            bVar.f12544c = bitmap;
            C0164b bVar2 = bVar.f12542a;
            bVar2.f12546a = width;
            bVar2.f12547b = height;
            return this;
        }

        public final a a(ByteBuffer byteBuffer, int i2, int i3, int i4) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (byteBuffer.capacity() < i2 * i3) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else if (i4 == 16 || i4 == 17 || i4 == 842094169) {
                b bVar = this.f12545a;
                bVar.f12543b = byteBuffer;
                C0164b bVar2 = bVar.f12542a;
                bVar2.f12546a = i2;
                bVar2.f12547b = i3;
                bVar2.f12551f = i4;
                return this;
            } else {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unsupported image format: ");
                sb.append(i4);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public final a a(int i2) {
            this.f12545a.f12542a.f12548c = i2;
            return this;
        }

        public final a a(long j) {
            this.f12545a.f12542a.f12549d = j;
            return this;
        }

        public final a b(int i2) {
            this.f12545a.f12542a.f12550e = i2;
            return this;
        }

        public final b a() {
            if (this.f12545a.f12543b != null || this.f12545a.f12544c != null) {
                return this.f12545a;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }
    }

    public final ByteBuffer a() {
        Bitmap bitmap = this.f12544c;
        if (bitmap == null) {
            return this.f12543b;
        }
        int width = bitmap.getWidth();
        int height = this.f12544c.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        this.f12544c.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            bArr[i3] = (byte) ((int) ((((float) Color.red(iArr[i3])) * 0.299f) + (((float) Color.green(iArr[i3])) * 0.587f) + (((float) Color.blue(iArr[i3])) * 0.114f)));
        }
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: com.google.android.gms.vision.b$b  reason: collision with other inner class name */
    public static class C0164b {

        /* renamed from: a  reason: collision with root package name */
        public int f12546a;

        /* renamed from: b  reason: collision with root package name */
        public int f12547b;

        /* renamed from: c  reason: collision with root package name */
        public int f12548c;

        /* renamed from: d  reason: collision with root package name */
        public long f12549d;

        /* renamed from: e  reason: collision with root package name */
        public int f12550e;

        /* renamed from: f  reason: collision with root package name */
        public int f12551f = -1;

        public C0164b() {
        }

        public C0164b(C0164b bVar) {
            this.f12546a = bVar.f12546a;
            this.f12547b = bVar.f12547b;
            this.f12548c = bVar.f12548c;
            this.f12549d = bVar.f12549d;
            this.f12550e = bVar.f12550e;
        }
    }

    private b() {
        this.f12542a = new C0164b();
        this.f12543b = null;
        this.f12544c = null;
    }

    /* synthetic */ b(byte b2) {
        this();
    }
}
