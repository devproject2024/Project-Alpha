package com.sendbird.android;

import android.text.TextUtils;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonNull;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.Request;
import com.sendbird.android.shadow.okhttp3.RequestBody;
import com.sendbird.android.shadow.okhttp3.Response;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

final class c {

    /* renamed from: a  reason: collision with root package name */
    AtomicBoolean f44699a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Call> f44700b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    private final OkHttpClient f44701c;

    c(OkHttpClient okHttpClient) {
        this.f44701c = okHttpClient;
    }

    private static Request.Builder b(String str) throws SendBirdException {
        String str2;
        boolean z = !TextUtils.isEmpty(APIClient.a().h());
        Logger.d("++ hasSessionKey : ".concat(String.valueOf(z)));
        if (z && SendBird.getConnectionState() == SendBird.ConnectionState.CLOSED && !SendBird.isAppBackground()) {
            SendBird.reconnect();
        }
        if (!z) {
            if (!u.a().f45287d.get()) {
                SendBird.ConnectionState c2 = u.a().c();
                Logger.i("++ SessionKey is empty, connection state : %s", c2);
                int i2 = AnonymousClass1.f44702a[c2.ordinal()];
                if (i2 == 1) {
                    throw u.b();
                } else if (i2 == 2) {
                    u.a().f();
                }
            } else {
                throw u.b();
            }
        }
        Request.Builder header = new Request.Builder().header("Accept", "application/json").header("User-Agent", "Jand/" + SendBird.getSDKVersion()).header(StringSet.SBUserAgent, SendBird.makeExUserAgentString()).header(StringSet.SendBird, "Android," + SendBird.getOSVersion() + AppConstants.COMMA + SendBird.getSDKVersion() + AppConstants.COMMA + SendBird.getApplicationId()).header("Connection", "keep-alive").header(StringSet.RequestSentTimestamp, String.valueOf(System.currentTimeMillis())).header(StringSet.SessionKey, APIClient.a().h());
        StringBuilder sb = new StringBuilder();
        if (SendBird.getApplicationId() == null || SendBird.getApplicationId().length() == 0) {
            throw new SendBirdException("Application ID is not set. Initialize SendBird class.", SendBirdError.ERR_INVALID_INITIALIZATION);
        }
        if (u.f45285b != null) {
            str2 = u.f45285b;
        } else {
            str2 = "https://api-" + SendBird.getApplicationId() + ".sendbird.com";
        }
        sb.append(str2);
        sb.append(str);
        return header.url(sb.toString());
    }

    /* renamed from: com.sendbird.android.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f44702a = new int[SendBird.ConnectionState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.sendbird.android.SendBird$ConnectionState[] r0 = com.sendbird.android.SendBird.ConnectionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44702a = r0
                int[] r0 = f44702a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.SendBird$ConnectionState r1 = com.sendbird.android.SendBird.ConnectionState.CLOSED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f44702a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.SendBird$ConnectionState r1 = com.sendbird.android.SendBird.ConnectionState.CONNECTING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.c.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str) throws SendBirdException {
        Logger.d("++ request GET path : ".concat(String.valueOf(str)));
        return a(b(str).get().build());
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, RequestBody requestBody) throws SendBirdException {
        Logger.d("++ request POST path : ".concat(String.valueOf(str)));
        return a(b(str).post(requestBody).build());
    }

    /* access modifiers changed from: package-private */
    public final JsonElement b(String str, RequestBody requestBody) throws SendBirdException {
        Logger.d("++ request PUT path : ".concat(String.valueOf(str)));
        return a(b(str).put(requestBody).build());
    }

    /* access modifiers changed from: package-private */
    public final JsonElement c(String str, RequestBody requestBody) throws SendBirdException {
        Logger.d("++ request DELETE path : ".concat(String.valueOf(str)));
        return a(b(str).delete(requestBody).build());
    }

    private JsonElement a(Request request) throws SendBirdException {
        int i2 = SendBirdError.ERR_FILE_UPLOAD_CANCELED;
        try {
            if (!this.f44699a.getAndSet(false)) {
                Call newCall = this.f44701c.newCall(request);
                this.f44700b.set(newCall);
                JsonElement a2 = a(newCall.execute());
                this.f44700b.set((Object) null);
                return a2;
            }
            Logger.d("Thre request already canceled");
            throw new SendBirdException("Canceled", SendBirdError.ERR_FILE_UPLOAD_CANCELED);
        } catch (IOException e2) {
            Logger.d((Throwable) e2);
            String message = e2.getMessage();
            if (!this.f44699a.get()) {
                i2 = SendBirdError.ERR_NETWORK;
            }
            throw new SendBirdException(message, i2);
        } catch (Exception e3) {
            Logger.d((Throwable) e3);
            throw (e3 instanceof SendBirdException ? (SendBirdException) e3 : new SendBirdException(e3.getMessage(), SendBirdError.ERR_REQUEST_FAILED));
        } catch (Throwable th) {
            this.f44700b.set((Object) null);
            throw th;
        }
    }

    private static JsonElement a(Response response) throws SendBirdException {
        String str;
        if (response.code() != 500) {
            String str2 = null;
            try {
                int i2 = 0;
                String str3 = "";
                if (response.body() != null) {
                    str2 = response.body().string();
                    if (response.handshake() != null) {
                        str = "(" + response.handshake().tlsVersion().javaName() + ")";
                    } else {
                        str = str3;
                    }
                    Logger.d("API response tlsVersion = %s, [%s], body : %s", str, response.request().url(), str2);
                }
                if (str2 == null || str2.length() <= 0) {
                    return JsonNull.INSTANCE;
                }
                try {
                    JsonElement parse = new JsonParser().parse(str2);
                    if (response.isSuccessful() || !parse.isJsonObject() || !parse.getAsJsonObject().has("error") || !parse.getAsJsonObject().get("error").isJsonPrimitive() || !parse.getAsJsonObject().get("error").getAsBoolean()) {
                        return parse;
                    }
                    if (parse.getAsJsonObject().has("message") && parse.getAsJsonObject().get("message").isJsonPrimitive()) {
                        str3 = parse.getAsJsonObject().get("message").getAsString();
                    }
                    if (parse.getAsJsonObject().has("code") && parse.getAsJsonObject().get("code").isJsonPrimitive()) {
                        i2 = parse.getAsJsonObject().get("code").getAsInt();
                    }
                    throw new SendBirdException(str3, i2);
                } catch (Exception e2) {
                    throw new SendBirdException(e2.getMessage(), SendBirdError.ERR_MALFORMED_DATA);
                }
            } catch (IOException e3) {
                throw new SendBirdException(e3.getMessage(), SendBirdError.ERR_MALFORMED_DATA);
            }
        } else {
            throw new SendBirdException(response.message(), SendBirdError.ERR_INTERNAL_SERVER_ERROR);
        }
    }
}
