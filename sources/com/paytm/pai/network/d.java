package com.paytm.pai.network;

import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.paytm.pai.network.model.EventResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.upi.util.UpiConstants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43389a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f43390b;

    public d(boolean z) {
        this.f43390b = z;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final EventResponse<String> a(String str, String str2, String str3, String str4, String str5) throws IllegalArgumentException {
        k.c(str, "url");
        return a(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, str, str2, str3, str4, str5, true);
    }

    public final EventResponse<String> a(String str, String str2, String str3, String str4, String str5, boolean z) throws IllegalArgumentException {
        k.c(str, "url");
        k.c(str3, "requestBody");
        return a("POST", str, str2, str3, str4, str5, z);
    }

    public final EventResponse<String> b(String str, String str2, String str3, String str4, String str5) throws IllegalArgumentException {
        k.c(str, "url");
        return a("DELETE", str, str2, str3, str4, str5, true);
    }

    private static void a(int i2, EventResponse<?> eventResponse) {
        k.c(eventResponse, Payload.RESPONSE);
        if (i2 == 1) {
            eventResponse.setErrorMessage("Network Error");
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 200) {
            eventResponse.setErrorMessage((String) null);
            eventResponse.setSuccess(Boolean.TRUE);
        } else if (i2 == 202) {
            eventResponse.setErrorMessage((String) null);
            eventResponse.setSuccess(Boolean.TRUE);
        } else if (i2 == 403) {
            eventResponse.setErrorMessage("Forbidden");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 500) {
            eventResponse.setErrorMessage("Server Error");
            eventResponse.setSuccess(Boolean.FALSE);
        } else if (i2 == 400) {
            eventResponse.setErrorMessage("Invalid Request");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
            eventResponse.setDiscard(Boolean.TRUE);
        } else if (i2 != 401) {
            eventResponse.setErrorMessage("UnKnown Error");
            eventResponse.setSuccess(Boolean.FALSE);
        } else {
            eventResponse.setErrorMessage("Unauthorized");
            eventResponse.setDoNotRetry(Boolean.TRUE);
            eventResponse.setSuccess(Boolean.FALSE);
        }
    }

    public final EventResponse<String> a(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        if (this.f43390b) {
            StringBuilder sb = new StringBuilder("makeCall Method: ");
            sb.append(str7);
            sb.append(" URL: ");
            sb.append(str8);
        }
        c cVar = c.f43385a;
        OkHttpClient a2 = c.a(z, this.f43390b);
        Request.Builder addHeader = new Request.Builder().url(str8).addHeader("content-type", "application/json").addHeader(UpiConstants.CACHE_CONTROL, "no-cache");
        if (str9 != null && str12 != null && str11 != null) {
            String c2 = c(str11, str7, str9, str10, str12);
            if (c2 != null) {
                addHeader.addHeader("hash", c2);
            }
        } else if (this.f43390b) {
            StringBuilder sb2 = new StringBuilder("Header: skipping HMAC because secret is null: ");
            boolean z2 = false;
            sb2.append(str12 == null);
            sb2.append(" or clientName is null:  ");
            sb2.append(str11 == null);
            sb2.append(" or apiUrl is null:  ");
            if (str9 == null) {
                z2 = true;
            }
            sb2.append(z2);
        }
        if (str11 != null) {
            addHeader.addHeader("x-requester", str11);
        }
        if (k.a((Object) H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, (Object) str7)) {
            addHeader.get();
        } else if (k.a((Object) "PUT", (Object) str7)) {
            addHeader.put(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str10));
        } else if (k.a((Object) "POST", (Object) str7)) {
            addHeader.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str10));
        } else if (k.a((Object) "DELETE", (Object) str7)) {
            addHeader.delete(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str10));
        }
        k.a((Object) addHeader, "builder");
        try {
            Response execute = FirebasePerfOkHttpClient.execute(a2.newCall(addHeader.build()));
            if (this.f43390b) {
                new StringBuilder("RESPONSE : ").append(execute);
            }
            k.a((Object) execute, Payload.RESPONSE);
            return a(execute);
        } catch (IOException e2) {
            if (this.f43390b && e2.getMessage() != null && e2.getMessage() == null) {
                k.a();
            }
            EventResponse<String> eventResponse = new EventResponse<>((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
            eventResponse.setResponse(e2.getMessage());
            eventResponse.setResponseCode(1);
            a(1, eventResponse);
            return eventResponse;
        }
    }

    private static String c(String str, String str2, String str3, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer(str2);
        try {
            String decode = URLDecoder.decode(str3, "UTF8");
            k.a((Object) decode, "url");
            if (p.c(decode, "/", false)) {
                decode = decode.substring(0, decode.length() - 1);
                k.a((Object) decode, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            stringBuffer.append("|");
            stringBuffer.append(decode);
            stringBuffer.append("|x-requester:");
            stringBuffer.append(str);
            stringBuffer.append("|");
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            String stringBuffer2 = stringBuffer.toString();
            k.a((Object) stringBuffer2, "buffer.toString()");
            Mac instance = Mac.getInstance("HmacSHA256");
            Charset forName = Charset.forName("UTF8");
            k.a((Object) forName, "Charset.forName(charsetName)");
            if (str5 != null) {
                byte[] bytes = str5.getBytes(forName);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                instance.init(new SecretKeySpec(bytes, "HmacSHA256"));
                Charset forName2 = Charset.forName("UTF8");
                k.a((Object) forName2, "Charset.forName(charsetName)");
                if (stringBuffer2 != null) {
                    byte[] bytes2 = stringBuffer2.getBytes(forName2);
                    k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
                    byte[] doFinal = instance.doFinal(bytes2);
                    k.a((Object) doFinal, "mac.doFinal(value.toByteArray(charset(ENCODING)))");
                    String a2 = b.a(doFinal);
                    k.a((Object) a2, "HmacConverter.bytesToHex…(key, buffer.toString()))");
                    String lowerCase = a2.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    return lowerCase;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalArgumentException("unable to calculate request hash");
        } catch (NoSuchAlgorithmException unused2) {
            throw new IllegalArgumentException("unable to calculate request hash");
        } catch (InvalidKeyException unused3) {
            throw new IllegalArgumentException("unable to calculate request hash");
        }
    }

    private final EventResponse<String> a(Response response) {
        EventResponse eventResponse = new EventResponse((Object) null, (Integer) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 63, (g) null);
        Integer num = null;
        try {
            ResponseBody body = response.body();
            eventResponse.setResponse(body != null ? body.string() : null);
        } catch (Exception e2) {
            if (this.f43390b && e2.getMessage() != null && e2.getMessage() == null) {
                k.a();
            }
        }
        Response networkResponse = response.networkResponse();
        if (networkResponse != null) {
            num = Integer.valueOf(networkResponse.code());
        }
        eventResponse.setResponseCode(num);
        Integer responseCode = eventResponse.getResponseCode();
        a(responseCode != null ? responseCode.intValue() : 0, eventResponse);
        return eventResponse;
    }
}
