package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final Header[] f45145a = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, (String) H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header((String) UpiConstants.CACHE_CONTROL, ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header((String) CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header((String) H5Param.HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header((String) H5Param.MENU_REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header((String) ContactsConstant.USER_AGENT, ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    /* renamed from: b  reason: collision with root package name */
    static final Map<ByteString, Integer> f45146b;

    static {
        int i2 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f45145a.length);
        while (true) {
            Header[] headerArr = f45145a;
            if (i2 < headerArr.length) {
                if (!linkedHashMap.containsKey(headerArr[i2].name)) {
                    linkedHashMap.put(f45145a[i2].name, Integer.valueOf(i2));
                }
                i2++;
            } else {
                f45146b = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    /* renamed from: com.sendbird.android.shadow.okhttp3.internal.http2.a$a  reason: collision with other inner class name */
    static final class C0758a {

        /* renamed from: a  reason: collision with root package name */
        Header[] f45147a;

        /* renamed from: b  reason: collision with root package name */
        int f45148b;

        /* renamed from: c  reason: collision with root package name */
        int f45149c;

        /* renamed from: d  reason: collision with root package name */
        int f45150d;

        /* renamed from: e  reason: collision with root package name */
        private final List<Header> f45151e;

        /* renamed from: f  reason: collision with root package name */
        private final BufferedSource f45152f;

        /* renamed from: g  reason: collision with root package name */
        private final int f45153g;

        /* renamed from: h  reason: collision with root package name */
        private int f45154h;

        C0758a(Source source) {
            this(source, (byte) 0);
        }

        private C0758a(Source source, byte b2) {
            this.f45151e = new ArrayList();
            this.f45147a = new Header[8];
            this.f45148b = this.f45147a.length - 1;
            this.f45149c = 0;
            this.f45150d = 0;
            this.f45153g = 4096;
            this.f45154h = 4096;
            this.f45152f = Okio.buffer(source);
        }

        private void c() {
            int i2 = this.f45154h;
            int i3 = this.f45150d;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                d();
            } else {
                a(i3 - i2);
            }
        }

        private void d() {
            Arrays.fill(this.f45147a, (Object) null);
            this.f45148b = this.f45147a.length - 1;
            this.f45149c = 0;
            this.f45150d = 0;
        }

        private int a(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f45147a.length;
                while (true) {
                    length--;
                    if (length < this.f45148b || i2 <= 0) {
                        Header[] headerArr = this.f45147a;
                        int i4 = this.f45148b;
                        System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i3, this.f45149c);
                        this.f45148b += i3;
                    } else {
                        i2 -= this.f45147a[length].hpackSize;
                        this.f45150d -= this.f45147a[length].hpackSize;
                        this.f45149c--;
                        i3++;
                    }
                }
                Header[] headerArr2 = this.f45147a;
                int i42 = this.f45148b;
                System.arraycopy(headerArr2, i42 + 1, headerArr2, i42 + 1 + i3, this.f45149c);
                this.f45148b += i3;
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public final void a() throws IOException {
            while (!this.f45152f.exhausted()) {
                byte readByte = this.f45152f.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    int a2 = a(readByte, 127) - 1;
                    if (d(a2)) {
                        this.f45151e.add(a.f45145a[a2]);
                    } else {
                        int b2 = b(a2 - a.f45145a.length);
                        if (b2 >= 0) {
                            Header[] headerArr = this.f45147a;
                            if (b2 < headerArr.length) {
                                this.f45151e.add(headerArr[b2]);
                            }
                        }
                        throw new IOException("Header index too large " + (a2 + 1));
                    }
                } else if (readByte == 64) {
                    a(new Header(a.a(f()), f()));
                } else if ((readByte & 64) == 64) {
                    a(new Header(c(a(readByte, 63) - 1), f()));
                } else if ((readByte & 32) == 32) {
                    this.f45154h = a(readByte, 31);
                    int i2 = this.f45154h;
                    if (i2 < 0 || i2 > this.f45153g) {
                        throw new IOException("Invalid dynamic table size update " + this.f45154h);
                    }
                    c();
                } else if (readByte == 16 || readByte == 0) {
                    this.f45151e.add(new Header(a.a(f()), f()));
                } else {
                    this.f45151e.add(new Header(c(a(readByte, 15) - 1), f()));
                }
            }
        }

        public final List<Header> b() {
            ArrayList arrayList = new ArrayList(this.f45151e);
            this.f45151e.clear();
            return arrayList;
        }

        private int b(int i2) {
            return this.f45148b + 1 + i2;
        }

        private ByteString c(int i2) throws IOException {
            if (d(i2)) {
                return a.f45145a[i2].name;
            }
            int b2 = b(i2 - a.f45145a.length);
            if (b2 >= 0) {
                Header[] headerArr = this.f45147a;
                if (b2 < headerArr.length) {
                    return headerArr[b2].name;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private static boolean d(int i2) {
            return i2 >= 0 && i2 <= a.f45145a.length - 1;
        }

        private void a(Header header) {
            this.f45151e.add(header);
            int i2 = header.hpackSize;
            int i3 = this.f45154h;
            if (i2 > i3) {
                d();
                return;
            }
            a((this.f45150d + i2) - i3);
            int i4 = this.f45149c + 1;
            Header[] headerArr = this.f45147a;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f45148b = this.f45147a.length - 1;
                this.f45147a = headerArr2;
            }
            int i5 = this.f45148b;
            this.f45148b = i5 - 1;
            this.f45147a[i5] = header;
            this.f45149c++;
            this.f45150d += i2;
        }

        private int e() throws IOException {
            return this.f45152f.readByte() & 255;
        }

        private int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int e2 = e();
                if ((e2 & 128) == 0) {
                    return i3 + (e2 << i5);
                }
                i3 += (e2 & 127) << i5;
                i5 += 7;
            }
        }

        private ByteString f() throws IOException {
            int e2 = e();
            boolean z = (e2 & 128) == 128;
            int a2 = a(e2, 127);
            if (z) {
                return ByteString.of(d.a().a(this.f45152f.readByteArray((long) a2)));
            }
            return this.f45152f.readByteString((long) a2);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f45155a;

        /* renamed from: b  reason: collision with root package name */
        int f45156b;

        /* renamed from: c  reason: collision with root package name */
        Header[] f45157c;

        /* renamed from: d  reason: collision with root package name */
        int f45158d;

        /* renamed from: e  reason: collision with root package name */
        int f45159e;

        /* renamed from: f  reason: collision with root package name */
        int f45160f;

        /* renamed from: g  reason: collision with root package name */
        private final Buffer f45161g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f45162h;

        /* renamed from: i  reason: collision with root package name */
        private int f45163i;
        private boolean j;

        b(Buffer buffer) {
            this(buffer, (byte) 0);
        }

        private b(Buffer buffer, byte b2) {
            this.f45163i = Integer.MAX_VALUE;
            this.f45157c = new Header[8];
            this.f45158d = this.f45157c.length - 1;
            this.f45159e = 0;
            this.f45160f = 0;
            this.f45155a = 4096;
            this.f45156b = 4096;
            this.f45162h = true;
            this.f45161g = buffer;
        }

        private void a() {
            Arrays.fill(this.f45157c, (Object) null);
            this.f45158d = this.f45157c.length - 1;
            this.f45159e = 0;
            this.f45160f = 0;
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f45157c.length;
                while (true) {
                    length--;
                    if (length < this.f45158d || i2 <= 0) {
                        Header[] headerArr = this.f45157c;
                        int i4 = this.f45158d;
                        System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i3, this.f45159e);
                        Header[] headerArr2 = this.f45157c;
                        int i5 = this.f45158d;
                        Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                        this.f45158d += i3;
                    } else {
                        i2 -= this.f45157c[length].hpackSize;
                        this.f45160f -= this.f45157c[length].hpackSize;
                        this.f45159e--;
                        i3++;
                    }
                }
                Header[] headerArr3 = this.f45157c;
                int i42 = this.f45158d;
                System.arraycopy(headerArr3, i42 + 1, headerArr3, i42 + 1 + i3, this.f45159e);
                Header[] headerArr22 = this.f45157c;
                int i52 = this.f45158d;
                Arrays.fill(headerArr22, i52 + 1, i52 + 1 + i3, (Object) null);
                this.f45158d += i3;
            }
            return i3;
        }

        private void a(Header header) {
            int i2 = header.hpackSize;
            int i3 = this.f45156b;
            if (i2 > i3) {
                a();
                return;
            }
            b((this.f45160f + i2) - i3);
            int i4 = this.f45159e + 1;
            Header[] headerArr = this.f45157c;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f45158d = this.f45157c.length - 1;
                this.f45157c = headerArr2;
            }
            int i5 = this.f45158d;
            this.f45158d = i5 - 1;
            this.f45157c[i5] = header;
            this.f45159e++;
            this.f45160f += i2;
        }

        /* access modifiers changed from: package-private */
        public final void a(List<Header> list) throws IOException {
            int i2;
            int i3;
            if (this.j) {
                int i4 = this.f45163i;
                if (i4 < this.f45156b) {
                    a(i4, 31, 32);
                }
                this.j = false;
                this.f45163i = Integer.MAX_VALUE;
                a(this.f45156b, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Header header = list.get(i5);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = a.f45146b.get(asciiLowercase);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (Util.equal(a.f45145a[i3 - 1].value, byteString)) {
                            i2 = i3;
                        } else if (Util.equal(a.f45145a[i3].value, byteString)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.f45158d + 1;
                    int length = this.f45157c.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Util.equal(this.f45157c[i6].name, asciiLowercase)) {
                            if (Util.equal(this.f45157c[i6].value, byteString)) {
                                i3 = a.f45145a.length + (i6 - this.f45158d);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.f45158d) + a.f45145a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    a(i3, 127, 128);
                } else if (i2 == -1) {
                    this.f45161g.writeByte(64);
                    a(asciiLowercase);
                    a(byteString);
                    a(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    a(i2, 63, 64);
                    a(byteString);
                    a(header);
                } else {
                    a(i2, 15, 0);
                    a(byteString);
                }
            }
        }

        private void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f45161g.writeByte(i2 | i4);
                return;
            }
            this.f45161g.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f45161g.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f45161g.writeByte(i5);
        }

        private void a(ByteString byteString) throws IOException {
            if (this.f45162h) {
                d.a();
                if (d.a(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    d.a();
                    d.a(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    a(readByteString.size(), 127, 128);
                    this.f45161g.write(readByteString);
                    return;
                }
            }
            a(byteString.size(), 127, 0);
            this.f45161g.write(byteString);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f45155a = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.f45156b;
            if (i3 != min) {
                if (min < i3) {
                    this.f45163i = Math.min(this.f45163i, min);
                }
                this.j = true;
                this.f45156b = min;
                int i4 = this.f45156b;
                int i5 = this.f45160f;
                if (i4 >= i5) {
                    return;
                }
                if (i4 == 0) {
                    a();
                } else {
                    b(i5 - i4);
                }
            }
        }
    }

    static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i2 = 0;
        while (i2 < size) {
            byte b2 = byteString.getByte(i2);
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
