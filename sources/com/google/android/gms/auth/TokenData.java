package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.List;

public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f8063a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8064b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f8065c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8066d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8067e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f8068f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8069g;

    TokenData(int i2, String str, Long l, boolean z, boolean z2, List<String> list, String str2) {
        this.f8063a = i2;
        this.f8064b = s.a(str);
        this.f8065c = l;
        this.f8066d = z;
        this.f8067e = z2;
        this.f8068f = list;
        this.f8069g = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        if (!TextUtils.equals(this.f8064b, tokenData.f8064b) || !q.a(this.f8065c, tokenData.f8065c) || this.f8066d != tokenData.f8066d || this.f8067e != tokenData.f8067e || !q.a(this.f8068f, tokenData.f8068f) || !q.a(this.f8069g, tokenData.f8069g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8064b, this.f8065c, Boolean.valueOf(this.f8066d), Boolean.valueOf(this.f8067e), this.f8068f, this.f8069g});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8063a);
        b.a(parcel, 2, this.f8064b, false);
        b.a(parcel, 3, this.f8065c);
        b.a(parcel, 4, this.f8066d);
        b.a(parcel, 5, this.f8067e);
        b.b(parcel, 6, this.f8068f);
        b.a(parcel, 7, this.f8069g, false);
        b.b(parcel, a2);
    }
}
