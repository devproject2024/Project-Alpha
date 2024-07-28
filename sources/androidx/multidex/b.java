package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f3853a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3854b;

    /* renamed from: c  reason: collision with root package name */
    private final File f3855c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f3856d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f3857e;

    /* renamed from: f  reason: collision with root package name */
    private final FileLock f3858f;

    static class a extends File {
        public long crc = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    b(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        this.f3853a = file;
        this.f3855c = file2;
        this.f3854b = b(file);
        File file3 = new File(file2, "MultiDex.lock");
        this.f3856d = new RandomAccessFile(file3, "rw");
        try {
            this.f3857e = this.f3856d.getChannel();
            try {
                new StringBuilder("Blocking on lock ").append(file3.getPath());
                this.f3858f = this.f3857e.lock();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file3.getPath());
                sb2.append(" locked");
            } catch (IOException e2) {
                e = e2;
                a((Closeable) this.f3857e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                a((Closeable) this.f3857e);
                throw e;
            } catch (Error e4) {
                e = e4;
                a((Closeable) this.f3857e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            a((Closeable) this.f3856d);
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0073 A[SYNTHETIC, Splitter:B:10:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<? extends java.io.File> a(android.content.Context r11, java.lang.String r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "MultiDexExtractor.load("
            r0.<init>(r1)
            java.io.File r1 = r10.f3853a
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r13)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.nio.channels.FileLock r0 = r10.f3858f
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x009f
            if (r13 != 0) goto L_0x0078
            java.io.File r13 = r10.f3853a
            long r0 = r10.f3854b
            android.content.SharedPreferences r2 = a((android.content.Context) r11)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            java.lang.String r4 = "timestamp"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = -1
            long r6 = r2.getLong(r3, r4)
            long r8 = a((java.io.File) r13)
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 != 0) goto L_0x0070
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            java.lang.String r3 = "crc"
            r13.append(r3)
            java.lang.String r13 = r13.toString()
            long r2 = r2.getLong(r13, r4)
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r13 = 0
            goto L_0x0071
        L_0x0070:
            r13 = 1
        L_0x0071:
            if (r13 != 0) goto L_0x0078
            java.util.List r11 = r10.a(r11, r12)     // Catch:{ IOException -> 0x0078 }
            goto L_0x008b
        L_0x0078:
            java.util.List r13 = r10.a()
            java.io.File r0 = r10.f3853a
            long r2 = a((java.io.File) r0)
            long r4 = r10.f3854b
            r0 = r11
            r1 = r12
            r6 = r13
            a(r0, r1, r2, r4, r6)
            r11 = r13
        L_0x008b:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "load found "
            r12.<init>(r13)
            int r13 = r11.size()
            r12.append(r13)
            java.lang.String r13 = " secondary dex files"
            r12.append(r13)
            return r11
        L_0x009f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "MultiDexExtractor was closed"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.b.a(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    public final void close() throws IOException {
        this.f3858f.release();
        this.f3857e.close();
        this.f3856d.close();
    }

    private List<a> a(Context context, String str) throws IOException {
        String str2 = str;
        String str3 = this.f3853a.getName() + ".classes";
        SharedPreferences a2 = a(context);
        int i2 = a2.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + -1);
        int i3 = 2;
        while (i3 <= i2) {
            a aVar = new a(this.f3855c, str3 + i3 + ".zip");
            if (aVar.isFile()) {
                aVar.crc = b(aVar);
                long j = a2.getLong(str2 + "dex.crc." + i3, -1);
                long j2 = a2.getLong(str2 + "dex.time." + i3, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = a2;
                    if (j == aVar.crc) {
                        arrayList.add(aVar);
                        i3++;
                        a2 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
        }
        return arrayList;
    }

    private static long a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long b(File file) throws IOException {
        long a2 = c.a(file);
        return a2 == -1 ? a2 - 1 : a2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        new java.lang.StringBuilder("Failed to read crc from ").append(r6.getAbsolutePath());
        r8 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<androidx.multidex.b.a> a() throws java.io.IOException {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = r12.f3853a
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ".classes"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.b()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile
            java.io.File r3 = r12.f3853a
            r2.<init>(r3)
            r3 = 2
            java.lang.String r4 = "classes2.dex"
            java.util.zip.ZipEntry r4 = r2.getEntry(r4)     // Catch:{ all -> 0x0113 }
        L_0x002d:
            if (r4 == 0) goto L_0x010f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r5.<init>()     // Catch:{ all -> 0x0113 }
            r5.append(r0)     // Catch:{ all -> 0x0113 }
            r5.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r6 = ".zip"
            r5.append(r6)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0113 }
            androidx.multidex.b$a r6 = new androidx.multidex.b$a     // Catch:{ all -> 0x0113 }
            java.io.File r7 = r12.f3855c     // Catch:{ all -> 0x0113 }
            r6.<init>(r7, r5)     // Catch:{ all -> 0x0113 }
            r1.add(r6)     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r7 = "Extraction is needed for file "
            r5.<init>(r7)     // Catch:{ all -> 0x0113 }
            r5.append(r6)     // Catch:{ all -> 0x0113 }
            r5 = 0
            r7 = 0
            r8 = 0
        L_0x005a:
            r9 = 3
            if (r7 >= r9) goto L_0x00cd
            if (r8 != 0) goto L_0x00cd
            int r7 = r7 + 1
            a(r2, r4, r6, r0)     // Catch:{ all -> 0x0113 }
            long r8 = b(r6)     // Catch:{ IOException -> 0x006c }
            r6.crc = r8     // Catch:{ IOException -> 0x006c }
            r8 = 1
            goto L_0x007b
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r9 = "Failed to read crc from "
            r8.<init>(r9)     // Catch:{ all -> 0x0113 }
            java.lang.String r9 = r6.getAbsolutePath()     // Catch:{ all -> 0x0113 }
            r8.append(r9)     // Catch:{ all -> 0x0113 }
            r8 = 0
        L_0x007b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = "Extraction "
            r9.<init>(r10)     // Catch:{ all -> 0x0113 }
            if (r8 == 0) goto L_0x0087
            java.lang.String r10 = "succeeded"
            goto L_0x0089
        L_0x0087:
            java.lang.String r10 = "failed"
        L_0x0089:
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = " '"
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = r6.getAbsolutePath()     // Catch:{ all -> 0x0113 }
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = "': length "
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            long r10 = r6.length()     // Catch:{ all -> 0x0113 }
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = " - crc: "
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            long r10 = r6.crc     // Catch:{ all -> 0x0113 }
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            if (r8 != 0) goto L_0x005a
            r6.delete()     // Catch:{ all -> 0x0113 }
            boolean r9 = r6.exists()     // Catch:{ all -> 0x0113 }
            if (r9 == 0) goto L_0x005a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = "Failed to delete corrupted secondary dex '"
            r9.<init>(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = r6.getPath()     // Catch:{ all -> 0x0113 }
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            java.lang.String r10 = "'"
            r9.append(r10)     // Catch:{ all -> 0x0113 }
            goto L_0x005a
        L_0x00cd:
            if (r8 == 0) goto L_0x00ea
            int r3 = r3 + 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = "classes"
            r4.<init>(r5)     // Catch:{ all -> 0x0113 }
            r4.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r5 = ".dex"
            r4.append(r5)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0113 }
            java.util.zip.ZipEntry r4 = r2.getEntry(r4)     // Catch:{ all -> 0x0113 }
            goto L_0x002d
        L_0x00ea:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = "Could not create zip file "
            r1.<init>(r4)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = r6.getAbsolutePath()     // Catch:{ all -> 0x0113 }
            r1.append(r4)     // Catch:{ all -> 0x0113 }
            java.lang.String r4 = " for secondary dex ("
            r1.append(r4)     // Catch:{ all -> 0x0113 }
            r1.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r3 = ")"
            r1.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0113 }
            r0.<init>(r1)     // Catch:{ all -> 0x0113 }
            throw r0     // Catch:{ all -> 0x0113 }
        L_0x010f:
            r2.close()     // Catch:{ IOException -> 0x0112 }
        L_0x0112:
            return r1
        L_0x0113:
            r0 = move-exception
            r2.close()     // Catch:{ IOException -> 0x0117 }
        L_0x0117:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.b.a():java.util.List");
    }

    private static void a(Context context, String str, long j, long j2, List<a> list) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (a next : list) {
            edit.putLong(str + "dex.crc." + i2, next.crc);
            edit.putLong(str + "dex.time." + i2, next.lastModified());
            i2++;
        }
        edit.commit();
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void b() {
        File[] listFiles = this.f3855c.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return !file.getName().equals("MultiDex.lock");
            }
        });
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder("Failed to list secondary dex dir content (");
            sb.append(this.f3855c.getPath());
            sb.append(").");
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            if (!file.delete()) {
                new StringBuilder("Failed to delete old file ").append(file.getPath());
            } else {
                new StringBuilder("Deleted old file ").append(file.getPath());
            }
        }
    }

    private static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".zip", file.getParentFile());
        new StringBuilder("Extracting ").append(createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                new StringBuilder("Renaming to ").append(file.getPath());
                if (createTempFile.renameTo(file)) {
                    a((Closeable) inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            a((Closeable) inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
