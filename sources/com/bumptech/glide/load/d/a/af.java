package com.bumptech.glide.load.d.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class af<T> implements k<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final h<Long> f7122a = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new h.a<Long>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f7128a = ByteBuffer.allocate(8);

        public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Long l = (Long) obj;
            messageDigest.update(bArr);
            synchronized (this.f7128a) {
                this.f7128a.position(0);
                messageDigest.update(this.f7128a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final h<Integer> f7123b = h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new h.a<Integer>() {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f7129a = ByteBuffer.allocate(4);

        public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
            Integer num = (Integer) obj;
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f7129a) {
                    this.f7129a.position(0);
                    messageDigest.update(this.f7129a.putInt(num.intValue()).array());
                }
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private static final c f7124c = new c();

    /* renamed from: d  reason: collision with root package name */
    private final d<T> f7125d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.e f7126e;

    /* renamed from: f  reason: collision with root package name */
    private final c f7127f;

    interface d<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public final boolean a(T t, i iVar) {
        return true;
    }

    public static k<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.b.a.e eVar) {
        return new af(eVar, new a((byte) 0));
    }

    public static k<ParcelFileDescriptor, Bitmap> b(com.bumptech.glide.load.b.a.e eVar) {
        return new af(eVar, new e());
    }

    public static k<ByteBuffer, Bitmap> c(com.bumptech.glide.load.b.a.e eVar) {
        return new af(eVar, new b());
    }

    private af(com.bumptech.glide.load.b.a.e eVar, d<T> dVar) {
        this(eVar, dVar, f7124c);
    }

    private af(com.bumptech.glide.load.b.a.e eVar, d<T> dVar, c cVar) {
        this.f7126e = eVar;
        this.f7125d = dVar;
        this.f7127f = cVar;
    }

    public final v<Bitmap> a(T t, int i2, int i3, i iVar) throws IOException {
        long longValue = ((Long) iVar.a(f7122a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) iVar.a(f7123b);
            if (num == null) {
                num = 2;
            }
            n nVar = (n) iVar.a(n.f7157h);
            if (nVar == null) {
                nVar = n.f7156g;
            }
            n nVar2 = nVar;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.f7125d.a(mediaMetadataRetriever, t);
                int intValue = num.intValue();
                Bitmap bitmap = null;
                if (!(Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || nVar2 == n.f7155f)) {
                    bitmap = a(mediaMetadataRetriever, longValue, intValue, i2, i3, nVar2);
                }
                if (bitmap == null) {
                    bitmap = mediaMetadataRetriever.getFrameAtTime(longValue, intValue);
                }
                mediaMetadataRetriever.release();
                return e.a(bitmap, this.f7126e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: ".concat(String.valueOf(longValue)));
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, n nVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i5 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i5;
            }
            float a2 = nVar.a(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i2, Math.round(((float) parseInt) * a2), Math.round(a2 * ((float) parseInt2)));
        } catch (Throwable unused) {
            Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    static class c {
        c() {
        }
    }

    static final class a implements d<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class e implements d<ParcelFileDescriptor> {
        e() {
        }

        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    static final class b implements d<ByteBuffer> {
        public final /* synthetic */ void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            final ByteBuffer byteBuffer = (ByteBuffer) obj;
            mediaMetadataRetriever.setDataSource(new MediaDataSource() {
                public final void close() {
                }

                public final int readAt(long j, byte[] bArr, int i2, int i3) {
                    if (j >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int min = Math.min(i3, byteBuffer.remaining());
                    byteBuffer.get(bArr, i2, min);
                    return min;
                }

                public final long getSize() {
                    return (long) byteBuffer.limit();
                }
            });
        }

        b() {
        }
    }
}
