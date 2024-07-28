package org.apache.http.a;

import java.io.IOException;
import org.apache.http.b;
import org.apache.http.g;

public abstract class a implements g {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected b contentEncoding;
    protected b contentType;

    @Deprecated
    public void consumeContent() throws IOException {
    }

    protected a() {
    }

    public b getContentType() {
        return this.contentType;
    }

    public b getContentEncoding() {
        return this.contentEncoding;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public void setContentType(b bVar) {
        this.contentType = bVar;
    }

    public void setContentType(String str) {
        setContentType((b) str != null ? new org.apache.http.b.b("Content-Type", str) : null);
    }

    public void setContentEncoding(b bVar) {
        this.contentEncoding = bVar;
    }

    public void setContentEncoding(String str) {
        setContentEncoding((b) str != null ? new org.apache.http.b.b("Content-Encoding", str) : null);
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this.contentType != null) {
            sb.append("Content-Type: ");
            sb.append(this.contentType.b());
            sb.append(',');
        }
        if (this.contentEncoding != null) {
            sb.append("Content-Encoding: ");
            sb.append(this.contentEncoding.b());
            sb.append(',');
        }
        long contentLength = getContentLength();
        if (contentLength >= 0) {
            sb.append("Content-Length: ");
            sb.append(contentLength);
            sb.append(',');
        }
        sb.append("Chunked: ");
        sb.append(this.chunked);
        sb.append(']');
        return sb.toString();
    }
}
