package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.d;
import com.google.android.datatransport.f;
import com.google.firebase.encoders.a;
import com.google.firebase.encoders.c;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.j;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final a f39019a = new com.google.firebase.encoders.b.a().a(j.b.class, new j.c()).a(j.class, new j.a()).a();

    public static void a(Intent intent, f<String> fVar) {
        a("_nr", intent);
        if (fVar != null) {
            try {
                fVar.a(new com.google.android.datatransport.a(f39019a.a(new j.b(new j("MESSAGE_DELIVERED", intent))), d.VERY_LOW));
            } catch (c unused) {
            }
        }
    }

    public static void b(Intent intent) {
        a("_nd", intent);
    }

    public static void c(Intent intent) {
        a("_nf", intent);
    }

    public static boolean d(Intent intent) {
        if (intent == null || n(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    public static boolean e(Intent intent) {
        if (intent == null || n(intent)) {
            return false;
        }
        return d();
    }

    private static boolean n(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d() {
        /*
            java.lang.String r0 = "delivery_metrics_exported_to_big_query_enabled"
            r1 = 0
            com.google.firebase.c.e()     // Catch:{ IllegalStateException -> 0x0046 }
            com.google.firebase.c r2 = com.google.firebase.c.e()
            android.content.Context r2 = r2.a()
            java.lang.String r3 = "com.google.firebase.messaging"
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r1)
            java.lang.String r4 = "export_to_big_query"
            boolean r5 = r3.contains(r4)
            if (r5 == 0) goto L_0x0021
            boolean r0 = r3.getBoolean(r4, r1)
            return r0
        L_0x0021:
            android.content.pm.PackageManager r3 = r2.getPackageManager()     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            java.lang.String r2 = r2.getPackageName()     // Catch:{  }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r4)     // Catch:{  }
            if (r2 == 0) goto L_0x0046
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            boolean r3 = r3.containsKey(r0)     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r2 = r2.metaData     // Catch:{  }
            boolean r0 = r2.getBoolean(r0, r1)     // Catch:{  }
            return r0
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.m.d():boolean");
    }

    private static void a(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String l = l(intent);
        if (l != null) {
            bundle.putString("_nt", l);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException unused) {
            }
        }
        String p = p(intent);
        if (p != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(p));
            } catch (NumberFormatException unused2) {
            }
        }
        String o = o(intent);
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", o);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(valueOf).length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
        }
        com.google.firebase.analytics.connector.a aVar = (com.google.firebase.analytics.connector.a) com.google.firebase.c.e().a(com.google.firebase.analytics.connector.a.class);
        if (aVar != null) {
            aVar.a("fcm", str, bundle);
        }
    }

    static int f(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            return 0;
        }
    }

    static String g(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    static String h(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    static String i(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    static String j(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra(StringSet.message_id) : stringExtra;
    }

    static String a() {
        return com.google.firebase.c.e().a().getPackageName();
    }

    static String b() {
        return FirebaseInstanceId.getInstance(com.google.firebase.c.e()).d();
    }

    private static String o(Intent intent) {
        return (intent.getExtras() == null || !n.a(intent.getExtras())) ? "data" : "display";
    }

    static String k(Intent intent) {
        return (intent.getExtras() == null || !n.a(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION";
    }

    static String l(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    private static String p(Intent intent) {
        if (intent.hasExtra("google.c.a.udt")) {
            return intent.getStringExtra("google.c.a.udt");
        }
        return null;
    }

    static int m(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        if ("high".equals(stringExtra)) {
            return 1;
        }
        if ("normal".equals(stringExtra)) {
            return 2;
        }
        return 0;
    }

    static String c() {
        com.google.firebase.c e2 = com.google.firebase.c.e();
        String str = e2.c().f38756c;
        if (str != null) {
            return str;
        }
        String str2 = e2.c().f38755b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] split = str2.split(AppConstants.COLON);
        if (split.length < 2) {
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public static void a(Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                com.google.firebase.analytics.connector.a aVar = (com.google.firebase.analytics.connector.a) com.google.firebase.c.e().a(com.google.firebase.analytics.connector.a.class);
                Log.isLoggable("FirebaseMessaging", 3);
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aVar.a("fcm", "_ln", (Object) stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    aVar.a("fcm", "_cmp", bundle);
                }
            } else {
                Log.isLoggable("FirebaseMessaging", 3);
            }
        }
        a("_no", intent);
    }
}
