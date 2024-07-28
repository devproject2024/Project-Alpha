package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public DiskBasedCache(File file, int i2) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i2;
    }

    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0;
    }

    public synchronized Cache.Entry get(String str) {
        CountingInputStream countingInputStream;
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader == null) {
            return null;
        }
        File fileForKey = getFileForKey(str);
        try {
            countingInputStream = new CountingInputStream(new BufferedInputStream(createInputStream(fileForKey)), fileForKey.length());
            CacheHeader readHeader = CacheHeader.readHeader(countingInputStream);
            if (!TextUtils.equals(str, readHeader.key)) {
                Object[] objArr = {fileForKey.getAbsolutePath(), str, readHeader.key};
                removeEntry(str);
                countingInputStream.close();
                return null;
            }
            Cache.Entry cacheEntry = cacheHeader.toCacheEntry(streamToBytes(countingInputStream, countingInputStream.bytesRemaining()));
            countingInputStream.close();
            return cacheEntry;
        } catch (IOException e2) {
            Object[] objArr2 = {fileForKey.getAbsolutePath(), e2.toString()};
            remove(str);
            return null;
        } catch (Throwable th) {
            countingInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.File r0 = r9.mRootDirectory     // Catch:{ all -> 0x005c }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x005c }
            r1 = 0
            if (r0 != 0) goto L_0x001f
            java.io.File r0 = r9.mRootDirectory     // Catch:{ all -> 0x005c }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x001d
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x005c }
            java.io.File r2 = r9.mRootDirectory     // Catch:{ all -> 0x005c }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x005c }
            r0[r1] = r2     // Catch:{ all -> 0x005c }
        L_0x001d:
            monitor-exit(r9)
            return
        L_0x001f:
            java.io.File r0 = r9.mRootDirectory     // Catch:{ all -> 0x005c }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x0029
            monitor-exit(r9)
            return
        L_0x0029:
            int r2 = r0.length     // Catch:{ all -> 0x005c }
        L_0x002a:
            if (r1 >= r2) goto L_0x005a
            r3 = r0[r1]     // Catch:{ all -> 0x005c }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0054 }
            com.android.volley.toolbox.DiskBasedCache$CountingInputStream r6 = new com.android.volley.toolbox.DiskBasedCache$CountingInputStream     // Catch:{ IOException -> 0x0054 }
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0054 }
            java.io.InputStream r8 = r9.createInputStream(r3)     // Catch:{ IOException -> 0x0054 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0054 }
            r6.<init>(r7, r4)     // Catch:{ IOException -> 0x0054 }
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r7 = com.android.volley.toolbox.DiskBasedCache.CacheHeader.readHeader(r6)     // Catch:{ all -> 0x004f }
            r7.size = r4     // Catch:{ all -> 0x004f }
            java.lang.String r4 = r7.key     // Catch:{ all -> 0x004f }
            r9.putEntry(r4, r7)     // Catch:{ all -> 0x004f }
            r6.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0057
        L_0x004f:
            r4 = move-exception
            r6.close()     // Catch:{ IOException -> 0x0054 }
            throw r4     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            r3.delete()     // Catch:{ all -> 0x005c }
        L_0x0057:
            int r1 = r1 + 1
            goto L_0x002a
        L_0x005a:
            monitor-exit(r9)
            return
        L_0x005c:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.initialize():void");
    }

    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0;
            if (z) {
                entry.ttl = 0;
            }
            put(str, entry);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r0.delete() == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        new java.lang.Object[1][0] = r0.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.lang.String r7, com.android.volley.Cache.Entry r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r8.data     // Catch:{ all -> 0x004f }
            int r0 = r0.length     // Catch:{ all -> 0x004f }
            r6.pruneIfNeeded(r0)     // Catch:{ all -> 0x004f }
            java.io.File r0 = r6.getFileForKey(r7)     // Catch:{ all -> 0x004f }
            r1 = 0
            r2 = 1
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x003f }
            java.io.OutputStream r4 = r6.createOutputStream(r0)     // Catch:{ IOException -> 0x003f }
            r3.<init>(r4)     // Catch:{ IOException -> 0x003f }
            com.android.volley.toolbox.DiskBasedCache$CacheHeader r4 = new com.android.volley.toolbox.DiskBasedCache$CacheHeader     // Catch:{ IOException -> 0x003f }
            r4.<init>(r7, r8)     // Catch:{ IOException -> 0x003f }
            boolean r5 = r4.writeHeader(r3)     // Catch:{ IOException -> 0x003f }
            if (r5 == 0) goto L_0x002e
            byte[] r8 = r8.data     // Catch:{ IOException -> 0x003f }
            r3.write(r8)     // Catch:{ IOException -> 0x003f }
            r3.close()     // Catch:{ IOException -> 0x003f }
            r6.putEntry(r7, r4)     // Catch:{ IOException -> 0x003f }
            monitor-exit(r6)
            return
        L_0x002e:
            r3.close()     // Catch:{ IOException -> 0x003f }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x003f }
            java.lang.String r8 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x003f }
            r7[r1] = r8     // Catch:{ IOException -> 0x003f }
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x003f }
            r7.<init>()     // Catch:{ IOException -> 0x003f }
            throw r7     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            boolean r7 = r0.delete()     // Catch:{ all -> 0x004f }
            if (r7 != 0) goto L_0x004d
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x004f }
            java.lang.String r8 = r0.getAbsolutePath()     // Catch:{ all -> 0x004f }
            r7[r1] = r8     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r6)
            return
        L_0x004f:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.DiskBasedCache.put(java.lang.String, com.android.volley.Cache$Entry):void");
    }

    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            Object[] objArr = {str, getFilenameForKey(str)};
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    private void pruneIfNeeded(int i2) {
        int i3;
        long j = this.mTotalSize;
        long j2 = (long) i2;
        if (j + j2 >= ((long) this.mMaxCacheSizeInBytes)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, CacheHeader>> it2 = this.mEntries.entrySet().iterator();
            int i4 = 0;
            while (it2.hasNext()) {
                CacheHeader cacheHeader = (CacheHeader) it2.next().getValue();
                if (getFileForKey(cacheHeader.key).delete()) {
                    i3 = i4;
                    this.mTotalSize -= cacheHeader.size;
                } else {
                    i3 = i4;
                    Object[] objArr = {cacheHeader.key, getFilenameForKey(cacheHeader.key)};
                }
                it2.remove();
                i4 = i3 + 1;
                if (((float) (this.mTotalSize + j2)) < ((float) this.mMaxCacheSizeInBytes) * HYSTERESIS_FACTOR) {
                    break;
                }
            }
            int i5 = i4;
            if (VolleyLog.DEBUG) {
                Object[] objArr2 = {Integer.valueOf(i5), Long.valueOf(this.mTotalSize - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)};
            }
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader remove = this.mEntries.remove(str);
        if (remove != null) {
            this.mTotalSize -= remove.size;
        }
    }

    static byte[] streamToBytes(CountingInputStream countingInputStream, long j) throws IOException {
        long bytesRemaining = countingInputStream.bytesRemaining();
        if (j >= 0 && j <= bytesRemaining) {
            int i2 = (int) j;
            if (((long) i2) == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(countingInputStream).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + bytesRemaining);
    }

    /* access modifiers changed from: package-private */
    public InputStream createInputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /* access modifiers changed from: package-private */
    public OutputStream createOutputStream(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    static class CacheHeader {
        final List<Header> allResponseHeaders;
        final String etag;
        final String key;
        final long lastModified;
        final long serverDate;
        long size;
        final long softTtl;
        final long ttl;

        private CacheHeader(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.key = str;
            this.etag = "".equals(str2) ? null : str2;
            this.serverDate = j;
            this.lastModified = j2;
            this.ttl = j3;
            this.softTtl = j4;
            this.allResponseHeaders = list;
        }

        CacheHeader(String str, Cache.Entry entry) {
            this(str, entry.etag, entry.serverDate, entry.lastModified, entry.ttl, entry.softTtl, getAllResponseHeaders(entry));
            this.size = (long) entry.data.length;
        }

        private static List<Header> getAllResponseHeaders(Cache.Entry entry) {
            if (entry.allResponseHeaders != null) {
                return entry.allResponseHeaders;
            }
            return HttpHeaderParser.toAllHeaderList(entry.responseHeaders);
        }

        static CacheHeader readHeader(CountingInputStream countingInputStream) throws IOException {
            if (DiskBasedCache.readInt(countingInputStream) == DiskBasedCache.CACHE_MAGIC) {
                return new CacheHeader(DiskBasedCache.readString(countingInputStream), DiskBasedCache.readString(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readLong(countingInputStream), DiskBasedCache.readHeaderList(countingInputStream));
            }
            throw new IOException();
        }

        /* access modifiers changed from: package-private */
        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
            entry.allResponseHeaders = Collections.unmodifiableList(this.allResponseHeaders);
            return entry;
        }

        /* access modifiers changed from: package-private */
        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                DiskBasedCache.writeString(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeHeaderList(this.allResponseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                new Object[1][0] = e2.toString();
                return false;
            }
        }
    }

    static class CountingInputStream extends FilterInputStream {
        private long bytesRead;
        private final long length;

        CountingInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.length = j;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.bytesRead += (long) read;
            }
            return read;
        }

        /* access modifiers changed from: package-private */
        public long bytesRead() {
            return this.bytesRead;
        }

        /* access modifiers changed from: package-private */
        public long bytesRemaining() {
            return this.length - this.bytesRead;
        }
    }

    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i2) throws IOException {
        outputStream.write((i2 >> 0) & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        outputStream.write((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static long readLong(InputStream inputStream) throws IOException {
        return ((((long) read(inputStream)) & 255) << 0) | 0 | ((((long) read(inputStream)) & 255) << 8) | ((((long) read(inputStream)) & 255) << 16) | ((((long) read(inputStream)) & 255) << 24) | ((((long) read(inputStream)) & 255) << 32) | ((((long) read(inputStream)) & 255) << 40) | ((((long) read(inputStream)) & 255) << 48) | ((255 & ((long) read(inputStream))) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(AppConstants.UTF_8);
        writeLong(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String readString(CountingInputStream countingInputStream) throws IOException {
        return new String(streamToBytes(countingInputStream, readLong(countingInputStream)), AppConstants.UTF_8);
    }

    static void writeHeaderList(List<Header> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            writeInt(outputStream, list.size());
            for (Header next : list) {
                writeString(outputStream, next.getName());
                writeString(outputStream, next.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    static List<Header> readHeaderList(CountingInputStream countingInputStream) throws IOException {
        int readInt = readInt(countingInputStream);
        if (readInt >= 0) {
            List<Header> emptyList = readInt == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i2 = 0; i2 < readInt; i2++) {
                emptyList.add(new Header(readString(countingInputStream).intern(), readString(countingInputStream).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=".concat(String.valueOf(readInt)));
    }
}
