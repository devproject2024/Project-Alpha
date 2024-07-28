package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new g();
    private static final a k = new f(new String[0]);

    /* renamed from: a  reason: collision with root package name */
    final String[] f8665a;

    /* renamed from: b  reason: collision with root package name */
    Bundle f8666b;

    /* renamed from: c  reason: collision with root package name */
    final CursorWindow[] f8667c;

    /* renamed from: d  reason: collision with root package name */
    int[] f8668d;

    /* renamed from: e  reason: collision with root package name */
    int f8669e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8670f;

    /* renamed from: g  reason: collision with root package name */
    private final int f8671g;

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f8672h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8673i = false;
    private boolean j = true;

    DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f8670f = i2;
        this.f8665a = strArr;
        this.f8667c = cursorWindowArr;
        this.f8671g = i3;
        this.f8672h = bundle;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f8674a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f8675b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8676c;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<Object, Integer> f8677d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8678e;

        /* renamed from: f  reason: collision with root package name */
        private String f8679f;

        private a(String[] strArr) {
            this.f8674a = (String[]) s.a(strArr);
            this.f8675b = new ArrayList<>();
            this.f8676c = null;
            this.f8677d = new HashMap<>();
            this.f8678e = false;
            this.f8679f = null;
        }

        /* synthetic */ a(String[] strArr, byte b2) {
            this(strArr);
        }
    }

    public final int a(int i2) {
        int i3 = 0;
        s.a(i2 >= 0 && i2 < this.f8669e);
        while (true) {
            int[] iArr = this.f8668d;
            if (i3 >= iArr.length) {
                break;
            } else if (i2 < iArr[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        return i3 == this.f8668d.length ? i3 - 1 : i3;
    }

    public final boolean a() {
        boolean z;
        synchronized (this) {
            z = this.f8673i;
        }
        return z;
    }

    public final void close() {
        synchronized (this) {
            if (!this.f8673i) {
                this.f8673i = true;
                for (CursorWindow close : this.f8667c) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.j && this.f8667c.length > 0 && !a()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
            }
        } finally {
            super.finalize();
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f8665a);
        b.a(parcel, 2, (T[]) this.f8667c, i2);
        b.b(parcel, 3, this.f8671g);
        b.a(parcel, 4, this.f8672h);
        b.b(parcel, 1000, this.f8670f);
        b.b(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }
}
