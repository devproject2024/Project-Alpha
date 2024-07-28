package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.b;
import com.sendbird.android.constant.StringSet;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class ar {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f38828a;

    /* renamed from: b  reason: collision with root package name */
    final Context f38829b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Long> f38830c = new androidx.a.a();

    public ar(Context context) {
        this.f38829b = context;
        this.f38828a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(b.c(this.f38829b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !b()) {
                    a();
                    FirebaseInstanceId.a().j();
                }
            } catch (IOException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                    } else {
                        new String("Error creating file in no backup dir: ");
                    }
                }
            }
        }
    }

    static class a {

        /* renamed from: d  reason: collision with root package name */
        private static final long f38831d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f38832a;

        /* renamed from: b  reason: collision with root package name */
        final String f38833b;

        /* renamed from: c  reason: collision with root package name */
        final long f38834c;

        private a(String str, String str2, long j) {
            this.f38832a = str;
            this.f38833b = str2;
            this.f38834c = j;
        }

        static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString(StringSet.token), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                sb.append("Failed to parse token: ");
                sb.append(valueOf);
                return null;
            }
        }

        static String a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(StringSet.token, str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
                sb.append("Failed to encode token: ");
                sb.append(valueOf);
                return null;
            }
        }

        static String a(a aVar) {
            if (aVar == null) {
                return null;
            }
            return aVar.f38832a;
        }

        /* access modifiers changed from: package-private */
        public final boolean b(String str) {
            return System.currentTimeMillis() > this.f38834c + f38831d || !str.equals(this.f38833b);
        }
    }

    private synchronized boolean b() {
        return this.f38828a.getAll().isEmpty();
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void a() {
        this.f38830c.clear();
        this.f38828a.edit().clear().commit();
    }

    public final synchronized a a(String str, String str2, String str3) {
        return a.a(this.f38828a.getString(b(str, str2, str3), (String) null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = a.a(str4, str5, System.currentTimeMillis());
        if (a2 != null) {
            SharedPreferences.Editor edit = this.f38828a.edit();
            edit.putString(b(str, str2, str3), a2);
            edit.commit();
        }
    }

    private long c(String str) {
        String string = this.f38828a.getString(a(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final synchronized void b(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f38828a.edit();
        for (String next : this.f38828a.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    public final synchronized long a(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.f38828a.contains(a(str, "cre"))) {
            SharedPreferences.Editor edit = this.f38828a.edit();
            edit.putString(a(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = c(str);
        }
        this.f38830c.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }
}
