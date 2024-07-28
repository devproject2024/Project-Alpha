package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8130a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8131b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8132c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8133d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8134e;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    CredentialPickerConfig(int r2, boolean r3, boolean r4, boolean r5, int r6) {
        /*
            r1 = this;
            r1.<init>()
            r1.f8130a = r2
            r1.f8131b = r3
            r1.f8132c = r4
            r3 = 1
            r4 = 3
            r0 = 2
            if (r2 >= r0) goto L_0x0016
            r1.f8133d = r5
            if (r5 == 0) goto L_0x0013
            r3 = 3
        L_0x0013:
            r1.f8134e = r3
            return
        L_0x0016:
            if (r6 != r4) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r1.f8133d = r3
            r1.f8134e = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.CredentialPickerConfig.<init>(int, boolean, boolean, boolean, int):void");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f8135a = false;

        /* renamed from: b  reason: collision with root package name */
        boolean f8136b = true;

        /* renamed from: c  reason: collision with root package name */
        int f8137c = 1;

        public final CredentialPickerConfig a() {
            return new CredentialPickerConfig(this, (byte) 0);
        }
    }

    /* synthetic */ CredentialPickerConfig(a aVar, byte b2) {
        this(aVar);
    }

    private CredentialPickerConfig(a aVar) {
        this(2, aVar.f8135a, aVar.f8136b, false, aVar.f8137c);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        boolean z = true;
        b.a(parcel, 1, this.f8131b);
        b.a(parcel, 2, this.f8132c);
        if (this.f8134e != 3) {
            z = false;
        }
        b.a(parcel, 3, z);
        b.b(parcel, 4, this.f8134e);
        b.b(parcel, 1000, this.f8130a);
        b.b(parcel, a2);
    }
}
