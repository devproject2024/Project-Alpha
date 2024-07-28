package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.c.ad;
import com.google.c.j;
import com.google.firebase.remoteconfig.a.a;
import com.google.firebase.remoteconfig.internal.f;
import com.google.firebase.remoteconfig.o;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import e.a.a.a;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<DateFormat> f39420a = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f39421c = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f39422b;

    /* renamed from: d  reason: collision with root package name */
    private final Context f39423d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39424e;

    public q(Context context, String str) {
        this.f39423d = context;
        this.f39424e = str;
        this.f39422b = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    public final void a(Map<String, a> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            a aVar = (a) next.getValue();
            a a2 = a(str, "fetch");
            a a3 = a(str, "activate");
            a a4 = a(str, "defaults");
            if (aVar.f39425a != null) {
                a2.a(aVar.f39425a, true);
            }
            if (aVar.f39426b != null) {
                a3.a(aVar.f39426b, true);
            }
            if (aVar.f39427c != null) {
                a4.a(aVar.f39427c, true);
            }
        }
    }

    public static Map<String, f> a(a.C0659a aVar) {
        HashMap hashMap = new HashMap();
        Date date = new Date(aVar.f39318b);
        JSONArray a2 = a((List<j>) aVar.f39319c);
        for (a.e next : aVar.f39317a) {
            String str = next.f39326a;
            if (str.startsWith("configns:")) {
                str = str.substring(9);
            }
            f.a a3 = f.a().a(b(next.f39327b));
            a3.f39372a = date;
            if (str.equals("firebase")) {
                a3.a(a2);
            }
            try {
                hashMap.put(str, a3.a());
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    private static JSONArray a(List<j> list) {
        JSONArray jSONArray = new JSONArray();
        for (j a2 : list) {
            a.c a3 = a(a2);
            if (a3 != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("experimentId", a3.f46008a);
                    jSONObject.put("variantId", a3.f46009b);
                    jSONObject.put("experimentStartTime", f39420a.get().format(new Date(a3.f46010c)));
                    jSONObject.put("triggerEvent", a3.f46011g);
                    jSONObject.put("triggerTimeoutMillis", a3.f46012h);
                    jSONObject.put("timeToLiveMillis", a3.f46013i);
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONArray;
    }

    private static a.c a(j jVar) {
        try {
            j.e it2 = jVar.iterator();
            byte[] bArr = new byte[jVar.size()];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = ((Byte) it2.next()).byteValue();
            }
            return a.c.a(bArr);
        } catch (ad unused) {
            return null;
        }
    }

    private static Map<String, String> b(List<a.c> list) {
        HashMap hashMap = new HashMap();
        for (a.c next : list) {
            hashMap.put(next.f39322a, next.f39323b.toString(f39421c));
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e A[SYNTHETIC, Splitter:B:17:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0025 A[SYNTHETIC, Splitter:B:25:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x002c A[SYNTHETIC, Splitter:B:33:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.remoteconfig.a.a.g a() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f39423d
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "persisted_config"
            java.io.FileInputStream r0 = r0.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x0029, IOException -> 0x0022, all -> 0x001b }
            com.google.firebase.remoteconfig.a.a$g r1 = com.google.firebase.remoteconfig.a.a.g.a((java.io.InputStream) r0)     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0023, all -> 0x0016 }
            if (r0 == 0) goto L_0x0015
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r1
        L_0x0016:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x001c
        L_0x001b:
            r0 = move-exception
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            throw r0
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r1
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.q.a():com.google.firebase.remoteconfig.a.a$g");
    }

    private a a(String str, String str2) {
        return o.a(this.f39423d, this.f39424e, str, str2);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f f39425a;

        /* renamed from: b  reason: collision with root package name */
        public f f39426b;

        /* renamed from: c  reason: collision with root package name */
        public f f39427c;

        public /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
        }
    }
}
