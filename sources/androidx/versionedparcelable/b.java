package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.a.a;
import java.lang.reflect.Method;

final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f4933d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f4934e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4935f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4936g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4937h;

    /* renamed from: i  reason: collision with root package name */
    private int f4938i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    private b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f4933d = new SparseIntArray();
        this.f4938i = -1;
        this.j = 0;
        this.k = -1;
        this.f4934e = parcel;
        this.f4935f = i2;
        this.f4936g = i3;
        this.j = this.f4935f;
        this.f4937h = str;
    }

    public final boolean b(int i2) {
        while (this.j < this.f4936g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f4934e.setDataPosition(this.j);
            int readInt = this.f4934e.readInt();
            this.k = this.f4934e.readInt();
            this.j += readInt;
        }
        return this.k == i2;
    }

    public final void c(int i2) {
        a();
        this.f4938i = i2;
        this.f4933d.put(i2, this.f4934e.dataPosition());
        a(0);
        a(i2);
    }

    public final void a() {
        int i2 = this.f4938i;
        if (i2 >= 0) {
            int i3 = this.f4933d.get(i2);
            int dataPosition = this.f4934e.dataPosition();
            this.f4934e.setDataPosition(i3);
            this.f4934e.writeInt(dataPosition - i3);
            this.f4934e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public final a b() {
        Parcel parcel = this.f4934e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f4935f) {
            i2 = this.f4936g;
        }
        int i3 = i2;
        return new b(parcel, dataPosition, i3, this.f4937h + "  ", this.f4930a, this.f4931b, this.f4932c);
    }

    public final void a(byte[] bArr) {
        if (bArr != null) {
            this.f4934e.writeInt(bArr.length);
            this.f4934e.writeByteArray(bArr);
            return;
        }
        this.f4934e.writeInt(-1);
    }

    public final void a(int i2) {
        this.f4934e.writeInt(i2);
    }

    public final void a(String str) {
        this.f4934e.writeString(str);
    }

    public final void a(Parcelable parcelable) {
        this.f4934e.writeParcelable(parcelable, 0);
    }

    public final void a(boolean z) {
        this.f4934e.writeInt(z ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public final void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4934e, 0);
    }

    /* access modifiers changed from: protected */
    public final CharSequence f() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4934e);
    }

    public final int c() {
        return this.f4934e.readInt();
    }

    public final String d() {
        return this.f4934e.readString();
    }

    public final byte[] e() {
        int readInt = this.f4934e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4934e.readByteArray(bArr);
        return bArr;
    }

    public final <T extends Parcelable> T g() {
        return this.f4934e.readParcelable(getClass().getClassLoader());
    }

    public final boolean h() {
        return this.f4934e.readInt() != 0;
    }
}
