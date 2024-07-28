package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e();

    /* renamed from: c  reason: collision with root package name */
    private static e f8202c = h.d();

    /* renamed from: a  reason: collision with root package name */
    public String f8203a;

    /* renamed from: b  reason: collision with root package name */
    public String f8204b;

    /* renamed from: d  reason: collision with root package name */
    private final int f8205d;

    /* renamed from: e  reason: collision with root package name */
    private String f8206e;

    /* renamed from: f  reason: collision with root package name */
    private String f8207f;

    /* renamed from: g  reason: collision with root package name */
    private String f8208g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f8209h;

    /* renamed from: i  reason: collision with root package name */
    private String f8210i;
    private long j;
    private List<Scope> k;
    private String l;
    private String m;
    private Set<Scope> n = new HashSet();

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", (String) null);
        String optString4 = jSONObject.optString(AppConstants.KEY_EMAIL, (String) null);
        String optString5 = jSONObject.optString("displayName", (String) null);
        String optString6 = jSONObject.optString("givenName", (String) null);
        String optString7 = jSONObject.optString("familyName", (String) null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(f8202c.a() / 1000);
        }
        GoogleSignInAccount googleSignInAccount = r3;
        GoogleSignInAccount googleSignInAccount2 = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, (String) null, valueOf.longValue(), s.a(string), new ArrayList((Collection) s.a(hashSet)), optString6, optString7);
        googleSignInAccount.f8210i = jSONObject.optString("serverAuthCode", (String) null);
        return googleSignInAccount;
    }

    GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.f8205d = i2;
        this.f8206e = str;
        this.f8207f = str2;
        this.f8203a = str3;
        this.f8208g = str4;
        this.f8209h = uri;
        this.f8210i = str5;
        this.j = j2;
        this.f8204b = str6;
        this.k = list;
        this.l = str7;
        this.m = str8;
    }

    public final Set<Scope> a() {
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return hashSet;
    }

    public int hashCode() {
        return ((this.f8204b.hashCode() + 527) * 31) + a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f8204b.equals(this.f8204b) && googleSignInAccount.a().equals(a());
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f8206e != null) {
                jSONObject.put("id", this.f8206e);
            }
            if (this.f8207f != null) {
                jSONObject.put("tokenId", this.f8207f);
            }
            if (this.f8203a != null) {
                jSONObject.put(AppConstants.KEY_EMAIL, this.f8203a);
            }
            if (this.f8208g != null) {
                jSONObject.put("displayName", this.f8208g);
            }
            if (this.l != null) {
                jSONObject.put("givenName", this.l);
            }
            if (this.m != null) {
                jSONObject.put("familyName", this.m);
            }
            if (this.f8209h != null) {
                jSONObject.put("photoUrl", this.f8209h.toString());
            }
            if (this.f8210i != null) {
                jSONObject.put("serverAuthCode", this.f8210i);
            }
            jSONObject.put("expirationTime", this.j);
            jSONObject.put("obfuscatedIdentifier", this.f8204b);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.k.toArray(new Scope[this.k.size()]);
            Arrays.sort(scopeArr, d.f8241a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f8352a);
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8205d);
        b.a(parcel, 2, this.f8206e, false);
        b.a(parcel, 3, this.f8207f, false);
        b.a(parcel, 4, this.f8203a, false);
        b.a(parcel, 5, this.f8208g, false);
        b.a(parcel, 6, this.f8209h, i2, false);
        b.a(parcel, 7, this.f8210i, false);
        b.a(parcel, 8, this.j);
        b.a(parcel, 9, this.f8204b, false);
        b.a(parcel, 10, this.k, false);
        b.a(parcel, 11, this.l, false);
        b.a(parcel, 12, this.m, false);
        b.b(parcel, a2);
    }
}
