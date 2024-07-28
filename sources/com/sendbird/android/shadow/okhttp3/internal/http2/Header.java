package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.ByteString;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class Header {
    public static final ByteString PSEUDO_PREFIX = ByteString.encodeUtf8(AppConstants.COLON);
    public static final ByteString RESPONSE_STATUS = ByteString.encodeUtf8(":status");
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final ByteString TARGET_AUTHORITY = ByteString.encodeUtf8(":authority");
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final ByteString TARGET_METHOD = ByteString.encodeUtf8(":method");
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final ByteString TARGET_PATH = ByteString.encodeUtf8(":path");
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final ByteString TARGET_SCHEME = ByteString.encodeUtf8(":scheme");
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    interface a {
    }

    public Header(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            if (!this.name.equals(header.name) || !this.value.equals(header.value)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.name.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public final String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }
}
