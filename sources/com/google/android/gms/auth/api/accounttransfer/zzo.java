package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.List;
import java.util.Map;

public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private static final a<String, FastJsonResponse.Field<?, ?>> f8096a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8097b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f8098c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f8099d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f8100e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f8101f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f8102g;

    public zzo() {
        this.f8097b = 1;
    }

    public final boolean a(FastJsonResponse.Field field) {
        return true;
    }

    zzo(int i2, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        this.f8097b = i2;
        this.f8098c = list;
        this.f8099d = list2;
        this.f8100e = list3;
        this.f8101f = list4;
        this.f8102g = list5;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> a() {
        return f8096a;
    }

    public final Object b(FastJsonResponse.Field field) {
        switch (field.a()) {
            case 1:
                return Integer.valueOf(this.f8097b);
            case 2:
                return this.f8098c;
            case 3:
                return this.f8099d;
            case 4:
                return this.f8100e;
            case 5:
                return this.f8101f;
            case 6:
                return this.f8102g;
            default:
                int a2 = field.a();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(a2);
                throw new IllegalStateException(sb.toString());
        }
    }

    static {
        a<String, FastJsonResponse.Field<?, ?>> aVar = new a<>();
        f8096a = aVar;
        aVar.put("registered", FastJsonResponse.Field.b("registered", 2));
        f8096a.put("in_progress", FastJsonResponse.Field.b("in_progress", 3));
        f8096a.put("success", FastJsonResponse.Field.b("success", 4));
        f8096a.put("failed", FastJsonResponse.Field.b("failed", 5));
        f8096a.put("escrowed", FastJsonResponse.Field.b("escrowed", 6));
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f8097b);
        b.b(parcel, 2, this.f8098c);
        b.b(parcel, 3, this.f8099d);
        b.b(parcel, 4, this.f8100e);
        b.b(parcel, 5, this.f8101f);
        b.b(parcel, 6, this.f8102g);
        b.b(parcel, a2);
    }
}
