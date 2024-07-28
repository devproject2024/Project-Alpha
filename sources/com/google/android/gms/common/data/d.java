package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f8683a;

    /* renamed from: b  reason: collision with root package name */
    protected int f8684b;

    /* renamed from: c  reason: collision with root package name */
    private int f8685c;

    public d(DataHolder dataHolder, int i2) {
        this.f8683a = (DataHolder) s.a(dataHolder);
        s.a(i2 >= 0 && i2 < this.f8683a.f8669e);
        this.f8684b = i2;
        this.f8685c = this.f8683a.a(this.f8684b);
    }

    /* access modifiers changed from: protected */
    public final String a(String str) {
        DataHolder dataHolder = this.f8683a;
        int i2 = this.f8684b;
        int i3 = this.f8685c;
        if (dataHolder.f8666b == null || !dataHolder.f8666b.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (dataHolder.a()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i2 >= 0 && i2 < dataHolder.f8669e) {
            return dataHolder.f8667c[i3].getString(i2, dataHolder.f8666b.getInt(str));
        } else {
            throw new CursorIndexOutOfBoundsException(i2, dataHolder.f8669e);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8684b), Integer.valueOf(this.f8685c), this.f8683a});
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (!q.a(Integer.valueOf(dVar.f8684b), Integer.valueOf(this.f8684b)) || !q.a(Integer.valueOf(dVar.f8685c), Integer.valueOf(this.f8685c)) || dVar.f8683a != this.f8683a) {
                return false;
            }
            return true;
        }
        return false;
    }
}
