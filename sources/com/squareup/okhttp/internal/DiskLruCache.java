package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import i.c;
import i.d;
import i.n;
import i.u;
import i.v;
import i.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class DiskLruCache implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    /* access modifiers changed from: private */
    public static final u NULL_SINK = new u() {
        public final void close() throws IOException {
        }

        public final void flush() throws IOException {
        }

        public final void write(c cVar, long j) throws IOException {
            cVar.i(j);
        }

        public final w timeout() {
            return w.NONE;
        }
    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new Runnable() {
        public void run() {
            synchronized (DiskLruCache.this) {
                if (!(!DiskLruCache.this.initialized) && !DiskLruCache.this.closed) {
                    try {
                        DiskLruCache.this.trimToSize();
                        if (DiskLruCache.this.journalRebuildRequired()) {
                            DiskLruCache.this.rebuildJournal();
                            int unused = DiskLruCache.this.redundantOpCount = 0;
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean closed;
    /* access modifiers changed from: private */
    public final File directory;
    private final Executor executor;
    /* access modifiers changed from: private */
    public final FileSystem fileSystem;
    /* access modifiers changed from: private */
    public boolean hasJournalErrors;
    /* access modifiers changed from: private */
    public boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private d journalWriter;
    /* access modifiers changed from: private */
    public final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size = 0;
    /* access modifiers changed from: private */
    public final int valueCount;

    DiskLruCache(FileSystem fileSystem2, File file, int i2, int i3, long j, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i2;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i3;
        this.maxSize = j;
        this.executor = executor2;
    }

    public final synchronized void initialize() throws IOException {
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e2) {
                    Platform platform = Platform.get();
                    platform.logW("DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing");
                    delete();
                    this.closed = false;
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i2, int i3, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            return new DiskLruCache(fileSystem2, file, i2, i3, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.d() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.squareup.okhttp.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            i.v r1 = r1.source(r2)
            i.e r1 = i.n.a((i.v) r1)
            java.lang.String r2 = r1.r()     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = r1.r()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = r1.r()     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r1.r()     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = r1.r()     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.appVersion     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a6 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a6 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.valueCount     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a6 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a6 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a6 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.r()     // Catch:{ EOFException -> 0x005d }
            r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, com.squareup.okhttp.internal.DiskLruCache$Entry> r2 = r9.lruEntries     // Catch:{ all -> 0x00a6 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a6 }
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch:{ all -> 0x00a6 }
            boolean r0 = r1.d()     // Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0070
            r9.rebuildJournal()     // Catch:{ all -> 0x00a6 }
            goto L_0x0076
        L_0x0070:
            i.d r0 = r9.newJournalWriter()     // Catch:{ all -> 0x00a6 }
            r9.journalWriter = r0     // Catch:{ all -> 0x00a6 }
        L_0x0076:
            com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.<init>(r8)     // Catch:{ all -> 0x00a6 }
            r7.append(r2)     // Catch:{ all -> 0x00a6 }
            r7.append(r0)     // Catch:{ all -> 0x00a6 }
            r7.append(r3)     // Catch:{ all -> 0x00a6 }
            r7.append(r0)     // Catch:{ all -> 0x00a6 }
            r7.append(r5)     // Catch:{ all -> 0x00a6 }
            r7.append(r0)     // Catch:{ all -> 0x00a6 }
            r7.append(r6)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a6 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a6 }
            throw r4     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            com.squareup.okhttp.internal.Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.DiskLruCache.readJournal():void");
    }

    private d newJournalWriter() throws FileNotFoundException {
        return n.a((u) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<DiskLruCache> cls = DiskLruCache.class;
            }

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                boolean unused = DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = entry.readable = true;
                Editor unused2 = entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                Editor unused3 = entry.currentEditor = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(READ)) {
                throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it2 = this.lruEntries.values().iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            int i2 = 0;
            if (next.currentEditor == null) {
                while (i2 < this.valueCount) {
                    this.size += next.lengths[i2];
                    i2++;
                }
            } else {
                Editor unused = next.currentEditor = null;
                while (i2 < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i2]);
                    this.fileSystem.delete(next.dirtyFiles[i2]);
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        d a2 = n.a(this.fileSystem.sink(this.journalFileTmp));
        try {
            a2.b(MAGIC).j(10);
            a2.b("1").j(10);
            a2.n((long) this.appVersion).j(10);
            a2.n((long) this.valueCount).j(10);
            a2.j(10);
            for (Entry next : this.lruEntries.values()) {
                if (next.currentEditor != null) {
                    a2.b(DIRTY).j(32);
                    a2.b(next.key);
                    a2.j(10);
                } else {
                    a2.b(CLEAN).j(32);
                    a2.b(next.key);
                    next.writeLengths(a2);
                    a2.j(10);
                }
            }
            a2.close();
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.squareup.okhttp.internal.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x0052 }
            r3.checkNotClosed()     // Catch:{ all -> 0x0052 }
            r3.validateKey(r4)     // Catch:{ all -> 0x0052 }
            java.util.LinkedHashMap<java.lang.String, com.squareup.okhttp.internal.DiskLruCache$Entry> r0 = r3.lruEntries     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0052 }
            com.squareup.okhttp.internal.DiskLruCache$Entry r0 = (com.squareup.okhttp.internal.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0052 }
            r1 = 0
            if (r0 == 0) goto L_0x0050
            boolean r2 = r0.readable     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x001c
            goto L_0x0050
        L_0x001c:
            com.squareup.okhttp.internal.DiskLruCache$Snapshot r0 = r0.snapshot()     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x0024
            monitor-exit(r3)
            return r1
        L_0x0024:
            int r1 = r3.redundantOpCount     // Catch:{ all -> 0x0052 }
            int r1 = r1 + 1
            r3.redundantOpCount = r1     // Catch:{ all -> 0x0052 }
            i.d r1 = r3.journalWriter     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "READ"
            i.d r1 = r1.b(r2)     // Catch:{ all -> 0x0052 }
            r2 = 32
            i.d r1 = r1.j(r2)     // Catch:{ all -> 0x0052 }
            i.d r4 = r1.b(r4)     // Catch:{ all -> 0x0052 }
            r1 = 10
            r4.j(r1)     // Catch:{ all -> 0x0052 }
            boolean r4 = r3.journalRebuildRequired()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004e
            java.util.concurrent.Executor r4 = r3.executor     // Catch:{ all -> 0x0052 }
            java.lang.Runnable r1 = r3.cleanupRunnable     // Catch:{ all -> 0x0052 }
            r4.execute(r1)     // Catch:{ all -> 0x0052 }
        L_0x004e:
            monitor-exit(r3)
            return r0
        L_0x0050:
            monitor-exit(r3)
            return r1
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.DiskLruCache.get(java.lang.String):com.squareup.okhttp.internal.DiskLruCache$Snapshot");
    }

    public final Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.squareup.okhttp.internal.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0067 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0067 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0067 }
            java.util.LinkedHashMap<java.lang.String, com.squareup.okhttp.internal.DiskLruCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0067 }
            com.squareup.okhttp.internal.DiskLruCache$Entry r0 = (com.squareup.okhttp.internal.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0067 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x0023
            long r1 = r0.sequenceNumber     // Catch:{ all -> 0x0067 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0025
        L_0x0023:
            monitor-exit(r5)
            return r3
        L_0x0025:
            if (r0 == 0) goto L_0x002f
            com.squareup.okhttp.internal.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0067 }
            if (r7 == 0) goto L_0x002f
            monitor-exit(r5)
            return r3
        L_0x002f:
            i.d r7 = r5.journalWriter     // Catch:{ all -> 0x0067 }
            java.lang.String r8 = "DIRTY"
            i.d r7 = r7.b(r8)     // Catch:{ all -> 0x0067 }
            r8 = 32
            i.d r7 = r7.j(r8)     // Catch:{ all -> 0x0067 }
            i.d r7 = r7.b(r6)     // Catch:{ all -> 0x0067 }
            r8 = 10
            r7.j(r8)     // Catch:{ all -> 0x0067 }
            i.d r7 = r5.journalWriter     // Catch:{ all -> 0x0067 }
            r7.flush()     // Catch:{ all -> 0x0067 }
            boolean r7 = r5.hasJournalErrors     // Catch:{ all -> 0x0067 }
            if (r7 == 0) goto L_0x0051
            monitor-exit(r5)
            return r3
        L_0x0051:
            if (r0 != 0) goto L_0x005d
            com.squareup.okhttp.internal.DiskLruCache$Entry r0 = new com.squareup.okhttp.internal.DiskLruCache$Entry     // Catch:{ all -> 0x0067 }
            r0.<init>(r6)     // Catch:{ all -> 0x0067 }
            java.util.LinkedHashMap<java.lang.String, com.squareup.okhttp.internal.DiskLruCache$Entry> r7 = r5.lruEntries     // Catch:{ all -> 0x0067 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0067 }
        L_0x005d:
            com.squareup.okhttp.internal.DiskLruCache$Editor r6 = new com.squareup.okhttp.internal.DiskLruCache$Editor     // Catch:{ all -> 0x0067 }
            r6.<init>(r0)     // Catch:{ all -> 0x0067 }
            com.squareup.okhttp.internal.DiskLruCache.Editor unused = r0.currentEditor = r6     // Catch:{ all -> 0x0067 }
            monitor-exit(r5)
            return r6
        L_0x0067:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.DiskLruCache.edit(java.lang.String, long):com.squareup.okhttp.internal.DiskLruCache$Editor");
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(com.squareup.okhttp.internal.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.squareup.okhttp.internal.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x0111 }
            com.squareup.okhttp.internal.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x0111 }
            if (r1 != r10) goto L_0x010b
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.readable     // Catch:{ all -> 0x0111 }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x0015:
            int r3 = r9.valueCount     // Catch:{ all -> 0x0111 }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.written     // Catch:{ all -> 0x0111 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0111 }
            if (r3 == 0) goto L_0x0037
            com.squareup.okhttp.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x0111 }
            java.io.File[] r4 = r0.dirtyFiles     // Catch:{ all -> 0x0111 }
            r4 = r4[r2]     // Catch:{ all -> 0x0111 }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x0111 }
            if (r3 != 0) goto L_0x0034
            r10.abort()     // Catch:{ all -> 0x0111 }
            monitor-exit(r9)
            return
        L_0x0034:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0037:
            r10.abort()     // Catch:{ all -> 0x0111 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = "Newly created entry didn't create value for index "
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = r11.concat(r0)     // Catch:{ all -> 0x0111 }
            r10.<init>(r11)     // Catch:{ all -> 0x0111 }
            throw r10     // Catch:{ all -> 0x0111 }
        L_0x004a:
            int r10 = r9.valueCount     // Catch:{ all -> 0x0111 }
            if (r1 >= r10) goto L_0x008a
            java.io.File[] r10 = r0.dirtyFiles     // Catch:{ all -> 0x0111 }
            r10 = r10[r1]     // Catch:{ all -> 0x0111 }
            if (r11 == 0) goto L_0x0082
            com.squareup.okhttp.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x0111 }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x0111 }
            if (r2 == 0) goto L_0x0087
            java.io.File[] r2 = r0.cleanFiles     // Catch:{ all -> 0x0111 }
            r2 = r2[r1]     // Catch:{ all -> 0x0111 }
            com.squareup.okhttp.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x0111 }
            r3.rename(r10, r2)     // Catch:{ all -> 0x0111 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x0111 }
            r3 = r10[r1]     // Catch:{ all -> 0x0111 }
            com.squareup.okhttp.internal.io.FileSystem r10 = r9.fileSystem     // Catch:{ all -> 0x0111 }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x0111 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x0111 }
            r10[r1] = r5     // Catch:{ all -> 0x0111 }
            long r7 = r9.size     // Catch:{ all -> 0x0111 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.size = r7     // Catch:{ all -> 0x0111 }
            goto L_0x0087
        L_0x0082:
            com.squareup.okhttp.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x0111 }
            r2.delete(r10)     // Catch:{ all -> 0x0111 }
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x008a:
            int r10 = r9.redundantOpCount     // Catch:{ all -> 0x0111 }
            r1 = 1
            int r10 = r10 + r1
            r9.redundantOpCount = r10     // Catch:{ all -> 0x0111 }
            r10 = 0
            com.squareup.okhttp.internal.DiskLruCache.Editor unused = r0.currentEditor = r10     // Catch:{ all -> 0x0111 }
            boolean r10 = r0.readable     // Catch:{ all -> 0x0111 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00cd
            boolean unused = r0.readable = r1     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = "CLEAN"
            i.d r10 = r10.b(r1)     // Catch:{ all -> 0x0111 }
            r10.j(r3)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = r0.key     // Catch:{ all -> 0x0111 }
            r10.b(r1)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            r0.writeLengths(r10)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            r10.j(r2)     // Catch:{ all -> 0x0111 }
            if (r11 == 0) goto L_0x00ef
            long r10 = r9.nextSequenceNumber     // Catch:{ all -> 0x0111 }
            r1 = 1
            long r1 = r1 + r10
            r9.nextSequenceNumber = r1     // Catch:{ all -> 0x0111 }
            long unused = r0.sequenceNumber = r10     // Catch:{ all -> 0x0111 }
            goto L_0x00ef
        L_0x00cd:
            java.util.LinkedHashMap<java.lang.String, com.squareup.okhttp.internal.DiskLruCache$Entry> r10 = r9.lruEntries     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x0111 }
            r10.remove(r11)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = "REMOVE"
            i.d r10 = r10.b(r11)     // Catch:{ all -> 0x0111 }
            r10.j(r3)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x0111 }
            r10.b(r11)     // Catch:{ all -> 0x0111 }
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            r10.j(r2)     // Catch:{ all -> 0x0111 }
        L_0x00ef:
            i.d r10 = r9.journalWriter     // Catch:{ all -> 0x0111 }
            r10.flush()     // Catch:{ all -> 0x0111 }
            long r10 = r9.size     // Catch:{ all -> 0x0111 }
            long r0 = r9.maxSize     // Catch:{ all -> 0x0111 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0102
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x0111 }
            if (r10 == 0) goto L_0x0109
        L_0x0102:
            java.util.concurrent.Executor r10 = r9.executor     // Catch:{ all -> 0x0111 }
            java.lang.Runnable r11 = r9.cleanupRunnable     // Catch:{ all -> 0x0111 }
            r10.execute(r11)     // Catch:{ all -> 0x0111 }
        L_0x0109:
            monitor-exit(r9)
            return
        L_0x010b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0111 }
            r10.<init>()     // Catch:{ all -> 0x0111 }
            throw r10     // Catch:{ all -> 0x0111 }
        L_0x0111:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.DiskLruCache.completeEdit(com.squareup.okhttp.internal.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i2 = this.redundantOpCount;
        return i2 >= 2000 && i2 >= this.lruEntries.size();
    }

    public final synchronized boolean remove(String str) throws IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        return removeEntry(entry);
    }

    /* access modifiers changed from: private */
    public boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            boolean unused = entry.currentEditor.hasErrors = true;
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            this.fileSystem.delete(entry.cleanFiles[i2]);
            this.size -= entry.lengths[i2];
            entry.lengths[i2] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.b(REMOVE).j(32).b(entry.key).j(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public final synchronized void close() throws IOException {
        if (this.initialized) {
            if (!this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
        }
        this.closed = true;
    }

    /* access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        for (Entry removeEntry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
            removeEntry(removeEntry);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {
            final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = this.delegate.next().snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            public Snapshot next() {
                if (hasNext()) {
                    this.removeSnapshot = this.nextSnapshot;
                    this.nextSnapshot = null;
                    return this.removeSnapshot;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.remove(snapshot.key);
                    } catch (IOException unused) {
                    } finally {
                        this.removeSnapshot = null;
                    }
                } else {
                    throw new IllegalStateException("remove() before next()");
                }
            }
        };
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final v[] sources;

        private Snapshot(String str, long j, v[] vVarArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = vVarArr;
            this.lengths = jArr;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final v getSource(int i2) {
            return this.sources[i2];
        }

        public final long getLength(int i2) {
            return this.lengths[i2];
        }

        public final void close() {
            for (v closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }
    }

    public final class Editor {
        private boolean committed;
        /* access modifiers changed from: private */
        public final Entry entry;
        /* access modifiers changed from: private */
        public boolean hasErrors;
        /* access modifiers changed from: private */
        public final boolean[] written;

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public final v newSource(int i2) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        v source = DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i2]);
                        return source;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        public final u newSink(int i2) throws IOException {
            AnonymousClass1 r1;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor == this) {
                    if (!this.entry.readable) {
                        this.written[i2] = true;
                    }
                    try {
                        r1 = new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i2])) {
                            /* access modifiers changed from: protected */
                            public void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    boolean unused = Editor.this.hasErrors = true;
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return DiskLruCache.NULL_SINK;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return r1;
        }

        public final void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.hasErrors) {
                    DiskLruCache.this.completeEdit(this, false);
                    boolean unused = DiskLruCache.this.removeEntry(this.entry);
                } else {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.committed = true;
            }
        }

        public final void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                DiskLruCache.this.completeEdit(this, false);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void abortUnlessCommitted() {
            /*
                r3 = this;
                com.squareup.okhttp.internal.DiskLruCache r0 = com.squareup.okhttp.internal.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.committed     // Catch:{ all -> 0x000f }
                if (r1 != 0) goto L_0x000d
                com.squareup.okhttp.internal.DiskLruCache r1 = com.squareup.okhttp.internal.DiskLruCache.this     // Catch:{ IOException -> 0x000d }
                r2 = 0
                r1.completeEdit(r3, r2)     // Catch:{ IOException -> 0x000d }
            L_0x000d:
                monitor-exit(r0)     // Catch:{ all -> 0x000f }
                return
            L_0x000f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x000f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.DiskLruCache.Editor.abortUnlessCommitted():void");
        }
    }

    final class Entry {
        /* access modifiers changed from: private */
        public final File[] cleanFiles;
        /* access modifiers changed from: private */
        public Editor currentEditor;
        /* access modifiers changed from: private */
        public final File[] dirtyFiles;
        /* access modifiers changed from: private */
        public final String key;
        /* access modifiers changed from: private */
        public final long[] lengths;
        /* access modifiers changed from: private */
        public boolean readable;
        /* access modifiers changed from: private */
        public long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.valueCount; i2++) {
                sb.append(i2);
                this.cleanFiles[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.lengths[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        /* access modifiers changed from: package-private */
        public final void writeLengths(d dVar) throws IOException {
            for (long n : this.lengths) {
                dVar.j(32).n(n);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public final Snapshot snapshot() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                v[] vVarArr = new v[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.lengths.clone();
                int i2 = 0;
                int i3 = 0;
                while (i3 < DiskLruCache.this.valueCount) {
                    try {
                        vVarArr[i3] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i3]);
                        i3++;
                    } catch (FileNotFoundException unused) {
                        while (i2 < DiskLruCache.this.valueCount && vVarArr[i2] != null) {
                            Util.closeQuietly((Closeable) vVarArr[i2]);
                            i2++;
                        }
                        return null;
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, vVarArr, jArr);
            }
            throw new AssertionError();
        }
    }
}
