package com.squareup.okhttp.internal.framed;

import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.contactsSdk.constant.ContactsConstant;
import i.c;
import i.e;
import i.f;
import i.n;
import i.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;

final class Hpack {
    /* access modifiers changed from: private */
    public static final Map<f, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    /* access modifiers changed from: private */
    public static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, (String) H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header((String) UpiConstants.CACHE_CONTROL, ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header((String) CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header((String) H5Param.HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header((String) H5Param.MENU_REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header((String) ContactsConstant.USER_AGENT, ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    private Hpack() {
    }

    static final class Reader {
        Header[] dynamicTable = new Header[8];
        int dynamicTableByteCount = 0;
        int headerCount = 0;
        private final List<Header> headerList = new ArrayList();
        private int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex = (this.dynamicTable.length - 1);
        private final e source;

        Reader(int i2, v vVar) {
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i2;
            this.source = n.a(vVar);
        }

        /* access modifiers changed from: package-private */
        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        /* access modifiers changed from: package-private */
        public final void headerTableSizeSetting(int i2) {
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i2;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i3 - i2);
            }
        }

        private void clearDynamicTable() {
            this.headerList.clear();
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i2 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i4 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i4 + 1, headerArr, i4 + 1 + i3, this.headerCount);
                        this.nextHeaderIndex += i3;
                    } else {
                        i2 -= this.dynamicTable[length].hpackSize;
                        this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                        this.headerCount--;
                        i3++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                int i42 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i42 + 1, headerArr2, i42 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public final void readHeaders() throws IOException {
            while (!this.source.d()) {
                byte g2 = this.source.g() & 255;
                if (g2 == 128) {
                    throw new IOException("index == 0");
                } else if ((g2 & 128) == 128) {
                    readIndexedHeader(readInt(g2, 127) - 1);
                } else if (g2 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((g2 & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(g2, 63) - 1);
                } else if ((g2 & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(g2, 31);
                    int i2 = this.maxDynamicTableByteCount;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (g2 == 16 || g2 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(g2, 15) - 1);
                }
            }
        }

        public final List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i2]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex <= headerArr.length - 1) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private int dynamicTableIndex(int i2) {
            return this.nextHeaderIndex + 1 + i2;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            this.headerList.add(new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private f getName(int i2) {
            if (isStaticHeader(i2)) {
                return Hpack.STATIC_HEADER_TABLE[i2].name;
            }
            return this.dynamicTable[dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length)].name;
        }

        private boolean isStaticHeader(int i2) {
            return i2 >= 0 && i2 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i2, Header header) {
            this.headerList.add(header);
            int i3 = header.hpackSize;
            if (i2 != -1) {
                i3 -= this.dynamicTable[dynamicTableIndex(i2)].hpackSize;
            }
            int i4 = this.maxDynamicTableByteCount;
            if (i3 > i4) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i4);
            if (i2 == -1) {
                int i5 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i5 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i6 = this.nextHeaderIndex;
                this.nextHeaderIndex = i6 - 1;
                this.dynamicTable[i6] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i2 + dynamicTableIndex(i2) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i3;
        }

        private int readByte() throws IOException {
            return this.source.g() & 255;
        }

        /* access modifiers changed from: package-private */
        public final int readInt(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & 127) << i5;
                i5 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public final f readByteString() throws IOException {
            int readByte = readByte();
            boolean z = (readByte & 128) == 128;
            int readInt = readInt(readByte, 127);
            if (z) {
                return f.of(Huffman.get().decode(this.source.h((long) readInt)));
            }
            return this.source.d((long) readInt);
        }
    }

    private static Map<f, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i2 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i2].name, Integer.valueOf(i2));
            }
            i2++;
        }
    }

    static final class Writer {
        private final c out;

        Writer(c cVar) {
            this.out = cVar;
        }

        /* access modifiers changed from: package-private */
        public final void writeHeaders(List<Header> list) throws IOException {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                f asciiLowercase = list.get(i2).name.toAsciiLowercase();
                Integer num = (Integer) Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    writeInt(num.intValue() + 1, 15, 0);
                    writeByteString(list.get(i2).value);
                } else {
                    this.out.j(0);
                    writeByteString(asciiLowercase);
                    writeByteString(list.get(i2).value);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void writeInt(int i2, int i3, int i4) throws IOException {
            if (i2 < i3) {
                this.out.j(i2 | i4);
                return;
            }
            this.out.j(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.out.j(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.out.j(i5);
        }

        /* access modifiers changed from: package-private */
        public final void writeByteString(f fVar) throws IOException {
            writeInt(fVar.size(), 127, 0);
            this.out.d(fVar);
        }
    }

    /* access modifiers changed from: private */
    public static f checkLowercase(f fVar) throws IOException {
        int size = fVar.size();
        int i2 = 0;
        while (i2 < size) {
            byte b2 = fVar.getByte(i2);
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.utf8());
            }
        }
        return fVar;
    }
}
