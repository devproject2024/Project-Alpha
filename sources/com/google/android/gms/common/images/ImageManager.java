package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import com.google.android.gms.internal.base.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8696a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static HashSet<Uri> f8697b = new HashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f8698c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f8699d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f8700e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f8701f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final e f8702g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Map<c, ImageReceiver> f8703h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Map<Uri, ImageReceiver> f8704i;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> j;

    public interface a {
    }

    static final class b extends androidx.a.e<b, Bitmap> {
        public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        public final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (b) obj, (Bitmap) obj2, (Bitmap) obj3);
        }
    }

    final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8705a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<c> f8706b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ ImageManager f8707c;

        public final void onReceiveResult(int i2, Bundle bundle) {
            this.f8707c.f8700e.execute(new c(this.f8705a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8711a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f8712b;

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f8713c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8714d;

        public d(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f8711a = uri;
            this.f8712b = bitmap;
            this.f8714d = z;
            this.f8713c = countDownLatch;
        }

        public final void run() {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                boolean z = this.f8712b != null;
                if (ImageManager.this.f8701f != null) {
                    if (this.f8714d) {
                        ImageManager.this.f8701f.evictAll();
                        System.gc();
                        this.f8714d = false;
                        ImageManager.this.f8699d.post(this);
                        return;
                    } else if (z) {
                        ImageManager.this.f8701f.put(new b(this.f8711a), this.f8712b);
                    }
                }
                ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f8704i.remove(this.f8711a);
                if (imageReceiver != null) {
                    ArrayList a2 = imageReceiver.f8706b;
                    int size = a2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c cVar = (c) a2.get(i2);
                        if (z) {
                            cVar.a(ImageManager.this.f8698c, this.f8712b);
                        } else {
                            ImageManager.this.j.put(this.f8711a, Long.valueOf(SystemClock.elapsedRealtime()));
                            Context b2 = ImageManager.this.f8698c;
                            e unused = ImageManager.this.f8702g;
                            cVar.a(b2);
                        }
                        if (!(cVar instanceof d)) {
                            ImageManager.this.f8703h.remove(cVar);
                        }
                    }
                }
                this.f8713c.countDown();
                synchronized (ImageManager.f8696a) {
                    ImageManager.f8697b.remove(this.f8711a);
                }
                return;
            }
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("checkMainThread: current thread ");
            sb.append(valueOf);
            sb.append(" IS NOT the main thread ");
            sb.append(valueOf2);
            sb.append("!");
            throw new IllegalStateException("OnBitmapLoadedRunnable must be executed in the main thread");
        }
    }

    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8708a;

        /* renamed from: b  reason: collision with root package name */
        private final ParcelFileDescriptor f8709b;

        public c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f8708a = uri;
            this.f8709b = parcelFileDescriptor;
        }

        public final void run() {
            boolean z;
            Bitmap bitmap;
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                boolean z2 = false;
                Bitmap bitmap2 = null;
                ParcelFileDescriptor parcelFileDescriptor = this.f8709b;
                if (parcelFileDescriptor != null) {
                    try {
                        bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                    } catch (OutOfMemoryError unused) {
                        String valueOf = String.valueOf(this.f8708a);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                        sb.append("OOM while loading bitmap for uri: ");
                        sb.append(valueOf);
                        z2 = true;
                    }
                    try {
                        this.f8709b.close();
                    } catch (IOException unused2) {
                    }
                    z = z2;
                    bitmap = bitmap2;
                } else {
                    bitmap = null;
                    z = false;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ImageManager.this.f8699d.post(new d(this.f8708a, bitmap, z, countDownLatch));
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused3) {
                    String valueOf2 = String.valueOf(this.f8708a);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                    sb2.append("Latch interrupted while posting ");
                    sb2.append(valueOf2);
                }
            } else {
                String valueOf3 = String.valueOf(Thread.currentThread());
                String valueOf4 = String.valueOf(Looper.getMainLooper().getThread());
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 56 + String.valueOf(valueOf4).length());
                sb3.append("checkNotMainThread: current thread ");
                sb3.append(valueOf3);
                sb3.append(" IS the main thread ");
                sb3.append(valueOf4);
                sb3.append("!");
                throw new IllegalStateException("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            }
        }
    }
}
