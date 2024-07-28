package androidx.room;

import android.content.Context;
import androidx.room.b.d;
import androidx.sqlite.db.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

final class o implements c {

    /* renamed from: a  reason: collision with root package name */
    a f4492a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4493b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4494c;

    /* renamed from: d  reason: collision with root package name */
    private final File f4495d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4496e;

    /* renamed from: f  reason: collision with root package name */
    private final c f4497f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4498g;

    o(Context context, String str, File file, int i2, c cVar) {
        this.f4493b = context;
        this.f4494c = str;
        this.f4495d = file;
        this.f4496e = i2;
        this.f4497f = cVar;
    }

    public final String a() {
        return this.f4497f.a();
    }

    public final void a(boolean z) {
        this.f4497f.a(z);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:9|11|12|13|(2:15|16)|21|(2:23|24)(2:31|(5:33|34|35|36|(1:38)(2:39|(1:41)(2:42|(2:44|45)(2:46|47)))))|25|26|48|49) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0057 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC, Splitter:B:15:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[SYNTHETIC, Splitter:B:23:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064 A[Catch:{ IOException -> 0x005b, IOException -> 0x0045, all -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized androidx.sqlite.db.b b() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f4498g     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x00a1
            java.lang.String r0 = r7.a()     // Catch:{ all -> 0x00a9 }
            android.content.Context r1 = r7.f4493b     // Catch:{ all -> 0x00a9 }
            java.io.File r1 = r1.getDatabasePath(r0)     // Catch:{ all -> 0x00a9 }
            androidx.room.a r2 = r7.f4492a     // Catch:{ all -> 0x00a9 }
            r3 = 1
            if (r2 == 0) goto L_0x001d
            androidx.room.a r2 = r7.f4492a     // Catch:{ all -> 0x00a9 }
            boolean r2 = r2.j     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r2 = 0
            goto L_0x001e
        L_0x001d:
            r2 = 1
        L_0x001e:
            androidx.room.b.a r4 = new androidx.room.b.a     // Catch:{ all -> 0x00a9 }
            android.content.Context r5 = r7.f4493b     // Catch:{ all -> 0x00a9 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ all -> 0x00a9 }
            r4.<init>(r0, r5, r2)     // Catch:{ all -> 0x00a9 }
            java.util.concurrent.locks.Lock r2 = r4.f4384b     // Catch:{ all -> 0x009c }
            r2.lock()     // Catch:{ all -> 0x009c }
            boolean r2 = r4.f4385c     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x004e
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0045 }
            java.io.File r5 = r4.f4383a     // Catch:{ IOException -> 0x0045 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0045 }
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ IOException -> 0x0045 }
            r4.f4386d = r2     // Catch:{ IOException -> 0x0045 }
            java.nio.channels.FileChannel r2 = r4.f4386d     // Catch:{ IOException -> 0x0045 }
            r2.lock()     // Catch:{ IOException -> 0x0045 }
            goto L_0x004e
        L_0x0045:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "Unable to grab copy lock."
            r1.<init>(r2, r0)     // Catch:{ all -> 0x009c }
            throw r1     // Catch:{ all -> 0x009c }
        L_0x004e:
            boolean r2 = r1.exists()     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0064
            r7.a((java.io.File) r1)     // Catch:{ IOException -> 0x005b }
        L_0x0057:
            r4.a()     // Catch:{ all -> 0x00a9 }
            goto L_0x0099
        L_0x005b:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "Unable to copy database file."
            r1.<init>(r2, r0)     // Catch:{ all -> 0x009c }
            throw r1     // Catch:{ all -> 0x009c }
        L_0x0064:
            androidx.room.a r2 = r7.f4492a     // Catch:{ all -> 0x009c }
            if (r2 != 0) goto L_0x0069
            goto L_0x0057
        L_0x0069:
            int r2 = androidx.room.b.c.a((java.io.File) r1)     // Catch:{ IOException -> 0x0057 }
            int r5 = r7.f4496e     // Catch:{ all -> 0x009c }
            if (r2 != r5) goto L_0x0072
            goto L_0x0057
        L_0x0072:
            androidx.room.a r5 = r7.f4492a     // Catch:{ all -> 0x009c }
            int r6 = r7.f4496e     // Catch:{ all -> 0x009c }
            boolean r2 = r5.a(r2, r6)     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x007d
            goto L_0x0057
        L_0x007d:
            android.content.Context r2 = r7.f4493b     // Catch:{ all -> 0x009c }
            boolean r2 = r2.deleteDatabase(r0)     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x0089
            r7.a((java.io.File) r1)     // Catch:{ IOException -> 0x0057 }
            goto L_0x0057
        L_0x0089:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "Failed to delete database file ("
            r1.<init>(r2)     // Catch:{ all -> 0x009c }
            r1.append(r0)     // Catch:{ all -> 0x009c }
            java.lang.String r0 = ") for a copy destructive migration."
            r1.append(r0)     // Catch:{ all -> 0x009c }
            goto L_0x0057
        L_0x0099:
            r7.f4498g = r3     // Catch:{ all -> 0x00a9 }
            goto L_0x00a1
        L_0x009c:
            r0 = move-exception
            r4.a()     // Catch:{ all -> 0x00a9 }
            throw r0     // Catch:{ all -> 0x00a9 }
        L_0x00a1:
            androidx.sqlite.db.c r0 = r7.f4497f     // Catch:{ all -> 0x00a9 }
            androidx.sqlite.db.b r0 = r0.b()     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)
            return r0
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.o.b():androidx.sqlite.db.b");
    }

    public final synchronized void close() {
        this.f4497f.close();
        this.f4498g = false;
    }

    private void a(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f4494c != null) {
            readableByteChannel = Channels.newChannel(this.f4493b.getAssets().open(this.f4494c));
        } else {
            File file2 = this.f4495d;
            if (file2 != null) {
                readableByteChannel = new FileInputStream(file2).getChannel();
            } else {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f4493b.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }
}
