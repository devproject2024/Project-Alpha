package com.google.android.play.core.b;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.d.aa;
import com.google.android.play.core.d.ae;
import com.google.android.play.core.splitcompat.a;
import com.google.android.play.core.splitcompat.e;
import com.google.android.play.core.splitcompat.r;
import java.util.List;
import java.util.concurrent.Executor;

public final class o implements ae {

    /* renamed from: a  reason: collision with root package name */
    final Context f37322a;

    /* renamed from: b  reason: collision with root package name */
    final p f37323b;

    /* renamed from: c  reason: collision with root package name */
    private final e f37324c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f37325d;

    /* renamed from: e  reason: collision with root package name */
    private final r f37326e;

    public o(Context context, Executor executor, p pVar, e eVar, r rVar) {
        this.f37322a = context;
        this.f37324c = eVar;
        this.f37323b = pVar;
        this.f37325d = executor;
        this.f37326e = rVar;
    }

    public final void a(List<Intent> list, aa aaVar) {
        if (a.a()) {
            this.f37325d.execute(new n(this, list, aaVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|(6:11|12|(6:15|(2:20|(2:74|73))(1:19)|22|(11:24|25|26|27|28|29|(2:30|(1:32)(2:36|37))|33|34|35|76)(1:75)|73|13)|52|53|(1:55))|58|59) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00c5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer a(java.util.List<android.content.Intent> r14) {
        /*
            r13 = this;
            r0 = -13
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00de }
            com.google.android.play.core.splitcompat.e r2 = r13.f37324c     // Catch:{ Exception -> 0x00de }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00de }
            java.io.File r2 = r2.d()     // Catch:{ Exception -> 0x00de }
            java.lang.String r4 = "lock.tmp"
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "rw"
            r1.<init>(r3, r2)     // Catch:{ Exception -> 0x00de }
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ Exception -> 0x00de }
            r2 = 0
            java.nio.channels.FileLock r3 = r1.tryLock()     // Catch:{ OverlappingFileLockException -> 0x0023 }
            goto L_0x0024
        L_0x0020:
            r14 = move-exception
            goto L_0x00cd
        L_0x0023:
            r3 = r2
        L_0x0024:
            if (r3 == 0) goto L_0x00d8
            r2 = 0
            r4 = -11
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x00c3 }
        L_0x002d:
            boolean r5 = r14.hasNext()     // Catch:{ Exception -> 0x00c3 }
            if (r5 == 0) goto L_0x00b9
            java.lang.Object r5 = r14.next()     // Catch:{ Exception -> 0x00c3 }
            android.content.Intent r5 = (android.content.Intent) r5     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r6 = "split_id"
            java.lang.String r6 = r5.getStringExtra(r6)     // Catch:{ Exception -> 0x00c3 }
            android.content.Context r7 = r13.f37322a     // Catch:{ Exception -> 0x00c3 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ Exception -> 0x00c3 }
            android.net.Uri r5 = r5.getData()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = "r"
            android.content.res.AssetFileDescriptor r5 = r7.openAssetFileDescriptor(r5, r8)     // Catch:{ Exception -> 0x00c3 }
            com.google.android.play.core.splitcompat.e r7 = r13.f37324c     // Catch:{ Exception -> 0x00c3 }
            java.io.File r7 = r7.b()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r8 = com.google.android.play.core.splitcompat.e.e(r6)     // Catch:{ Exception -> 0x00c3 }
            java.io.File r7 = com.google.android.play.core.splitcompat.e.a(r7, r8)     // Catch:{ Exception -> 0x00c3 }
            boolean r8 = r7.exists()     // Catch:{ Exception -> 0x00c3 }
            if (r8 == 0) goto L_0x0070
            long r8 = r7.length()     // Catch:{ Exception -> 0x00c3 }
            long r10 = r5.getLength()     // Catch:{ Exception -> 0x00c3 }
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            boolean r8 = r7.exists()     // Catch:{ Exception -> 0x00c3 }
            if (r8 != 0) goto L_0x002d
        L_0x0076:
            com.google.android.play.core.splitcompat.e r8 = r13.f37324c     // Catch:{ Exception -> 0x00c3 }
            java.io.File r6 = r8.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00c3 }
            boolean r6 = r6.exists()     // Catch:{ Exception -> 0x00c3 }
            if (r6 != 0) goto L_0x002d
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c3 }
            java.io.FileInputStream r5 = r5.createInputStream()     // Catch:{ Exception -> 0x00c3 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00c3 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x00af }
            r5.<init>(r7)     // Catch:{ all -> 0x00af }
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x00a5 }
        L_0x0094:
            int r8 = r6.read(r7)     // Catch:{ all -> 0x00a5 }
            if (r8 > 0) goto L_0x00a1
            r5.close()     // Catch:{ all -> 0x00af }
            r6.close()     // Catch:{ Exception -> 0x00c3 }
            goto L_0x002d
        L_0x00a1:
            r5.write(r7, r2, r8)     // Catch:{ all -> 0x00a5 }
            goto L_0x0094
        L_0x00a5:
            r14 = move-exception
            r5.close()     // Catch:{ all -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r2 = move-exception
            com.google.android.play.core.b.bg.a(r14, r2)     // Catch:{ all -> 0x00af }
        L_0x00ae:
            throw r14     // Catch:{ all -> 0x00af }
        L_0x00af:
            r14 = move-exception
            r6.close()     // Catch:{ all -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r2 = move-exception
            com.google.android.play.core.b.bg.a(r14, r2)     // Catch:{ Exception -> 0x00c3 }
        L_0x00b8:
            throw r14     // Catch:{ Exception -> 0x00c3 }
        L_0x00b9:
            com.google.android.play.core.b.p r14 = r13.f37323b     // Catch:{ Exception -> 0x00c5 }
            boolean r14 = r14.a()     // Catch:{ Exception -> 0x00c5 }
            if (r14 == 0) goto L_0x00c5
            r4 = 0
            goto L_0x00c5
        L_0x00c3:
            r4 = -13
        L_0x00c5:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0020 }
            r3.release()     // Catch:{ all -> 0x0020 }
            goto L_0x00d8
        L_0x00cd:
            if (r1 == 0) goto L_0x00d7
            r1.close()     // Catch:{ all -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r1 = move-exception
            com.google.android.play.core.b.bg.a(r14, r1)     // Catch:{ Exception -> 0x00de }
        L_0x00d7:
            throw r14     // Catch:{ Exception -> 0x00de }
        L_0x00d8:
            if (r1 == 0) goto L_0x00dd
            r1.close()     // Catch:{ Exception -> 0x00de }
        L_0x00dd:
            return r2
        L_0x00de:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.b.o.a(java.util.List):java.lang.Integer");
    }
}
