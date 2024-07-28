package okhttp3.internal.http;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import i.c;
import i.f;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public final class HttpHeaders {
    private static final f QUOTED_STRING_DELIMITERS = f.encodeUtf8("\"\\");
    private static final f TOKEN_DELIMITERS = f.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String next : varyFields(response)) {
            if (!Util.equal(headers.values(next), request.headers(next))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        Set<String> set = emptySet;
        for (int i2 = 0; i2 < size; i2++) {
            if ("Vary".equalsIgnoreCase(headers.name(i2))) {
                String value = headers.value(i2);
                if (set.isEmpty()) {
                    set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(AppConstants.COMMA)) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i2));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < headers.size(); i2++) {
            if (str.equalsIgnoreCase(headers.name(i2))) {
                parseChallengeHeader(arrayList, new c().b(headers.value(i2)));
            }
        }
        return arrayList;
    }

    private static void parseChallengeHeader(List<Challenge> list, c cVar) {
        String readToken;
        int skipAll;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    skipWhitespaceAndCommas(cVar);
                    str2 = readToken(cVar);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean skipWhitespaceAndCommas = skipWhitespaceAndCommas(cVar);
                readToken = readToken(cVar);
                if (readToken != null) {
                    skipAll = skipAll(cVar, (byte) 61);
                    boolean skipWhitespaceAndCommas2 = skipWhitespaceAndCommas(cVar);
                    if (skipWhitespaceAndCommas || (!skipWhitespaceAndCommas2 && !cVar.d())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int skipAll2 = skipAll + skipAll(cVar, (byte) 61);
                        while (true) {
                            if (readToken == null) {
                                readToken = readToken(cVar);
                                if (skipWhitespaceAndCommas(cVar)) {
                                    continue;
                                    break;
                                }
                                skipAll2 = skipAll(cVar, (byte) 61);
                            }
                            if (skipAll2 == 0) {
                                continue;
                                break;
                            } else if (skipAll2 <= 1 && !skipWhitespaceAndCommas(cVar)) {
                                if (cVar.d() || cVar.c(0) != 34) {
                                    str = readToken(cVar);
                                } else {
                                    str = readQuotedString(cVar);
                                }
                                if (str == null || ((String) linkedHashMap.put(readToken, str)) != null) {
                                    return;
                                }
                                if (skipWhitespaceAndCommas(cVar) || cVar.d()) {
                                    readToken = null;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str2, (Map<String, String>) linkedHashMap));
                        str2 = readToken;
                    }
                } else if (cVar.d()) {
                    list.add(new Challenge(str2, (Map<String, String>) Collections.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            list.add(new Challenge(str2, (Map<String, String>) Collections.singletonMap((Object) null, readToken + repeat('=', skipAll))));
        }
    }

    private static boolean skipWhitespaceAndCommas(c cVar) {
        boolean z = false;
        while (!cVar.d()) {
            byte c2 = cVar.c(0);
            if (c2 != 44) {
                if (c2 != 32 && c2 != 9) {
                    break;
                }
                cVar.g();
            } else {
                cVar.g();
                z = true;
            }
        }
        return z;
    }

    private static int skipAll(c cVar, byte b2) {
        int i2 = 0;
        while (!cVar.d() && cVar.c(0) == b2) {
            i2++;
            cVar.g();
        }
        return i2;
    }

    private static String readQuotedString(c cVar) {
        if (cVar.g() == 34) {
            c cVar2 = new c();
            while (true) {
                long c2 = cVar.c(QUOTED_STRING_DELIMITERS);
                if (c2 == -1) {
                    return null;
                }
                if (cVar.c(c2) == 34) {
                    cVar2.write(cVar, c2);
                    cVar.g();
                    return cVar2.q();
                } else if (cVar.f46277b == c2 + 1) {
                    return null;
                } else {
                    cVar2.write(cVar, c2);
                    cVar.g();
                    cVar2.write(cVar, 1);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static String readToken(c cVar) {
        try {
            long b2 = cVar.b(TOKEN_DELIMITERS, 0);
            if (b2 == -1) {
                b2 = cVar.f46277b;
            }
            if (b2 != 0) {
                return cVar.e(b2);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c2, int i2) {
        char[] cArr = new char[i2];
        Arrays.fill(cArr, c2);
        return new String(cArr);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static int skipUntil(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int skipWhitespace(String str, int i2) {
        while (i2 < str.length() && ((r0 = str.charAt(i2)) == ' ' || r0 == 9)) {
            i2++;
        }
        return i2;
    }

    public static int parseSeconds(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
