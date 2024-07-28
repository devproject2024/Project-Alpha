package androidx.core.d;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class k {
    @Deprecated
    public static <T> Parcelable.Creator<T> a(l<T> lVar) {
        return new a(lVar);
    }

    static class a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final l<T> f2862a;

        a(l<T> lVar) {
            this.f2862a = lVar;
        }

        public final T createFromParcel(Parcel parcel) {
            return this.f2862a.a(parcel, (ClassLoader) null);
        }

        public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f2862a.a(parcel, classLoader);
        }

        public final T[] newArray(int i2) {
            return this.f2862a.a(i2);
        }
    }
}
