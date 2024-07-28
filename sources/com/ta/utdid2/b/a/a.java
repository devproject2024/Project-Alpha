package com.ta.utdid2.b.a;

import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import org.xmlpull.v1.XmlSerializer;

final class a implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f16120a;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f16121b = new char[FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE];

    /* renamed from: c  reason: collision with root package name */
    private int f16122c;

    /* renamed from: d  reason: collision with root package name */
    private Writer f16123d;

    /* renamed from: e  reason: collision with root package name */
    private OutputStream f16124e;

    /* renamed from: f  reason: collision with root package name */
    private CharsetEncoder f16125f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f16126g = ByteBuffer.allocate(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);

    /* renamed from: h  reason: collision with root package name */
    private boolean f16127h;

    a() {
    }

    static {
        String[] strArr = new String[64];
        strArr[34] = "&quot;";
        strArr[38] = "&amp;";
        strArr[60] = "&lt;";
        strArr[62] = "&gt;";
        f16120a = strArr;
    }

    private void a(char c2) throws IOException {
        int i2 = this.f16122c;
        if (i2 >= 8191) {
            flush();
            i2 = this.f16122c;
        }
        this.f16121b[i2] = c2;
        this.f16122c = i2 + 1;
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i2 + i3;
            while (i2 < i4) {
                int i5 = i2 + FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
                a(str, i2, i5 < i4 ? FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.f16122c;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.f16122c;
        }
        str.getChars(i2, i2 + i3, this.f16121b, i6);
        this.f16122c = i6 + i3;
    }

    private void a(char[] cArr, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i2 + i3;
            while (i2 < i4) {
                int i5 = i2 + FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
                a(cArr, i2, i5 < i4 ? FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.f16122c;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.f16122c;
        }
        System.arraycopy(cArr, i2, this.f16121b, i6, i3);
        this.f16122c = i6 + i3;
    }

    private void a(String str) throws IOException {
        a(str, 0, str.length());
    }

    private void b(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f16120a;
        char length2 = (char) strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i3 < i2) {
                    a(str, i3, i2 - i3);
                }
                i3 = i2 + 1;
                a(str2);
            }
            i2++;
        }
        if (i3 < i2) {
            a(str, i3, i2 - i3);
        }
    }

    public final XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        a(' ');
        if (str != null) {
            a(str);
            a(':');
        }
        a(str2);
        a("=\"");
        b(str3);
        a('\"');
        return this;
    }

    public final void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public final XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f16127h) {
            a(" />\n");
        } else {
            a("</");
            if (str != null) {
                a(str);
                a(':');
            }
            a(str2);
            a(">\n");
        }
        this.f16127h = false;
        return this;
    }

    public final void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void a() throws IOException {
        int position = this.f16126g.position();
        if (position > 0) {
            this.f16126g.flip();
            this.f16124e.write(this.f16126g.array(), 0, position);
            this.f16126g.clear();
        }
    }

    public final void flush() throws IOException {
        int i2 = this.f16122c;
        if (i2 > 0) {
            if (this.f16124e != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f16121b, 0, i2);
                CoderResult encode = this.f16125f.encode(wrap, this.f16126g, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f16125f.encode(wrap, this.f16126g, true);
                    } else {
                        a();
                        this.f16124e.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f16123d.write(this.f16121b, 0, i2);
            this.f16123d.flush();
            this.f16122c = 0;
        }
    }

    public final int getDepth() {
        throw new UnsupportedOperationException();
    }

    public final boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public final String getName() {
        throw new UnsupportedOperationException();
    }

    public final String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public final String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public final Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public final void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public final void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f16125f = Charset.forName(str).newEncoder();
                this.f16124e = outputStream;
            } catch (IllegalCharsetNameException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            } catch (UnsupportedCharsetException e3) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f16123d = writer;
    }

    public final void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? H5AppHandler.CHECK_VALUE : "no");
        sb.append("' ?>\n");
        a(sb.toString());
    }

    public final XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f16127h) {
            a(">\n");
        }
        a('<');
        if (str != null) {
            a(str);
            a(':');
        }
        a(str2);
        this.f16127h = true;
        return this;
    }

    public final XmlSerializer text(char[] cArr, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        String str;
        if (this.f16127h) {
            a(SimpleComparison.GREATER_THAN_OPERATION);
            this.f16127h = false;
        }
        String[] strArr = f16120a;
        char length = (char) strArr.length;
        int i4 = i3 + i2;
        int i5 = i2;
        while (i2 < i4) {
            char c2 = cArr[i2];
            if (c2 < length && (str = strArr[c2]) != null) {
                if (i5 < i2) {
                    a(cArr, i5, i2 - i5);
                }
                i5 = i2 + 1;
                a(str);
            }
            i2++;
        }
        if (i5 < i2) {
            a(cArr, i5, i2 - i5);
        }
        return this;
    }

    public final XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f16127h) {
            a(SimpleComparison.GREATER_THAN_OPERATION);
            this.f16127h = false;
        }
        b(str);
        return this;
    }
}
