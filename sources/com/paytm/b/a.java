package com.paytm.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.b.a.b;
import com.paytm.b.a.c;
import com.paytm.b.a.d;
import com.paytm.b.a.f;
import com.paytm.utility.f;
import com.paytm.utility.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.m.p;
import net.one97.paytm.common.utility.l;

public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final C0707a f42632b = new C0707a((byte) 0);
    private static final String q = y.b(a.class).b();
    /* access modifiers changed from: private */
    public static u r;

    /* renamed from: a  reason: collision with root package name */
    final Context f42633a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42634c = true;

    /* renamed from: d  reason: collision with root package name */
    private final f f42635d = new f();

    /* renamed from: e  reason: collision with root package name */
    private final c f42636e = new c();

    /* renamed from: f  reason: collision with root package name */
    private final d f42637f = new d(this.f42633a);

    /* renamed from: g  reason: collision with root package name */
    private final b f42638g = new b();

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f42639h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedPreferences f42640i = this.f42633a.getSharedPreferences(this.p, 0);
    private final SharedPreferences j = this.f42633a.getSharedPreferences("app_pref", 0);
    private StringBuilder k = new StringBuilder();
    private SharedPreferences l;
    private final String m = "decryptExCount";
    private final String n = "decrypt_pref_debug";
    private HashMap<String, com.paytm.b.a.a> o;
    private final String p;

    public a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "verticalName");
        this.f42633a = context;
        this.p = str;
        SharedPreferences sharedPreferences = this.f42633a.getSharedPreferences(this.n, 0);
        k.a((Object) sharedPreferences, "context.getSharedPrefere…    Context.MODE_PRIVATE)");
        this.l = sharedPreferences;
    }

    /* renamed from: com.paytm.b.a$a  reason: collision with other inner class name */
    public static final class C0707a {
        private C0707a() {
        }

        public /* synthetic */ C0707a(byte b2) {
            this();
        }
    }

    public final <T> void a(String str, T t, boolean z) {
        k.c(str, "key");
        if (z) {
            if (t == null) {
                a(str, true);
                return;
            }
            String obj = t.toString();
            if (this.f42634c) {
                StringBuilder sb = new StringBuilder("put plainText: ");
                sb.append(str);
                sb.append(" -> ");
                sb.append(obj);
            }
            String a2 = this.f42637f.a(obj);
            if (a2 != null) {
                if (this.f42634c) {
                    StringBuilder sb2 = new StringBuilder("put cipherText: ");
                    sb2.append(str);
                    sb2.append(" -> ");
                    sb2.append(a2);
                }
                this.j.edit().putString(str, a2).apply();
            }
        } else if (t == null) {
            a(str, false);
        } else {
            String obj2 = t.toString();
            if (this.f42634c) {
                StringBuilder sb3 = new StringBuilder("put plainText: ");
                sb3.append(str);
                sb3.append(" -> ");
                sb3.append(obj2);
            }
            SharedPreferences sharedPreferences = this.f42640i;
            k.a((Object) sharedPreferences, "preference");
            sharedPreferences.getAll().size();
            b.a(str, obj2, this.p);
            if (this.f42634c) {
                StringBuilder sb4 = new StringBuilder("put criteria check: ");
                sb4.append(str);
                sb4.append(" length ");
                sb4.append(str.length());
                sb4.append(", ");
                sb4.append(obj2);
                sb4.append(" length ");
                sb4.append(obj2.length());
            }
            String a3 = this.f42636e.a(obj2);
            if (a3 != null) {
                if (this.f42634c) {
                    StringBuilder sb5 = new StringBuilder("put cipherText: ");
                    sb5.append(str);
                    sb5.append(" -> ");
                    sb5.append(a3);
                }
                c().putString(str, a3).apply();
            }
        }
    }

    public final void a(String str, Set<String> set, boolean z) {
        k.c(str, "key");
        if (set == null) {
            a(str, z);
            return;
        }
        if (this.f42634c) {
            StringBuilder sb = new StringBuilder("get plainText: ");
            sb.append(str);
            sb.append(" -> ");
            sb.append(set);
        }
        if (z) {
            this.j.edit().putStringSet(str, set).apply();
        } else {
            c().putStringSet(str, set).apply();
        }
    }

    public final <T> T b(String str, T t, boolean z) {
        T t2;
        T t3;
        k.c(str, "key");
        if (z) {
            String string = this.j.getString(str, String.valueOf(t));
            if (k.a((Object) string, (Object) String.valueOf(t)) || string == null) {
                return t;
            }
            if (this.f42634c) {
                StringBuilder sb = new StringBuilder("get cipherText: ");
                sb.append(str);
                sb.append(" -> ");
                sb.append(string);
            }
            t2 = this.f42637f.a(string, str, this);
            if (t2 == null) {
                return t;
            }
            if (this.f42634c) {
                StringBuilder sb2 = new StringBuilder("get plainText: ");
                sb2.append(str);
                sb2.append(" -> ");
                sb2.append(t2);
            }
        } else {
            String string2 = this.f42640i.getString(str, String.valueOf(t));
            if (k.a((Object) string2, (Object) String.valueOf(t)) || string2 == null) {
                return t;
            }
            if (this.f42634c) {
                StringBuilder sb3 = new StringBuilder("get cipherText: ");
                sb3.append(str);
                sb3.append(" -> ");
                sb3.append(string2);
            }
            t2 = this.f42636e.a(string2, str, this);
            if (t2 == null) {
                return t;
            }
            if (this.f42634c) {
                StringBuilder sb4 = new StringBuilder("get plainText: ");
                sb4.append(str);
                sb4.append(" -> ");
                sb4.append(t2);
            }
        }
        f fVar = this.f42635d;
        k.c(t2, "value");
        if (t instanceof Boolean) {
            t3 = Boolean.valueOf(Boolean.parseBoolean(t2));
        } else if (t instanceof String) {
            t3 = (Object) t2;
        } else if (t instanceof Float) {
            t3 = Float.valueOf(Float.parseFloat(t2));
        } else if (t instanceof Long) {
            t3 = Long.valueOf(Long.parseLong(t2));
        } else if (t instanceof Integer) {
            t3 = Integer.valueOf(Integer.parseInt(t2));
        } else {
            throw new RuntimeException(fVar.f42660a + " Cannot convert " + t2 + " to default value type.");
        }
        return t3 == null ? t : t3;
    }

    public final Set<String> b(String str, Set<String> set, boolean z) {
        k.c(str, "key");
        if (z) {
            return this.j.getStringSet(str, set);
        }
        return this.f42640i.getStringSet(str, set);
    }

    public final void a(String str, boolean z) {
        k.c(str, "key");
        if (z) {
            this.j.edit().remove(str).apply();
        } else {
            c().remove(str).apply();
        }
    }

    public final void a() {
        c().clear().apply();
    }

    public final boolean b(String str, boolean z) {
        k.c(str, "key");
        if (z) {
            return this.j.contains(str);
        }
        return this.f42640i.contains(str);
    }

    public final void a(List<String> list) {
        if (list != null) {
            this.f42639h = new HashMap<>();
            Map<String, ?> a2 = this.f42637f.a(list, this);
            if (this.f42634c) {
                StringBuilder sb = new StringBuilder("migrate: size ");
                sb.append(a2 != null ? Integer.valueOf(a2.size()) : null);
                sb.append(" \n ");
                sb.append(a2);
            }
            if (a2 != null && (!a2.isEmpty())) {
                for (Map.Entry next : a2.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value instanceof String) {
                        HashMap<String, String> hashMap = this.f42639h;
                        if (hashMap == null) {
                            k.a("keyValMap");
                        }
                        hashMap.put(str, value);
                        a(str, value, false);
                        a(str, true);
                    } else if (value instanceof Object) {
                        try {
                            HashMap<String, String> hashMap2 = this.f42639h;
                            if (hashMap2 == null) {
                                k.a("keyValMap");
                            }
                            hashMap2.put(str, value.toString());
                            a(str, (Set<String>) (Set) value, false);
                            a(str, true);
                        } catch (Exception e2) {
                            String.valueOf(e2.getMessage());
                        }
                    }
                }
            }
            a("migrated", Boolean.TRUE, false);
        }
    }

    public final void a(List<String> list, f.a aVar) {
        k.c(aVar, "prefName");
        if (list != null) {
            this.f42639h = new HashMap<>();
            Map<String, ?> a2 = this.f42637f.a(list, aVar, this);
            if (this.f42634c) {
                StringBuilder sb = new StringBuilder("migrate: size ");
                sb.append(a2 != null ? Integer.valueOf(a2.size()) : null);
                sb.append(" \n ");
                sb.append(a2);
            }
            if (a2 != null && (!a2.isEmpty())) {
                for (Map.Entry next : a2.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value instanceof String) {
                        HashMap<String, String> hashMap = this.f42639h;
                        if (hashMap == null) {
                            k.a("keyValMap");
                        }
                        hashMap.put(str, value);
                        a(str, value, false);
                    } else if (value instanceof Object) {
                        try {
                            HashMap<String, String> hashMap2 = this.f42639h;
                            if (hashMap2 == null) {
                                k.a("keyValMap");
                            }
                            hashMap2.put(str, value.toString());
                            a(str, (Set<String>) (Set) value, false);
                        } catch (Exception e2) {
                            String.valueOf(e2.getMessage());
                        }
                    }
                }
            }
            a("migrated", Boolean.TRUE, false);
            SharedPreferences sharedPreferences = this.f42633a.getSharedPreferences(aVar.getPrefname(), 0);
            sharedPreferences.edit().clear().apply();
            AsyncTask.SERIAL_EXECUTOR.execute(new b(this, sharedPreferences, aVar));
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SharedPreferences f42647b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a f42648c;

        b(a aVar, SharedPreferences sharedPreferences, f.a aVar2) {
            this.f42646a = aVar;
            this.f42647b = sharedPreferences;
            this.f42648c = aVar2;
        }

        public final void run() {
            SharedPreferences sharedPreferences = this.f42647b;
            k.a((Object) sharedPreferences, "pref");
            if (sharedPreferences.getAll().isEmpty()) {
                a aVar = this.f42646a;
                f.a aVar2 = this.f42648c;
                k.c(aVar2, "prefName");
                try {
                    File file = new File(aVar.f42633a.getApplicationInfo().dataDir.toString() + "/shared_prefs");
                    String str = aVar2.getPrefname() + ".xml";
                    File file2 = new File(file, str);
                    StringBuilder sb = new StringBuilder("File is present at ");
                    sb.append(file2.getAbsolutePath());
                    sb.append("  and its cannonical path is ");
                    sb.append(file2.getCanonicalPath());
                    if (!file2.exists() || file2.isDirectory()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" : is not present and cannot be deleted");
                        return;
                    }
                    boolean delete = file2.delete();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" : is present and deleted with status ");
                    sb3.append(delete);
                    new StringBuilder("Does File Exists after deletion ").append(file2.exists());
                } catch (Exception unused) {
                }
            }
        }
    }

    private final SharedPreferences.Editor c() {
        SharedPreferences.Editor edit = this.f42640i.edit();
        k.a((Object) edit, "preference.edit()");
        return edit;
    }

    public final void a(HashMap<String, com.paytm.b.a.a> hashMap) {
        k.c(hashMap, "prefMap");
        this.o = hashMap;
    }

    public final synchronized void a(Exception exc, String str, String str2) {
        k.c(exc, "e");
        k.c(str, "key");
        k.c(str2, "value");
        StringBuilder sb = new StringBuilder("error is ");
        sb.append(exc.getMessage());
        sb.append(" for key : ");
        sb.append(str);
        sb.append(" and value ");
        sb.append(str2);
        sb.append(' ');
        StringBuilder sb2 = this.k;
        sb2.append("decryptEx:" + exc.getMessage());
        sb2.append(", ");
        StringBuilder sb3 = this.k;
        sb3.append("decryptKey:".concat(String.valueOf(str)));
        sb3.append(", ");
        StringBuilder sb4 = this.k;
        sb4.append("decryptVal:".concat(String.valueOf(str2)));
        sb4.append(", ");
        SharedPreferences sharedPreferences = this.l;
        if (sharedPreferences == null) {
            k.a("mSharedPreferencesDecryptError");
        }
        int intValue = (sharedPreferences != null ? Integer.valueOf(sharedPreferences.getInt(this.m, 0)) : null).intValue();
        if (r != null) {
            try {
                d();
                SharedPreferences sharedPreferences2 = this.l;
                if (sharedPreferences2 == null) {
                    k.a("mSharedPreferencesDecryptError");
                }
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                k.a((Object) edit, "mSharedPreferencesDecryptError.edit()");
                edit.putInt(this.m, intValue + 1);
                edit.apply();
                l.a("decryptExCount:" + intValue + 1 + AppConstants.COMMA + this.k.toString());
                l.a((Throwable) new Exception());
                this.k.setLength(0);
                u uVar = r;
                if (uVar != null) {
                    exc.getMessage();
                    uVar.a();
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void d() {
        File file = new File(this.f42633a.getApplicationInfo().dataDir.toString() + "/shared_prefs");
        if (a(file, "app_pref.xml")) {
            File[] listFiles = file.listFiles();
            k.a((Object) listFiles, "sharedPrefDir.listFiles()");
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                String name = file2.getName();
                k.a((Object) name, "file.getName()");
                if (name != null) {
                    String lowerCase = name.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (!file2.isDirectory()) {
                        CharSequence charSequence = lowerCase;
                        if (!p.a(charSequence, (CharSequence) Payload.SOURCE_GOOGLE, false) && !p.a(charSequence, (CharSequence) "facebook", false) && !p.a(charSequence, (CharSequence) "appsflyer", false) && !p.a(charSequence, (CharSequence) "decrypt", false) && !p.a(charSequence, (CharSequence) "hansel", false)) {
                            int a2 = p.a((CharSequence) name, AppUtility.CENTER_DOT, p.d(name));
                            if (a2 > 0) {
                                if (name != null) {
                                    name = name.substring(0, a2);
                                    k.a((Object) name, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                } else {
                                    throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                            this.f42633a.getSharedPreferences(name, 0).edit().clear().apply();
                            StringBuilder sb = this.k;
                            sb.append(name + " cleared");
                            sb.append(", ");
                        }
                    }
                    i2++;
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                }
            }
            return;
        }
        this.k.append(" path not found , ");
        e();
    }

    private final void e() {
        HashMap<String, com.paytm.b.a.a> hashMap = this.o;
        if (hashMap == null) {
            k.a("prefMap");
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ((com.paytm.b.a.a) entry.getValue()).a();
            StringBuilder sb = this.k;
            sb.append(entry + " cleared");
            sb.append(", ");
        }
    }

    private static boolean a(File file, String str) {
        while (true) {
            File[] listFiles = file.listFiles();
            k.a((Object) listFiles, "fileRoot.listFiles()");
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                String name = file2.getName();
                k.a((Object) name, "file.name");
                if (file2.isDirectory()) {
                    file = file2;
                } else if (p.a(name, str, true)) {
                    return true;
                } else {
                    i2++;
                }
            }
            return false;
        }
    }
}
