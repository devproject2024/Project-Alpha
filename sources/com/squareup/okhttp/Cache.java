package com.squareup.okhttp;

import com.alipay.mobile.h5container.api.H5Param;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import i.c;
import i.d;
import i.e;
import i.f;
import i.h;
import i.i;
import i.n;
import i.u;
import i.v;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Cache {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    /* access modifiers changed from: private */
    public final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    static /* synthetic */ int access$808(Cache cache2) {
        int i2 = cache2.writeSuccessCount;
        cache2.writeSuccessCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$908(Cache cache2) {
        int i2 = cache2.writeAbortCount;
        cache2.writeAbortCount = i2 + 1;
        return i2;
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() {
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            public void update(Response response, Response response2) throws IOException {
                Cache.this.update(response, response2);
            }

            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    private static String urlToKey(Request request) {
        return Util.md5Hex(request.urlString());
    }

    /* access modifiers changed from: package-private */
    public final Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(urlToKey(request));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(request, snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly((Closeable) response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public CacheRequest put(Response response) throws IOException {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD) || OkHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(urlToKey(response.request()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void remove(Request request) throws IOException {
        this.cache.remove(urlToKey(request));
    }

    /* access modifiers changed from: private */
    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public final Iterator<String> urls() throws IOException {
        return new Iterator<String>() {
            boolean canRemove;
            final Iterator<DiskLruCache.Snapshot> delegate = Cache.this.cache.snapshots();
            String nextUrl;

            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        this.nextUrl = n.a(next.getSource(0)).r();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }
        };
    }

    public final synchronized int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long getSize() throws IOException {
        return this.cache.size();
    }

    public final long getMaxSize() {
        return this.cache.getMaxSize();
    }

    public final void flush() throws IOException {
        this.cache.flush();
    }

    public final void close() throws IOException {
        this.cache.close();
    }

    public final File getDirectory() {
        return this.cache.getDirectory();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trackResponse(com.squareup.okhttp.internal.http.CacheStrategy r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            int r0 = r1.requestCount     // Catch:{ all -> 0x001f }
            int r0 = r0 + 1
            r1.requestCount = r0     // Catch:{ all -> 0x001f }
            com.squareup.okhttp.Request r0 = r2.networkRequest     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0013
            int r2 = r1.networkCount     // Catch:{ all -> 0x001f }
            int r2 = r2 + 1
            r1.networkCount = r2     // Catch:{ all -> 0x001f }
            monitor-exit(r1)
            return
        L_0x0013:
            com.squareup.okhttp.Response r2 = r2.cacheResponse     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            int r2 = r1.hitCount     // Catch:{ all -> 0x001f }
            int r2 = r2 + 1
            r1.hitCount = r2     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.Cache.trackResponse(com.squareup.okhttp.internal.http.CacheStrategy):void");
    }

    /* access modifiers changed from: private */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public final synchronized int getNetworkCount() {
        return this.networkCount;
    }

    public final synchronized int getHitCount() {
        return this.hitCount;
    }

    public final synchronized int getRequestCount() {
        return this.requestCount;
    }

    final class CacheRequestImpl implements CacheRequest {
        private u body;
        private u cacheOut;
        /* access modifiers changed from: private */
        public boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(final DiskLruCache.Editor editor2) throws IOException {
            this.editor = editor2;
            this.cacheOut = editor2.newSink(1);
            this.body = new h(this.cacheOut, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!CacheRequestImpl.this.done) {
                            boolean unused = CacheRequestImpl.this.done = true;
                            Cache.access$808(Cache.this);
                            super.close();
                            editor2.commit();
                        }
                    }
                }
            };
        }

        public final void abort() {
            synchronized (Cache.this) {
                if (!this.done) {
                    this.done = true;
                    Cache.access$908(Cache.this);
                    Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public final u body() {
            return this.body;
        }
    }

    static final class Entry {
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final String url;
        private final Headers varyHeaders;

        public Entry(v vVar) throws IOException {
            try {
                e a2 = n.a(vVar);
                this.url = a2.r();
                this.requestMethod = a2.r();
                Headers.Builder builder = new Headers.Builder();
                int access$1000 = Cache.readInt(a2);
                for (int i2 = 0; i2 < access$1000; i2++) {
                    builder.addLenient(a2.r());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(a2.r());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int access$10002 = Cache.readInt(a2);
                for (int i3 = 0; i3 < access$10002; i3++) {
                    builder2.addLenient(a2.r());
                }
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String r = a2.r();
                    if (r.length() <= 0) {
                        this.handshake = Handshake.get(a2.r(), readCertificateList(a2), readCertificateList(a2));
                    } else {
                        throw new IOException("expected \"\" but was \"" + r + "\"");
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                vVar.close();
            }
        }

        public Entry(Response response) {
            this.url = response.request().urlString();
            this.varyHeaders = OkHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            d a2 = n.a(editor.newSink(0));
            a2.b(this.url);
            a2.j(10);
            a2.b(this.requestMethod);
            a2.j(10);
            a2.n((long) this.varyHeaders.size());
            a2.j(10);
            int size = this.varyHeaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2.b(this.varyHeaders.name(i2));
                a2.b(": ");
                a2.b(this.varyHeaders.value(i2));
                a2.j(10);
            }
            a2.b(new StatusLine(this.protocol, this.code, this.message).toString());
            a2.j(10);
            a2.n((long) this.responseHeaders.size());
            a2.j(10);
            int size2 = this.responseHeaders.size();
            for (int i3 = 0; i3 < size2; i3++) {
                a2.b(this.responseHeaders.name(i3));
                a2.b(": ");
                a2.b(this.responseHeaders.value(i3));
                a2.j(10);
            }
            if (isHttps()) {
                a2.j(10);
                a2.b(this.handshake.cipherSuite());
                a2.j(10);
                writeCertList(a2, this.handshake.peerCertificates());
                writeCertList(a2, this.handshake.localCertificates());
            }
            a2.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(e eVar) throws IOException {
            int access$1000 = Cache.readInt(eVar);
            if (access$1000 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(access$1000);
                for (int i2 = 0; i2 < access$1000; i2++) {
                    String r = eVar.r();
                    c cVar = new c();
                    cVar.d(f.decodeBase64(r));
                    arrayList.add(instance.generateCertificate(cVar.e()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void writeCertList(d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.n((long) list.size());
                dVar.j(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    dVar.b(f.of(list.get(i2).getEncoded()).base64());
                    dVar.j(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            return this.url.equals(request.urlString()) && this.requestMethod.equals(request.method()) && OkHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(Request request, DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).build();
        }
    }

    /* access modifiers changed from: private */
    public static int readInt(e eVar) throws IOException {
        try {
            long n = eVar.n();
            String r = eVar.r();
            if (n >= 0 && n <= 2147483647L && r.isEmpty()) {
                return (int) n;
            }
            throw new IOException("expected an int but was \"" + n + r + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    static class CacheResponseBody extends ResponseBody {
        private final e bodySource;
        private final String contentLength;
        private final String contentType;
        /* access modifiers changed from: private */
        public final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = n.a((v) new i(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    snapshot2.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public long contentLength() {
            try {
                if (this.contentLength != null) {
                    return Long.parseLong(this.contentLength);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public e source() {
            return this.bodySource;
        }
    }
}
