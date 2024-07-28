package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new BackStackState[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f3334a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f3335b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f3336c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f3337d;

    /* renamed from: e  reason: collision with root package name */
    final int f3338e;

    /* renamed from: f  reason: collision with root package name */
    final String f3339f;

    /* renamed from: g  reason: collision with root package name */
    final int f3340g;

    /* renamed from: h  reason: collision with root package name */
    final int f3341h;

    /* renamed from: i  reason: collision with root package name */
    final CharSequence f3342i;
    final int j;
    final CharSequence k;
    final ArrayList<String> l;
    final ArrayList<String> m;
    final boolean n;

    public final int describeContents() {
        return 0;
    }

    public BackStackState(a aVar) {
        int size = aVar.f3463d.size();
        this.f3334a = new int[(size * 5)];
        if (aVar.j) {
            this.f3335b = new ArrayList<>(size);
            this.f3336c = new int[size];
            this.f3337d = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                q.a aVar2 = (q.a) aVar.f3463d.get(i2);
                int i4 = i3 + 1;
                this.f3334a[i3] = aVar2.f3469a;
                this.f3335b.add(aVar2.f3470b != null ? aVar2.f3470b.mWho : null);
                int i5 = i4 + 1;
                this.f3334a[i4] = aVar2.f3471c;
                int i6 = i5 + 1;
                this.f3334a[i5] = aVar2.f3472d;
                int i7 = i6 + 1;
                this.f3334a[i6] = aVar2.f3473e;
                this.f3334a[i7] = aVar2.f3474f;
                this.f3336c[i2] = aVar2.f3475g.ordinal();
                this.f3337d[i2] = aVar2.f3476h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.f3338e = aVar.f3468i;
            this.f3339f = aVar.l;
            this.f3340g = aVar.f3390c;
            this.f3341h = aVar.m;
            this.f3342i = aVar.n;
            this.j = aVar.o;
            this.k = aVar.p;
            this.l = aVar.q;
            this.m = aVar.r;
            this.n = aVar.s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f3334a = parcel.createIntArray();
        this.f3335b = parcel.createStringArrayList();
        this.f3336c = parcel.createIntArray();
        this.f3337d = parcel.createIntArray();
        this.f3338e = parcel.readInt();
        this.f3339f = parcel.readString();
        this.f3340g = parcel.readInt();
        this.f3341h = parcel.readInt();
        this.f3342i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.createStringArrayList();
        this.m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }

    public final a a(j jVar) {
        a aVar = new a(jVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f3334a.length) {
            q.a aVar2 = new q.a();
            int i4 = i2 + 1;
            aVar2.f3469a = this.f3334a[i2];
            if (j.a(2)) {
                StringBuilder sb = new StringBuilder("Instantiate ");
                sb.append(aVar);
                sb.append(" op #");
                sb.append(i3);
                sb.append(" base fragment #");
                sb.append(this.f3334a[i4]);
            }
            String str = this.f3335b.get(i3);
            if (str != null) {
                aVar2.f3470b = jVar.e(str);
            } else {
                aVar2.f3470b = null;
            }
            aVar2.f3475g = k.b.values()[this.f3336c[i3]];
            aVar2.f3476h = k.b.values()[this.f3337d[i3]];
            int[] iArr = this.f3334a;
            int i5 = i4 + 1;
            aVar2.f3471c = iArr[i4];
            int i6 = i5 + 1;
            aVar2.f3472d = iArr[i5];
            int i7 = i6 + 1;
            aVar2.f3473e = iArr[i6];
            aVar2.f3474f = iArr[i7];
            aVar.f3464e = aVar2.f3471c;
            aVar.f3465f = aVar2.f3472d;
            aVar.f3466g = aVar2.f3473e;
            aVar.f3467h = aVar2.f3474f;
            aVar.b(aVar2);
            i3++;
            i2 = i7 + 1;
        }
        aVar.f3468i = this.f3338e;
        aVar.l = this.f3339f;
        aVar.f3390c = this.f3340g;
        aVar.j = true;
        aVar.m = this.f3341h;
        aVar.n = this.f3342i;
        aVar.o = this.j;
        aVar.p = this.k;
        aVar.q = this.l;
        aVar.r = this.m;
        aVar.s = this.n;
        aVar.a(1);
        return aVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f3334a);
        parcel.writeStringList(this.f3335b);
        parcel.writeIntArray(this.f3336c);
        parcel.writeIntArray(this.f3337d);
        parcel.writeInt(this.f3338e);
        parcel.writeString(this.f3339f);
        parcel.writeInt(this.f3340g);
        parcel.writeInt(this.f3341h);
        TextUtils.writeToParcel(this.f3342i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeStringList(this.l);
        parcel.writeStringList(this.m);
        parcel.writeInt(this.n ? 1 : 0);
    }
}
