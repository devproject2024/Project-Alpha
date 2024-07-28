package com.google.firebase.installations;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f38939a;

    /* renamed from: b  reason: collision with root package name */
    private final FileLock f38940b;

    private b(FileChannel fileChannel, FileLock fileLock) {
        this.f38939a = fileChannel;
        this.f38940b = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[SYNTHETIC, Splitter:B:14:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[SYNTHETIC, Splitter:B:18:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.installations.b a(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException | Error -> 0x0023 }
            java.io.File r2 = r2.getFilesDir()     // Catch:{ IOException | Error -> 0x0023 }
            r1.<init>(r2, r3)     // Catch:{ IOException | Error -> 0x0023 }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException | Error -> 0x0023 }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ IOException | Error -> 0x0023 }
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ IOException | Error -> 0x0023 }
            java.nio.channels.FileLock r3 = r2.lock()     // Catch:{ IOException | Error -> 0x0021 }
            com.google.firebase.installations.b r1 = new com.google.firebase.installations.b     // Catch:{ IOException | Error -> 0x001f }
            r1.<init>(r2, r3)     // Catch:{ IOException | Error -> 0x001f }
            return r1
        L_0x001f:
            goto L_0x0025
        L_0x0021:
            r3 = r0
            goto L_0x0025
        L_0x0023:
            r2 = r0
            r3 = r2
        L_0x0025:
            if (r3 == 0) goto L_0x002c
            r3.release()     // Catch:{ IOException -> 0x002b }
            goto L_0x002c
        L_0x002b:
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            r2.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.b.a(android.content.Context, java.lang.String):com.google.firebase.installations.b");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            this.f38940b.release();
            this.f38939a.close();
        } catch (IOException unused) {
        }
    }
}
