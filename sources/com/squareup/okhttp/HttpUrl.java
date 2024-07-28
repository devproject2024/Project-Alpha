package com.squareup.okhttp;

import com.alipay.iap.android.webapp.sdk.provider.BaseJSApiPermissionProvider;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import i.c;
import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    /* access modifiers changed from: private */
    public final String host;
    private final String password;
    private final List<String> pathSegments;
    /* access modifiers changed from: private */
    public final int port;
    private final List<String> queryNamesAndValues;
    /* access modifiers changed from: private */
    public final String scheme;
    private final String url;
    private final String username;

    static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername);
        this.password = percentDecode(builder.encodedPassword);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments);
        String str = null;
        this.queryNamesAndValues = builder.encodedQueryNamesAndValues != null ? percentDecode(builder.encodedQueryNamesAndValues) : null;
        this.fragment = builder.encodedFragment != null ? percentDecode(builder.encodedFragment) : str;
        this.url = builder.toString();
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final URI uri() {
        try {
            return new URI(this.url);
        } catch (URISyntaxException unused) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.url);
        }
    }

    public final String scheme() {
        return this.scheme;
    }

    public final boolean isHttps() {
        return this.scheme.equals("https");
    }

    public final String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, delimiterOffset(str, length, str.length(), ":@"));
    }

    public final String username() {
        return this.username;
    }

    public final String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public final String password() {
        return this.password;
    }

    public final String host() {
        return this.host;
    }

    public final int port() {
        return this.port;
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public final List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i2 = indexOf + 1;
            int delimiterOffset2 = delimiterOffset(this.url, i2, delimiterOffset, "/");
            arrayList.add(this.url.substring(i2, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf + 1, str.length(), "#"));
    }

    static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                return this.queryNamesAndValues.get(i2 + 1);
            }
        }
        return null;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public final List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i2))) {
                arrayList.add(this.queryNamesAndValues.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final String queryParameterName(int i2) {
        return this.queryNamesAndValues.get(i2 * 2);
    }

    public final String queryParameterValue(int i2) {
        return this.queryNamesAndValues.get((i2 * 2) + 1);
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public final String fragment() {
        return this.fragment;
    }

    public final HttpUrl resolve(String str) {
        return new Builder().parse(this, str);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        if (this.port == defaultPort(this.scheme)) {
            builder.port = -1;
        } else {
            builder.port = this.port;
        }
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public static HttpUrl parse(String str) {
        return new Builder().parse((HttpUrl) null, str);
    }

    public static HttpUrl get(URL url2) {
        return parse(url2.toString());
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public final int hashCode() {
        return this.url.hashCode();
    }

    public final String toString() {
        return this.url;
    }

    public static final class Builder {
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments = new ArrayList();
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        public Builder() {
            this.encodedPathSegments.add("");
        }

        public final Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.scheme = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public final Builder username(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false);
                return this;
            }
            throw new IllegalArgumentException("username == null");
        }

        public final Builder encodedUsername(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false);
                return this;
            }
            throw new IllegalArgumentException("encodedUsername == null");
        }

        public final Builder password(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false);
                return this;
            }
            throw new IllegalArgumentException("password == null");
        }

        public final Builder encodedPassword(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false);
                return this;
            }
            throw new IllegalArgumentException("encodedPassword == null");
        }

        public final Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: ".concat(String.valueOf(str)));
            }
            throw new IllegalArgumentException("host == null");
        }

        public final Builder port(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: ".concat(String.valueOf(i2)));
            }
            this.port = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final int effectivePort() {
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.defaultPort(this.scheme);
        }

        public final Builder addPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, false);
                return this;
            }
            throw new IllegalArgumentException("pathSegment == null");
        }

        public final Builder addEncodedPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, true);
                return this;
            }
            throw new IllegalArgumentException("encodedPathSegment == null");
        }

        public final Builder setPathSegment(int i2, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false);
                if (isDot(canonicalize) || isDotDot(canonicalize)) {
                    throw new IllegalArgumentException("unexpected path segment: ".concat(String.valueOf(str)));
                }
                this.encodedPathSegments.set(i2, canonicalize);
                return this;
            }
            throw new IllegalArgumentException("pathSegment == null");
        }

        public final Builder setEncodedPathSegment(int i2, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false);
                this.encodedPathSegments.set(i2, canonicalize);
                if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: ".concat(String.valueOf(str)));
            }
            throw new IllegalArgumentException("encodedPathSegment == null");
        }

        public final Builder removePathSegment(int i2) {
            this.encodedPathSegments.remove(i2);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder encodedPath(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPath == null");
            } else if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            } else {
                throw new IllegalArgumentException("unexpected encodedPath: ".concat(String.valueOf(str)));
            }
        }

        public final Builder query(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, false, true)) : null;
            return this;
        }

        public final Builder encodedQuery(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, true, true)) : null;
            return this;
        }

        public final Builder addQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public final Builder addEncodedQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("encodedName == null");
        }

        public final Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public final Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public final Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, true));
                return this;
            }
        }

        public final Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, true, true));
                return this;
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        public final Builder fragment(String str) {
            if (str != null) {
                this.encodedFragment = HttpUrl.canonicalize(str, "", false, false);
                return this;
            }
            throw new IllegalArgumentException("fragment == null");
        }

        public final Builder encodedFragment(String str) {
            if (str != null) {
                this.encodedFragment = HttpUrl.canonicalize(str, "", true, false);
                return this;
            }
            throw new IllegalArgumentException("encodedFragment == null");
        }

        public final HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append("://");
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(effectivePort);
            }
            HttpUrl.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                HttpUrl.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public final HttpUrl parse(HttpUrl httpUrl, String str) {
            int i2;
            int access$200;
            int i3;
            String str2 = str;
            boolean z = false;
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str2, 0, str.length());
            int skipTrailingAsciiWhitespace = skipTrailingAsciiWhitespace(str2, skipLeadingAsciiWhitespace, str.length());
            if (schemeDelimiterOffset(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, BaseJSApiPermissionProvider.PROTOCOL_HTTPS, 0, 6)) {
                    this.scheme = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else if (!str.regionMatches(true, skipLeadingAsciiWhitespace, BaseJSApiPermissionProvider.PROTOCOL_HTTP, 0, 5)) {
                    return null;
                } else {
                    this.scheme = "http";
                    skipLeadingAsciiWhitespace += 5;
                }
            } else if (httpUrl == null) {
                return null;
            } else {
                this.scheme = httpUrl.scheme;
            }
            int slashCount = slashCount(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c2 = '?';
            char c3 = '#';
            if (slashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                int i4 = skipLeadingAsciiWhitespace + slashCount;
                boolean z2 = false;
                while (true) {
                    access$200 = HttpUrl.delimiterOffset(str2, i4, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = access$200 != skipTrailingAsciiWhitespace ? str2.charAt(access$200) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        i2 = access$200;
                        int portColonOffset = portColonOffset(str2, i4, i2);
                        int i5 = portColonOffset + 1;
                    } else if (charAt == '@') {
                        if (!z) {
                            int access$2002 = HttpUrl.delimiterOffset(str2, i4, access$200, AppConstants.COLON);
                            int i6 = access$2002;
                            String str3 = "%40";
                            i3 = access$200;
                            String canonicalize = HttpUrl.canonicalize(str, i4, access$2002, " \"':;<=>@[]^`{}|/\\?#", true, false);
                            if (z2) {
                                canonicalize = this.encodedUsername + str3 + canonicalize;
                            }
                            this.encodedUsername = canonicalize;
                            if (i6 != i3) {
                                this.encodedPassword = HttpUrl.canonicalize(str, i6 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i3 = access$200;
                            this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false);
                        }
                        i4 = i3 + 1;
                        c2 = '?';
                        c3 = '#';
                    }
                }
                i2 = access$200;
                int portColonOffset2 = portColonOffset(str2, i4, i2);
                int i52 = portColonOffset2 + 1;
                if (i52 < i2) {
                    this.host = canonicalizeHost(str2, i4, portColonOffset2);
                    this.port = parsePort(str2, i52, i2);
                    if (this.port == -1) {
                        return null;
                    }
                } else {
                    this.host = canonicalizeHost(str2, i4, portColonOffset2);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    return null;
                }
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str2.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i2 = skipLeadingAsciiWhitespace;
            }
            int access$2003 = HttpUrl.delimiterOffset(str2, i2, skipTrailingAsciiWhitespace, "?#");
            resolvePath(str2, i2, access$2003);
            if (access$2003 < skipTrailingAsciiWhitespace && str2.charAt(access$2003) == '?') {
                int access$2004 = HttpUrl.delimiterOffset(str2, access$2003, skipTrailingAsciiWhitespace, "#");
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, access$2003 + 1, access$2004, HttpUrl.QUERY_ENCODE_SET, true, true));
                access$2003 = access$2004;
            }
            if (access$2003 < skipTrailingAsciiWhitespace && str2.charAt(access$2003) == '#') {
                this.encodedFragment = HttpUrl.canonicalize(str, 1 + access$2003, skipTrailingAsciiWhitespace, "", true, false);
            }
            return build();
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043 A[SYNTHETIC] */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x002a
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
            L_0x0028:
                int r12 = r12 + 1
            L_0x002a:
                r6 = r12
                if (r6 >= r13) goto L_0x0043
                java.lang.String r12 = "/\\"
                int r12 = com.squareup.okhttp.HttpUrl.delimiterOffset(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0037
                r0 = 1
                goto L_0x0038
            L_0x0037:
                r0 = 0
            L_0x0038:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x002a
                goto L_0x0028
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        private void push(String str, int i2, int i3, boolean z, boolean z2) {
            String canonicalize = HttpUrl.canonicalize(str, i2, i3, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false);
            if (!isDot(canonicalize)) {
                if (isDotDot(canonicalize)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize);
                } else {
                    this.encodedPathSegments.add(canonicalize);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private boolean isDot(String str) {
            return str.equals(AppUtility.CENTER_DOT) || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (!list.remove(list.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
                return;
            }
            List<String> list2 = this.encodedPathSegments;
            list2.set(list2.size() - 1, "");
        }

        private int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }

        private int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }

        private static int schemeDelimiterOffset(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 < 'a' || charAt2 > 'z') && !((charAt2 >= 'A' && charAt2 <= 'Z') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.')) {
                        if (charAt2 == ':') {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private static int portColonOffset(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) == ']');
                }
                i2++;
            }
            return i3;
        }

        private static String canonicalizeHost(String str, int i2, int i3) {
            String percentDecode = HttpUrl.percentDecode(str, i2, i3);
            if (!percentDecode.startsWith("[") || !percentDecode.endsWith("]")) {
                String domainToAscii = domainToAscii(percentDecode);
                if (domainToAscii == null) {
                    return null;
                }
                int length = domainToAscii.length();
                if (HttpUrl.delimiterOffset(domainToAscii, 0, length, "\u0000\t\n\r #%/:?@[\\]") != length) {
                    return null;
                }
                return domainToAscii;
            }
            InetAddress decodeIpv6 = decodeIpv6(percentDecode, 1, percentDecode.length() - 1);
            if (decodeIpv6 == null) {
                return null;
            }
            byte[] address = decodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError();
        }

        private static InetAddress decodeIpv6(String str, int i2, int i3) {
            byte[] bArr = new byte[16];
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i2 >= i3) {
                    break;
                } else if (i4 == 16) {
                    return null;
                } else {
                    int i7 = i2 + 2;
                    if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                        if (i4 != 0) {
                            if (str.regionMatches(i2, AppConstants.COLON, 0, 1)) {
                                i2++;
                            } else if (!str.regionMatches(i2, AppUtility.CENTER_DOT, 0, 1) || !decodeIpv4Suffix(str, i6, i3, bArr, i4 - 2)) {
                                return null;
                            } else {
                                i4 += 2;
                            }
                        }
                        i6 = i2;
                    } else if (i5 != -1) {
                        return null;
                    } else {
                        i4 += 2;
                        i5 = i4;
                        if (i7 == i3) {
                            break;
                        }
                        i6 = i7;
                    }
                    i2 = i6;
                    int i8 = 0;
                    while (i2 < i3) {
                        int decodeHexDigit = HttpUrl.decodeHexDigit(str.charAt(i2));
                        if (decodeHexDigit == -1) {
                            break;
                        }
                        i8 = (i8 << 4) + decodeHexDigit;
                        i2++;
                    }
                    int i9 = i2 - i6;
                    if (i9 == 0 || i9 > 4) {
                        return null;
                    }
                    int i10 = i4 + 1;
                    bArr[i4] = (byte) ((i8 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
                    i4 = i10 + 1;
                    bArr[i10] = (byte) (i8 & PriceRangeSeekBar.INVALID_POINTER_ID);
                }
            }
            if (i4 != 16) {
                if (i5 == -1) {
                    return null;
                }
                int i11 = i4 - i5;
                System.arraycopy(bArr, i5, bArr, 16 - i11, i11);
                Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        private static boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            if (i5 != i4 + 4) {
                return false;
            }
            return true;
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            int i5 = 0;
            while (i3 < bArr.length) {
                int i6 = i3;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i3;
                if (i7 > i5) {
                    i4 = i3;
                    i5 = i7;
                }
                i3 = i6 + 2;
            }
            c cVar = new c();
            while (i2 < bArr.length) {
                if (i2 == i4) {
                    cVar.j(58);
                    i2 += i5;
                    if (i2 == 16) {
                        cVar.j(58);
                    }
                } else {
                    if (i2 > 0) {
                        cVar.j(58);
                    }
                    cVar.m((long) (((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                    i2 += 2;
                }
            }
            return cVar.q();
        }

        private static int parsePort(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.canonicalize(str, i2, i3, "", false, false));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    static String percentDecode(String str) {
        return percentDecode(str, 0, str.length());
    }

    private List<String> percentDecode(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            arrayList.add(next != null ? percentDecode(next) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String percentDecode(String str, int i2, int i3) {
        for (int i4 = i2; i4 < i3; i4++) {
            if (str.charAt(i4) == '%') {
                c cVar = new c();
                cVar.b(str, i2, i4);
                percentDecode(cVar, str, i4, i3);
                return cVar.q();
            }
        }
        return str.substring(i2, i3);
    }

    static void percentDecode(c cVar, String str, int i2, int i3) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int decodeHexDigit = decodeHexDigit(str.charAt(i2 + 1));
                int decodeHexDigit2 = decodeHexDigit(str.charAt(i4));
                if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                    cVar.j((decodeHexDigit << 4) + decodeHexDigit2);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            }
            cVar.a(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, int i2, int i3, String str2, boolean z, boolean z2) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt >= 127 || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z) || (z2 && codePointAt == 43))) {
                c cVar = new c();
                cVar.b(str, i2, i4);
                canonicalize(cVar, str, i4, i3, str2, z, z2);
                return cVar.q();
            }
            i4 += Character.charCount(codePointAt);
        }
        return str.substring(i2, i3);
    }

    static void canonicalize(c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (z2 && codePointAt == 43) {
                    cVar.b(z ? "%20" : "%2B");
                } else if (codePointAt < 32 || codePointAt >= 127 || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && !z)) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.d()) {
                        byte g2 = cVar2.g() & 255;
                        cVar.j(37);
                        cVar.j((int) HEX_DIGITS[(g2 >> 4) & 15]);
                        cVar.j((int) HEX_DIGITS[g2 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2) {
        return canonicalize(str, 0, str.length(), str2, z, z2);
    }
}
