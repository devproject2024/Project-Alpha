package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import i.d;
import i.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MultipartBuilder {
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    /* access modifiers changed from: private */
    public static final byte[] COLONSPACE = {58, 32};
    /* access modifiers changed from: private */
    public static final byte[] CRLF = {13, 10};
    /* access modifiers changed from: private */
    public static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    private final f boundary;
    private final List<RequestBody> partBodies;
    private final List<Headers> partHeaders;
    private MediaType type;

    public MultipartBuilder() {
        this(UUID.randomUUID().toString());
    }

    public MultipartBuilder(String str) {
        this.type = MIXED;
        this.partHeaders = new ArrayList();
        this.partBodies = new ArrayList();
        this.boundary = f.encodeUtf8(str);
    }

    public final MultipartBuilder type(MediaType mediaType) {
        if (mediaType == null) {
            throw new NullPointerException("type == null");
        } else if (mediaType.type().equals("multipart")) {
            this.type = mediaType;
            return this;
        } else {
            throw new IllegalArgumentException("multipart != ".concat(String.valueOf(mediaType)));
        }
    }

    public final MultipartBuilder addPart(RequestBody requestBody) {
        return addPart((Headers) null, requestBody);
    }

    public final MultipartBuilder addPart(Headers headers, RequestBody requestBody) {
        if (requestBody == null) {
            throw new NullPointerException("body == null");
        } else if (headers != null && headers.get("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        } else if (headers == null || headers.get("Content-Length") == null) {
            this.partHeaders.add(headers);
            this.partBodies.add(requestBody);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
    }

    private static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 10) {
                sb.append("%0A");
            } else if (charAt == 13) {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    public final MultipartBuilder addFormDataPart(String str, String str2) {
        return addFormDataPart(str, (String) null, RequestBody.create((MediaType) null, str2));
    }

    public final MultipartBuilder addFormDataPart(String str, String str2, RequestBody requestBody) {
        if (str != null) {
            StringBuilder sb = new StringBuilder("form-data; name=");
            appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                appendQuotedString(sb, str2);
            }
            return addPart(Headers.of("Content-Disposition", sb.toString()), requestBody);
        }
        throw new NullPointerException("name == null");
    }

    public final RequestBody build() {
        if (!this.partHeaders.isEmpty()) {
            return new MultipartRequestBody(this.type, this.boundary, this.partHeaders, this.partBodies);
        }
        throw new IllegalStateException("Multipart body must have at least one part.");
    }

    static final class MultipartRequestBody extends RequestBody {
        private final f boundary;
        private long contentLength = -1;
        private final MediaType contentType;
        private final List<RequestBody> partBodies;
        private final List<Headers> partHeaders;

        public MultipartRequestBody(MediaType mediaType, f fVar, List<Headers> list, List<RequestBody> list2) {
            if (mediaType != null) {
                this.boundary = fVar;
                this.contentType = MediaType.parse(mediaType + "; boundary=" + fVar.utf8());
                this.partHeaders = Util.immutableList(list);
                this.partBodies = Util.immutableList(list2);
                return;
            }
            throw new NullPointerException("type == null");
        }

        public final MediaType contentType() {
            return this.contentType;
        }

        public final long contentLength() throws IOException {
            long j = this.contentLength;
            if (j != -1) {
                return j;
            }
            long writeOrCountBytes = writeOrCountBytes((d) null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: i.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: i.c} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: i.c} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: i.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: i.c} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long writeOrCountBytes(i.d r13, boolean r14) throws java.io.IOException {
            /*
                r12 = this;
                if (r14 == 0) goto L_0x0009
                i.c r13 = new i.c
                r13.<init>()
                r0 = r13
                goto L_0x000a
            L_0x0009:
                r0 = 0
            L_0x000a:
                java.util.List<com.squareup.okhttp.Headers> r1 = r12.partHeaders
                int r1 = r1.size()
                r2 = 0
                r3 = 0
                r4 = r3
                r3 = 0
            L_0x0015:
                if (r3 >= r1) goto L_0x00c3
                java.util.List<com.squareup.okhttp.Headers> r6 = r12.partHeaders
                java.lang.Object r6 = r6.get(r3)
                com.squareup.okhttp.Headers r6 = (com.squareup.okhttp.Headers) r6
                java.util.List<com.squareup.okhttp.RequestBody> r7 = r12.partBodies
                java.lang.Object r7 = r7.get(r3)
                com.squareup.okhttp.RequestBody r7 = (com.squareup.okhttp.RequestBody) r7
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.c(r8)
                i.f r8 = r12.boundary
                r13.d(r8)
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.c(r8)
                if (r6 == 0) goto L_0x0065
                int r8 = r6.size()
                r9 = 0
            L_0x0041:
                if (r9 >= r8) goto L_0x0065
                java.lang.String r10 = r6.name(r9)
                i.d r10 = r13.b(r10)
                byte[] r11 = com.squareup.okhttp.MultipartBuilder.COLONSPACE
                i.d r10 = r10.c(r11)
                java.lang.String r11 = r6.value(r9)
                i.d r10 = r10.b(r11)
                byte[] r11 = com.squareup.okhttp.MultipartBuilder.CRLF
                r10.c(r11)
                int r9 = r9 + 1
                goto L_0x0041
            L_0x0065:
                com.squareup.okhttp.MediaType r6 = r7.contentType()
                if (r6 == 0) goto L_0x0080
                java.lang.String r8 = "Content-Type: "
                i.d r8 = r13.b(r8)
                java.lang.String r6 = r6.toString()
                i.d r6 = r8.b(r6)
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r6.c(r8)
            L_0x0080:
                long r6 = r7.contentLength()
                r8 = -1
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 == 0) goto L_0x009c
                java.lang.String r8 = "Content-Length: "
                i.d r8 = r13.b(r8)
                i.d r8 = r8.n(r6)
                byte[] r9 = com.squareup.okhttp.MultipartBuilder.CRLF
                r8.c(r9)
                goto L_0x00a2
            L_0x009c:
                if (r14 == 0) goto L_0x00a2
                r0.t()
                return r8
            L_0x00a2:
                byte[] r8 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.c(r8)
                if (r14 == 0) goto L_0x00ad
                long r4 = r4 + r6
                goto L_0x00b8
            L_0x00ad:
                java.util.List<com.squareup.okhttp.RequestBody> r6 = r12.partBodies
                java.lang.Object r6 = r6.get(r3)
                com.squareup.okhttp.RequestBody r6 = (com.squareup.okhttp.RequestBody) r6
                r6.writeTo(r13)
            L_0x00b8:
                byte[] r6 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.c(r6)
                int r3 = r3 + 1
                goto L_0x0015
            L_0x00c3:
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.c(r1)
                i.f r1 = r12.boundary
                r13.d(r1)
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.DASHDASH
                r13.c(r1)
                byte[] r1 = com.squareup.okhttp.MultipartBuilder.CRLF
                r13.c(r1)
                if (r14 == 0) goto L_0x00e5
                long r13 = r0.f46277b
                long r4 = r4 + r13
                r0.t()
            L_0x00e5:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.MultipartBuilder.MultipartRequestBody.writeOrCountBytes(i.d, boolean):long");
        }

        public final void writeTo(d dVar) throws IOException {
            writeOrCountBytes(dVar, false);
        }
    }
}
