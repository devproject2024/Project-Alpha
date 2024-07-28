package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public final String f8122a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8123b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f8124c;

    /* renamed from: d  reason: collision with root package name */
    private final List<IdToken> f8125d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8126e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8127f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8128g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8129h;

    Credential(String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        List<IdToken> list2;
        String trim = ((String) s.a(str, (Object) "credential identifier cannot be null")).trim();
        s.a(trim, (Object) "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                        z = true;
                    }
                }
                if (!z) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.f8123b = str2;
                this.f8124c = uri;
                if (list == null) {
                    list2 = Collections.emptyList();
                } else {
                    list2 = Collections.unmodifiableList(list);
                }
                this.f8125d = list2;
                this.f8122a = trim;
                this.f8126e = str3;
                this.f8127f = str4;
                this.f8128g = str5;
                this.f8129h = str6;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public final String a() {
        return this.f8122a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f8122a, credential.f8122a) && TextUtils.equals(this.f8123b, credential.f8123b) && q.a(this.f8124c, credential.f8124c) && TextUtils.equals(this.f8126e, credential.f8126e) && TextUtils.equals(this.f8127f, credential.f8127f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8122a, this.f8123b, this.f8124c, this.f8126e, this.f8127f});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8122a, false);
        b.a(parcel, 2, this.f8123b, false);
        b.a(parcel, 3, this.f8124c, i2, false);
        b.a(parcel, 4, this.f8125d, false);
        b.a(parcel, 5, this.f8126e, false);
        b.a(parcel, 6, this.f8127f, false);
        b.a(parcel, 9, this.f8128g, false);
        b.a(parcel, 10, this.f8129h, false);
        b.b(parcel, a2);
    }
}
