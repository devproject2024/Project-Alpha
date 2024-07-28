package com.google.firebase.crashlytics.a.d;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

class c implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f38336b = Logger.getLogger(c.class.getName());

    /* renamed from: a  reason: collision with root package name */
    int f38337a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f38338c;

    /* renamed from: d  reason: collision with root package name */
    private int f38339d;

    /* renamed from: e  reason: collision with root package name */
    private a f38340e;

    /* renamed from: f  reason: collision with root package name */
    private a f38341f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f38342g = new byte[16];

    /* renamed from: com.google.firebase.crashlytics.a.d.c$c  reason: collision with other inner class name */
    public interface C0630c {
        void a(InputStream inputStream, int i2) throws IOException;
    }

    /* JADX INFO: finally extract failed */
    public c(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile a2 = a(file2);
            try {
                a2.setLength(4096);
                a2.seek(0);
                byte[] bArr = new byte[16];
                a(bArr, 4096, 0, 0, 0);
                a2.write(bArr);
                a2.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
        }
        this.f38338c = a(file);
        this.f38338c.seek(0);
        this.f38338c.readFully(this.f38342g);
        this.f38337a = b(this.f38342g, 0);
        if (((long) this.f38337a) <= this.f38338c.length()) {
            this.f38339d = b(this.f38342g, 4);
            int b2 = b(this.f38342g, 8);
            int b3 = b(this.f38342g, 12);
            this.f38340e = a(b2);
            this.f38341f = a(b3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f38337a + ", Actual length: " + this.f38338c.length());
    }

    private static void a(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            a(bArr, i2, iArr[i3]);
            i2 += 4;
        }
    }

    private static int b(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    private void a(int i2, int i3, int i4, int i5) throws IOException {
        a(this.f38342g, i2, i3, i4, i5);
        this.f38338c.seek(0);
        this.f38338c.write(this.f38342g);
    }

    private a a(int i2) throws IOException {
        if (i2 == 0) {
            return a.f38346a;
        }
        this.f38338c.seek((long) i2);
        return new a(i2, this.f38338c.readInt());
    }

    private static RandomAccessFile a(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    public int b(int i2) {
        int i3 = this.f38337a;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    private void a(int i2, byte[] bArr, int i3) throws IOException {
        int b2 = b(i2);
        int i4 = b2 + i3;
        int i5 = this.f38337a;
        if (i4 <= i5) {
            this.f38338c.seek((long) b2);
            this.f38338c.write(bArr, 0, i3);
            return;
        }
        int i6 = i5 - b2;
        this.f38338c.seek((long) b2);
        this.f38338c.write(bArr, 0, i6);
        this.f38338c.seek(16);
        this.f38338c.write(bArr, i6 + 0, i3 - i6);
    }

    /* access modifiers changed from: private */
    public void a(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int b2 = b(i2);
        int i5 = b2 + i4;
        int i6 = this.f38337a;
        if (i5 <= i6) {
            this.f38338c.seek((long) b2);
            this.f38338c.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - b2;
        this.f38338c.seek((long) b2);
        this.f38338c.readFully(bArr, i3, i7);
        this.f38338c.seek(16);
        this.f38338c.readFully(bArr, i3 + i7, i4 - i7);
    }

    public final synchronized void a(byte[] bArr, int i2) throws IOException {
        int i3;
        b(bArr, "buffer");
        if ((i2 | 0) < 0 || i2 > bArr.length - 0) {
            throw new IndexOutOfBoundsException();
        }
        c(i2);
        boolean b2 = b();
        if (b2) {
            i3 = 16;
        } else {
            i3 = b(this.f38341f.f38347b + 4 + this.f38341f.f38348c);
        }
        a aVar = new a(i3, i2);
        a(this.f38342g, 0, i2);
        a(aVar.f38347b, this.f38342g, 4);
        a(aVar.f38347b + 4, bArr, i2);
        a(this.f38337a, this.f38339d + 1, b2 ? aVar.f38347b : this.f38340e.f38347b, aVar.f38347b);
        this.f38341f = aVar;
        this.f38339d++;
        if (b2) {
            this.f38340e = this.f38341f;
        }
    }

    public final int a() {
        if (this.f38339d == 0) {
            return 16;
        }
        if (this.f38341f.f38347b >= this.f38340e.f38347b) {
            return (this.f38341f.f38347b - this.f38340e.f38347b) + 4 + this.f38341f.f38348c + 16;
        }
        return (((this.f38341f.f38347b + 4) + this.f38341f.f38348c) + this.f38337a) - this.f38340e.f38347b;
    }

    public final synchronized boolean b() {
        return this.f38339d == 0;
    }

    private void d(int i2) throws IOException {
        this.f38338c.setLength((long) i2);
        this.f38338c.getChannel().force(true);
    }

    public final synchronized void a(C0630c cVar) throws IOException {
        int i2 = this.f38340e.f38347b;
        for (int i3 = 0; i3 < this.f38339d; i3++) {
            a a2 = a(i2);
            cVar.a(new b(this, a2, (byte) 0), a2.f38348c);
            i2 = b(a2.f38347b + 4 + a2.f38348c);
        }
    }

    /* access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    final class b extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        private int f38350b;

        /* renamed from: c  reason: collision with root package name */
        private int f38351c;

        /* synthetic */ b(c cVar, a aVar, byte b2) {
            this(aVar);
        }

        private b(a aVar) {
            this.f38350b = c.this.b(aVar.f38347b + 4);
            this.f38351c = aVar.f38348c;
        }

        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            Object unused = c.b(bArr, "buffer");
            if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = this.f38351c;
            if (i4 <= 0) {
                return -1;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            c.this.a(this.f38350b, bArr, i2, i3);
            this.f38350b = c.this.b(this.f38350b + i3);
            this.f38351c -= i3;
            return i3;
        }

        public final int read() throws IOException {
            if (this.f38351c == 0) {
                return -1;
            }
            c.this.f38338c.seek((long) this.f38350b);
            int read = c.this.f38338c.read();
            this.f38350b = c.this.b(this.f38350b + 1);
            this.f38351c--;
            return read;
        }
    }

    public final synchronized void c() throws IOException {
        if (b()) {
            throw new NoSuchElementException();
        } else if (this.f38339d == 1) {
            d();
        } else {
            int b2 = b(this.f38340e.f38347b + 4 + this.f38340e.f38348c);
            a(b2, this.f38342g, 0, 4);
            int b3 = b(this.f38342g, 0);
            a(this.f38337a, this.f38339d - 1, b2, this.f38341f.f38347b);
            this.f38339d--;
            this.f38340e = new a(b2, b3);
        }
    }

    private synchronized void d() throws IOException {
        a(4096, 0, 0, 0);
        this.f38339d = 0;
        this.f38340e = a.f38346a;
        this.f38341f = a.f38346a;
        if (this.f38337a > 4096) {
            d(4096);
        }
        this.f38337a = 4096;
    }

    public synchronized void close() throws IOException {
        this.f38338c.close();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f38337a);
        sb.append(", size=");
        sb.append(this.f38339d);
        sb.append(", first=");
        sb.append(this.f38340e);
        sb.append(", last=");
        sb.append(this.f38341f);
        sb.append(", element lengths=[");
        try {
            a((C0630c) new C0630c() {

                /* renamed from: a  reason: collision with root package name */
                boolean f38343a = true;

                public final void a(InputStream inputStream, int i2) throws IOException {
                    if (this.f38343a) {
                        this.f38343a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i2);
                }
            });
        } catch (IOException e2) {
            f38336b.log(Level.WARNING, "read error", e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final a f38346a = new a(0, 0);

        /* renamed from: b  reason: collision with root package name */
        final int f38347b;

        /* renamed from: c  reason: collision with root package name */
        final int f38348c;

        a(int i2, int i3) {
            this.f38347b = i2;
            this.f38348c = i3;
        }

        public final String toString() {
            return getClass().getSimpleName() + "[position = " + this.f38347b + ", length = " + this.f38348c + "]";
        }
    }

    private void c(int i2) throws IOException {
        int i3 = i2 + 4;
        int a2 = this.f38337a - a();
        if (a2 < i3) {
            int i4 = this.f38337a;
            do {
                a2 += i4;
                i4 <<= 1;
            } while (a2 < i3);
            d(i4);
            int b2 = b(this.f38341f.f38347b + 4 + this.f38341f.f38348c);
            if (b2 < this.f38340e.f38347b) {
                FileChannel channel = this.f38338c.getChannel();
                channel.position((long) this.f38337a);
                long j = (long) (b2 - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f38341f.f38347b < this.f38340e.f38347b) {
                int i5 = (this.f38337a + this.f38341f.f38347b) - 16;
                a(i4, this.f38339d, this.f38340e.f38347b, i5);
                this.f38341f = new a(i5, this.f38341f.f38348c);
            } else {
                a(i4, this.f38339d, this.f38340e.f38347b, this.f38341f.f38347b);
            }
            this.f38337a = i4;
        }
    }
}
