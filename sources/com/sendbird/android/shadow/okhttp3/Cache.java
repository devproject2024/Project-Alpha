package com.sendbird.android.shadow.okhttp3;

import com.alipay.mobile.h5container.api.H5Param;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheRequest;
import com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy;
import com.sendbird.android.shadow.okhttp3.internal.cache.DiskLruCache;
import com.sendbird.android.shadow.okhttp3.internal.cache.InternalCache;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpHeaders;
import com.sendbird.android.shadow.okhttp3.internal.http.HttpMethod;
import com.sendbird.android.shadow.okhttp3.internal.http.StatusLine;
import com.sendbird.android.shadow.okhttp3.internal.io.FileSystem;
import com.sendbird.android.shadow.okhttp3.internal.platform.Platform;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.ForwardingSource;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
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

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() {
            public final Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            public final CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            public final void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            public final void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }

            public final void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            public final void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    /* access modifiers changed from: package-private */
    public final Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                boolean z = false;
                c cVar = new c(snapshot.getSource(0));
                String str = cVar.f45015g.get("Content-Type");
                String str2 = cVar.f45015g.get("Content-Length");
                Response build = new Response.Builder().request(new Request.Builder().url(cVar.f45009a).method(cVar.f45011c, (RequestBody) null).headers(cVar.f45010b).build()).protocol(cVar.f45012d).code(cVar.f45013e).message(cVar.f45014f).headers(cVar.f45015g).body(new b(snapshot, str, str2)).handshake(cVar.f45016h).sentRequestAtMillis(cVar.f45017i).receivedResponseAtMillis(cVar.j).build();
                if (cVar.f45009a.equals(request.url().toString()) && cVar.f45011c.equals(request.method()) && HttpHeaders.varyMatches(build, cVar.f45010b, request)) {
                    z = true;
                }
                if (z) {
                    return build;
                }
                Util.closeQuietly((Closeable) build.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD) || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            c cVar = new c(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    cVar.a(editor);
                    return new a(editor);
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

    /* access modifiers changed from: package-private */
    public final void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    /* access modifiers changed from: package-private */
    public final void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        c cVar = new c(response2);
        try {
            editor = ((b) response.body()).f45003a.edit();
            if (editor != null) {
                try {
                    cVar.a(editor);
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

            /* renamed from: a  reason: collision with root package name */
            final Iterator<DiskLruCache.Snapshot> f44991a = Cache.this.cache.snapshots();

            /* renamed from: b  reason: collision with root package name */
            String f44992b;

            /* renamed from: c  reason: collision with root package name */
            boolean f44993c;

            public final boolean hasNext() {
                if (this.f44992b != null) {
                    return true;
                }
                this.f44993c = false;
                while (this.f44991a.hasNext()) {
                    DiskLruCache.Snapshot next = this.f44991a.next();
                    try {
                        this.f44992b = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            public final void remove() {
                if (this.f44993c) {
                    this.f44991a.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }

            public final /* synthetic */ Object next() {
                if (hasNext()) {
                    String str = this.f44992b;
                    this.f44992b = null;
                    this.f44993c = true;
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final void flush() throws IOException {
        this.cache.flush();
    }

    public final void close() throws IOException {
        this.cache.close();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void trackResponse(com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            int r0 = r1.requestCount     // Catch:{ all -> 0x001f }
            int r0 = r0 + 1
            r1.requestCount = r0     // Catch:{ all -> 0x001f }
            com.sendbird.android.shadow.okhttp3.Request r0 = r2.networkRequest     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0013
            int r2 = r1.networkCount     // Catch:{ all -> 0x001f }
            int r2 = r2 + 1
            r1.networkCount = r2     // Catch:{ all -> 0x001f }
            monitor-exit(r1)
            return
        L_0x0013:
            com.sendbird.android.shadow.okhttp3.Response r2 = r2.cacheResponse     // Catch:{ all -> 0x001f }
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
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.Cache.trackResponse(com.sendbird.android.shadow.okhttp3.internal.cache.CacheStrategy):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    final class a implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        boolean f44995a;

        /* renamed from: c  reason: collision with root package name */
        private final DiskLruCache.Editor f44997c;

        /* renamed from: d  reason: collision with root package name */
        private Sink f44998d;

        /* renamed from: e  reason: collision with root package name */
        private Sink f44999e;

        a(final DiskLruCache.Editor editor) {
            this.f44997c = editor;
            this.f44998d = editor.newSink(1);
            this.f44999e = new ForwardingSink(this.f44998d, Cache.this) {
                public final void close() throws IOException {
                    synchronized (Cache.this) {
                        if (!a.this.f44995a) {
                            a.this.f44995a = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            editor.commit();
                        }
                    }
                }
            };
        }

        public final void abort() {
            synchronized (Cache.this) {
                if (!this.f44995a) {
                    this.f44995a = true;
                    Cache.this.writeAbortCount++;
                    Util.closeQuietly((Closeable) this.f44998d);
                    try {
                        this.f44997c.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public final Sink body() {
            return this.f44999e;
        }
    }

    static final class c {
        private static final String k = (Platform.get().getPrefix() + "-Sent-Millis");
        private static final String l = (Platform.get().getPrefix() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        final String f45009a;

        /* renamed from: b  reason: collision with root package name */
        final Headers f45010b;

        /* renamed from: c  reason: collision with root package name */
        final String f45011c;

        /* renamed from: d  reason: collision with root package name */
        final Protocol f45012d;

        /* renamed from: e  reason: collision with root package name */
        final int f45013e;

        /* renamed from: f  reason: collision with root package name */
        final String f45014f;

        /* renamed from: g  reason: collision with root package name */
        final Headers f45015g;

        /* renamed from: h  reason: collision with root package name */
        final Handshake f45016h;

        /* renamed from: i  reason: collision with root package name */
        final long f45017i;
        final long j;

        c(Source source) throws IOException {
            TlsVersion tlsVersion;
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f45009a = buffer.readUtf8LineStrict();
                this.f45011c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(buffer);
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.f45010b = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f45012d = parse.protocol;
                this.f45013e = parse.code;
                this.f45014f = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(buffer);
                for (int i3 = 0; i3 < readInt2; i3++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                String str = builder2.get(k);
                String str2 = builder2.get(l);
                builder2.removeAll(k);
                builder2.removeAll(l);
                long j2 = 0;
                this.f45017i = str != null ? Long.parseLong(str) : 0;
                this.j = str2 != null ? Long.parseLong(str2) : j2;
                this.f45015g = builder2.build();
                if (a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(buffer.readUtf8LineStrict());
                        List<Certificate> a2 = a(buffer);
                        List<Certificate> a3 = a(buffer);
                        if (!buffer.exhausted()) {
                            tlsVersion = TlsVersion.forJavaName(buffer.readUtf8LineStrict());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.f45016h = Handshake.get(tlsVersion, forJavaName, a2, a3);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.f45016h = null;
                }
            } finally {
                source.close();
            }
        }

        c(Response response) {
            this.f45009a = response.request().url().toString();
            this.f45010b = HttpHeaders.varyHeaders(response);
            this.f45011c = response.request().method();
            this.f45012d = response.protocol();
            this.f45013e = response.code();
            this.f45014f = response.message();
            this.f45015g = response.headers();
            this.f45016h = response.handshake();
            this.f45017i = response.sentRequestAtMillis();
            this.j = response.receivedResponseAtMillis();
        }

        public final void a(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f45009a).writeByte(10);
            buffer.writeUtf8(this.f45011c).writeByte(10);
            buffer.writeDecimalLong((long) this.f45010b.size()).writeByte(10);
            int size = this.f45010b.size();
            for (int i2 = 0; i2 < size; i2++) {
                buffer.writeUtf8(this.f45010b.name(i2)).writeUtf8(": ").writeUtf8(this.f45010b.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f45012d, this.f45013e, this.f45014f).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.f45015g.size() + 2)).writeByte(10);
            int size2 = this.f45015g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                buffer.writeUtf8(this.f45015g.name(i3)).writeUtf8(": ").writeUtf8(this.f45015g.value(i3)).writeByte(10);
            }
            buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.f45017i).writeByte(10);
            buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.f45016h.cipherSuite().javaName()).writeByte(10);
                a(buffer, this.f45016h.peerCertificates());
                a(buffer, this.f45016h.localCertificates());
                buffer.writeUtf8(this.f45016h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }

        private boolean a() {
            return this.f45009a.startsWith("https://");
        }

        private static List<Certificate> a(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private static void a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i2).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    static class b extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        final DiskLruCache.Snapshot f45003a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f45004b;

        /* renamed from: c  reason: collision with root package name */
        private final String f45005c;

        /* renamed from: d  reason: collision with root package name */
        private final String f45006d;

        b(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f45003a = snapshot;
            this.f45005c = str;
            this.f45006d = str2;
            this.f45004b = Okio.buffer((Source) new ForwardingSource(snapshot.getSource(1)) {
                public final void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public final MediaType contentType() {
            String str = this.f45005c;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public final long contentLength() {
            try {
                if (this.f45006d != null) {
                    return Long.parseLong(this.f45006d);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final BufferedSource source() {
            return this.f45004b;
        }
    }
}
