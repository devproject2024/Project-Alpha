package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.e, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public static final Scope f8211a = new Scope("profile");

    /* renamed from: b  reason: collision with root package name */
    public static final Scope f8212b = new Scope(AppConstants.KEY_EMAIL);

    /* renamed from: c  reason: collision with root package name */
    public static final Scope f8213c = new Scope("openid");

    /* renamed from: d  reason: collision with root package name */
    public static final Scope f8214d = new Scope("https://www.googleapis.com/auth/games_lite");

    /* renamed from: e  reason: collision with root package name */
    public static final Scope f8215e = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: f  reason: collision with root package name */
    public static final GoogleSignInOptions f8216f;

    /* renamed from: g  reason: collision with root package name */
    public static final GoogleSignInOptions f8217g = new a().a(f8214d, new Scope[0]).b();
    private static Comparator<Scope> s = new f();

    /* renamed from: h  reason: collision with root package name */
    private final int f8218h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<Scope> f8219i;
    /* access modifiers changed from: private */
    public Account j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public final boolean l;
    /* access modifiers changed from: private */
    public final boolean m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> p;
    /* access modifiers changed from: private */
    public String q;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> r;

    public static GoogleSignInOptions a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.optString("accountName", (String) null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", (String) null), jSONObject.optString("hostedDomain", (String) null), (Map<Integer, GoogleSignInOptionsExtensionParcelable>) new HashMap(), (String) null);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Set<Scope> f8220a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public String f8221b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8222c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8223d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8224e;

        /* renamed from: f  reason: collision with root package name */
        private String f8225f;

        /* renamed from: g  reason: collision with root package name */
        private Account f8226g;

        /* renamed from: h  reason: collision with root package name */
        private String f8227h;

        /* renamed from: i  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f8228i = new HashMap();

        public a() {
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            s.a(googleSignInOptions);
            this.f8220a = new HashSet(googleSignInOptions.f8219i);
            this.f8222c = googleSignInOptions.l;
            this.f8223d = googleSignInOptions.m;
            this.f8224e = googleSignInOptions.k;
            this.f8225f = googleSignInOptions.n;
            this.f8226g = googleSignInOptions.j;
            this.f8227h = googleSignInOptions.o;
            this.f8228i = GoogleSignInOptions.b((List<GoogleSignInOptionsExtensionParcelable>) googleSignInOptions.p);
            this.f8221b = googleSignInOptions.q;
        }

        public final a a() {
            this.f8220a.add(GoogleSignInOptions.f8213c);
            return this;
        }

        public final a a(Scope scope, Scope... scopeArr) {
            this.f8220a.add(scope);
            this.f8220a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final GoogleSignInOptions b() {
            if (this.f8220a.contains(GoogleSignInOptions.f8215e) && this.f8220a.contains(GoogleSignInOptions.f8214d)) {
                this.f8220a.remove(GoogleSignInOptions.f8214d);
            }
            if (this.f8224e && (this.f8226g == null || !this.f8220a.isEmpty())) {
                a();
            }
            return new GoogleSignInOptions(new ArrayList(this.f8220a), this.f8226g, this.f8224e, this.f8222c, this.f8223d, this.f8225f, this.f8227h, this.f8228i, this.f8221b);
        }
    }

    GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String str3) {
        this(i2, arrayList, account, z, z2, z3, str, str2, b((List<GoogleSignInOptionsExtensionParcelable>) arrayList2), str3);
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.f8218h = i2;
        this.f8219i = arrayList;
        this.j = account;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = str;
        this.o = str2;
        this.p = new ArrayList<>(map.values());
        this.r = map;
        this.q = str3;
    }

    public final ArrayList<Scope> a() {
        return new ArrayList<>(this.f8219i);
    }

    /* access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> b(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.f8242a), next);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r3.j.equals(r4.j) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r3.n.equals(r4.n) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.p     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 > 0) goto L_0x0080
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.p     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 <= 0) goto L_0x0017
            goto L_0x0080
        L_0x0017:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f8219i     // Catch:{ ClassCastException -> 0x0080 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList r2 = r4.a()     // Catch:{ ClassCastException -> 0x0080 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f8219i     // Catch:{ ClassCastException -> 0x0080 }
            java.util.ArrayList r2 = r4.a()     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x0034
            goto L_0x0080
        L_0x0034:
            android.accounts.Account r1 = r3.j     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x003d
            android.accounts.Account r1 = r4.j     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != 0) goto L_0x0080
            goto L_0x0047
        L_0x003d:
            android.accounts.Account r1 = r3.j     // Catch:{ ClassCastException -> 0x0080 }
            android.accounts.Account r2 = r4.j     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
        L_0x0047:
            java.lang.String r1 = r3.n     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0058
            java.lang.String r1 = r4.n     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
            goto L_0x0062
        L_0x0058:
            java.lang.String r1 = r3.n     // Catch:{ ClassCastException -> 0x0080 }
            java.lang.String r2 = r4.n     // Catch:{ ClassCastException -> 0x0080 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 == 0) goto L_0x0080
        L_0x0062:
            boolean r1 = r3.m     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.m     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            boolean r1 = r3.k     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.k     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            boolean r1 = r3.l     // Catch:{ ClassCastException -> 0x0080 }
            boolean r2 = r4.l     // Catch:{ ClassCastException -> 0x0080 }
            if (r1 != r2) goto L_0x0080
            java.lang.String r1 = r3.q     // Catch:{ ClassCastException -> 0x0080 }
            java.lang.String r4 = r4.q     // Catch:{ ClassCastException -> 0x0080 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0080 }
            if (r4 == 0) goto L_0x0080
            r4 = 1
            return r4
        L_0x0080:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f8219i;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            arrayList.add(((Scope) obj).f8352a);
        }
        Collections.sort(arrayList);
        return new com.google.android.gms.auth.api.signin.internal.a().a((Object) arrayList).a((Object) this.j).a((Object) this.n).a(this.m).a(this.k).a(this.l).a((Object) this.q).f8255a;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f8219i, s);
            ArrayList arrayList = this.f8219i;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                jSONArray.put(((Scope) obj).f8352a);
            }
            jSONObject.put("scopes", jSONArray);
            if (this.j != null) {
                jSONObject.put("accountName", this.j.name);
            }
            jSONObject.put("idTokenRequested", this.k);
            jSONObject.put("forceCodeForRefreshToken", this.m);
            jSONObject.put("serverAuthRequested", this.l);
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("serverClientId", this.n);
            }
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("hostedDomain", this.o);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* synthetic */ GoogleSignInOptions(ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    static {
        a a2 = new a().a();
        a2.f8220a.add(f8211a);
        f8216f = a2.b();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8218h);
        b.a(parcel, 2, a(), false);
        b.a(parcel, 3, this.j, i2, false);
        b.a(parcel, 4, this.k);
        b.a(parcel, 5, this.l);
        b.a(parcel, 6, this.m);
        b.a(parcel, 7, this.n, false);
        b.a(parcel, 8, this.o, false);
        b.a(parcel, 9, this.p, false);
        b.a(parcel, 10, this.q, false);
        b.b(parcel, a2);
    }
}
