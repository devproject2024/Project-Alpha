package net.one97.paytm.o2o.movies.utils;

import android.graphics.Bitmap;
import kotlin.g.b.k;

final class ab {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f75913a;

    /* renamed from: b  reason: collision with root package name */
    final Bitmap f75914b;

    /* renamed from: c  reason: collision with root package name */
    final Bitmap f75915c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return k.a((Object) this.f75913a, (Object) abVar.f75913a) && k.a((Object) this.f75914b, (Object) abVar.f75914b) && k.a((Object) this.f75915c, (Object) abVar.f75915c);
    }

    public final int hashCode() {
        Bitmap bitmap = this.f75913a;
        int i2 = 0;
        int hashCode = (bitmap != null ? bitmap.hashCode() : 0) * 31;
        Bitmap bitmap2 = this.f75914b;
        int hashCode2 = (hashCode + (bitmap2 != null ? bitmap2.hashCode() : 0)) * 31;
        Bitmap bitmap3 = this.f75915c;
        if (bitmap3 != null) {
            i2 = bitmap3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ShareImageBitmapHolder(moviePosterImage=" + this.f75913a + ", customBrandingImage=" + this.f75914b + ", adImage=" + this.f75915c + ")";
    }

    public ab(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        this.f75913a = bitmap;
        this.f75914b = bitmap2;
        this.f75915c = bitmap3;
    }
}
