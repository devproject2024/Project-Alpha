package okhttp3;

import i.d;
import i.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType FORM = MediaType.get("multipart/form-data");
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    private final f boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    MultipartBody(f fVar, MediaType mediaType, List<Part> list) {
        this.boundary = fVar;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + fVar.utf8());
        this.parts = Util.immutableList(list);
    }

    public final MediaType type() {
        return this.originalType;
    }

    public final String boundary() {
        return this.boundary.utf8();
    }

    public final int size() {
        return this.parts.size();
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final Part part(int i2) {
        return this.parts.get(i2);
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

    public final void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
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
            java.util.List<okhttp3.MultipartBody$Part> r1 = r12.parts
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00a7
            java.util.List<okhttp3.MultipartBody$Part> r6 = r12.parts
            java.lang.Object r6 = r6.get(r3)
            okhttp3.MultipartBody$Part r6 = (okhttp3.MultipartBody.Part) r6
            okhttp3.Headers r7 = r6.headers
            okhttp3.RequestBody r6 = r6.body
            byte[] r8 = DASHDASH
            r13.c(r8)
            i.f r8 = r12.boundary
            r13.d(r8)
            byte[] r8 = CRLF
            r13.c(r8)
            if (r7 == 0) goto L_0x0059
            int r8 = r7.size()
            r9 = 0
        L_0x0039:
            if (r9 >= r8) goto L_0x0059
            java.lang.String r10 = r7.name(r9)
            i.d r10 = r13.b(r10)
            byte[] r11 = COLONSPACE
            i.d r10 = r10.c(r11)
            java.lang.String r11 = r7.value(r9)
            i.d r10 = r10.b(r11)
            byte[] r11 = CRLF
            r10.c(r11)
            int r9 = r9 + 1
            goto L_0x0039
        L_0x0059:
            okhttp3.MediaType r7 = r6.contentType()
            if (r7 == 0) goto L_0x0072
            java.lang.String r8 = "Content-Type: "
            i.d r8 = r13.b(r8)
            java.lang.String r7 = r7.toString()
            i.d r7 = r8.b(r7)
            byte[] r8 = CRLF
            r7.c(r8)
        L_0x0072:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008c
            java.lang.String r9 = "Content-Length: "
            i.d r9 = r13.b(r9)
            i.d r9 = r9.n(r7)
            byte[] r10 = CRLF
            r9.c(r10)
            goto L_0x0092
        L_0x008c:
            if (r14 == 0) goto L_0x0092
            r0.t()
            return r9
        L_0x0092:
            byte[] r9 = CRLF
            r13.c(r9)
            if (r14 == 0) goto L_0x009b
            long r4 = r4 + r7
            goto L_0x009e
        L_0x009b:
            r6.writeTo(r13)
        L_0x009e:
            byte[] r6 = CRLF
            r13.c(r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00a7:
            byte[] r1 = DASHDASH
            r13.c(r1)
            i.f r1 = r12.boundary
            r13.d(r1)
            byte[] r1 = DASHDASH
            r13.c(r1)
            byte[] r1 = CRLF
            r13.c(r1)
            if (r14 == 0) goto L_0x00c3
            long r13 = r0.f46277b
            long r4 = r4 + r13
            r0.t()
        L_0x00c3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MultipartBody.writeOrCountBytes(i.d, boolean):long");
    }

    static StringBuilder appendQuotedString(StringBuilder sb, String str) {
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

    public static final class Part {
        final RequestBody body;
        final Headers headers;

        public static Part create(RequestBody requestBody) {
            return create((Headers) null, requestBody);
        }

        public static Part create(Headers headers2, RequestBody requestBody) {
            if (requestBody == null) {
                throw new NullPointerException("body == null");
            } else if (headers2 != null && headers2.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers2 == null || headers2.get("Content-Length") == null) {
                return new Part(headers2, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, (String) null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.appendQuotedString(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.appendQuotedString(sb, str2);
                }
                return create(Headers.of("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }

        private Part(Headers headers2, RequestBody requestBody) {
            this.headers = headers2;
            this.body = requestBody;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }
    }

    public static final class Builder {
        private final f boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = f.encodeUtf8(str);
        }

        public final Builder setType(MediaType mediaType) {
            if (mediaType == null) {
                throw new NullPointerException("type == null");
            } else if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            } else {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(mediaType)));
            }
        }

        public final Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public final Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public final Builder addPart(Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }
}
